package mozago.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.sql.SQLException;
import java.util.Locale;

import javax.swing.JButton;

import mozago.bdRelated.InvestimentoDAO;
import mozago.bdRelated.ObraDAO;
import mozago.controller.point;
import mozago.model.Investimento;
import mozago.model.Obra;
import mozago.model.User;

public class Janela_CriarObraInvs extends JFrame implements ActionListener, WindowStateListener {

	private JPanel contentPane;
	private JTextField txtValorInicial;
	private JTextField txtDescricao;
	private JButton btnLimpar = new JButton("Limpar");
	private JButton btnGuardar = new JButton("Guardar");
	private Obra obra = new Obra();
	private User user = new User();
	/**
	 * Launch the application.
	 */
/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Obra obra1 = new Obra();
					User user1 = new User();
					Janela_CriarObraInvs frame = new Janela_CriarObraInvs(obra1,user1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Janela_CriarObraInvs(Obra obra, User user) {
		this.obra=obra;
		this.user=user;
		
		UIManager.put("OptionPane.yesButtonText", "Sim");  
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");  
        UIManager.put("OptionPane.noButtonText", "Não");  
        UIManager.put("OptionPane.okButtonText", "OK");  
	    Locale.setDefault(new Locale("pt","PT"));  
	   
	    addWindowListener(new WindowAdapter() {
			@Override
			  public void windowClosing(WindowEvent e) {  

			    BlockingGlassPane glass = new BlockingGlassPane();  
			    setGlassPane(glass);  
			    glass.setVisible(true);  
                int i = JOptionPane.showConfirmDialog(Janela_CriarObraInvs.this ,"Tem certeza que deseja cancelar a criacao do Investimento inicial?", "Cancelar",JOptionPane.YES_NO_OPTION); 
              
                if (i == JOptionPane.YES_OPTION) {  
                	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                //new Janela_principal(user).setVisible(true); 
                } else {  
                	glass.setVisible(false); 
                   setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }     } 
		}); 	
	    
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 671, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtValorInicial = new JTextField();
		txtValorInicial.setToolTipText("Montante do Investimento inicial");
		txtValorInicial.setForeground(Color.GRAY);
		txtValorInicial.setFont(new Font("Futura Lt BT", Font.BOLD, 26));
		txtValorInicial.setBounds(49, 150, 176, 37);
		panel.add(txtValorInicial);
		txtValorInicial.setColumns(10);
		
		JLabel lblMzn = new JLabel("MZN");
		lblMzn.setFont(new Font("Futura Lt BT", Font.PLAIN, 26));
		lblMzn.setBounds(235, 151, 69, 37);
		panel.add(lblMzn);
		
		txtDescricao = new JTextField();
		txtDescricao.setToolTipText("Descricao do Investimento Inicial");
		txtDescricao.setForeground(Color.GRAY);
		txtDescricao.setFont(new Font("Futura Lt BT", Font.PLAIN, 17));
		txtDescricao.setBounds(382, 150, 258, 37);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		btnLimpar.setIcon(new ImageIcon(Janela_CriarObraInvs.class.getResource("/img/Janela_valor/Limpar.png")));
		btnLimpar.setBounds(360, 198, 121, 37);
		panel.add(btnLimpar);
		
		
		btnGuardar.setIcon(new ImageIcon(Janela_CriarObraInvs.class.getResource("/img/Janela_valor/Guardar.png")));
		btnGuardar.setBounds(503, 198, 121, 37);
		panel.add(btnGuardar);
		
		JLabel lblinvestimento = new JLabel("New label");
		lblinvestimento.setFont(new Font("Futura Lt BT", Font.PLAIN, 26));
		lblinvestimento.setIcon(new ImageIcon(Janela_CriarObraInvs.class.getResource("/img/Janela_valor/BG.png")));
		lblinvestimento.setBounds(-10, 0, 671, 250);
		panel.add(lblinvestimento);
		setLocation(point.findScreenCenter(this));
		
		btnGuardar.addActionListener(this);
		btnLimpar.addActionListener(this);
	}
	
	private boolean verificarVazios(){
		if(txtDescricao.getText().isEmpty() || txtValorInicial.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos");
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnGuardar){
			
			if (verificarVazios()){
				double valor = Double.parseDouble(txtValorInicial.getText());
				String descricao = txtDescricao.getText().toString();
				
				
				try {
					Investimento investimento = new Investimento(InvestimentoDAO.generateId(),valor,descricao);
					InvestimentoDAO.inserir(investimento, obra);
										
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			JOptionPane.showMessageDialog(null, "Vontando para o menu inicial...");
			dispose();
		}//endBtnGuardar
		
		if (e.getSource()==btnLimpar){
			txtDescricao.setText("");
			txtValorInicial.setText("");
		}
		
		
	}
	
	

	@Override
	public void windowStateChanged(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	} 
}

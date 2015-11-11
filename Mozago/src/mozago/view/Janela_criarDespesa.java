package mozago.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;

import mozago.bdRelated.DespesaDAO;
import mozago.controller.point;
import mozago.model.Despesa;
import mozago.model.Obra;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Janela_criarDespesa extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTextField txtValorUnitario;
	private JTextField txtQuantidade;
	private JLabel lblResultado;
	private Obra obra= new Obra();
	private JButton btnGuardar = new JButton("Guardar");
	private JButton btnLimpar = new JButton("Limpar");
	private JComboBox comboBoxTipoDespesa = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	Obra obra2=new Obra();				
					Janela_criarDespesa frame = new Janela_criarDespesa(obra2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Janela_criarDespesa(Obra obra) {
		UIManager.put("OptionPane.yesButtonText", "Sim");
		UIManager.put("OptionPane.cancelButtonText", "Cancelar");
		UIManager.put("OptionPane.noButtonText", "Não");
		UIManager.put("OptionPane.okButtonText", "OK");
		Locale.setDefault(new Locale("pt", "PT"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				BlockingGlassPane glass = new BlockingGlassPane();
				setGlassPane(glass);
				glass.setVisible(true);
				int i = JOptionPane.showConfirmDialog(Janela_criarDespesa.this,
						"Tem certeza que deseja sair sem adicionar a despesa?", "Saída",
						JOptionPane.YES_NO_OPTION);

				if (i == JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(DISPOSE_ON_CLOSE);
              	  new Janela_ViewDisp().setVisible(true); 
				} else {
					glass.setVisible(false);
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setTitle("Mozago");
		setResizable(false);
		
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
		setBounds(100, 100, 762, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId;
		try {
			lblId = new JLabel(DespesaDAO.generateId()+"");
			lblId.setForeground(Color.GRAY);
			lblId.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
			lblId.setBounds(128, 149, 257, 30);
			contentPane.add(lblId);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		txtDescricao = new JTextField();
		txtDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescricao.setForeground(Color.GRAY);
		txtDescricao.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		txtDescricao.setText("Descricao");
		txtDescricao.setBounds(128, 231, 257, 82);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		
		comboBoxTipoDespesa.setForeground(Color.GRAY);
		comboBoxTipoDespesa.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		comboBoxTipoDespesa.setBounds(128, 190, 257, 30);
		contentPane.add(comboBoxTipoDespesa);
		
		JLabel lblIdDaObra = new JLabel(obra.getId_obra()+"");
		lblIdDaObra.setForeground(Color.GRAY);
		lblIdDaObra.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		lblIdDaObra.setBounds(533, 149, 199, 30);
		contentPane.add(lblIdDaObra);
		
		txtValorUnitario = new JTextField();
		txtValorUnitario.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtValorUnitario.setText("");
				txtQuantidade.setText("0");
			}
		});
		txtValorUnitario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {
					
					getLblResultado().setText(txtValorUnitario.getText());
				}else{getLblResultado().setText(txtValorUnitario.getText());}
			}
		});
		
		txtValorUnitario.setForeground(Color.GRAY);
		txtValorUnitario.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		txtValorUnitario.setText("Valor Unitario");
		txtValorUnitario.setBounds(533, 190, 165, 30);
		contentPane.add(txtValorUnitario);
		txtValorUnitario.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
					
					if (txtQuantidade.getText()!="" && txtQuantidade.getText()!=null) {
						String resultado=""+ Integer.parseInt( txtValorUnitario.getText())*Integer.parseInt( txtQuantidade.getText());
						if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE && txtQuantidade.getText() !="" ) {
								getLblResultado().setText(String.valueOf(resultado));
						
					}else{if (txtQuantidade.getText().isEmpty()) {
						resultado=""+ Integer.parseInt( txtValorUnitario.getText())*1;
					}else{
						resultado=""+ Integer.parseInt( txtValorUnitario.getText())*1;
						
						getLblResultado().setText(String.valueOf(resultado));}}
					}
				
			}
		});
		txtQuantidade.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtQuantidade.setText("");
				
			}
		});
		txtQuantidade.setForeground(Color.GRAY);
		txtQuantidade.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		txtQuantidade.setText("Quantidade");
		txtQuantidade.setBounds(533, 231, 165, 30);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setFont(new Font("Futura Lt BT", Font.BOLD, 30));
		lblValorTotal.setBounds(293, 337, 184, 39);
		contentPane.add(lblValorTotal);
		
		JLabel lblMzn = new JLabel("MZN");
		lblMzn.setForeground(Color.GRAY);
		lblMzn.setFont(new Font("Futura Lt BT", Font.BOLD, 19));
		lblMzn.setBounds(708, 193, 46, 26);
		contentPane.add(lblMzn);
		
		JLabel labelMZN2 = new JLabel("MZN");
		labelMZN2.setForeground(Color.GRAY);
		labelMZN2.setFont(new Font("Futura Lt BT", Font.BOLD, 19));
		labelMZN2.setBounds(657, 337, 58, 39);
		contentPane.add(labelMZN2);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setForeground(new Color(255, 0, 0));
		lblResultado.setFont(new Font("FuturaExtended", Font.BOLD, 32));
		lblResultado.setBounds(487, 337, 171, 39);
		contentPane.add(lblResultado);
		
		
		btnLimpar.setBackground(Color.GRAY);
		btnLimpar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		btnLimpar.setBounds(363, 424, 138, 39);
		contentPane.add(btnLimpar);
		
		
		btnGuardar.setIcon(new ImageIcon(Janela_criarDespesa.class.getResource("/img/Janela_criarDespeza/guardar.png")));
		btnGuardar.setBounds(533, 424, 138, 39);
		contentPane.add(btnGuardar);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(Janela_criarDespesa.class.getResource("/img/Janela_criarDespeza/bg.png")));
		lblBg.setBounds(-16, 0, 773, 474);
		contentPane.add(lblBg);
		setLocation(point.findScreenCenter(this));
		
		btnGuardar.addActionListener(this);
		btnLimpar.addActionListener(this);
	}
	public JLabel getLblResultado() {
		return lblResultado;
	}

	private boolean verificarVazios(){
		if (txtDescricao.getText().toString().isEmpty() ||
				txtQuantidade.getText().toString().isEmpty()||
				comboBoxTipoDespesa.getSelectedIndex()==0 ||
				txtValorUnitario.getText().toString().isEmpty()) {
			JOptionPane.showMessageDialog(null, "preencha todos os campos");
			return false;}
			else
				return true;
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	if(e.getSource()==btnLimpar){
		txtDescricao.setText("");
		txtQuantidade.setText("");
		txtValorUnitario.setText("");
		comboBoxTipoDespesa.setSelectedIndex(0);
		
	}
	
//	if(e.getSource()==btnGuardar){
//		if(verificarVazios()){
//			
//			Despesa despesa = new Despesa(DespesaDAO.generateId(), title, title, title);
//		}
//	}
//	work in progress - HN
	
	}
}

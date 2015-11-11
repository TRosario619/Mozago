package mozago.view;

import java.awt.BorderLayout;
import java.awt.color.CMMException;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JComboBox;

import mozago.bdRelated.AlocacaoDAO;
import mozago.bdRelated.BdConecta;
import mozago.bdRelated.ObraDAO;
import mozago.bdRelated.UserDAO;
import mozago.controller.point;
import mozago.model.Obra;
import mozago.model.User;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class Janela_CriarObra extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTextField txtDonoDaObra;
	private JTextField txtValorProjecto;
	private JTextField txtContacto;
	private JTextField txtValor;
	private JLabel lblMzn;
	private JComboBox comboBoxDirector;
	private JComboBox comboBoxGestor;
	private JButton btnGuardar;
	private JButton btnLimpar;
	private JComboBox comboBoxTipoObra;
	private JComboBox comboBoxInicioDia;
	private JComboBox comboBoxInicioMes;
	private JComboBox comboBoxInicioAno;
	private JComboBox comboBoxFimAno;
	private JComboBox comboBoxFimMes;
	private JComboBox comboBoxFimDia;
	private User user = new User();

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		User user = new User();
							Janela_CriarObra frame;
							try {
								frame = new Janela_CriarObra(user);
								frame.setVisible(true);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
					
				
	}*/

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Janela_CriarObra(User user) throws SQLException {
		
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
                int i = JOptionPane.showConfirmDialog(Janela_CriarObra.this ,"Tem certeza que deseja cancelar a criacao da obra?", "Cancelar",JOptionPane.YES_NO_OPTION); 
              
                if (i == JOptionPane.YES_OPTION) {  
                	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                	// new Janela_principal(user).setVisible(true); 
                } else {  
                	glass.setVisible(false); 
                   setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }     } 
		}); 
		
		
		setTitle("MOZAGO");
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
		setBounds(100, 100, 822, 707);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelCriarObra = new JPanel();
		panelCriarObra.setBounds(0, 0, 813, 668);
		contentPane.add(panelCriarObra);
		panelCriarObra.setLayout(null);
		
		JLabel lblIdObrar = new JLabel("ID Obrar");
		lblIdObrar.setForeground(Color.GRAY);
		lblIdObrar.setFont(new Font("FuturaExtended", Font.BOLD, 26));
		lblIdObrar.setBounds(55, 175, 125, 43);
		panelCriarObra.add(lblIdObrar);
		
		txtDescricao = new JTextField();
		txtDescricao.setToolTipText("Descricao da Obra");
		txtDescricao.setForeground(Color.GRAY);
		txtDescricao.setFont(new Font("Futura Lt BT", Font.BOLD, 24));
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(55, 256, 301, 43);
		panelCriarObra.add(txtDescricao);
		
		txtDonoDaObra = new JTextField();
		txtDonoDaObra.setToolTipText("Insira o nome do Dono da Obra");
		txtDonoDaObra.setForeground(Color.GRAY);
		txtDonoDaObra.setFont(new Font("Futura Lt BT", Font.BOLD, 24));
		txtDonoDaObra.setColumns(10);
		txtDonoDaObra.setBounds(55, 449, 301, 43);
		panelCriarObra.add(txtDonoDaObra);
		
		txtContacto = new JTextField();
		txtContacto.setToolTipText("Contacto do dono da obra");
		txtContacto.setForeground(Color.GRAY);
		txtContacto.setFont(new Font("Futura Lt BT", Font.BOLD, 24));
		txtContacto.setColumns(10);
		txtContacto.setBounds(55, 532, 301, 43);
		panelCriarObra.add(txtContacto);
		
		txtValor = new JTextField();
		txtValor.setToolTipText("Valor do projecto em Meticais");
		txtValor.setForeground(Color.GRAY);
		txtValor.setFont(new Font("Futura Lt BT", Font.BOLD, 24));
		txtValor.setColumns(10);
		txtValor.setBounds(451, 449, 176, 43);
		panelCriarObra.add(txtValor);
		
		lblMzn = new JLabel("MZN");
		lblMzn.setFont(new Font("Futura Lt BT", Font.BOLD, 23));
		lblMzn.setBounds(657, 449, 75, 43);
		panelCriarObra.add(lblMzn);
		
		comboBoxDirector = new JComboBox();
		comboBoxDirector.setBounds(451, 532, 281, 43);
		panelCriarObra.add(comboBoxDirector);
		
		comboBoxGestor = new JComboBox();
		comboBoxGestor.setBounds(55, 614, 301, 43);
		panelCriarObra.add(comboBoxGestor);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(Janela_CriarObra.class.getResource("/img/Janela_criar/Guardar.png")));
		btnGuardar.setBounds(605, 614, 136, 43);
		panelCriarObra.add(btnGuardar);
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(Janela_CriarObra.class.getResource("/img/Janela_criar/Limpar.png")));
		btnLimpar.setBounds(463, 614, 136, 44);
		panelCriarObra.add(btnLimpar);
		
		comboBoxTipoObra = new JComboBox();
		comboBoxTipoObra.setModel(new DefaultComboBoxModel(new String[] {"--Escolha um tipo de obra--", "Constru\u00E7\u00E3o", "Reabilita\u00E7\u00E3o", "Expans\u00E3o"}));
		comboBoxTipoObra.setBounds(55, 334, 301, 50);
		panelCriarObra.add(comboBoxTipoObra);
		
		String[] dias=new String[32];
		dias[0]="Dia";
		for(int i = 1; i<32;i++){
			dias[i]=i+"";
			}
		
		String[] anos=new String[32];
		anos[0]="Ano";
		for(int i = 1; i<32;i++){
			
			anos[i]=i+2014+"";
		}
		
		String[] meses = {"mês","janeiro","fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro",
				"novembro","dezembro"};
		
		comboBoxInicioDia = new JComboBox(dias);
		comboBoxInicioDia.setBounds(451, 175, 53, 43);
		panelCriarObra.add(comboBoxInicioDia);
		
		comboBoxInicioMes = new JComboBox(meses);
		comboBoxInicioMes.setBounds(514, 175, 157, 43);
		panelCriarObra.add(comboBoxInicioMes);
		
		comboBoxInicioAno = new JComboBox(anos);
		comboBoxInicioAno.setBounds(681, 175, 68, 43);
		panelCriarObra.add(comboBoxInicioAno);
		
		comboBoxFimAno = new JComboBox(anos);
		comboBoxFimAno.setBounds(681, 256, 68, 43);
		panelCriarObra.add(comboBoxFimAno);
		
		comboBoxFimMes = new JComboBox(meses);
		comboBoxFimMes.setBounds(514, 256, 157, 43);
		panelCriarObra.add(comboBoxFimMes);
		
		comboBoxFimDia = new JComboBox(dias);
		comboBoxFimDia.setBounds(451, 256, 53, 43);
		panelCriarObra.add(comboBoxFimDia);
		
		
		
		JLabel labelBG = new JLabel("");
		labelBG.setBackground(Color.WHITE);
		labelBG.setIcon(new ImageIcon(Janela_CriarObra.class.getResource("/img/Janela_criar/BG.png")));
		labelBG.setBounds(-11, -11, 819, 674);
		panelCriarObra.add(labelBG);
		setLocation(point.findScreenCenter(this));
		
		//actualizar comboxes --AB
		try {
			actualizarComboBoxes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Generate Id da Obra --AB
		lblIdObrar.setText(ObraDAO.generateId()+"");
		
		
		btnGuardar.addActionListener(this);
		btnLimpar.addActionListener(this);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	
	private boolean verificarVazios(){
		if ( txtContacto.getText().isEmpty() || comboBoxFimAno.getSelectedIndex()==0||
				comboBoxFimMes.getSelectedIndex()==0||comboBoxFimDia.getSelectedIndex()==0||
				comboBoxInicioAno.getSelectedIndex()==0||comboBoxInicioMes.getSelectedIndex()==0||
				comboBoxInicioDia.getSelectedIndex()==0||txtDescricao.getText().isEmpty() || txtDonoDaObra.getText().isEmpty() ||
				txtValor.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "preencha todos os campos");
			return false;}
			else
				return true;
		}
		
	//actualizacao das comboboxes --AB
	private void actualizarComboBoxes() throws SQLException{
		
		Vector<User> v=UserDAO.retornaUsuariosCatgoria(2);
		Vector<User> v1=UserDAO.retornaUsuariosCatgoria(3);
		comboBoxDirector.removeAllItems();
		comboBoxGestor.removeAllItems();
		
		comboBoxDirector.addItem("--Escolha um Director--");
		comboBoxGestor.addItem("--Escolha um Gestor--");
		
		for (int j = 0; j < v.size(); j++) {
			
			
			comboBoxDirector.addItem(v.elementAt(j).getUsername());
			comboBoxGestor.addItem(v1.elementAt(j).getUsername());
			
			
			
		}
		
		
	}
	
public void criarAlocacao(Obra obra)
{
	try {	
		User admin = new User();
		admin= UserDAO.VerificarUser(user.getUsername());
		User director = new User();
		director= UserDAO.VerificarUser(comboBoxDirector.getSelectedItem().toString());
		User gestor = new User();
		gestor= UserDAO.VerificarUser(comboBoxGestor.getSelectedItem().toString());
		System.out.println(obra.toString());
	AlocacaoDAO.inserir(obra, admin, gestor, director);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
		
@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnGuardar){
			if(verificarVazios()){
				Obra obra=new Obra();
				//falta tipo de obra - HN
				//ja pus o tipo de obra!! - AB
				
				//cases dos meses -AB e HN
				int mesInicio=comboBoxFimMes.getSelectedIndex();
				int mesFim=comboBoxInicioMes.getSelectedIndex();
				
				Date data_inicio=new Date(Integer.parseInt(comboBoxInicioAno.getSelectedItem().toString()),(mesInicio),comboBoxInicioDia.getSelectedIndex());
				Date data_fim=new Date(Integer.parseInt(comboBoxFimAno.getSelectedItem().toString()),(mesFim),comboBoxFimDia.getSelectedIndex());
				Date data_prazo=null;		
				try {
					obra=new Obra(ObraDAO.generateId(), txtDescricao.getText(), txtDonoDaObra.getText(), txtContacto.getText(), comboBoxTipoObra.getSelectedIndex(), data_inicio, data_fim, data_prazo, Double.parseDouble(txtValor.getText()));
					
					ObraDAO.inserir(obra);
					
					criarAlocacao(obra);
				} catch (NumberFormatException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} //valorProjectado
		
				
				
				 new Janela_CriarObraInvs(obra, user).setVisible(true);
				dispose();			
				
			}
			
		} //EndBtnGuardar
		
		if(e.getSource() == btnLimpar){
			txtContacto.setText("");
			comboBoxFimAno.setSelectedIndex(0);
			comboBoxFimMes.setSelectedIndex(0);
			comboBoxFimDia.setSelectedIndex(0);
			comboBoxInicioAno.setSelectedIndex(0);
			comboBoxInicioDia.setSelectedIndex(0);
			comboBoxInicioMes.setSelectedIndex(0);
			txtDescricao.setText("");
			txtDonoDaObra.setText("");
			txtValor.setText(""); 
			//txtValorProjecto.setText(""); nao existe!!!! AB
			comboBoxDirector.setSelectedIndex(0);
			comboBoxGestor.setSelectedIndex(0);
			
			comboBoxTipoObra.setSelectedIndex(0);;
		}
		
	}
}

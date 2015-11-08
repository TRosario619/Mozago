package mozago.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import mozago.controller.point;

public class Janela_users extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtApelido;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtCategoria;
	private JTable tableP;
	private JButton btnCriar;
	private JButton btnEditar;
	private JButton btnApagar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela_users frame = new Janela_users();
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
	public Janela_users() {
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
                int i = JOptionPane.showConfirmDialog(Janela_users.this ,"Tem certeza que deseja sair?", "Saída",JOptionPane.YES_NO_OPTION); 
              
                if (i == JOptionPane.YES_OPTION) {  
                	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                	  new Janela_principal().setVisible(true); 
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
		setBounds(100, 100, 807, 699);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.setBounds(145, 149, 221, 28);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtApelido = new JTextField();
		txtApelido.setText("Apelido");
		txtApelido.setBounds(145, 188, 221, 28);
		contentPane.add(txtApelido);
		txtApelido.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(145, 227, 221, 28);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setText("Telefone");
		txtTelefone.setBounds(145, 272, 221, 28);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(549, 153, 177, 28);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(549, 188, 177, 30);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(549, 237, 177, 28);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		btnCriar = new JButton("Criar");
		btnCriar.setIcon(new ImageIcon(Janela_users.class.getResource("/img/Janela_users/criar.png")));
		btnCriar.setBounds(431, 605, 118, 30);
		contentPane.add(btnCriar);
		
		btnEditar = new JButton("Editar ");
		btnEditar.setIcon(new ImageIcon(Janela_users.class.getResource("/img/Janela_users/editar.png")));
		btnEditar.setBounds(559, 605, 101, 30);
		contentPane.add(btnEditar);
		
		btnApagar = new JButton("Apagar");
		btnApagar.setIcon(new ImageIcon(Janela_users.class.getResource("/img/Janela_users/apagar.png")));
		btnApagar.setBounds(670, 605, 101, 30);
		contentPane.add(btnApagar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(78, 344, 666, 230);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		tableP=new JTable();
		scrollPane.setViewportView(tableP);
		inicializarTabela();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 646, GroupLayout.PREFERRED_SIZE))
		);
		
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		
		JLabel lblBg = new JLabel("BG");
		lblBg.setIcon(new ImageIcon(Janela_users.class.getResource("/img/Janela_users/BG.png")));
		lblBg.setBounds(0, 0, 798, 663);
		contentPane.add(lblBg);
		
		
	}
private void inicializarTabela(){
		
		tableP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		DefaultTableModel modelo_tabela = new DefaultTableModel(0,6)
		{

		    @Override
		    public boolean isCellEditable(int row, int column) 
		    {
		       return false;
		    }
		};
		tableP.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Nome", "Apelido", "email", "Telefone", "Username", "Password", "Categoria"
			}
		));
		tableP.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		
		
		
		tableP.getTableHeader().setReorderingAllowed(false);
		this.setVisible(true);
		setLocation(point.findScreenCenter(this));
	}
}

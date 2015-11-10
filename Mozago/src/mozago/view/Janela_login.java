package mozago.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import mozago.bdRelated.UserDAO;
import mozago.controller.point;
import mozago.model.User;

import java.awt.Color;

public class Janela_login extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField_username;
	private JPasswordField passwordField;
	private JButton btn_limpar = new JButton("Limpar");
	private JButton btn_login = new JButton("Login");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela_login frame = new Janela_login();
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
	public Janela_login() {
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
				int i = JOptionPane.showConfirmDialog(Janela_login.this,
						"Tem certeza que deseja sair?", "Saída",
						JOptionPane.YES_NO_OPTION);

				if (i == JOptionPane.YES_OPTION) {
					System.exit(0);
				} else {
					glass.setVisible(false);
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setTitle("Mozago");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 366);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(20, 160, 142, 30);
		contentPane.add(lblUsername);
		lblUsername.setFont(new Font("Futura Lt BT", Font.BOLD, 26));
		
		JLabel lbl_password = new JLabel("Password:");
		lbl_password.setFont(new Font("Futura Lt BT", Font.BOLD, 26));
		lbl_password.setBounds(30, 211, 118, 30);
		contentPane.add(lbl_password);
		
		textField_username = new JTextField();
		textField_username.setForeground(Color.GRAY);
		textField_username.setFont(new Font("Futura Lt BT", Font.BOLD, 24));
		textField_username.setBounds(167, 157, 226, 33);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(Color.GRAY);
		passwordField.setFont(new Font("Futura Lt BT", Font.BOLD, 24));
		passwordField.setBounds(167, 211, 226, 29);
		contentPane.add(passwordField);
		
		btn_login.setForeground(new Color(255, 153, 0));
		btn_login.setBackground(new Color(0, 0, 0));
		btn_login.setFont(new Font("Futura Lt BT", Font.BOLD, 26));
		btn_login.setBounds(151, 268, 126, 41);
		contentPane.add(btn_login);
		
		
		btn_limpar.setBackground(Color.WHITE);
		btn_limpar.setFont(new Font("Futura Lt BT", Font.BOLD, 26));
		btn_limpar.setBounds(302, 268, 126, 41);
		contentPane.add(btn_limpar);
		
				
				JLabel lblLogologin = new JLabel("logo_login");
				lblLogologin.setBounds(0, -14, 703, 609);
				contentPane.add(lblLogologin);
				lblLogologin.setBackground(Color.WHITE);
				lblLogologin.setForeground(Color.WHITE);
				lblLogologin.setIcon(new ImageIcon(Janela_login.class.getResource("/img/logo_mozago - Copy - Copy (Custom)4.png")));
				setLocation(point.findScreenCenter(this));
		

				//accoes - HN
				btn_limpar.addActionListener(this);
				btn_login.addActionListener(this);
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			// If Nimbus is not available, you can set the GUI to another look
			// and feel.
		}
	}

	private boolean verificarVazios(){
		if(textField_username.getText().isEmpty() || passwordField.getPassword().toString().isEmpty()){
			JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos");
			return false;
			}
		else{
				return true;
			}
		}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btn_limpar){
			textField_username.setText("");
			passwordField.setText("");
		}
		
		if(e.getSource()==btn_login){
			if(verificarVazios()){
			User user=null;
			try {
//				user = new User(UserDAO.VerificarUser(textField_username.getText(),passwordField.getPassword().toString()));
				user = UserDAO.VerificarUser(textField_username.getText().toString(),passwordField.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
				System.out.println("erro action listener btn login");
			}
			
			if(user==null){
				JOptionPane.showMessageDialog(null, "User/Password incorrect");}
			else{
				Janela_principal janela = new Janela_principal(user);
				janela.setVisible(true);
				this.dispose();
			} //endElse
			}//endIfVerificarVazios
		}
		}//endIFActionListener
}

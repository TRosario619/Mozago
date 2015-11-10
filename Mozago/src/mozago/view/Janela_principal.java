package mozago.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import mozago.controller.point;





import mozago.model.User;

import java.awt.Font;
import java.awt.Color;



public class Janela_principal extends JFrame implements ActionListener{

	private JPanel contentPane;
	private String data,horas;
	private Date dataSistema =new Date();
	private JButton btnCriarObra = new JButton("Criar Obra");
	private JButton btnVisualizar = new JButton("Visualizar");
	private JButton btnUsuarios = new JButton("Usuários");
	private User user;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public Janela_principal(User user) {
		 UIManager.put("OptionPane.yesButtonText", "Sim");  
         UIManager.put("OptionPane.cancelButtonText", "Cancelar");  
         UIManager.put("OptionPane.noButtonText", "Não");  
         UIManager.put("OptionPane.okButtonText", "OK");  
	    Locale.setDefault(new Locale("pt","PT"));  
	   this.user=user;
		addWindowListener(new WindowAdapter() {
			@Override
			  public void windowClosing(WindowEvent e) {  

			    BlockingGlassPane glass = new BlockingGlassPane();  
			    setGlassPane(glass);  
			    glass.setVisible(true);  
                int i = JOptionPane.showConfirmDialog(Janela_principal.this ,"Tem certeza que deseja sair?", "Saída",JOptionPane.YES_NO_OPTION); 
              
                if (i == JOptionPane.YES_OPTION) {  
                	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                	  new Janela_login().setVisible(true); 
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
		setBounds(100, 100, 706, 608);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(-13, -13, 756, 594);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lblData = new JLabel("18 de August de 2014");
		lblData.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblData.setBounds(409, 542, 176, 30);
		panelPrincipal.add(lblData);
		
		JLabel label_4 = new JLabel("::");
		label_4.setFont(new Font("Consolas", Font.PLAIN, 14));
		label_4.setBounds(588, 542, 68, 30);
		panelPrincipal.add(label_4);
		
		JLabelTimer lblHora = new JLabelTimer();

		lblHora.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblHora.setBounds(604, 542, 96, 30);
		panelPrincipal.add(lblHora);
		
		JLabel lblUser = new JLabel(user.getNome() + " " + user.getApelido());
		lblUser.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblUser.setBounds(547, 49, 245, 30);
		panelPrincipal.add(lblUser);
		
		JLabel label_7 = new JLabel("Nome do Utilizador:");
		label_7.setFont(new Font("Consolas", Font.PLAIN, 14));
		label_7.setBounds(547, 27, 170, 30);
		panelPrincipal.add(label_7);
		
		
		
		btnCriarObra.setBackground(Color.WHITE);
		btnCriarObra.setFont(new Font("Futura Lt BT", Font.BOLD, 27));
		btnCriarObra.setBounds(61, 427, 176, 73);
		panelPrincipal.add(btnCriarObra);
		
		
		btnVisualizar.setBackground(new Color(0, 0, 0));
		btnVisualizar.setForeground(new Color(255, 140, 0));
		btnVisualizar.setFont(new Font("Futura Lt BT", Font.BOLD, 27));
		btnVisualizar.setBounds(263, 430, 214, 70);
		panelPrincipal.add(btnVisualizar);
		
		
		btnUsuarios.setFont(new Font("Futura Lt BT", Font.BOLD, 27));
		btnUsuarios.setBackground(new Color(255, 140, 0));
		btnUsuarios.setForeground(new Color(0, 0, 0));
		btnUsuarios.setBounds(504, 431, 163, 69);
		panelPrincipal.add(btnUsuarios);
		
		JLabel labelBackground = new JLabel("");
		labelBackground.setForeground(new Color(255, 140, 0));
		labelBackground.setBackground(Color.BLACK);
		labelBackground.setIcon(new ImageIcon(Janela_principal.class.getResource("/img/Janela_main/logo_mozago background5.png")));
		labelBackground.setBounds(-16, 0, 734, 594);
		panelPrincipal.add(labelBackground);
		
		DateFormat dfmt = new SimpleDateFormat("d 'de' MMMM 'de' yyyy",new Locale("pt", "PT"));  
	     data=dfmt.format(dataSistema);
	     
	     lblData.setText(data);
		
		  SimpleDateFormat timeFormat = new SimpleDateFormat("HH'h':mm'm'");
		     horas=timeFormat.format(dataSistema);
		     lblHora.setText(horas);
		     //user=point.users.get(0);
		     //lblUser.setText(point.users.get(0));
		
		setLocation(point.findScreenCenter(this));
		
		btnCriarObra.addActionListener(this);
		btnUsuarios.addActionListener(this);
		btnVisualizar.addActionListener(this);
		
		//aqui faltam cenas - HN 
		if (user.getCategoria()==2){
			btnCriarObra.setVisible(false);
			btnUsuarios.setVisible(false);
		}
		else if (user.getCategoria()==3){
			btnCriarObra.setVisible(false);
			btnUsuarios.setVisible(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnCriarObra){
			Janela_CriarObra janela = new Janela_CriarObra();
			janela.setVisible(true);
		}
		
		if(e.getSource()==btnUsuarios){
			new Janela_users(user).setVisible(true);
		}
		
		if(e.getSource()==btnVisualizar){
			//janela nao criada - HN
		}
	}

}

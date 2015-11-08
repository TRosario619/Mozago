package mozago.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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



import java.awt.Font;
import java.awt.Color;



public class Janela_principal extends JFrame {

	private JPanel contentPane;
	private String data,horas,user;
	private Date dataSistema =new Date();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela_principal frame = new Janela_principal();
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
	public Janela_principal() {
		 UIManager.put("OptionPane.yesButtonText", "Sim");  
         UIManager.put("OptionPane.cancelButtonText", "Cancelar");  
         UIManager.put("OptionPane.noButtonText", "N�o");  
         UIManager.put("OptionPane.okButtonText", "OK");  
	    Locale.setDefault(new Locale("pt","PT"));  
	    
		addWindowListener(new WindowAdapter() {
			@Override
			  public void windowClosing(WindowEvent e) {  

			    BlockingGlassPane glass = new BlockingGlassPane();  
			    setGlassPane(glass);  
			    glass.setVisible(true);  
                int i = JOptionPane.showConfirmDialog(Janela_principal.this ,"Tem certeza que deseja sair?", "Sa�da",JOptionPane.YES_NO_OPTION); 
              
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
		setBounds(100, 100, 732, 608);
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
		lblData.setBounds(416, 542, 170, 30);
		panelPrincipal.add(lblData);
		
		JLabel label_4 = new JLabel("::");
		label_4.setFont(new Font("Consolas", Font.PLAIN, 14));
		label_4.setBounds(588, 542, 68, 30);
		panelPrincipal.add(label_4);
		
		JLabelTimer lblHora = new JLabelTimer();

		lblHora.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblHora.setBounds(604, 542, 96, 30);
		panelPrincipal.add(lblHora);
		
		JLabel lblUser = new JLabel("<dynamic>");
		lblUser.setFont(new Font("Consolas", Font.PLAIN, 14));
		lblUser.setBounds(547, 49, 245, 30);
		panelPrincipal.add(lblUser);
		
		JLabel label_7 = new JLabel("Nome do Utilizador:");
		label_7.setFont(new Font("Consolas", Font.PLAIN, 14));
		label_7.setBounds(547, 27, 170, 30);
		panelPrincipal.add(label_7);
		
		
		JButton btnCriarObra = new JButton("Criar Obra");
		btnCriarObra.setBackground(Color.WHITE);
		btnCriarObra.setFont(new Font("Consolas", Font.PLAIN, 25));
		btnCriarObra.setBounds(61, 427, 176, 73);
		panelPrincipal.add(btnCriarObra);
		
		JButton btnNewButton = new JButton("Visualizar");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 140, 0));
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 25));
		btnNewButton.setBounds(263, 430, 214, 70);
		panelPrincipal.add(btnNewButton);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setFont(new Font("Consolas", Font.PLAIN, 23));
		btnUsuarios.setBackground(new Color(255, 140, 0));
		btnUsuarios.setForeground(new Color(0, 0, 0));
		btnUsuarios.setBounds(504, 431, 163, 69);
		panelPrincipal.add(btnUsuarios);
		
		JLabel labelBackground = new JLabel("");
		labelBackground.setForeground(new Color(255, 140, 0));
		labelBackground.setBackground(Color.BLACK);
		labelBackground.setIcon(new ImageIcon(Janela_principal.class.getResource("/img/logo_mozago background2.png")));
		labelBackground.setBounds(-16, 0, 762, 594);
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
	}

}

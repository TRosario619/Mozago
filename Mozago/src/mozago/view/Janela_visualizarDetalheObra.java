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
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import javax.swing.JButton;

import mozago.controller.point;
import mozago.model.User;

public class Janela_visualizarDetalheObra extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescObra;
	private JTextField txtContacto;
	private double custo=0, investimento=0, lucro=0,valorEmFalta=0, valorProjecto=0;
	private User user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela_visualizarDetalheObra frame = new Janela_visualizarDetalheObra();
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
	public Janela_visualizarDetalheObra() {
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
                int i = JOptionPane.showConfirmDialog(Janela_visualizarDetalheObra.this ,"Tem certeza que deseja sair?", "Saída",JOptionPane.YES_NO_OPTION); 
              
                if (i == JOptionPane.YES_OPTION) {  
                	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                	  new Janela_visualizarObra(user).setVisible(true); 
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
		setBounds(100, 100, 803, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Calculos-RG
		
		lucro=investimento-custo;
		valorEmFalta=valorProjecto-investimento;
		
		
		
		
		
		JLabel lblIdObra = new JLabel("ID Obra");
		lblIdObra.setForeground(Color.GRAY);
		lblIdObra.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		lblIdObra.setBounds(153, 145, 159, 31);
		contentPane.add(lblIdObra);
		
		txtDescObra = new JTextField();
		txtDescObra.setEnabled(false);
		txtDescObra.setForeground(Color.GRAY);
		txtDescObra.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		txtDescObra.setText("Desc Obra");
		txtDescObra.setBounds(221, 187, 194, 31);
		contentPane.add(txtDescObra);
		txtDescObra.setColumns(10);
		
		JLabel lbTipoObra = new JLabel("Tipo de Obra");
		lbTipoObra.setForeground(Color.GRAY);
		lbTipoObra.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		lbTipoObra.setBounds(183, 229, 186, 31);
		contentPane.add(lbTipoObra);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setForeground(Color.GRAY);
		lblDataInicio.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		lblDataInicio.setBounds(167, 271, 180, 31);
		contentPane.add(lblDataInicio);
		
		JLabel lblDataFim = new JLabel("Data fim");
		lblDataFim.setForeground(Color.GRAY);
		lblDataFim.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		lblDataFim.setBounds(562, 271, 172, 31);
		contentPane.add(lblDataFim);
		
		JLabel lblDonoDaObra = new JLabel("Dono Da Obra");
		lblDonoDaObra.setForeground(Color.GRAY);
		lblDonoDaObra.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		lblDonoDaObra.setBounds(194, 367, 497, 31);
		contentPane.add(lblDonoDaObra);
		
		JLabel lblValorDoProjecto = new JLabel("Valor Do projecto");
		lblValorDoProjecto.setForeground(Color.GRAY);
		lblValorDoProjecto.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		lblValorDoProjecto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorDoProjecto.setBounds(204, 409, 186, 32);
		contentPane.add(lblValorDoProjecto);
		lblValorDoProjecto.setText(valorProjecto+" MZN");
		
		txtContacto = new JTextField();
		txtContacto.setEnabled(false);
		txtContacto.setForeground(Color.GRAY);
		txtContacto.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		txtContacto.setText("Contacto");
		txtContacto.setBounds(153, 452, 194, 31);
		contentPane.add(txtContacto);
		txtContacto.setColumns(10);
		
		JComboBox comboBoxDirector = new JComboBox();
		comboBoxDirector.setEnabled(false);
		comboBoxDirector.setForeground(Color.GRAY);
		comboBoxDirector.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		comboBoxDirector.setBounds(153, 494, 267, 31);
		contentPane.add(comboBoxDirector);
		
		JComboBox comboBoxGestor = new JComboBox();
		comboBoxGestor.setEnabled(false);
		comboBoxGestor.setForeground(Color.GRAY);
		comboBoxGestor.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		comboBoxGestor.setBounds(544, 494, 233, 31);
		contentPane.add(comboBoxGestor);
		
		JLabel lblValor = new JLabel("Valor ");
		lblValor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValor.setForeground(Color.GRAY);
		lblValor.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		lblValor.setBounds(124, 573, 130, 31);
		contentPane.add(lblValor);
		lblValor.setText(investimento+" MZN");
		
		JLabel lblDescricao = new JLabel("Descricao");
		lblDescricao.setVerticalAlignment(SwingConstants.TOP);
		lblDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		lblDescricao.setForeground(Color.GRAY);
		lblDescricao.setFont(new Font("Futura Lt BT", Font.BOLD, 13));
		lblDescricao.setBounds(593, 583, 194, 62);
		contentPane.add(lblDescricao);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(Janela_visualizarDetalheObra.class.getResource("/img/Janela_Visualizar/editar.png")));
		btnEditar.setBounds(188, 603, 110, 42);
		contentPane.add(btnEditar);
		
		JButton btnFecharObra = new JButton("Fechar Obra");
		btnFecharObra.setIcon(new ImageIcon(Janela_visualizarDetalheObra.class.getResource("/img/Janela_Visualizar/Fechar Obra.png")));
		btnFecharObra.setBounds(29, 603, 150, 42);
		contentPane.add(btnFecharObra);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(Janela_visualizarDetalheObra.class.getResource("/img/Janela_Visualizar/sair.png")));
		btnSair.setBounds(448, 603, 144, 42);
		contentPane.add(btnSair);
		
		JButton btnInvestimento = new JButton("Investimento");
		btnInvestimento.setIcon(new ImageIcon(Janela_visualizarDetalheObra.class.getResource("/img/Janela_Visualizar/Adicionar Investimento.png")));
		btnInvestimento.setBounds(308, 603, 130, 42);
		contentPane.add(btnInvestimento);
		
		JLabel lblCustoDoProjecto = new JLabel("Custo do Projecto:");
		lblCustoDoProjecto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCustoDoProjecto.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		lblCustoDoProjecto.setBounds(435, 187, 186, 31);
		contentPane.add(lblCustoDoProjecto);
		
		JLabel lblValorOnHand = new JLabel("Valor Investido:");
		lblValorOnHand.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorOnHand.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		lblValorOnHand.setBounds(462, 145, 159, 31);
		contentPane.add(lblValorOnHand);
		
		JLabel lblValorEmFalta = new JLabel("Valor Em Falta:");
		lblValorEmFalta.setFont(new Font("Futura Lt BT", Font.BOLD, 19));
		lblValorEmFalta.setBounds(433, 410, 159, 31);
		contentPane.add(lblValorEmFalta);
		
		JLabel lblValorEmFalta_1 = new JLabel("Valor em Falta");
		lblValorEmFalta_1.setForeground(new Color(255, 0, 0));
		lblValorEmFalta_1.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		lblValorEmFalta_1.setBounds(593, 409, 141, 32);
		contentPane.add(lblValorEmFalta_1);
		lblValorEmFalta_1.setText(valorEmFalta+" MZN");
		
		JLabel lblCusto = new JLabel("Custo");
		lblCusto.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCusto.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		lblCusto.setBounds(631, 187, 146, 26);
		contentPane.add(lblCusto);
		lblCusto.setText(custo+" MZN");
		
		JLabel lblInvestimento = new JLabel("Investimento");
		lblInvestimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInvestimento.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		lblInvestimento.setBounds(631, 145, 146, 32);
		contentPane.add(lblInvestimento);
		lblInvestimento.setText(investimento+" MZN");
		
		JLabel lblLucro = new JLabel("Lucro:");
		lblLucro.setFont(new Font("Futura Lt BT", Font.BOLD, 19));
		lblLucro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLucro.setBounds(559, 230, 62, 31);
		contentPane.add(lblLucro);
		
		JLabel lblLucro_1 = new JLabel("Lucro");
		lblLucro_1.setFont(new Font("Futura Lt BT", Font.BOLD, 20));
		lblLucro_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLucro_1.setBounds(631, 229, 146, 31);
		contentPane.add(lblLucro_1);
		lblLucro_1.setText(lucro+" MZN");
		
		JLabel lblBg = new JLabel("Bg");
		lblBg.setForeground(Color.GRAY);
		lblBg.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		lblBg.setIcon(new ImageIcon(Janela_visualizarDetalheObra.class.getResource("/img/Janela_Visualizar/BG.png")));
		lblBg.setBounds(0, 0, 787, 661);
		contentPane.add(lblBg);
		setLocation(point.findScreenCenter(this));
	}
}

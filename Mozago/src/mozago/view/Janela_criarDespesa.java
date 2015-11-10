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
import javax.swing.UIManager;

import mozago.controller.point;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Janela_criarDespesa extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescricao;
	private JTextField txtValorUnitario;
	private JTextField txtQuantidade;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela_criarDespesa frame = new Janela_criarDespesa();
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
	public Janela_criarDespesa() {
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
		
		JLabel lblId = new JLabel("ID da Despesa");
		lblId.setForeground(Color.GRAY);
		lblId.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		lblId.setBounds(128, 149, 257, 30);
		contentPane.add(lblId);
		
		txtDescricao = new JTextField();
		txtDescricao.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescricao.setForeground(Color.GRAY);
		txtDescricao.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		txtDescricao.setText("Descricao");
		txtDescricao.setBounds(128, 231, 257, 82);
		contentPane.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JComboBox comboBoxTipoDespesa = new JComboBox();
		comboBoxTipoDespesa.setForeground(Color.GRAY);
		comboBoxTipoDespesa.setFont(new Font("Futura Lt BT", Font.BOLD, 22));
		comboBoxTipoDespesa.setBounds(128, 190, 257, 30);
		contentPane.add(comboBoxTipoDespesa);
		
		JLabel lblIdDaObra = new JLabel("ID Da Obra");
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
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBackground(Color.GRAY);
		btnLimpar.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 20));
		btnLimpar.setBounds(363, 424, 138, 39);
		contentPane.add(btnLimpar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon(Janela_criarDespesa.class.getResource("/img/Janela_criarDespeza/guardar.png")));
		btnGuardar.setBounds(533, 424, 138, 39);
		contentPane.add(btnGuardar);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(Janela_criarDespesa.class.getResource("/img/Janela_criarDespeza/bg.png")));
		lblBg.setBounds(-16, 0, 773, 474);
		contentPane.add(lblBg);
		setLocation(point.findScreenCenter(this));
	}
	public JLabel getLblResultado() {
		return lblResultado;
	}
}

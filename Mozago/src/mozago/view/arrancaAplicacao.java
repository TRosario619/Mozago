package mozago.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JProgressBar;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.ImageIcon;


import java.awt.Window.Type;
import java.io.IOException;
import javax.swing.UIManager;

public class arrancaAplicacao extends JFrame implements Runnable {
	private JLabel lblDinamico;
	public JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public JProgressBar progressBar;
	private JLabel lblNewLabel_1;
	private JLabel lblEngsoftware;
	
	public static void main(String[] args) {
		arrancaAplicacao sp = new arrancaAplicacao();
		sp.setVisible(true);
		sp.carregar();
	}
	/**
	 * Create the frame.
	 */
	public arrancaAplicacao() {
		super("MOZAGO");
		setIconImage(Toolkit.getDefaultToolkit().getImage(arrancaAplicacao.class.getResource("/img/logo_mozago background3.png")));
		setTitle("Mozago");
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 513);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocation(findScreenCenter());
		progressBar = new JProgressBar();
		progressBar.setBounds(10, 440, 681, 33);
		progressBar.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(221, 5, 0, 340);
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.PLAIN, 30));
		lblNewLabel.setIcon(new ImageIcon(arrancaAplicacao.class.getResource("/img/logo_mozago background4dark.png")));
		JLabel lblstartup = new JLabel("Por favor espere ...");
		lblstartup.setBounds(10, 382, 514, 53);
		lblstartup.setBackground(new Color(255, 250, 205));
		lblstartup.setForeground(new Color(0, 0, 51));
		lblstartup.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 32));
		lblDinamico = new JLabel("10%");
		lblDinamico.setBounds(635, 395, 56, 34);
		lblDinamico.setForeground(new Color(0, 0, 51));
		lblDinamico.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 28));
		contentPane.setLayout(null);
		
		lblEngsoftware = new JLabel("Engenharia de Software Projecto final");
		lblEngsoftware.setForeground(new Color(0, 0, 0));
		lblEngsoftware.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		lblEngsoftware.setBackground(new Color(255, 250, 205));
		lblEngsoftware.setBounds(365, 345, 311, 53);
		contentPane.add(lblEngsoftware);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(arrancaAplicacao.class.getResource("/img/logo_mozago background3.png")));
		lblNewLabel_1.setBounds(-42, -27, 779, 511);
		contentPane.add(lblstartup);
		contentPane.add(progressBar);
		contentPane.add(lblDinamico);
		contentPane.add(lblNewLabel);
		contentPane.add(lblNewLabel_1);
		
		
	}
	private Point findScreenCenter() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension mySize = getSize();
		Point fin = new Point(0, 0);
		fin.x = (screenSize.width - mySize.width) / 2;
		fin.y = (screenSize.height - mySize.height) / 2;
		return fin;
	}

	public void carregar() {

		for (int i = 0; i < 101; i++) {
			final int percent = i;
			try {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						progressBar.setValue(percent);
					}
				});
				Thread.sleep(50);
				if (i == 20)
				{
					lblDinamico.setText("18%");
				}
				if (i == 30)
				{
					lblDinamico.setText("30%");
				}
				if (i == 54)
				{
					lblDinamico.setText("47%");
				}
				if (i == 60)
				{
					lblDinamico.setText("62%");
				}
				if (i == 78)
				{
					lblDinamico.setText("88%");
				}
				if (i == 90)
				{
					lblDinamico.setText("98%");
				}
			} catch (InterruptedException e) {
				JOptionPane.showMessageDialog(null,
						"Erro ao carregar a aplicacao : " + e.getMessage());
				e.printStackTrace();
			}
		}
		dispose();
		new Janela_login().setVisible(true);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}

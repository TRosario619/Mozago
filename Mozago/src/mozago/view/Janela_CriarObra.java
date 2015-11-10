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
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;

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
	private JTextField txtDataInicio;
	private JTextField txtDataFim;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela_CriarObra frame = new Janela_CriarObra();
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
	public Janela_CriarObra() {
		
		
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
		
		txtDataInicio = new JTextField();
		txtDataInicio.setToolTipText("Data de Inicio da Obra");
		txtDataInicio.setForeground(Color.GRAY);
		txtDataInicio.setFont(new Font("Futura Lt BT", Font.BOLD, 24));
		txtDataInicio.setBounds(451, 173, 230, 43);
		panelCriarObra.add(txtDataInicio);
		txtDataInicio.setColumns(10);
		
		txtDataFim = new JTextField();
		txtDataFim.setToolTipText("Data do Fim da obra");
		txtDataFim.setForeground(Color.GRAY);
		txtDataFim.setFont(new Font("Futura Lt BT", Font.BOLD, 24));
		txtDataFim.setColumns(10);
		txtDataFim.setBounds(451, 256, 230, 43);
		panelCriarObra.add(txtDataFim);
		
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
		lblIdObrar.setText(UserDAO.generateId()+"");
		
		
		btnGuardar.addActionListener(this);
		btnLimpar.addActionListener(this);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
	
	private boolean verificarVazios(){
		if ( txtContacto.getText().isEmpty() || txtDataFim.getText().isEmpty() || 
				txtDataInicio.getText().isEmpty() || txtDataFim.getText().isEmpty() ||
				txtDescricao.getText().isEmpty() || txtDonoDaObra.getText().isEmpty() ||
				txtValor.getText().isEmpty() || txtValorProjecto.getText().isEmpty()) {
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
		
@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnGuardar){
			if(verificarVazios()){
				//falta tipo de obra - HN
				//ja pus o tipo de obra!! - AB
				Obra obra=new Obra(ObraDAO.generateId(), //id_obra
						txtDescricao.getText(),			//decricao
						txtDonoDaObra.getText(),//dono_obra
						txtContacto.getText(), //contacto_dono_obra
						comboBoxTipoObra.getSelectedIndex(),//tipo_obra
						txtDataInicio.getText(),//data_inicio
						null,	//data_fim_no momento de criacao esta data é nula - HN
						txtDataFim.getText(), //data_prazo
						Double.parseDouble(txtValorProjecto.getText())); //valorProjectado
				
				try {
					ObraDAO.inserir(obra);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			
		}
		
		if(e.getSource() == btnLimpar){
			txtContacto.setText("");
			txtDataFim.setText("");
			txtDataInicio.setText("");
			txtDataFim.setText("");
			txtDescricao.setText("");
			txtDonoDaObra.setText("");
			txtValor.setText(""); 
			//txtValorProjecto.setText(""); nao existe!!!! AB
			comboBoxDirector.setSelectedIndex(0);
			comboBoxGestor.setSelectedIndex(0);
		}
		
	}
}

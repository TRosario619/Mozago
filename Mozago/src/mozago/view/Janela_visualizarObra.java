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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import mozago.controller.point;
import mozago.model.User;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

public class Janela_visualizarObra extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable tableP;
	private JButton btnVisualizarDespesas;
	private JButton btnActualizarObrar;
	private JButton btnInvestimento;
	private User user;
	
	
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela_visualizarObra frame = new Janela_visualizarObra(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Janela_visualizarObra(User user) {

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
               int i = JOptionPane.showConfirmDialog(Janela_visualizarObra.this ,"Tem certeza que deseja sair?", "Saída",JOptionPane.YES_NO_OPTION); 
             
               if (i == JOptionPane.YES_OPTION) {  
               	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
               //	  new Janela_principal().setVisible(true); 
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
		setBounds(100, 100, 813, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		tableP=new JTable();
		tableP.setFont(new Font("Futura Lt BT", Font.PLAIN, 14));
		scrollPane.setViewportView(tableP);
		inicializarTabela();
		
		btnVisualizarDespesas = new JButton("Visualizar Despesas");
		btnVisualizarDespesas.setToolTipText("Visualizar despesas feitas nas obras");
		btnVisualizarDespesas.setBackground(new Color(0, 0, 0));
		btnVisualizarDespesas.setForeground(new Color(255, 140, 0));
		btnVisualizarDespesas.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		btnVisualizarDespesas.setBounds(499, 612, 215, 56);
		contentPane.add(btnVisualizarDespesas);
		
		btnActualizarObrar = new JButton("Actualizar obrar");
		btnActualizarObrar.setToolTipText("Modificar detalhes da obra");
		btnActualizarObrar.setBackground(Color.GRAY);
		btnActualizarObrar.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		btnActualizarObrar.setBounds(134, 612, 192, 56);
		contentPane.add(btnActualizarObrar);
		
		btnInvestimento = new JButton("Investimento");
		btnInvestimento.setToolTipText("Adicionar ao investimento Dado");
		btnInvestimento.setBackground(Color.GRAY);
		btnInvestimento.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		btnInvestimento.setBounds(336, 612, 153, 56);
		contentPane.add(btnInvestimento);
		scrollPane.setBounds(42, 341, 713, 253);
		contentPane.add(scrollPane);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("FuturaExtended", Font.BOLD, 19));
		lblId.setBounds(147, 158, 251, 22);
		contentPane.add(lblId);
		
		JLabel lblDataInicio = new JLabel("Data Inicio");
		lblDataInicio.setFont(new Font("FuturaExtended", Font.BOLD, 19));
		lblDataInicio.setBounds(147, 200, 251, 22);
		contentPane.add(lblDataInicio);
		
		JLabel lblGestor = new JLabel("Gestor");
		lblGestor.setFont(new Font("FuturaExtended", Font.BOLD, 19));
		lblGestor.setBounds(147, 246, 251, 22);
		contentPane.add(lblGestor);
		
		JLabel lblDono = new JLabel("Dono");
		lblDono.setFont(new Font("FuturaExtended", Font.BOLD, 19));
		lblDono.setBounds(540, 158, 229, 22);
		contentPane.add(lblDono);
		
		JLabel lblDataPraza = new JLabel("Data Praza");
		lblDataPraza.setFont(new Font("FuturaExtended", Font.BOLD, 19));
		lblDataPraza.setBounds(540, 200, 229, 22);
		contentPane.add(lblDataPraza);
		
		JLabel lblTotalDespesas = new JLabel("Total Despesas");
		lblTotalDespesas.setFont(new Font("FuturaExtended", Font.BOLD, 19));
		lblTotalDespesas.setBounds(540, 246, 229, 22);
		contentPane.add(lblTotalDespesas);
		
		JLabel lblbg = new JLabel("");
		lblbg.setBackground(new Color(0, 0, 0));
		lblbg.setForeground(new Color(255, 140, 0));
		lblbg.setIcon(new ImageIcon(Janela_visualizarObra.class.getResource("/img/Janela_visualizarObra/bg.png")));
		lblbg.setBounds(0, 0, 797, 679);
		contentPane.add(lblbg);
		setLocation(point.findScreenCenter(this));
		
		btnActualizarObrar.addActionListener(this);
		btnInvestimento.addActionListener(this);
		btnVisualizarDespesas.addActionListener(this);
		
		
		if (user.getCategoria()==2){
			btnActualizarObrar.setVisible(false);
			btnInvestimento.setVisible(false);
		}
		else if (user.getCategoria()==3){
			btnActualizarObrar.setVisible(false);
			btnInvestimento.setVisible(false);
		}
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
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			
			
			},
			new String[] {
					"ID Obra", "Dono", "Data Inicio", "Data do Prazo", "Total Despesas", "Gestor"
			}
		));
		tableP.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		
		
		
		tableP.getTableHeader().setReorderingAllowed(false);
		this.setVisible(true);
		setLocation(point.findScreenCenter(this));
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnVisualizarDespesas){
			new Janela_ViewDisp(user).setVisible(true);
		}
	}
	}


package mozago.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

import mozago.controller.point;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Locale;

import javax.swing.JButton;

public class Janela_ViewDisp extends JFrame {

	private JPanel contentPane;
	private JTable tableP;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela_ViewDisp frame = new Janela_ViewDisp();
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
	public Janela_ViewDisp() {
		
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
                int i = JOptionPane.showConfirmDialog(Janela_ViewDisp.this ,"Tem certeza que deseja sair?", "Saída",JOptionPane.YES_NO_OPTION); 
              
                if (i == JOptionPane.YES_OPTION) {  
                	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                	  new Janela_visualizarObra().setVisible(true); 
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
		setBounds(100, 100, 800, 655);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocation(point.findScreenCenter(this));
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(73, 199, 668, 326);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		tableP=new JTable();
		scrollPane.setViewportView(tableP);
		inicializarTabela();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 666, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
					.addContainerGap())
		);
		
			panel.setLayout(gl_panel);
		
		JLabel lblDetalhesDaObra = new JLabel("Detalhes da Obra");
		lblDetalhesDaObra.setFont(new Font("Futurist Fixed-width", Font.PLAIN, 13));
		lblDetalhesDaObra.setBounds(106, 161, 236, 14);
		contentPane.add(lblDetalhesDaObra);
		
		JButton btnVerDespois = new JButton("Ver despois");
		btnVerDespois.setIcon(new ImageIcon(Janela_ViewDisp.class.getResource("/img/Janela_viewDisp/ver-depois.png")));
		btnVerDespois.setBounds(380, 549, 118, 42);
		contentPane.add(btnVerDespois);
		
		JButton btnGuardar = new JButton("Guardar ");
		btnGuardar.setIcon(new ImageIcon(Janela_ViewDisp.class.getResource("/img/Janela_viewDisp/guardar.png")));
		btnGuardar.setBounds(505, 549, 118, 42);
		contentPane.add(btnGuardar);
		
		JButton btnAprovar = new JButton("Aprovar");
		btnAprovar.setIcon(new ImageIcon(Janela_ViewDisp.class.getResource("/img/Janela_viewDisp/approvar.png")));
		btnAprovar.setBounds(627, 549, 125, 42);
		contentPane.add(btnAprovar);
		
		JLabel lblBg = new JLabel("bg");
		lblBg.setIcon(new ImageIcon(Janela_ViewDisp.class.getResource("/img/Janela_viewdisp/bg.png")));
		lblBg.setBounds(-10, -11, 800, 616);
		contentPane.add(lblBg);}
		
		
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
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
					{null, null, null, null, null, null},
				
				},
				new String[] {
						"ID Despesa", "Material", "Quantia", "Preço Unitário", "Preço Total", "Data despesa"
				}
			));
			tableP.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			
			
			
			
			tableP.getTableHeader().setReorderingAllowed(false);
			this.setVisible(true);
			setLocation(point.findScreenCenter(this));
	}
}

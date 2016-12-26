package pastry;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class CakesUI extends JFrame {
//	JFrame frame;

	/**
	 * 
	 */
	private static final long serialVersionUID = 573707037064132163L;
	private JPanel contentPane;
	private CardLayout card;
	private JPanel panel_1;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	public Inventory inventory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CakesUI frame = new CakesUI();
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
	public CakesUI() {
		this.inventory = new Inventory();
        this.inventory.load();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(4, 4, 4, 4, (Color) Color.GRAY));
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 762, 154);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dor De Dulce");
		lblNewLabel.setBounds(284, 7, 173, 36);
		lblNewLabel.setForeground(Color.GRAY);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Vezi Torturi");
		btnNewButton.setForeground(new Color(233, 150, 122));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card=(CardLayout) panel_1.getLayout();
				card.show(panel_1,"panel_3");			
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(10, 120, 305, 28);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Adauga Torturi");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card=(CardLayout) panel_1.getLayout();
				card.show(panel_1, "panel_2");
			}
		});
		btnNewButton_1.setForeground(new Color(233, 150, 122));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(404, 121, 348, 28);
		panel.add(btnNewButton_1);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.PINK, Color.PINK));
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(0, 154, 762, 277);
		contentPane.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(4, 4, 4, 4, (Color) Color.GRAY));
		panel_2.setBackground(new Color(95, 158, 160));
		panel_1.add(panel_2, "panel_3");
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(153, 9, 441, 264);
		panel_2.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Denumire", "Gramaj", "Pret"
			}
		));
		
		JButton btnCumparare = new JButton("Cumpara");
		final BuyDialog dialog=new BuyDialog(table, this.inventory);

		btnCumparare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialog.setVisible(true);
				
			}
		});
		btnCumparare.setBounds(634, 132, 89, 23);
		panel_2.add(btnCumparare);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(4, 4, 4, 4, (Color) new Color(250, 128, 114)));
		panel_1.add(panel_3, "panel_2");
		panel_3.setLayout(null);
		
		JLabel lblDenumire = new JLabel("Denumire");
		lblDenumire.setBounds(87, 44, 46, 14);
		panel_3.add(lblDenumire);
		
		JLabel lblGramaj = new JLabel("Gramaj");
		lblGramaj.setBounds(87, 106, 46, 14);
		panel_3.add(lblGramaj);
		
		JLabel lblPret = new JLabel("Pret");
		lblPret.setBounds(87, 146, 46, 14);
		panel_3.add(lblPret);
		
		textField = new JTextField();
		textField.setBounds(187, 41, 86, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(187, 103, 86, 20);
		panel_3.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(187, 143, 86, 20);
		panel_3.add(textField_2);
		
		JButton btnNewButton_2 = new JButton("OK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String den=textField.getText();
				String gr=textField_1.getText();
				String pret=textField_2.getText();
				Vector<String> newCake = new Vector<String>();
				newCake.add(den);
				newCake.add(gr);
				newCake.add(pret);
				addCake(newCake);
			}
		});
		btnNewButton_2.setBounds(341, 209, 89, 23);
		panel_3.add(btnNewButton_2);
		formWindowOpened();
	}
	
	public void addCake(Vector<String> cake) {
		DefaultTableModel tbl=(DefaultTableModel) table.getModel(); 
		tbl.addRow(cake);
		this.inventory.addCake(cake);
		this.inventory.save();
	}
	
	private void formWindowOpened()  {
        Vector<Vector<String>> data = inventory.getData();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        for (int i = 0; i<data.size(); i++) {
        	dtm.addRow(data.get(i));
        }
    }
}

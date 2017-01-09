package pastry;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class BuyDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6005749772156825994L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
    private String cantitateDorita;
    private String tip;
    private JComboBox<String> Box;
    private Float gramaj;
    private JTable tabel;
    
    public Inventory inventory;
	
	public BuyDialog( JTable t, final Inventory inventory) {
		tabel =t;
		this.inventory = inventory;
		setBounds(100, 100, 559, 419);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 235, 205));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Tort Intreg/ Felii");
			lblNewLabel.setForeground(UIManager.getColor("Button.darkShadow"));
			lblNewLabel.setBackground(new Color(192, 192, 192));
			lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblNewLabel.setBounds(10, 97, 139, 32);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Numar Felii/Torturi");
			lblNewLabel_1.setForeground(UIManager.getColor("Button.darkShadow"));
			lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(10, 154, 139, 65);
			contentPanel.add(lblNewLabel_1);
		}
		Box = new JComboBox<String>();
		Box.setModel(new DefaultComboBoxModel<String>(new String[] {"Tort Intreg", "Felii"}));
		Box.setBounds(175, 105, 100, 20);
		contentPanel.add(Box);
		
		textField = new JTextField();
		textField.setBounds(169, 178, 106, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 239, 213)));
			buttonPane.setBackground(new Color(255, 239, 213));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						cantitateDorita=(String) Box.getSelectedItem();
						tip=textField.getText();
						if (cantitateDorita=="Tort Intreg"){
							gramaj=3f;
							int var=tabel.getSelectedRow();
							Float availableQuantity = (Float) Float.parseFloat((String) tabel.getValueAt(var, 1));
							availableQuantity -= (gramaj*Integer.parseInt(tip));
							if (availableQuantity<0)
							JOptionPane.showMessageDialog(null, "Ati depasit cantitatea disponibila");
							
							else{
							 JOptionPane.showMessageDialog(null, "Cumpararea s-a facut cu succes");
							 tabel.setValueAt(availableQuantity.toString(), var, 1);
							 inventory.save();
							}
						}
						else{
							gramaj=0.3f;
							int var=tabel.getSelectedRow();
							Float availableQuantity = (Float) Float.parseFloat((String) tabel.getValueAt(var, 1));
							availableQuantity -= (gramaj*Integer.parseInt(tip));
							if (availableQuantity<0)
								JOptionPane.showMessageDialog(null, "Ati depasit cantitatea disponibila");
							else{
								 JOptionPane.showMessageDialog(null, "Cumpararea s-a facut cu succes");	
							tabel.setValueAt(availableQuantity.toString(), var, 1);
							
							inventory.save();
							
						}
						
						dispose();
					}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
}
	


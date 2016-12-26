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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("CantitateDorita");
			lblNewLabel.setBounds(10, 54, 112, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("NumarFelii/Torturi");
			lblNewLabel_1.setBounds(30, 97, 92, 14);
			contentPanel.add(lblNewLabel_1);
		}
		Box = new JComboBox<String>();
		Box.setModel(new DefaultComboBoxModel<String>(new String[] {"Tort Intreg", "Felii"}));
		Box.setBounds(172, 51, 100, 20);
		contentPanel.add(Box);
		
		textField = new JTextField();
		textField.setBounds(166, 94, 106, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
			JPanel buttonPane = new JPanel();
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
							tabel.setValueAt(availableQuantity.toString(), var, 1);
							//inventory.buyCake(var, availableQuantity.toString());
							inventory.save();
						}
						JOptionPane.showMessageDialog(null, "Cumpararea s-a facut cu succes");
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
}
	


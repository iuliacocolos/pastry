package pastry;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class Pastry {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pastry window = new Pastry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pastry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame=new JFrame("                                                                 Dor De Dulce                                                                                                ");
		frame.getContentPane().setBackground(new Color(220, 220, 220));
		frame.setBounds(100, 100, 623, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new LineBorder(new Color(230, 230, 250), 18));
		panel.setBounds(0, 0, 607, 85);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Bun Venit La Dor De Dulce!");
		lblNewLabel.setForeground(new Color(233, 150, 122));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 29));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Pastry.class.getResource("/pastry/62836.jpg")));
		lblNewLabel_1.setBounds(0, 84, 607, 247);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Vezi Torturi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CakesUI info=new CakesUI();
				info.setVisible(true);	
				 frame.dispose();
			}
		});
		btnNewButton.setForeground(new Color(233, 150, 122));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(167, 339, 271, 29);
		frame.getContentPane().add(btnNewButton);
	}


	
}

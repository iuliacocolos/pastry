package pastry;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4827170597553868073L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 192, 203));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("           Dor De Dulce ");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setForeground(new Color(105, 105, 105));
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		lblNewLabel.setBounds(103, 24, 333, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("        User Name :");
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_1.setBackground(new Color(105, 105, 105));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 115, 165, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblPassword = new JLabel("    Password :");
		lblPassword.setForeground(new Color(105, 105, 105));
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setBounds(39, 144, 121, 42);
		contentPane.add(lblPassword);

		textField = new JTextField();
		textField.setBounds(173, 111, 195, 33);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(173, 151, 195, 33);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				String username = textField.getText();

				if (password.equals("shop") && username.equals("candy")) {
					textField.setText(null);
					passwordField.setText(null);
					Pastry info = new Pastry();
					info.frame.setVisible(true);
					dispose();

				} else {
					JOptionPane
							.showMessageDialog(null, "Invalid Login Details");
					textField.setText(null);
					passwordField.setText(null);
				}

			}
		});

		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton.setBounds(199, 216, 141, 26);
		contentPane.add(btnNewButton);

	}
}

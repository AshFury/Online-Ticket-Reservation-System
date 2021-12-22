import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JSeparator;

public class TIcket_Details extends JFrame {
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TIcket_Details frame = new TIcket_Details();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	
	public static String trainNumberValue;
	public static String sourceLocation;
	public static String destinationLocation;
	public static String emailID;
	public static String name;
	
	public TIcket_Details() {
		getContentPane().setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		getContentPane().setForeground(Color.WHITE);
		setSize(1000, 600);
		setResizable(false);

		setTitle("Online Ticket Reservation System");
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(-22, -15, 194, 578);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Go to Menu");
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 17));
		btnNewButton.setBounds(45, 64, 124, 27);
		panel.add(btnNewButton);
		btnNewButton .addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 {
					HomePage hp = new HomePage(null);
					hp.setVisible(true);
					
					setVisible(false);
				}
				
			}
			
		});
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(33, 177, 199, 150);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(this.getClass().getResource("/images/person-photo.png")));
	//	lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Tarun R\\eclipse-workspace\\ReservationSystem\\images\\generic-headshot-854256.png"));
		
		JLabel name = new JLabel(TIcket_Details.name);
		name.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		name.setBounds(45, 322, 84, 32);
		panel.add(name);
		
		JLabel email = new JLabel(TIcket_Details.emailID);
		email.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		email.setBounds(45, 353, 119, 32);
		panel.add(email);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 1, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Ticket Number");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		lblNewLabel_2.setBounds(317, 118, 170, 44);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Transaction ID");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		lblNewLabel_3.setBounds(317, 150, 170, 82);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("Coach Number");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		lblNewLabel_2_1.setBounds(317, 224, 144, 44);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Seat Number");
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		lblNewLabel_2_1_1.setBounds(317, 278, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Train Number");
		lblNewLabel_2_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		lblNewLabel_2_1_1_1.setBounds(317, 332, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Date Time");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		lblNewLabel_2_1_1_1_1.setBounds(317, 376, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("Your Ticket Details");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 28));
		lblNewLabel.setBounds(412, 44, 335, 64);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Source");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		lblNewLabel_2_1_1_1_1_1.setBounds(317, 430, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Destination");
		lblNewLabel_2_1_1_1_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		lblNewLabel_2_1_1_1_1_1_1.setBounds(317, 484, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1_1_1_1_1);
		
		JLabel ticketNumber = new JLabel("TN444XR");
		ticketNumber.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		ticketNumber.setForeground(new Color(0, 0, 0));
		ticketNumber.setBounds(590, 127, 144, 39);
		getContentPane().add(ticketNumber);
		
		JLabel transactionID = new JLabel("PTIN556TUR");
		transactionID.setForeground(Color.BLACK);
		transactionID.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		transactionID.setBounds(590, 180, 144, 35);
		getContentPane().add(transactionID);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("17A");
		lblNewLabel_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		lblNewLabel_1_1_1.setBounds(590, 232, 144, 40);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("63");
		lblNewLabel_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		lblNewLabel_1_1_1_1.setBounds(590, 291, 144, 31);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel trainNumber = new JLabel(TIcket_Details.trainNumberValue);
		trainNumber.setForeground(Color.BLACK);
		trainNumber.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		trainNumber.setBounds(590, 340, 144, 40);
		getContentPane().add(trainNumber);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("04/05/21 - 11:30 AM");
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		lblNewLabel_1_1_1_1_1_1.setBounds(590, 384, 194, 40);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel source = new JLabel(TIcket_Details.sourceLocation);
		source.setForeground(Color.BLACK);
		source.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		source.setBounds(590, 438, 194, 40);
		getContentPane().add(source);
		
		JLabel destination = new JLabel(TIcket_Details.destinationLocation);
		destination.setForeground(Color.BLACK);
		destination.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		destination.setBounds(590, 497, 194, 31);
		getContentPane().add(destination);
		
		table = new JTable();
		table.setBounds(231, 524, 611, -420);
		getContentPane().add(table);

	}
}

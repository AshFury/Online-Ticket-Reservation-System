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

public class Ticket_Details extends JFrame {
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
	
	public Ticket_Details(int passenger_id) {
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
					HomePage hp = new HomePage();
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
		
		System.out.println("passenger id : " + passenger_id);
		
		int passenger_index = -1;
		int ticket_index = -1;
		System.out.println("Searching for :" + passenger_id);
		for (int i = 0; i < App.passengers.size(); i++) {
			System.out.println("passenger ids : " + App.passengers.get(i).Passenger_ID);
			if (App.passengers.get(i).Passenger_ID.equals(String.valueOf(passenger_id))) {
				passenger_index = i;
			}
		}
	
		
		// find user with same email as passenger id
		String name_str = "";
		for (int i = 0; i < App.passengers.size(); i++) {
			if (App.passengers.get(i).Passenger_ID.equals(String.valueOf(passenger_id))) {
				passenger_index = i;
				System.out.println("Passenger match found at index : " + i);
				for (int j = 0; j < App.users.size(); j++) {
				if (App.passengers.get(i).Email_ID.equals(App.users.get(j).Email_ID)) {
					name_str = App.users.get(j).First_Name.concat(App.users.get(j).Last_Name);
				}
			}
			}
		
		}
		
		System.out.println("Searching for ticket");
		for (int i = 0; i < App.tickets.size(); i++) {
			System.out.println("Searching for : " + App.tickets.get(i).Ticket_Number + " " + App.passengers.get(passenger_index).Ticket_Number);
			if (App.tickets.get(i).Ticket_Number == App.passengers.get(passenger_index).Ticket_Number) {
				
				ticket_index = i;
			}
		}
		
		System.out.println("Name : " + name_str);
		JLabel name = new JLabel(name_str);
		name.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		name.setBounds(45, 322, 84, 32);
		panel.add(name);
		
		JLabel email = new JLabel(App.passengers.get(passenger_index).Email_ID);
		email.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		email.setBounds(45, 353, 119, 32);
		panel.add(email);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 1, 2);
		panel.add(separator);
		
		JLabel tnumbe = new JLabel("Ticket Number");
		tnumbe.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 19));
		tnumbe.setBounds(317, 118, 170, 44);
		getContentPane().add(tnumbe);
		
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
		
		JLabel ticketNumberField = new JLabel(String.valueOf(App.passengers.get(passenger_index).Ticket_Number));
		ticketNumberField.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		ticketNumberField.setForeground(new Color(0, 0, 0));
		ticketNumberField.setBounds(590, 127, 144, 39);
		getContentPane().add(ticketNumberField);
		
		String transaction_id = String.valueOf(App.payments.get(ticket_index).Transaction_ID);
	
	
		System.out.println("Ticket index : " + ticket_index);
		
		JLabel transactionIDField = new JLabel(transaction_id);
		transactionIDField.setForeground(Color.BLACK);
		transactionIDField.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		transactionIDField.setBounds(590, 180, 144, 35);
		getContentPane().add(transactionIDField);
		
		JLabel coachNumberField = new JLabel(App.tickets.get(ticket_index).Coach_Number);
		coachNumberField.setForeground(Color.BLACK);
		coachNumberField.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		coachNumberField.setBounds(590, 232, 144, 40);
		getContentPane().add(coachNumberField);
		
		JLabel seatNumberField = new JLabel(String.valueOf(App.tickets.get(ticket_index).Seat_Number));
		seatNumberField.setForeground(Color.BLACK);
		seatNumberField.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		seatNumberField.setBounds(590, 291, 144, 31);
		getContentPane().add(seatNumberField);
		
		JLabel trainNumberField = new JLabel(String.valueOf(App.tickets.get(ticket_index).Train_Number));
		trainNumberField.setForeground(Color.BLACK);
		trainNumberField.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		trainNumberField.setBounds(590, 340, 144, 40);
		getContentPane().add(trainNumberField);
		
		JLabel dateTimeField = new JLabel(String.valueOf(App.tickets.get(ticket_index).Travel_Date));
		dateTimeField.setForeground(Color.BLACK);
		dateTimeField.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		dateTimeField.setBounds(590, 384, 194, 40);
		getContentPane().add(dateTimeField);
		
		int train_index = -1;
		for (int i = 0; i < App.trains.size(); i++) {
			if (App.trains.get(i).Train_Number == (App.tickets.get(ticket_index).Train_Number)) {
				train_index = i;
			}
		}
		
		JLabel sourceField = new JLabel(App.trains.get(train_index).Source);
		sourceField.setForeground(Color.BLACK);
		sourceField.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		sourceField.setBounds(590, 438, 194, 40);
		getContentPane().add(sourceField);
		
		JLabel destinationField = new JLabel(App.trains.get(train_index).Destination);
		destinationField.setForeground(Color.BLACK);
		destinationField.setFont(new Font("Yu Gothic", Font.PLAIN, 19));
		destinationField.setBounds(590, 497, 194, 31);
		getContentPane().add(destinationField);
		
		table = new JTable();
		table.setBounds(231, 524, 611, -420);
		getContentPane().add(table);

	}
}

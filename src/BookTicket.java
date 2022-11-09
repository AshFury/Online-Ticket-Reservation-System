import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


public class BookTicket extends JFrame {
	private JTextField destinationLocation;
	private JTextField sourceLocation;
	public static int ticket_number = 63;

	public static int passenger_index = 0;
	public static int ticket_index = 0;
	
	public int index = 0;
	private JTextField special_needs;
	public static boolean isValid(String email) {
		String emailFormate = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\."
				+ "[a-zA-Z0-9_!#$%&'+/=?`{|}~^-]+)@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

		Pattern p = Pattern.compile(emailFormate);
		if (email == null) {
			return false;
		}
		Matcher matcher = p.matcher(email);
		return matcher.matches();
	}

	public BookTicket() {
		setSize(1000, 600);
		setResizable(false);

		setTitle("Online Ticket Reservation System");
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(-22, -15, 1008, 117);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Book Your Ticket");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 29));
		lblNewLabel.setBounds(382, 33, 529, 74);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Train Number");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(281, 129, 106, 44);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Source");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(281, 227, 182, 50);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_2_1_1 = new JLabel("Destination");
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(281, 280, 106, 44);
		getContentPane().add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Class Type");
		lblNewLabel_2_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(281, 334, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Payment Method");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(281, 380, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1_1_1);

		destinationLocation = new JTextField();
		destinationLocation.setColumns(10);
		destinationLocation.setBounds(500, 292, 176, 27);
		getContentPane().add(destinationLocation);

		String classTypeOptions[] = { "AC First Class", "Second Class", "Third Class" };

		@SuppressWarnings("unchecked")
		JComboBox classTypes = new JComboBox(classTypeOptions);
		classTypes.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		classTypes.setBounds(500, 343, 115, 27);
		getContentPane().add(classTypes);

		String paymentMethodOptions[] = { "Net Banking", "Card (Credit / Debit)", "UPI" };
		JComboBox paymentsMethod = new JComboBox(paymentMethodOptions);
		paymentsMethod.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		paymentsMethod.setBounds(500, 392, 115, 27);
		getContentPane().add(paymentsMethod);

		String destination[] = { "Vasco Da Gama", "Bangalore Cy Junction", "Pune Junction", "Howrah Junction",
				"Chhapra", "Bhubaneswar", "Pune Junction", "Chittor", "Guntur Junction", "Udaipur", };

		int index = 0;
		String ticketNumbers[] = new String[App.tickets.size()];
		for (int i = 0; i < App.trains.size(); i++) {
			ticketNumbers[i] = String.valueOf(App.trains.get(i).Train_Number);
		}
		
		String source[] = new String[App.tickets.size()];
		for (int i = 0; i < App.trains.size(); i++) {
			source[i] = App.trains.get(i).Source;
		}
		
		String desination[] = new String[App.tickets.size()];
		for (int i = 0; i < App.trains.size(); i++) {
			destination[i] = App.trains.get(i).Destination;
		}
		// selected index
		
		JComboBox trainNumber = new JComboBox(ticketNumbers);
		trainNumber.setBounds(500, 144, 115, 21);
		getContentPane().add(trainNumber);

		trainNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = trainNumber.getSelectedIndex();
				sourceLocation.setText(source[index]);
				destinationLocation.setText(destination[index]);
			}
		});

		
		special_needs = new JTextField();
		special_needs.setColumns(10);
		special_needs.setBounds(500, 441, 176, 27);
		getContentPane().add(special_needs);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("Special Needs");
		lblNewLabel_2_1_1_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1_2.setBounds(281, 429, 106, 44);
		getContentPane().add(lblNewLabel_2_1_1_2);
		
		Random random = new Random();   
		BookTicket.ticket_number = (short)random.nextInt();
		if (BookTicket.ticket_number < 0) {
			BookTicket.ticket_number *= -1;
		}
		String class_type = String.valueOf((int)(Math.random() * (9) + 1));
		JButton makePayment = new JButton("Make Payment");
		makePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date travel_date = new Date(0, 0, 0);
				for (int i = 0; i < App.trains.size(); i++) {
					if (String.valueOf(App.trains.get(i).Train_Number).equals(trainNumber.getSelectedItem())) {
						travel_date = Date.valueOf(App.trains.get(i).Arrival_Time.toLocalDateTime().toLocalDate());
						System.out.println(travel_date);
					}
				}
				
				if (paymentsMethod.getSelectedIndex() == 2) {
					Random rand = new Random();
					int val = rand.nextInt();
					if (val < 0) {
						val *= -1;
					}
					
					int passenger_id = rand.nextInt();
					if (passenger_id < 0) {
						passenger_id *= -1;
					}
					
					int ticket_number = rand.nextInt();
					if (ticket_number < 0) {
						ticket_number *= -1;
					}
					
					int pnr_number = rand.nextInt();
					if (pnr_number < 0) {
						pnr_number *= -1;
					}
					
					// get phone number from passenger list
					String phone_number = "";
					for (int i = 0; i < App.logins.size(); i++) {
						if (App.logins.get(i).Email_ID.equals(App.users.get(App.user_index).Email_ID)) {
							phone_number = String.valueOf(App.logins.get(i).Phone_Number);
						}
					}
					
					try {
						App.create_payment(val, "UPI", 500, new Timestamp(System.currentTimeMillis()), "Success");
						
						App.create_ticket((BookTicket.ticket_number), (val), class_type, (int)BookTicket.ticket_number / 20, Integer.parseInt(String.valueOf(trainNumber.getSelectedItem())), travel_date);
						
						
						App.create_passenger(String.valueOf(passenger_id), (long)(pnr_number), (BookTicket.ticket_number), 
								App.users.get(App.user_index).Email_ID, 
								Long.valueOf(phone_number), App.users.get(App.user_index).Gender, (String)classTypes.getSelectedItem(), "", special_needs.getText());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					UPIPage upiPage = new UPIPage(val, passenger_id);
					upiPage.setVisible(true);
					setVisible(false);
				}
				else if (paymentsMethod.getSelectedIndex() == 1) {
					Random rand = new Random();
					int val = rand.nextInt();
					if (val < 0) {
						val *= -1;
					}
					
					
			
					int passenger_id = rand.nextInt();
					if (passenger_id < 0) {
						passenger_id *= -1;
					}
					
					int ticket_number = rand.nextInt();
					if (ticket_number < 0) {
						ticket_number *= -1;
					}
					
					int pnr_number = rand.nextInt();
					if (pnr_number < 0) {
						pnr_number *= -1;
					}
					
					// get phone number from passenger list
					String phone_number = "";
					for (int i = 0; i < App.logins.size(); i++) {
						if (App.logins.get(i).Email_ID.equals(App.users.get(App.user_index).Email_ID)) {
							phone_number = String.valueOf(App.logins.get(i).Phone_Number);
						}
					}
					
					
					try {
						App.create_payment(val, "Card Payment", 500, new Timestamp(System.currentTimeMillis()), "Success");
						
						App.create_ticket((BookTicket.ticket_number), (val), class_type, (int)BookTicket.ticket_number / 20, Integer.parseInt(String.valueOf(trainNumber.getSelectedItem())), travel_date);
						
						
						App.create_passenger(String.valueOf(passenger_id), (long)(pnr_number), (BookTicket.ticket_number), 
								App.users.get(App.user_index).Email_ID, 
								Long.valueOf(phone_number), App.users.get(App.user_index).Gender, (String)classTypes.getSelectedItem(), "", special_needs.getText());
						BookTicket.ticket_number++;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					CardPage cp = new CardPage(val, passenger_id);
					cp.setVisible(true);
					setVisible(false);
				}
				else if (paymentsMethod.getSelectedIndex() == 0) {
					Random rand = new Random();
					int val = rand.nextInt();
					if (val < 0) {
						val *= -1;
					}
					
					int passenger_id = rand.nextInt();
					if (passenger_id < 0) {
						passenger_id *= -1;
					}
					
					int ticket_number = rand.nextInt();
					if (ticket_number < 0) {
						ticket_number *= -1;
					}
					
					int pnr_number = rand.nextInt();
					if (pnr_number < 0) {
						pnr_number *= -1;
					}
					
					// get phone number from passenger list
					String phone_number = "";
					for (int i = 0; i < App.logins.size(); i++) {
						if (App.logins.get(i).Email_ID.equals(App.users.get(App.user_index).Email_ID)) {
							phone_number = String.valueOf(App.logins.get(i).Phone_Number);
						}
					}
					
					try {
						App.create_payment(val, "Net Banking", 500, new Timestamp(System.currentTimeMillis()), "Success");
						
						App.create_ticket((BookTicket.ticket_number), (val), class_type, (int)BookTicket.ticket_number / 20, Integer.parseInt(String.valueOf(trainNumber.getSelectedItem())), travel_date);
						
						App.create_passenger(String.valueOf(passenger_id), (long)(pnr_number), (int)(BookTicket.ticket_number), 
								App.users.get(App.user_index).Email_ID, 
								Long.valueOf(phone_number), App.users.get(App.user_index).Gender, (String)classTypes.getSelectedItem(), "", special_needs.getText());
						BookTicket.ticket_number++;
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					NetBankingPage nbp = new NetBankingPage(val, passenger_id);
					nbp.setVisible(true);
					setVisible(false);
				}
				
			
				
				
				System.out.println("Make payment");
			}
		});
		makePayment.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		makePayment.setBounds(381, 501, 176, 36);
		getContentPane().add(makePayment);

		sourceLocation = new JTextField();
		sourceLocation.setColumns(10);
		sourceLocation.setBounds(500, 242, 176, 27);
		getContentPane().add(sourceLocation);
		
		JLabel Fare = new JLabel("Fare");
		Fare.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		Fare.setBounds(281, 175, 182, 50);
		getContentPane().add(Fare);
		
		JLabel lblNewLabel_1 = new JLabel("300 Rupees");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(500, 184, 87, 33);
		getContentPane().add(lblNewLabel_1);
	

	}
}

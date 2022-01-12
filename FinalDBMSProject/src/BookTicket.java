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
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class BookTicket extends JFrame {
	private JTextField destinationLocation;
	private JTextField sourceLocation;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Create_Account frame = new Create_Account();
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

		public int index = 0;
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
		// setIconImage(Toolkit.getDefaultToolkit()
		// .getImage("C:\\Users\\Tarun
		// R\\eclipse-workspace\\ReservationSystem\\images\\amrita_logo.png"));
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
		lblNewLabel_3.setBounds(281, 214, 182, 50);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_2_1_1 = new JLabel("Destination");
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(281, 274, 106, 44);
		getContentPane().add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Class Type");
		lblNewLabel_2_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(281, 340, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Payment Method");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(281, 401, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1_1_1);

		destinationLocation = new JTextField();
		destinationLocation.setColumns(10);
		destinationLocation.setBounds(500, 286, 176, 27);
		getContentPane().add(destinationLocation);

		String classTypeOptions[] = { "AC First Class", "Second Class", "Third Class" };

		@SuppressWarnings("unchecked")
		JComboBox classTypes = new JComboBox(classTypeOptions);
		classTypes.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		classTypes.setBounds(500, 349, 115, 27);
		getContentPane().add(classTypes);

		String paymentMethodOptions[] = { "Net Banking", "Card (Credit / Debit)", "UPI" };
		JComboBox paymentsMethod = new JComboBox(paymentMethodOptions);
		paymentsMethod.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		paymentsMethod.setBounds(500, 416, 115, 27);
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
		
		JComboBox ticketNumber = new JComboBox(ticketNumbers);
		ticketNumber.setBounds(500, 144, 115, 21);
		getContentPane().add(ticketNumber);

		ticketNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = ticketNumber.getSelectedIndex();
				sourceLocation.setText(source[index]);
				destinationLocation.setText(destination[index]);
			}
		});

		JButton makePayment = new JButton("Make Payment");
		makePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (paymentsMethod.getSelectedIndex() == 2) {
					Random rand = new Random();
					int val = rand.nextInt();
					if (val < 0) {
						val *= -1;
					}
					
					UPIPage upiPage = new UPIPage(val);
					upiPage.setVisible(true);
					setVisible(false);
				}
				else if (paymentsMethod.getSelectedIndex() == 1) {
					Random rand = new Random();
					int val = rand.nextInt();
					if (val < 0) {
						val *= -1;
					}
					
					CardPage cp = new CardPage(val);
					cp.setVisible(true);
					setVisible(false);
				}
				else if (paymentsMethod.getSelectedIndex() == 0) {
					Random rand = new Random();
					int val = rand.nextInt();
					if (val < 0) {
						val *= -1;
					}
					
					NetBankingPage nbp = new NetBankingPage(val);
					nbp.setVisible(true);
					setVisible(false);
				}
				
				if (makePayment.getText() == "Confirm Booking") {
					Ticket_Details.destinationLocation = destination[index];
					Ticket_Details.sourceLocation = source[index];
					Ticket_Details.trainNumberValue = ticketNumbers[index];
					Ticket_Details td = new Ticket_Details(-1, 1);
					td.setVisible(true);
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
		sourceLocation.setBounds(500, 233, 176, 27);
		getContentPane().add(sourceLocation);

	}
}

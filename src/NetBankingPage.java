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

public class NetBankingPage extends JFrame {
	private JTextField transcationNumber;

	public int index = 0;
	private JTextField bankNameField;
	private JTextField accountNumber;
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

	public NetBankingPage(int transactionNumber, int passengerID) {
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

		JLabel lblNewLabel = new JLabel("Net Banking Payment Method");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 29));
		lblNewLabel.setBounds(297, 33, 529, 74);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Bank Name");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(280, 246, 106, 44);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1_1 = new JLabel("Transaction Number");
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(280, 300, 146, 44);
		getContentPane().add(lblNewLabel_2_1_1);

		transcationNumber = new JTextField(transactionNumber);
		transcationNumber.setText(String.valueOf(transactionNumber));
		transcationNumber.setColumns(10);
		transcationNumber.setBounds(499, 312, 176, 27);
		getContentPane().add(transcationNumber);

		String classTypeOptions[] = { "AC First Class", "Second Class", "Third Class" };

		String paymentMethodOptions[] = { "Net Banking", "Card (Credit / Debit)", "UPI" };

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

		
		bankNameField = new JTextField();
		bankNameField.setColumns(10);
		bankNameField.setBounds(499, 262, 176, 27);
		getContentPane().add(bankNameField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Account Number");
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(280, 188, 146, 44);
		getContentPane().add(lblNewLabel_2_1);
		
		accountNumber = new JTextField();
		accountNumber.setColumns(10);
		accountNumber.setBounds(499, 204, 176, 27);
		
		JButton makePayment = new JButton("Confirm Booking");
		makePayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (makePayment.getText() == "Confirm Booking") {
					try {
						App.create_netbanking(Integer.parseInt(accountNumber.getText()), bankNameField.getText(), transactionNumber);
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					Ticket_Details.destinationLocation = destination[index];
					Ticket_Details.sourceLocation = source[index];
					Ticket_Details.trainNumberValue = ticketNumbers[index];
					Ticket_Details td = new Ticket_Details(passengerID);
					td.setVisible(true);
					setVisible(false);
				}
				
				makePayment.setText("Confirm Booking");
				Random rand = new Random();
				int val = rand.nextInt();
				if (val < 0) {
					val *= -1;
				}

				String num = val + "";
				
				System.out.println("Make payment");
			}
		});

		makePayment.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		makePayment.setBounds(371, 404, 176, 36);
		getContentPane().add(makePayment);
		
		getContentPane().add(accountNumber);

	}
}

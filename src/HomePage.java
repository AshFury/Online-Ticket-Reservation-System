import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import javax.swing.border.MatteBorder;

public class HomePage extends JFrame {
	private JPasswordField passwordField;

	public boolean signinButtonClicked = false;
	public boolean signupButtonClicked = false;

	public boolean canSignIn = false;
	public boolean canSignup = true;

	private JTextField emailID;

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

	public HomePage() {

		setSize(1000, 600);
		setResizable(false);

		setTitle("Online Ticket Reservation System");
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(240, 255, 255)));
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(0, 0, 281, 568);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Online Ticket");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 28));
		lblNewLabel.setBounds(23, 273, 207, 100);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Reservation System");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 28));
		lblNewLabel_1.setBounds(23, 327, 289, 120);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBackground(new Color(248, 248, 255));
		lblNewLabel_5.setIcon(new ImageIcon(this.getClass().getResource("/images/globe.jpg")));
		lblNewLabel_5.setBounds(23, 108, 223, 152);
		panel.add(lblNewLabel_5);

		JButton searchTrainBtn = new JButton("Search Trains");
		searchTrainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SearchTrains searchPage = new SearchTrains();
				setVisible(false);
				searchPage.setVisible(true);
			}
		});

		searchTrainBtn.setBounds(23, 455, 179, 21);
		panel.add(searchTrainBtn);

		JLabel lblNewLabel_2 = new JLabel("Email ID");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(454, 232, 106, 44);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(454, 269, 144, 95);
		getContentPane().add(lblNewLabel_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(608, 306, 176, 27);
		getContentPane().add(passwordField);

		JLabel lblNewLabel_4 = new JLabel("Welcome to the Ticket Reservation System !");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 28));
		lblNewLabel_4.setBounds(358, 178, 572, 44);
		getContentPane().add(lblNewLabel_4);

		emailID = new JTextField();
		emailID.setBounds(608, 244, 180, 27);
		getContentPane().add(emailID);
		emailID.setColumns(10);

		JButton signinButton = new JButton("Sign In");
		signinButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		signinButton.setBounds(609, 374, 106, 27);
		getContentPane().add(signinButton);
		signinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					String email = emailID.getText();
					boolean emailIsValid = false;

					@SuppressWarnings("deprecation")
					String password = passwordField.getText();
					boolean passwordIsValid = false;

					// check if email is matching

					int index = -1;

					for (int i = 0; i < App.logins.size(); i++) {

						if (email.equals(App.logins.get(i).Email_ID.trim())) {
							emailIsValid = true;
							System.out.println("Required password : " + App.logins.get(i).Password);
							if (App.logins.get(i).Password.equals(password)) {
								passwordIsValid = true;
								index = i;
								App.has_logged_in = true;
								// get the user data
								for (int j = 0; j < App.users.size(); j++) {
									if (App.logins.get(index).Email_ID.equals(App.users.get(j).Email_ID)) {
										App.user_index = j;
										System.out.println("Current user index : " + App.user_index);
									}
								}
							}
						}
					}
						
					if (emailIsValid && passwordIsValid) {
						canSignIn = true;
						// find the current user
					} else {
						// emailID.setBorder(new LineBorder(Color.RED, 2));
						emailID.setForeground(Color.RED);
						passwordField.setForeground(Color.RED);
						emailID.setBorder(new LineBorder(Color.RED));
						passwordField.setBorder(new LineBorder(Color.RED));
					}

					if (canSignIn) {
						for (int i = 0; i < App.system_admins.size(); i++) {
							if (App.system_admins.get(i).Email_ID.equals(email)) {
								AdminControlpage acp = new AdminControlpage();
								acp.setVisible(true);
								setVisible(false);
								return;
							}
						}
					}
					String passenger_id = new String();
					int ticket_index = -1;
					signinButtonClicked = true;
					if (index != -1 && canSignIn) {

						// see if there is ticket
						int passenger_index = -1;
						for (int i = 0; i < App.passengers.size(); i++) {
							System.out.println(App.passengers.get(i).Email_ID);
							if (email.equals(App.passengers.get(i).Email_ID)) {
								passenger_id = App.passengers.get(i).Passenger_ID;
								passenger_index = i;
								System.out.println("Passenger index : " + passenger_index);
								for (int j = 0; j < App.tickets.size(); j++) {
									System.out.println("Tickets : " + App.tickets.get(j).Ticket_Number + " and to search for : " + App.passengers.get(i).Ticket_Number);
									if (App.passengers.get(i).Ticket_Number == App.tickets.get(j).Ticket_Number) {
										System.out.println("Ticket index : " + ticket_index);
										ticket_index = j;
									}
								}
							}
						}
						
						
						System.out.println("Ticket index : " + ticket_index);
						
						
			
						if (!passenger_id.equals("")) {
							Ticket_Details td = new Ticket_Details(Integer.parseInt(passenger_id));
							td.setVisible(true);
							setVisible(false);
						} else {
							SearchTrains st = new SearchTrains();
							st.setVisible(true);
							setVisible(false);
						}
					}
						// TIcket_Details td = new TIcket_Details();
						// td.setVisible(true);
					

					if (index == -1 && canSignIn) {
						SearchTrains st = new SearchTrains();
						st.setVisible(true);
						setVisible(false);
					}

				}
			}

		});
		JButton signupButton = new JButton("Sign Up");
		signupButton.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		signupButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				signupButtonClicked = true;
				setVisible(false);
				Create_Account ca = new Create_Account();
				setVisible(false);
				ca.setVisible(true);
			}
		});
		signupButton.setBounds(454, 374, 106, 27);
		getContentPane().add(signupButton);

	}
}

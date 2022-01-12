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
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;


public class Create_Account extends JFrame {
	private JPasswordField confirmPassword;
	private JPasswordField password;
	private JTextField emailID;
	private JTextField name;
	private JTextField dob;
	private JTextField gender;
	private JTextField phone_number;

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

	public Create_Account() {
		setSize(1000, 600);
		setResizable(false);
		//setIconImage(Toolkit.getDefaultToolkit()
		//		.getImage("C:\\Users\\Tarun R\\eclipse-workspace\\ReservationSystem\\images\\amrita_logo.png"));
		setTitle("Online Ticket Reservation System");
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(-22, -15, 1008, 117);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Create your Account");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 29));
		lblNewLabel.setBounds(347, 33, 529, 74);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Email ID");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(297, 112, 106, 44);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Confirm Password");
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(297, 224, 182, 50);
		getContentPane().add(lblNewLabel_3);

		confirmPassword = new JPasswordField();
		confirmPassword.setBounds(470, 247, 176, 27);
		getContentPane().add(confirmPassword);

		JLabel lblNewLabel_2_1_1 = new JLabel("Full Name");
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(297, 284, 106, 44);
		getContentPane().add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Date of Birth");
		lblNewLabel_2_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1.setBounds(297, 330, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1_1);

		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Gender");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1.setBounds(297, 384, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1_1_1);

		JLabel lblNewLabel_3_1 = new JLabel("Password");
		lblNewLabel_3_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(297, 166, 144, 50);
		getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/images/person-photo.png")));
		//lblNewLabel_1.setIcon(new ImageIcon(
			//	"C:\\Users\\Tarun R\\eclipse-workspace\\ReservationSystem\\images\\generic-headshot-854256.png"));
		lblNewLabel_1.setBounds(34, 140, 158, 157);
		getContentPane().add(lblNewLabel_1);

		password = new JPasswordField();
		password.setBounds(470, 187, 176, 27);
		getContentPane().add(password);

		JLabel lblNewLabel_4 = new JLabel("Add Image (Optional)");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(44, 305, 128, 25);
		getContentPane().add(lblNewLabel_4);

		emailID = new JTextField();
		emailID.setBounds(470, 120, 176, 27);
		getContentPane().add(emailID);
		emailID.setColumns(10);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(470, 293, 176, 27);
		getContentPane().add(name);

		dob = new JTextField();
		dob.setColumns(10);
		dob.setBounds(470, 346, 176, 27);
		getContentPane().add(dob);

		gender = new JTextField();
		gender.setColumns(10);
		gender.setBounds(470, 400, 176, 27);
		getContentPane().add(gender);

		JButton createAccount = new JButton("Create Account");
		createAccount.setFont(new Font("Yu Gothic UI", Font.PLAIN, 12));
		createAccount.setBounds(381, 501, 176, 36);
		getContentPane().add(createAccount);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Phone Number");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lblNewLabel_2_1_1_1_1_1.setBounds(297, 438, 144, 44);
		getContentPane().add(lblNewLabel_2_1_1_1_1_1);
		
		phone_number = new JTextField();
		phone_number.setColumns(10);
		phone_number.setBounds(470, 454, 176, 27);
		getContentPane().add(phone_number);
		createAccount.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				{

					boolean canCreateAccount = true;

					String email = emailID.getText();
					if (!Create_Account.isValid(email)) {
						emailID.setForeground(new Color(255, 0, 0));
						emailID.setBorder(new LineBorder(new Color(255, 0, 0)));

						canCreateAccount = false;
					} else {
						emailID.setForeground(new Color(0, 0, 0));
						emailID.setBorder(new LineBorder(new Color(0, 0, 0)));
						//canCreateAccount = true;
					}

					@SuppressWarnings("deprecation")
					String passwordText = password.getText();
					@SuppressWarnings("deprecation")
					String passwordConfirm = confirmPassword.getText();

					System.out.println(passwordText + " " + passwordConfirm);
					if (passwordText.equals("") || passwordConfirm.equals("") 
							|| passwordText.length() <= 5) {
						password.setForeground(new Color(255, 0, 0));
						confirmPassword.setForeground(new Color(255, 0, 0));
						password.setBorder(new LineBorder(new Color(255, 0, 0)));
						confirmPassword.setBorder(new LineBorder(new Color(255, 0, 0)));
							System.out.println(passwordText.equals(passwordConfirm));
						canCreateAccount = false;
					} else {
						//System.out.println(passwordText + " confirm password : " + passwordConfirm);
						password.setForeground(new Color(0, 0, 0));
						confirmPassword.setForeground(new Color(0, 0, 0));
						password.setBorder(new LineBorder(new Color(0, 0, 0)));
						confirmPassword.setBorder(new LineBorder(new Color(0, 0, 0)));
						canCreateAccount = true;
					}
					
					 if (!(passwordText.equals(passwordConfirm)))
					 {
						 password.setForeground(new Color(255, 0, 0));
							confirmPassword.setForeground(new Color(255, 0, 0));
							password.setBorder(new LineBorder(new Color(255, 0, 0)));
							confirmPassword.setBorder(new LineBorder(new Color(255, 0, 0)));
								System.out.println("Password status : " + passwordText.equals(passwordConfirm));
							canCreateAccount = false;
					 }
					String nameText = name.getText();
					String dobText = dob.getText();
					String genderText = gender.getText();

					boolean nameValid = true;
					for (int i = 0; i < nameText.length(); i++) {
						if (nameText.charAt(i) >= '0' && nameText.charAt(i) <= '9') {
							nameValid = false;
							canCreateAccount = false;
							break;
						}
					}

					if (nameText.equals("") || !nameValid) {
						name.setForeground(new Color(255, 0, 0));
						name.setBorder(new LineBorder(new Color(255, 0, 0)));
						canCreateAccount = false;
					} else {
						name.setForeground(new Color(0, 0, 0));
						name.setBorder(new LineBorder(new Color(0, 0, 0)));
					//	canCreateAccount = true;
					}

					if (dobText.equals("")) {
						dob.setForeground(new Color(255, 0, 0));
						dob.setBorder(new LineBorder(new Color(255, 0, 0)));
						canCreateAccount = false;
					} else {
						dob.setForeground(new Color(0, 0, 0));
						dob.setBorder(new LineBorder(new Color(0, 0, 0)));
					//	canCreateAccount = true;
					}

					if (genderText.equals("")) {
						gender.setForeground(new Color(255, 0, 0));
						gender.setBorder(new LineBorder(new Color(255, 0, 0)));
						canCreateAccount = false;
					} else {
						gender.setForeground(new Color(0, 0, 0));
						gender.setBorder(new LineBorder(new Color(0, 0, 0)));
					//	canCreateAccount = true;
					}

					String ph_no = phone_number.getText();
					@SuppressWarnings("deprecation")
					Date dt = java.sql.Date.valueOf("2000-10-21");
					System.out.println(dt);
					
					
					if (canCreateAccount) {
						
						try {
							App.create_user(email, passwordConfirm, nameText, dt, genderText, ph_no);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						Ticket_Details.emailID = email;
						Ticket_Details.name = nameText;
						SearchTrains st = new SearchTrains();
						st.setVisible(true);
						setVisible(false);
					}
				}

			}

		});

	}
}

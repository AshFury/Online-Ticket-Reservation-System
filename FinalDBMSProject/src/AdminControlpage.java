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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.border.BevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminControlpage extends JFrame {

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
	
	public static String[] column = null;
	public static Object[][] rows = null;
	
	
	public AdminControlpage() {
		
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

		JLabel lblNewLabel = new JLabel("Admin Control Page");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 29));
		lblNewLabel.setBounds(340, 33, 529, 74);
		panel.add(lblNewLabel);

		{
			JButton bookTicket = new JButton("Home Page");
			bookTicket.setBounds(31, 21, 105, 21);
			panel.add(bookTicket);
			bookTicket.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomePage bt = new HomePage();
					bookTicket.setText("Home page");
					bt.setVisible(true);
					setVisible(false);
				}
			});
			bookTicket.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		}

		JComboBox comboBox = new JComboBox();
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Trains" , "Users", "Tickets", "Passengers"}));
		comboBox.setBounds(43, 112, 112, 21);
		getContentPane().add(comboBox);

		String[] column = null;
		Object[][] rows = null;
		

		AdminControlpage.column = new String[]{ "Ticket_number", "Transaction_ID", "Coach_Number", "Seat_Number", "Train_number",
		"Travel_date" };
		
		 AdminControlpage.rows = new Object[App.trains.size()][9];
			for (int i = 0; i < App.trains.size(); i++) {
				AdminControlpage.rows[i][0] = App.trains.get(i).Train_Number;
				AdminControlpage.rows[i][1] = App.trains.get(i).Train_Name;
				AdminControlpage.rows[i][2] = App.trains.get(i).Route_ID;
				AdminControlpage.rows[i][3] = App.trains.get(i).Available_Seats;
				AdminControlpage.rows[i][4] = App.trains.get(i).Source;
				AdminControlpage.rows[i][5] = App.trains.get(i).Destination;
				AdminControlpage.rows[i][6] = App.trains.get(i).Arrival_Time;
				AdminControlpage.rows[i][7] = App.trains.get(i).Departure_Time;
				AdminControlpage.rows[i][8] = App.trains.get(i).Train_Status;
			}
			
			final JTable table = new JTable(AdminControlpage.rows, AdminControlpage.column);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Action performned");
				if (comboBox.getSelectedIndex() == 0) {
					AdminControlpage.column = new String[]{ "Ticket_number", "Transaction_ID", "Coach_Number", "Available Seats", "Train_number",
					"Travel_date" };
					
					 AdminControlpage.rows = new Object[App.trains.size()][9];
						for (int i = 0; i < App.trains.size(); i++) {
							AdminControlpage.rows[i][0] = App.trains.get(i).Train_Number;
							AdminControlpage.rows[i][1] = App.trains.get(i).Train_Name;
							AdminControlpage.rows[i][2] = App.trains.get(i).Route_ID;
							AdminControlpage.rows[i][3] = App.trains.get(i).Available_Seats;
							AdminControlpage.rows[i][4] = App.trains.get(i).Source;
							AdminControlpage.rows[i][5] = App.trains.get(i).Destination;
							AdminControlpage.rows[i][6] = App.trains.get(i).Arrival_Time;
							AdminControlpage.rows[i][7] = App.trains.get(i).Departure_Time;
							AdminControlpage.rows[i][8] = App.trains.get(i).Train_Status;
						}
				}

				else if (comboBox.getSelectedIndex() == 1) {
					AdminControlpage.column  = new String[]{ "Email_ID", "First_Name", "Last_name", "DOB", "Gender" };
					
					 AdminControlpage.rows = new Object[App.users.size()][5];
						for (int i = 0; i < App.users.size(); i++) {
							AdminControlpage.rows[i][0] = App.users.get(i).Email_ID;
							AdminControlpage.rows[i][1] = App.users.get(i).First_Name;
							AdminControlpage.rows[i][2] = App.users.get(i).Last_Name;
							AdminControlpage.rows[i][3] = App.users.get(i).Date_Of_Birth;
							AdminControlpage.rows[i][4] = App.users.get(i).Gender;
						}
				}
				
				else if (comboBox.getSelectedIndex() == 2) {
					AdminControlpage.column  = new String[]{ "Ticket_Number", "Transaction_ID", "Coach_Number", "Seat Numbe", "Train_Number", "Travel_Date" };
					
					 AdminControlpage.rows = new Object[App.tickets.size()][6];
						for (int i = 0; i < App.tickets.size(); i++) {
							AdminControlpage.rows[i][0] = App.tickets.get(i).Ticket_Number;
							AdminControlpage.rows[i][1] = App.tickets.get(i).Transaction_ID;
							AdminControlpage.rows[i][2] = App.tickets.get(i).Coach_Number;
							AdminControlpage.rows[i][3] = App.tickets.get(i).Seat_Number;
							AdminControlpage.rows[i][4] = App.tickets.get(i).Train_Number;
							AdminControlpage.rows[i][5] = App.tickets.get(i).Travel_Date;
						}
				}
				
				else if (comboBox.getSelectedIndex() == 3) {
					AdminControlpage.column  = new String[]{ "Passenger_ID", "PNR_Number", "Ticket_Number", "Email_ID", "Phone_Number", "Gender", "Class_Type" ,"Birth_Preference", "Special_Needs"};
					
					AdminControlpage.rows = new Object[App.passengers.size()][9];
						for (int i = 0; i < App.passengers.size(); i++) {
							AdminControlpage.rows[i][0] = App.passengers.get(i).Passenger_ID;
							AdminControlpage.rows[i][1] = App.passengers.get(i).PNR_Number;
							AdminControlpage.rows[i][2] = App.passengers.get(i).Ticket_Number;
							AdminControlpage.rows[i][3] = App.passengers.get(i).Email_ID;
							AdminControlpage.rows[i][4] = App.passengers.get(i).Phone_Number;
							AdminControlpage.rows[i][5] = App.passengers.get(i).Gender;
							AdminControlpage.rows[i][6] = App.passengers.get(i).Class_Type;
							AdminControlpage.rows[i][7] = App.passengers.get(i).Birth_Preference;
							AdminControlpage.rows[i][8] = App.passengers.get(i).Special_Needs;
							
						}
				}
				
				table.setModel(new DefaultTableModel(AdminControlpage.rows, AdminControlpage.column));
			}
		});
		

		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(AdminControlpage.rows, AdminControlpage.column));
		table.getColumnModel().getColumn(0).setPreferredWidth(48);
		table.getColumnModel().getColumn(3).setPreferredWidth(58);
		table.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		table.setCellSelectionEnabled(true);
		table.setRowHeight(29);
		table.setVisible(true);

		// tcm.getColumn(0).setPreferredWidth(25);

		// TableModel tableModel = new DefaultTableModel(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(43, 145, 901, 383);

		getContentPane().add(scrollPane);

		String text = "Go Back";

	}
}

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

public class SearchTrains extends JFrame {
	private JTextField searchQueryField;
	private JTable table;
	private JTable table_1;

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
	public SearchTrains() {
		setSize(1000, 600);
		setResizable(false);
		//setIconImage(Toolkit.getDefaultToolkit()
			//	.getImage("C:\\Users\\Tarun R\\eclipse-workspace\\ReservationSystem\\images\\amrita_logo.png"));
		setTitle("Online Ticket Reservation System");
		getContentPane().setBackground(new Color(245, 245, 245));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		panel.setBounds(-22, -15, 1008, 117);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Train Search page");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 29));
		lblNewLabel.setBounds(372, 33, 529, 74);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter Search Query : ");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 16));
		lblNewLabel_1.setBounds(281, 128, 271, 26);
		getContentPane().add(lblNewLabel_1);

		searchQueryField = new JTextField();
		searchQueryField.setBounds(467, 132, 217, 26);
		getContentPane().add(searchQueryField);
		searchQueryField.setColumns(10);
		

		String columnNames[] = {"Train_Number", "Train_Name", "Route_ID", "Available_Seats", "Source", "Destination", 
				"Arrival_Time", "Departure_Time", "Train_Status"};
		
		String data[][] = {
				{"12345", "Amaravathi Express", "Route123", "40", "Howrah Junction", "Vasco Da Gama", "20-01-22 / 08:30:00", "19-01-22 / 08:35:00", "Reached"},
			
		};
		
		Object[][] rows = new Object[App.trains.size()][9];
		for (int i = 0; i < App.trains.size(); i++) {
			rows[i][0] = App.trains.get(i).Train_Number;
			rows[i][1] = App.trains.get(i).Train_Name;
			rows[i][2] = App.trains.get(i).Route_ID;
			rows[i][3] = App.trains.get(i).Available_Seats;
			rows[i][4] = App.trains.get(i).Source;
			rows[i][5] = App.trains.get(i).Destination;
			rows[i][6] = App.trains.get(i).Arrival_Time;
			rows[i][7] = App.trains.get(i).Departure_Time;
			rows[i][8] = App.trains.get(i).Train_Status;
		} 
		
		final JTable table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			rows,
			new String[] {
				"Train_Number", "Train_Name", "Route_ID", "Available_Seats", "Source", "Destination", "Arrival_Time", "Departure_Time", "Train_Status"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(48);
		table.getColumnModel().getColumn(3).setPreferredWidth(58);
		table.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		table.setCellSelectionEnabled(true);
		table.setRowHeight(29);
		table.setVisible(true);
		
		
	
		//tcm.getColumn(0).setPreferredWidth(25);	


		//TableModel tableModel = new DefaultTableModel(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(51, 210, 893, 318);
		
		
		getContentPane().add(scrollPane);
		
		
		String text = "Go Back";
		
		if (App.has_logged_in == true) {
			JButton bookTicket = new JButton("Book Ticket");
			bookTicket.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					BookTicket bt = new BookTicket();
					bookTicket.setText("Book Ticket");
					bt.setVisible(true);
					setVisible(false);
				}
			});
			bookTicket.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
			bookTicket.setBounds(51, 134, 105, 21);
			getContentPane().add(bookTicket);
		}
		else {
			JButton bookTicket = new JButton("Go Back");
			bookTicket.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					HomePage hp = new HomePage();
					hp.setVisible(true);
					setVisible(false);
				}
			});
			bookTicket.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
			bookTicket.setBounds(51, 134, 105, 21);
			getContentPane().add(bookTicket);
		}
	
	
	}
}

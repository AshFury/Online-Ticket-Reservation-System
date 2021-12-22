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
		
		final JTable table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"12345", "Amaravathi Express", "Route123", "40", "Howrah Junction", "Vasco Da Gama", "20-01-22 / 08:30:00", "19-01-22 / 08:35:00", "Reached"},
				{"67890", "Brindavan Express", "Route456", "65", "Chennai Central", "Bangalore Cy Junction", "26-Feb-2022 10:35", "24-Feb-2022 09:35", "On the Way"},
				{"16524", "Deccan Express", "Route612", "32", "Mumbai Cst", "Pune Junction", "06-Nov-2022 05:22", "05-Nov-2022 11:45", "Not yet Started"},
				{"13278", "Falaknuma Express", "Route439", "10", "Secunderabad Junction", "Howrah Junction", "15-Apr-2022 03:55", "12-Apr-2022 07:15", "Just Started"},
				{"16790", "Ganga Kaveri Express", "Route678", "20", "Chennai Central", "Chhapra", "16-Jul-2022 04:05", "15-Jul-2022 06:35", "Reached"},
				{"33678", "Hirakhand Express", "Route992", "98", "Jagdalpur", "Bhubaneswar", "20-Jan-2022 08:32", "19-Jan-2022 08:35", "On the Way"},
				{"45812", "Indrayani Express", "Route145", "135", "Mumbai Cst", "Pune Junction", "28-Dec-2022 09:10", "27-Dec-2022 04:50", "On the Way"},
				{"76301", "Venkatadri Express", "Route635", "140", "Kacheguda", "Chittor", "18-Jan-2022 10:25", "17-Jan-2022 07:55", "Reached"},
				{"10390", "Simhadri Express", "Route934", "78", "Visakhapatnam", "Guntur Junction", "23-Mar-2022 09:20", "22-Mar-2022 06:21", "Not yet Started"},
				{"66803", "Ananya Express", "Route780", "21", "Sealdah", "Udaipur", "12-Jan-2022 11:40", "11-Jan-2022 05:30", "On the Way"},
			},
			new String[] {
				"Train_Number", "Train_Name", "Route_ID", "Available_Seats", "Source", "Destination", "Arrival_Time", "Departure_Time", "Train_Status"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(48);
		table.getColumnModel().getColumn(3).setPreferredWidth(58);
		table.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		table.setCellSelectionEnabled(true);
		table.setRowHeight(29);
		table.setVisible(false);
		
		DocumentListener dl = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFieldState();
            }
            
            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFieldState();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFieldState();
            }

            protected void updateFieldState() {
            	String searchQuery = searchQueryField.getText();
        		if (!searchQuery.equals("")) {
        			table.setVisible(true);
        		}
        		else {
        			table.setVisible(false);
        		}
            }
		};
            
		searchQueryField.getDocument().addDocumentListener(dl);
		
	
		//tcm.getColumn(0).setPreferredWidth(25);	


		//TableModel tableModel = new DefaultTableModel(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(51, 210, 893, 318);
		
		
		getContentPane().add(scrollPane);
	
	}
}

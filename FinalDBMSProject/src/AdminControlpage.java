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

public class AdminControlpage extends JFrame {
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
	public AdminControlpage() {
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

		JLabel lblNewLabel = new JLabel("Admin Control Page");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 29));
		lblNewLabel.setBounds(372, 33, 529, 74);
		panel.add(lblNewLabel);
		
		JButton gotoHomePage = new JButton("Go back");
		gotoHomePage.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
		gotoHomePage.setBounds(36, 33, 105, 21);
		panel.add(gotoHomePage);
		
		JComboBox toggleView = new JComboBox();
		toggleView.setModel(new DefaultComboBoxModel(new String[] {"Tickets", "User", "Trains"}));
		toggleView.setMaximumRowCount(3);
		toggleView.setBounds(32, 123, 74, 21);
		getContentPane().add(toggleView);
		
		int index = toggleView.getSelectedIndex();
		
		if (index == 1) {
			String columnNames[] = {"Email_ID", "First_Name", "Last_Name", "Date_Of_Birth", "Gender"};
			
			String data[][] = new String[App.users.size()][5];
			for (int i = 0; i < App.users.size(); i++) {
				data[i][0] = App.users.get(i).Email_ID;
				data[i][1] = App.users.get(i).First_Name;
				data[i][2] = App.users.get(i).Last_Name;
				data[i][3] = String.valueOf(App.users.get(i).Date_Of_Birth);
				data[i][4] = App.users.get(i).Gender;
			}
			
			final JTable table = new JTable(data, columnNames);
			table.setFillsViewportHeight(true);
			table.setModel(new DefaultTableModel(
				data,
				columnNames
			));
			table.getColumnModel().getColumn(0).setPreferredWidth(48);
			table.getColumnModel().getColumn(3).setPreferredWidth(58);
			table.setFont(new Font("Yu Gothic UI", Font.PLAIN, 10));
			table.setCellSelectionEnabled(true);
			table.setRowHeight(29);
			table.setVisible(false);

		}
		else if (index == 0) {
			
		}
		else if (index == 2) {
			
		}
		
	
		//tcm.getColumn(0).setPreferredWidth(25);	


		//TableModel tableModel = new DefaultTableModel(data, columnNames);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(32, 154, 912, 374);
		
		
		getContentPane().add(scrollPane);
		

	
	}
}

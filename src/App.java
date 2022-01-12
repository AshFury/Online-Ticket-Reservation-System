import java.sql.*;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.AddResultImpl;

public class App {
	public static ArrayList<Admin_Roles> admin_roles = new ArrayList<Admin_Roles>();
	public static ArrayList<Cancellation> cancellations = new ArrayList<Cancellation>();
	public static ArrayList<Card> cards = new ArrayList<Card>();
	public static ArrayList<Class_Types> class_types = new ArrayList<Class_Types>();
	public static ArrayList<Contact_Details> contact_details = new ArrayList<Contact_Details>();
	public static ArrayList<Login> logins = new ArrayList<Login>();
	public static ArrayList<Net_Banking> net_bankings = new ArrayList<Net_Banking>();
	public static ArrayList<Passenger> passengers = new ArrayList<Passenger>();
	public static ArrayList<Payment> payments = new ArrayList<Payment>();
	public static ArrayList<Route> routes = new ArrayList<Route>();
	public static ArrayList<Station> stations = new ArrayList<Station>();
	public static ArrayList<System_Admin> system_admins = new ArrayList<System_Admin>();
	public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	public static ArrayList<Train> trains = new ArrayList<Train>();
	public static ArrayList<UPI> upis = new ArrayList<UPI>();
	public static ArrayList<Users> users = new ArrayList<Users>();

	static Statement st;
	static int user_index = -1;
	
	static Boolean has_logged_in = false;
	
	public static void main(String args[]) throws Exception {

		String url = "jdbc:mysql://127.0.0.1/reservation_system";
		String username = "root";
		String password = "admin@123";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, username, password);

		st = con.createStatement();
		
		App.read_data(st);
		
		HomePage hp = new HomePage();
		hp.setVisible(true);
	}
	
	public static  void create_user(String email, String password, String name, Date dob, String gender, String phoneNumber) throws Exception{
		String[] str = name.split(" ");
		Users users = new Users(email, str[0], str[1], dob, gender);
		App.users.add(users);
		
		Login l = new Login(email, Long.valueOf(phoneNumber), password);
		App.logins.add(l);
		
		String new_user = "INSERT INTO Users VALUES('" + email + "', '" + str[0]  + "', '" + str[1] + "', '" + dob.toString() + "', '" +   gender + "');";
		String new_login = "INSERT INTO Login VALUES('" + email + "', '" + phoneNumber + "', '" + password  + "');";
		System.out.println(new_user);
		
		st.execute(new_user);
		st.execute(new_login);
	}

	public static void create_payment(long transaction_id, String payment_method, int fare, Timestamp dob, String status) throws Exception{
		Payment payment = new Payment(transaction_id, payment_method, fare, dob, status);
		App.payments.add(payment);
		String add_record = "INSERT INTO Payment VALUES(" + transaction_id + ", '" + payment_method + "'," + fare + ", '" + dob + "','Successful');";
		
		st.execute(add_record);
	}
	
	public static void create_netbanking(long account_number, String bank_name, long transaction_id) throws Exception{
		Net_Banking nb = new Net_Banking(account_number, bank_name, transaction_id);
		App.net_bankings.add(nb);
		
		String add_record = "INSERT INTO Net_Banking VALUES(" + account_number + ", '" + bank_name + "', " + transaction_id + ");";
		st.execute(add_record);
	}
	
	public static void create_card(long card_number, String account_holder_name, String type, long transaction_number) throws Exception {
		Card ca = new Card(card_number, account_holder_name, type, transaction_number);
		App.cards.add(ca);
		
		String add_record = "INSERT INTO Card VALUES('" + card_number + "', '" + account_holder_name + "', '" + type + "', " + transaction_number + ");";
		st.execute(add_record);
	}
	
	public static void create_upi(long phone_number, String wallet_type, long transaction_number) throws Exception {
		UPI upi = new UPI(phone_number, wallet_type, transaction_number);
		App.upis.add(upi);
		
		String add_record = "INSERT INTO UPI VALUES(" + phone_number + ", '" + wallet_type + "', " + transaction_number + ");";
		st.execute(add_record);
	}
	
	public static void read_data(Statement st) throws Exception {
		String query = "select * from Admin_Roles";

		// read admin_roles
		ResultSet rs = st.executeQuery(query);

		while (rs.next()) {
			String id = rs.getString("Admin_ID");
			String rights = rs.getString("Admin_Rights");

			Admin_Roles ar = new Admin_Roles(id, rights);
			App.admin_roles.add(ar);
		}

		// read cancellation data
		query = "select * from Cancellation";
		rs = st.executeQuery(query);

		while (rs.next()) {
			String id = rs.getString(1);
			String passenger_id = rs.getString(2);
			String admin_id = rs.getString(3);
			long phone_number = rs.getLong(4);
			String status = rs.getString(5);
			long refund = rs.getLong(6);
			long ticket_number = rs.getLong(7);

			Cancellation ca = new Cancellation(id, passenger_id, admin_id, phone_number, status, refund, ticket_number);
			App.cancellations.add(ca);
		}

		// read card details
		query = "select * from Card";
		rs = st.executeQuery(query);

		while (rs.next()) {
			long card_number = rs.getLong(1);
			String name = rs.getString(2);
			String type = rs.getString(3);
			long id = rs.getLong(4);

			Card c = new Card(card_number, name, type, id);
			App.cards.add(c);
		}

		// read class types details
		query = "select * from Class_Types";
		rs = st.executeQuery(query);

		while (rs.next()) {
			long number = rs.getLong(1);
			String type = rs.getString(2);

			Class_Types ct = new Class_Types(number, type);
			App.class_types.add(ct);
		}

		// read contact details types details
		query = "select * from Contact_Details";
		rs = st.executeQuery(query);

		while (rs.next()) {
			String id = rs.getString(1);
			long number = rs.getLong(2);

			Contact_Details cd = new Contact_Details(id, number);
			App.contact_details.add(cd);
		}

		// read login details
		query = "select * from Login";
		rs = st.executeQuery(query);

		while (rs.next()) {
			String id = rs.getString(1);
			long number = rs.getLong(2);
			String password = rs.getString(3);

			Login l = new Login(id, number, password);

			App.logins.add(l);
		}

		// read net banking details
		query = "select * from Net_Banking";
		rs = st.executeQuery(query);

		while (rs.next()) {
			long number = rs.getLong(1);
			String name = rs.getString(2);
			long id = rs.getLong(3);

			Net_Banking nb = new Net_Banking(number, name, id);

			App.net_bankings.add(nb);
		}

		// read Passenger details
		query = "select * from Passenger";
		rs = st.executeQuery(query);

		while (rs.next()) {
			String pid = rs.getString(1);
			long pnr_number = rs.getLong(2);
			long ticket_number = rs.getLong(3);
			String email = rs.getString(4);
			long phone_number = rs.getLong(5);
			String gender = rs.getString(6);
			String class_type = rs.getString(7);
			String bp = rs.getString(8);
			String sn = rs.getString(9);

			Passenger p = new Passenger(pid, pnr_number, ticket_number, email, phone_number, gender, class_type, bp,
					sn);
			App.passengers.add(p);
		}

		// read Payment details
		query = "select * from Payment";
		rs = st.executeQuery(query);

		while (rs.next()) {
			long id = rs.getLong(1);
			String mode = rs.getString(2);
			long fare = rs.getLong(3);
			Timestamp t = rs.getTimestamp(4);
			String booking_status = rs.getString(5);

			Payment p = new Payment(id,  mode, fare, t, booking_status);
			App.payments.add(p);
		}

		// read route details
		query = "select * from Route";
		rs = st.executeQuery(query);

		while (rs.next()) {
			String route_id = rs.getString(1);
			String stations = rs.getString(2);
			String dist = rs.getString(3);

			Route r = new Route(route_id, stations, dist);
			App.routes.add(r);
		}

		// read station details
		query = "select * from Station";
		rs = st.executeQuery(query);

		while (rs.next()) {
			String name = rs.getString(1);
			String rid = rs.getString(2);
			long number = rs.getLong(3);
			long tn = rs.getLong(4);

			Station s = new Station(name, rid, number, tn);
		}

		// read system admin details
		query = "select * from System_Admin";
		rs = st.executeQuery(query);

		while (rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String email = rs.getString(3);

			System_Admin sa = new System_Admin(id, name, email);
			App.system_admins.add(sa);
		}

		// read ticket details
		query = "select * from Ticket";
		rs = st.executeQuery(query);

		while (rs.next()) {
			long number = rs.getLong(1);
			long id = rs.getLong(2);
			String c_number = rs.getString(3);
			long s_number = rs.getLong(4);
			long t_number = rs.getLong(5);
			Date date = rs.getDate(6);

			Ticket t = new Ticket(t_number, id, c_number, 0, t_number, date);
			App.tickets.add(t);
		}

		// read Train details
		query = "select * from Train";
		rs = st.executeQuery(query);

		while (rs.next()) {
			long number = rs.getLong(1);
			String name = rs.getString(2);
			String rid = rs.getString(3);
			long seats = rs.getLong(4);
			String source = rs.getString(5);
			String destination = rs.getString(6);
			Timestamp at = rs.getTimestamp(7);
			Timestamp dt = rs.getTimestamp(8);
			String status = rs.getString(9);

			Train t = new Train(number, name, rid, seats, source, destination, at, dt, status);
			App.trains.add(t);
		}

		// read UPI details
		query = "select * from UPI";
		rs = st.executeQuery(query);

		while (rs.next()) {
			long number = rs.getLong(1);
			String type = rs.getString(2);
			long tid = rs.getLong(3);

			UPI upi = new UPI(number, type, tid);
			App.upis.add(upi);
		}

		// read user  details
		query = "select * from Users";
		rs = st.executeQuery(query);

		while (rs.next()) {
			String email = rs.getString(1);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			Date dob = rs.getDate(4);
			String gender = rs.getString(5);
			
			Users u = new Users(email, fname, lname, dob, gender);
			App.users.add(u);
		}
	}
}

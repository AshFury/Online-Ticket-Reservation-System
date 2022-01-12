import java.sql.*;

public class Ticket {
	public long Ticket_Number;
	public long Transaction_ID;
	public String Coach_Number;
	public long Seat_Number;
	public long Train_Number;
	public Date Travel_Date;
	
	public Ticket(long ticket_number, long transcation_id, String coach_number, long seat_number, long train_number, Date travel_date) {
		this.Ticket_Number = ticket_number;
		this.Transaction_ID = transcation_id;
		this.Coach_Number = coach_number;
		this.Seat_Number = seat_number;
		this.Train_Number = train_number;
		this.Travel_Date = travel_date;
	}
}

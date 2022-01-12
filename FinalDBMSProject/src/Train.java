import java.sql.*;

public class Train {
	public long Train_Number;
	public String Train_Name;
	public String Route_ID;
	public long Available_Seats;
	public String Source;
	public String Destination;
	public Timestamp Arrival_Time;
	public Timestamp Departure_Time;
	public String Train_Status;

	public Train(long train_Number, String train_Name, String route_ID, long available_Seats, String source,
			String destination, Timestamp arrival_Time, Timestamp departure_Time, String train_Status) {
		Train_Number = train_Number;
		Train_Name = train_Name;
		Route_ID = route_ID;
		Available_Seats = available_Seats;
		Source = source;
		Destination = destination;
		Arrival_Time = arrival_Time;
		Departure_Time = departure_Time;
		Train_Status = train_Status;
	}
}

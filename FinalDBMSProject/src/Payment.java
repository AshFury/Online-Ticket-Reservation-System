import java.sql.Time;
import java.sql.Timestamp;

public class Payment {
	public long Transaction_ID;
	public long Passenger_ID;
	public String Mode;
	public long Fare;
	public Timestamp Transaction_Time;
	public String Booking_Status;
	
	public Payment(long transcation_id, long passenger_id, String mode, long fare,
			Timestamp transaction_time, String booking_status) {
		this.Transaction_ID = transcation_id;
		this.Passenger_ID = passenger_id;
		this.Mode = mode;
		this.Fare = fare;
		this.Transaction_Time = transaction_time;
		this.Booking_Status = booking_status;
	}
}

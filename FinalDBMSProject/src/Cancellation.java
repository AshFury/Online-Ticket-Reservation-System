
public class Cancellation {

	public String Cancellation_ID;
	public String Passenger_ID;
	public String Admin_ID;
	public long Phone_Number;
	public String Cancellation_Status;
	public long Refund_Amount;
	public long Ticket_Number;
	
	public Cancellation(String cancellation_ID, String passenger_ID, String admin_ID, long phone_Number,
			String cancellation_Status, long refund_Amount, long ticket_Number) {
		Cancellation_ID = cancellation_ID;
		Passenger_ID = passenger_ID;
		Admin_ID = admin_ID;
		Phone_Number = phone_Number;
		Cancellation_Status = cancellation_Status;
		Refund_Amount = refund_Amount;
		Ticket_Number = ticket_Number;
	}
}

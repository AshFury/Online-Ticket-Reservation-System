
public class Passenger {
	public String Passenger_ID;
	public long PNR_Number;
	public long Ticket_Number;
	public String Email_ID;
	public long Phone_Number;
	public String Gender;
	public String Class_Type;
	public String Birth_Preference;
	public String Special_Needs;
	
	public Passenger(String Passenger_ID, long PNR_Number, long Ticket_Number, String Email_ID, long Phone_Number, 
				String Gender, String Class_Type, String Birth_Preference, String Special_Needs) {
		this.Passenger_ID =Passenger_ID;
		this.PNR_Number = PNR_Number;
		this.Ticket_Number = Ticket_Number;
		this.Email_ID = Email_ID;
		this.Phone_Number = Phone_Number;
		this.Gender = Gender;
		this.Class_Type = Class_Type;
		this.Birth_Preference = Birth_Preference;
		this.Special_Needs = Special_Needs;
	}
}

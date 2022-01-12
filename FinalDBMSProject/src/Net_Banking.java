
public class Net_Banking {
	public long Account_Number;
	public String Bank_Name;
	long Transaction_ID;
	
	public Net_Banking(long account_number, String name, long id) {
		this.Account_Number = account_number;
		this.Bank_Name = name;
		this.Transaction_ID = id;
	}
}

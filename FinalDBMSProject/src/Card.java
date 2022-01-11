
public class Card {
	public long Card_Number;
	public String Card_Holder_Name;
	public String Card_Type;
	public long Transaction_ID;
	
	public Card(long card_number, String name, String type, long transaction_id) {
		this.Card_Number = card_number;
		this.Card_Holder_Name = name;
		this.Card_Type = type;
		this.Transaction_ID = transaction_id;
	}
}

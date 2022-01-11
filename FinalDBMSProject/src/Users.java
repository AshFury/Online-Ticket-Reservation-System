import java.sql.*;

public class Users {
	public String Email_ID;
	public String First_Name;
	public String Last_Name;
	public Date Date_Of_Birth;
	public String Gender;
	
	public Users(String email, String first_name, String last_name, Date date_of_birth, String gender) {
		this.Email_ID = email;
		this.First_Name = first_name;
		this.Last_Name = last_name;
		this.Date_Of_Birth = date_of_birth;
		this.Gender = gender;
	}
}

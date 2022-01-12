public class Station {
	public String Station_Name;
	public String Route_ID;
	public long Platform_Number;
	public long Train_Number;
	
	public Station(String station_name, String route_id, long platform_number, long train_number) {
		this.Station_Name = station_name;
		this.Route_ID = route_id;
		this.Platform_Number = platform_number;
		this.Train_Number = train_number;
	}
}

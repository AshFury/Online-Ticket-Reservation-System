
public class Route {
	public String Route_ID;
	public String Bypass_Stations;
	public String Distance;
	
	public Route(String route_id, String bypass_station, String distance) {
		this.Route_ID = route_id;
		this.Bypass_Stations = bypass_station;
		this.Distance = distance;
	}
}

package modelObjects;

public class ParkingLot {
	
	private String name;
	private String location;
	private int cap;
	private int floors;
	
	public ParkingLot(String name, String location, int cap, int floors) {
		this.name = name;
		this.location = location;
		this.cap = cap;
		this.floors = floors;
	}
	
	
	
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	public int getCapacity() {
		return cap;
	}
	public int getFloors() {
		return floors;
	}
	
	
}

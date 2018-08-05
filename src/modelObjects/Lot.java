package modelObjects;

public class Lot {
	
	private String name;
	private String location;
	private int cap;
	private int floors;
	
	public Lot(String name, String location, int cap, int floors) {
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
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String loc) {
		location = loc;
	}
	public void setCapacity(int cap) {
		this.cap = cap;
	}
	public void setFloors(int floors) {
		this.floors = floors;
	}
	
	
}

package modelObjects;

/**
 * A parking lot. Has a name, location, capacity, and number of floors.
 */
public class Lot {

	/** Name of parking lot */
	private String name;

	/** Location of parking lot */
	private String location;

	/** Capacity of parking lot */
	private int cap;

	/** Number of floors of parking lot */
	private int floors;

	/**
	 * Creates a new parking lot with assigned values
	 * @param name name of lot
	 * @param location location of lot
	 * @param cap capacity of lot
	 * @param floors floors of lot
	 */
	public Lot(String name, String location, int cap, int floors) {
		this.name = name;
		this.location = location;
		this.cap = cap;
		this.floors = floors;
	}

	/**
	 * gets name of parking lot
	 * @return name of lot
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets location of lot
	 * @return location of lot
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * gets capacity of lot
	 * @return capacity of lot
	 */
	public int getCapacity() {
		return cap;
	}

	/**
	 * gets floors of lot
	 * @return floors of lot
	 */
	public int getFloors() {
		return floors;
	}

	/**
	 * updates name of lot
	 * @param name new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * updates location of lot
	 * @param loc new location
	 */
	public void setLocation(String loc) {
		location = loc;
	}

	/**
	 * updates capacity of lot
	 * @param cap new capacity number
	 */
	public void setCapacity(int cap) {
		this.cap = cap;
	}

	/**
	 * updates floors of lot
	 * @param floors new floor number
	 */
	public void setFloors(int floors) {
		this.floors = floors;
	}
	
	
}

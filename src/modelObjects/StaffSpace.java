package modelObjects;

public class StaffSpace {

	private int staffNumber;
	private int spaceNumber;
	
	public StaffSpace(int staffNumber, int spaceNumber) {
		super();
		this.staffNumber = staffNumber;
		this.spaceNumber = spaceNumber;
	}
	
	
	public int getStaffNumber() {
		return staffNumber;
	}
	public int getSpaceNumber() {
		return spaceNumber;
	}
	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
	}
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
}

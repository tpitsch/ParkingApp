package modelObjects;

public class StaffSpace {

	private String staffNumber;
	private int spaceNumber;
	
	public StaffSpace(String staffNumber, int spaceNumber) {
		super();
		this.staffNumber = staffNumber;
		this.spaceNumber = spaceNumber;
	}
	
	
	public String getStaffNumber() {
		return staffNumber;
	}
	public int getSpaceNumber() {
		return spaceNumber;
	}
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
}

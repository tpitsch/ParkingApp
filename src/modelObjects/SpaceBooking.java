package modelObjects;

public class SpaceBooking {
	
	private int bookingID;
	private int spaceNumber;
	private int staffNumber;
	private String visitorLicense;
	private String dateOfVisit;
	
	public SpaceBooking(int bookingID,int spaceNumber, int staffNumber, 
						String visitorLicense,String dateOfVisit) {
		this.bookingID = bookingID;
		this.spaceNumber = spaceNumber;
		this.staffNumber = staffNumber;
		this.visitorLicense = visitorLicense;
		this.dateOfVisit = dateOfVisit;
	}
	
	public int getBookingID() {
		return bookingID;
	}
	public int getSpaceNumber() {
		return spaceNumber;
	}
	public int getStaffNumber() {
		return staffNumber;
	}
	public String getVisitorLicense() {
		return visitorLicense;
	}
	public String getDateOfVisit() {
		return dateOfVisit;
	}
	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
	}
	public void setVisitorLicense(String license) {
		this.visitorLicense = license;
	}
	public void setDateOfVisit(String date) {
		this.dateOfVisit = date;
	}
}

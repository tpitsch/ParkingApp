package modelObjects;

public class Staff {
	
	private String staffName;
	private String staffNumber;
	private String ext;
	private String license;
	
	
	public Staff(String staffName, String staffNumber, String ext, String license) {
		this.staffName = staffName;
		this.staffNumber = staffNumber;
		this.ext = ext;
		this.license = license;
	}
	
	public String getStaffName() {
		return staffName;
	}
	public String getStaffNumber() {
		return staffNumber;
	}
	public String getExtension() {
		return ext;
	}
	public String getLicense() {
		return license;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
	public void setExtension(String ext) {
		this.ext = ext;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	
}


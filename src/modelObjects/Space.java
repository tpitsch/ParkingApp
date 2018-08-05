package modelObjects;

public class Space {
	
	private int spaceNumber;
	private String spaceType;
	private String lotName;
	
	public Space(int spaceNumber, String spaceType, String lotName) {
		this.spaceNumber = spaceNumber;
		this.spaceType = spaceType;
		this.lotName = lotName;
	}
	
	public int getSpaceNumber() {
		return spaceNumber;
	}
	public String getSpaceType() {
		return spaceType;
	}
	public String getLotName() {
		return lotName;
	}
	public void setSpaceNumber(int spaceNumber) {
		this.spaceNumber = spaceNumber;
	}
	public void setSpaceType(String spaceType) {
		this.spaceType = spaceType;
	}
	public void setLotName(String lotName) {
		this.lotName = lotName;
	}

}

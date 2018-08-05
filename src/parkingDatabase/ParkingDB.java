package parkingDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelObjects.Lot;
import modelObjects.Space;
import modelObjects.Staff;

public class ParkingDB {
	
	private static String userName = "***"; //TODO - Change to yours
	private static String password = "***"; //TODO - Change to yours
	private static String serverName = "cssgate.insttech.washington.edu"; //TODO - Change to yours
	private static Connection sConnection;

	
	
	/**
	 * Creates a sql connection to MySQL using the properties for
	 * userid, password and server information. (Copied from example by Menaka Abraham).
	 * @throws SQLException
	 */
	public static void createConnection() throws SQLException {
		sConnection =  DriverManager
				.getConnection("jdbc:mysql://" + serverName + "/" + userName + "?user=" + userName + "&password=" + password);
		
	}
	
	
	
	public void addLot(Lot lot) throws Exception {
		if (sConnection == null) {
			createConnection();
		}
		String sql = "insert into Lot values " + "(?, ?, ?, ?); ";
		PreparedStatement ps = null;
		
		try {
			ps = sConnection.prepareStatement(sql);
			ps.setString(1, lot.getName());
			ps.setString(2, lot.getLocation());
			ps.setInt(3,lot.getCapacity());
			ps.setInt(4, lot.getFloors());
			ps.executeUpdate();
		}catch(SQLException e) {
			throw new Exception("Unable to add new Lot: " + e.getMessage());
		}
	}
	
	//TODO add statements to create new spaces in the database
	public void addSpace(Space space) {
		
	}
	
	//TODO add statements to create new staff members to database
	public void addStaff(Staff staff) {
		
	}
	
	//TODO add statements to update a staff member(only phone and license can be updated)
	public void updateStaff(String phone, String licence) {
		
	}
	
	//TODO add statement to assign a space to a staff member
	public void assignSpace() {
		
	}
	
	//TODO add statements to allow staff to reserve a space for a visitor
	public void reserveSpace() {
		
	}
	
}

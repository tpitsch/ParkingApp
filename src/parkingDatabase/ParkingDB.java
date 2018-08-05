package parkingDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.scene.layout.VBox;

public class ParkingDB {
	
	private static String userName = "tpitsch";
	private static String password = "omRaic";
	private static String serverName = "cssgate.insttech.washington.edu";
	private static Connection sConnection;

	
	public ParkingDB() throws SQLException {
		createConnection();
	}
	/**
	 * Creates a sql connection to MySQL using the properties for
	 * userid, password and server information. (Copied from example by Menaka Abraham).
	 * @throws SQLException
	 */
	public static void createConnection() throws SQLException {
		sConnection =  DriverManager
				.getConnection("jdbc:mysql://" + serverName + "/" + userName + "?user=" 
								+ userName + "&password=" + password);
	}
	
	
	//TODO add statements to create new lots in the database
	public void addLot() {
		
	}
	
	//TODO add statements to create new spaces in the database
	public void addSpace() {
		
	}
	
	//TODO add statements to create new staff members to database
	public void addStaff() {
		
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

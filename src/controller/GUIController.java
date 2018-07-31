package controller;

import javafx.fxml.FXML;

public class GUIController {
	
	
	
	@FXML
	public void handleAddLot() {
		System.out.println("adding new lot");
	}
	
	@FXML
	public void handleAddSpace() {
		System.out.println("adding new space");
	}
	
	@FXML
	public void handleAddStaff() {
		System.out.println("adding new staff");
	}
	
	@FXML
	public void handleUpdateInfo() {
		System.out.println("update info");
	}
	
	@FXML
	public void handleReserve() {
		System.out.println("reserving space");
	}
}

package controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import modelObjects.Lot;
import parkingDatabase.ParkingDB;

public class GUIController{
	
	private ParkingDB db;
	
	@FXML
	public void handleAddLot() {
		try {
			
			//db.addLot(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public void makeComp(ParkingDB db) {
		this.db = db;
	}
}

	 

package controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GUIController extends Application{
	
	private Stage primaryStage;
	@FXML AnchorPane appPane;
	
	@Override
    public void start(Stage primaryStage) {
      this.primaryStage = primaryStage;
      mainWindow();
    }
	
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

	 public void mainWindow() {
	    	try {
	    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/appWindow.fxml"));
	    		AnchorPane pane = loader.load();
	    	 
	    		Scene scene = new Scene(pane);
	    		
	    		//GUIController control = loader.getController();
	    		//control.makeWindow(primaryStage,scene);
	    		
	    		primaryStage.setScene(scene);
	    		primaryStage.show();
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	}
	    
	    }
	    
	 public static void main(String[] args) {
	        launch(args);
	    }
	}


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainWindow extends Application{
	
	private Stage primaryStage;
	
	/**
	 * Fired to create the main window for the application.
	 */
	@Override
    public void start(Stage primaryStage) throws Exception {
      this.primaryStage = primaryStage;
      mainWindow();
    }
	
	/**
	 * Creates the window and components.  Tied the FXML together and shows the application window.
	 */
	public void mainWindow() {
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/appWindow.fxml"));
    		AnchorPane pane = loader.load();
    		
    		Scene scene = new Scene(pane);
    		
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



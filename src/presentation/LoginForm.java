package presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class LoginForm extends Application{
	
	private VBox vpane;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
	    
        Scene scene = new Scene(root, 300, 275);
   
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
	}

}

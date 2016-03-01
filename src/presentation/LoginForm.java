package presentation;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class LoginForm extends Application{
	
	@FXML private Text username;
	@FXML private Text password;
	@FXML private Button login;
	@FXML private Button reset;
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("LoginForm.fxml"));
		Scene scene = new Scene(root, 300, 175);
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void startMainForm() throws Exception{
		MainForm mf = new MainForm();
		Stage stage = new Stage();
		mf.start(stage);
	}
	@FXML protected void handleLoginButtonAction(ActionEvent event) throws Exception {
       this.startMainForm();
    }
	@FXML protected void handleResetButtonAction(ActionEvent event) {
        
    }
}


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

public class CheckOut extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("checkOut.fxml"));
		Scene scene = new Scene(root, 650, 720);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Book Check out");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML
	public void startMainForm(ActionEvent event) throws Exception{
		MainForm mf = new MainForm();
		Stage stage = new Stage();
		mf.start(stage);
	}

	@FXML
	public void printToConsole(ActionEvent event) throws Exception{
		System.out.println("BOOK");
	}
}
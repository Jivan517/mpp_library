package presentation;

import business.Author;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

 public class CheckOut extends Application
{
	@FXML
	private TableView<Author> cr;

	@FXML private TableColumn<Author, String> d;
	@FXML private TableColumn<Author, String> r;

	@FXML private TableColumn<Author, String> c;

	@FXML private TableColumn<Author, String> t;


	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("CheckOut.fxml"));
		Scene scene = new Scene(root, 650, 720);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Book Check out");
		primaryStage.setScene(scene);
		primaryStage.show();
		}

}
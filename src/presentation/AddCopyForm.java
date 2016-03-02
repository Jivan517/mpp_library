package presentation;

import business.Book;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.*;
public class AddCopyForm extends Application {
	private Book book = null;
	@FXML private TextField isbnText;
	@FXML private TextField tcid;
	@FXML private Label isbn, title,  copynum, author, popular;
	@FXML private Label bid;
	public void toast(String msg){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(msg);
		alert.showAndWait();
	}
	@FXML protected void handleAddButtonAction(ActionEvent event) {
		if(book == null){
			toast("No book selected");
			return;
		}
		if(tcid.getText().length() <= 0){
			toast("You should enter the correct copy id");
		}
		int cid;

		try{
			cid = Integer.parseInt(tcid.getText());
		}catch (NumberFormatException nfe)
		{
			cid = 0;
		}
		if(cid <= 0){
			toast("You should enter the correct copy id");
		}
		book.addCopy(cid);
		book.save();
		this.setBookInfo();
	}
	@FXML protected void handleSearchButtonAction(ActionEvent event) {

		book = Book.bookWithISBN(this.isbnText.getText());
		if(book == null){
			toast("No such book");
			return;
		}

		this.setBookInfo();
	}
	public void setBookInfo(){
		isbn.setText(book.getISBN());
		title.setText(book.getTitle());
		bid.setText(Long.toString(book.getId()));
		copynum.setText(Integer.toString(book.numberOfCopies()));
		author.setText(book.getAuthor());
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("AddCopyForm.fxml"));
		Scene scene = new Scene(root, 500, 400);
		primaryStage.setTitle("Add Library Member");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	
}

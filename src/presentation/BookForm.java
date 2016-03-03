package presentation;

import business.Author;
import business.Book;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import java.time.*;

public class BookForm extends Application implements AddAuthorDelegate {

	private Book book;
	@FXML private TextField title, isbn, author, maxCheckoutLength, copyid;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("BookForm.fxml"));
		Scene scene = new Scene(root, 600, 475);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Add/Edit Book");
		primaryStage.setScene(scene);
		primaryStage.show();
		book = new Book();
	}
	public void toast(String msg){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(msg);
		alert.showAndWait();
	}
	@FXML protected void submitAction(ActionEvent event) throws Exception {
		if(title.getText().length() == 0 || isbn.getText().length() == 0 || author.getText().length() == 0 || maxCheckoutLength.getText().length() == 0 || copyid.getText().length() == 0){
			toast("All fields should not be empty!");
			return;
		}
		if(Integer.parseInt(maxCheckoutLength.getText()) == 0 || Integer.parseInt(copyid.getText()) == 0){
			toast("Maximum checkout length and Copy ID should be a number!");
		}
		char[] isb = isbn.getText().toCharArray();
		for(int i = 0; i < isb.length; i++){
			int c = isb[i];
			if(c < '0' || c > '9'){
				toast("ISBN can only contains numbers!");
				return;
			}
		}
	       
	       book.setTitle(title.getText());
	       book.setISBN(isbn.getText());
	       book.setId(System.nanoTime()/1000);
	       book.setMaxCheckoutLength(Integer.parseInt(maxCheckoutLength.getText()));
	       for(int i = 0; i < Integer.parseInt(copyid.getText()); i++){
	    	   book.addCopy(i+1);
	       }
	       book.save();
	       toast("Add book success!");
	       handleResetButtonAction(null);
	}
		
	@FXML protected void handleResetButtonAction(ActionEvent event) {
	        title.setText("");
	        isbn.setText("");
	        author.setText("");
	        maxCheckoutLength.setText("");
	        copyid.setText("");
	}
	@FXML protected void handleAddAuthorButtonAction(ActionEvent event) throws Exception {
		AuthorForm af = new AuthorForm();
		Stage stage = new Stage();
		af.start(stage);
		af.setDelegate(this);
	}
	public void addAuthor(Author a){
		book.addAuthor(a);
		System.out.println(a.getFullname());
		author.setText(a.getFullname());
	}
}

package presentation;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import business.Book;
import business.CheckoutRecord;
import business.CheckoutRecordEntry;
import business.LibraryMember;
import business.UILib;
import dataaccess.DataAccessFacade;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CheckOut extends Application implements Initializable
{
	private Book book;
	private LibraryMember currentMem;

	@FXML
	private TextField mem_id;
	@FXML
	private TextField isbn_num;

	@FXML
	private TableView<CheckoutRecordEntry> checkout_records;

	@FXML
	private TableColumn<CheckoutRecordEntry, String> due_date;

	@FXML
	private TableColumn<CheckoutRecordEntry, String> checkout_date;

	@FXML
	private TableColumn<CheckoutRecordEntry, String> title;


	@FXML private Label isbn, btitle,  copynum, author, popular, availablenum;
	@FXML private Label bid;

	public void setBookInfo(){
		isbn.setText(book.getISBN());
		btitle.setText(book.getTitle());
		bid.setText(Long.toString(book.getId()));
		copynum.setText(Integer.toString(book.numberOfCopies()));
		author.setText(book.getAuthor());
		availablenum.setText(Integer.toString(book.getAvailableNumber()));

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("CheckOut.fxml"));
		Scene scene = new Scene(root, 650, 720);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Book Check out");
		primaryStage.setScene(scene);
		primaryStage.show();

		}

	@FXML protected void handleSearchMem(ActionEvent event) throws Exception {

		String memberId = mem_id.getText();

		DataAccessFacade accessFacade = new DataAccessFacade();
		LibraryMember lm = (LibraryMember) accessFacade.readLibraryMember(memberId);

		if(lm!=null)
		{
			populateTable(memberId, lm);

		}
		else
			UILib.toast("No such Library Member!");

	}

	ObservableList<CheckoutRecordEntry> b;

	private void populateTable(String memberId, LibraryMember lm) {
		currentMem=lm;
		CheckoutRecord rc = new CheckoutRecord().readCheckoutRecord(memberId);

		if(rc!=null)
		{
			b = FXCollections.observableArrayList();

			for(CheckoutRecordEntry e: rc.getEentries())
			{
				b.add(e);
			}

				title.setCellValueFactory(new PropertyValueFactory<CheckoutRecordEntry,String>("title"));
				due_date.setCellValueFactory(new PropertyValueFactory<CheckoutRecordEntry,String>("checkoutDate"));
				checkout_date.setCellValueFactory(new PropertyValueFactory<CheckoutRecordEntry,String>("checkoutDate"));

				checkout_records.setItems(b);

		}
		else
			UILib.toast("No Entry For this Library Member!");
	}

	@FXML protected void handleSearchBookCopy(ActionEvent event) throws Exception {

		String isbn_number = isbn_num.getText();

		book = Book.bookWithISBN(isbn_number);
		if(book == null){
			UILib.toast("No such book");
			return;
		}

		this.setBookInfo();

	}

	@FXML protected void handleResetButtonAction(ActionEvent event) throws Exception {

		mem_id.setText("");
		isbn_num.setText("");

		checkout_records.setItems(null);

		isbn.setText("");
		btitle.setText("");
		bid.setText("");
		copynum.setText("");
		author.setText("");
		availablenum.setText("");
	}

	@FXML protected void handleDoneButtonAction(ActionEvent event) throws Exception {
		((Node)(event.getSource())).getScene().getWindow().hide();
	}

	@FXML protected void handleCheckOutButton(ActionEvent event) throws Exception {
		currentMem.checkout(book,  LocalDate.now(), LocalDate.now());
		populateTable(currentMem.getMemberId(), currentMem);

		System.out.println(book.getTitle());
	}
	@FXML
	public void printToConsole(ActionEvent event) throws Exception{
		System.out.println("  	  |     "+"Book Title"+"  	  |     "+"Checkout Date"+"         |    "+"Due Date"+"         |     \n\n");
		for(CheckoutRecordEntry e: b)
		{
			System.out.println("  	  |         "+e.getTitle()+"  	  |         "+e.getCheckoutDate()+"         |     "+e.getDueDate()+"     |     \n");
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}
}
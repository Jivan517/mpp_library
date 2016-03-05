package presentation;

import java.time.LocalDate;

import business.CheckoutRecord;
import business.CheckoutRecordEntry;
import business.FineEntry;
import business.FineRecord;
import business.LibraryMember;
import business.UILib;
import dataaccess.DataAccessFacade;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FineRecordsController extends Application {

	private LibraryMember currentMem;
	private FineRecord fr;
	@FXML Button paidbutton, searchb;
	@FXML TextField memberid;
	@FXML Label membername;
	@FXML
	private TableView<FineEntry> tableview;

	@FXML
	private TableColumn<CheckoutRecordEntry, String> paid_date;

	@FXML
	private TableColumn<CheckoutRecordEntry, String> return_date;

	@FXML
	private TableColumn<CheckoutRecordEntry, String> title;
	@FXML
	private TableColumn<CheckoutRecordEntry, String> fine;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("FineRecordsController.fxml"));
		Scene scene = new Scene(root, 750, 620);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Fine Records");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	@FXML protected void handleSearch(ActionEvent event) throws Exception {
		String memberId = memberid.getText();

		DataAccessFacade accessFacade = new DataAccessFacade();
		LibraryMember lm = (LibraryMember) accessFacade.readLibraryMember(memberId);

		if(lm!=null){
			membername.setText(lm.getFirstName() + " " + lm.getLastName());
			populateTable(memberId, lm);
		}else{
			UILib.toast("No such Library Member!");
		}
	}
	@FXML protected void handlePaid(ActionEvent event) throws Exception {
		FineEntry entry =  tableview.getSelectionModel().getSelectedItem();
		if(entry.isPaid()){
			UILib.toast("This fine entry has been paid!");
			return;
		}
		entry.setPaid(true);
		entry.setDatePaid(LocalDate.now());
		fr.save(currentMem.getMemberId());
		tableview.refresh();
	}

	ObservableList<FineEntry> b;

	private void populateTable(String memberId, LibraryMember lm) {
		currentMem=lm;
		fr =  FineRecord.readFineRecord(memberId);
		if(fr!=null)
		{
			b = FXCollections.observableArrayList();

			for(FineEntry e: fr.getEntries())
			{
				b.add(e);
			}

			title.setCellValueFactory(new PropertyValueFactory<CheckoutRecordEntry,String>("title"));
			paid_date.setCellValueFactory(new PropertyValueFactory<CheckoutRecordEntry,String>("datePaid"));
			fine.setCellValueFactory(new PropertyValueFactory<CheckoutRecordEntry,String>("fineValue"));
			return_date.setCellValueFactory(new PropertyValueFactory<CheckoutRecordEntry,String>("returnDate"));
			tableview.setItems(b);

		}


//		else
//			UILib.toast("No Entry For this Library Member!");
	}

	@FXML protected void HandleLogout(ActionEvent event) throws Exception {
		((Node)(event.getSource())).getScene().getWindow().hide();

		LoginForm lf = new LoginForm();
		Stage stage = new Stage();
		lf.start(stage);
	}
}

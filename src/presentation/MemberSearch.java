package presentation;

import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import business.AdminRole;
import business.LibraryMember;
import business.SystemUser;
import business.UILib;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class MemberSearch extends Application{
	//private static Object sysUser = null;
	@FXML private TextField txtMemberID;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("before created");
		Parent root = FXMLLoader.load(getClass().getResource("MemberSearch.fxml"));
		System.out.println("created");
		Scene scene = new Scene(root, 250, 100);
		//sysUser = primaryStage.getUserData();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Search Library Members");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	/*@FXML protected void handleSubmitButtonAction(ActionEvent event) throws Exception
	{
		
	}*/
	private void test() throws Exception{
		search("1");
	}
	private void search(String id) throws Exception{
		LibraryMember member = new LibraryMember();
		member = member.getLiberaryMemberByID(id);
		if(member == null){
			UILib.toast("Can not find the Member!");
		}
		else{//the member is found
			startEditStage(member);
		}
	}
	private void startEditStage(LibraryMember member) throws Exception{
		AddMember mf = new AddMember(member);
		Stage stage = new Stage();
		mf.start(stage);
		
	}
	@FXML protected void btnSearchClicked (ActionEvent e) throws Exception {
		try{
			String memberID = txtMemberID.getText();
		
		if(memberID=="")
		{
			UILib.toast("Please enter the Library Member ID!");
		}
		else{
			System.out.println("searching");
			search(memberID);
			((Node)(e.getSource())).getScene().getWindow().hide();
		}
		}
		catch(Exception e1){
			e1.printStackTrace();
			//toast("An error occurred!");
		}
		//UILib.toast("clicked!");

	}
	
}

package presentation;

import javafx.scene.control.TextField;

import business.AdminRole;
import business.LibraryMember;
import business.SystemUser;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddMember extends Application {

	private Object sysUser = null;
	@FXML private TextField txtmember_id;
	@FXML private TextField txtFirstName;
	@FXML private TextField txtLastName;
	@FXML private TextField txtStreet;
	@FXML private TextField txtCity;
	@FXML private TextField txtState;
	@FXML private TextField txtZip;
	@FXML private TextField txtPhone;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("AddMember.fxml"));
		Scene scene = new Scene(root, 500, 400);
		sysUser = primaryStage.getUserData();
		primaryStage.setTitle("Add Library Member");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@FXML protected void handleSubmitButtonAction(ActionEvent event) throws Exception
	{
		try{
			String memberId = txtmember_id.getText();
			String firstName = txtFirstName.getText();
			String lastName  = txtLastName.getText();
			String street = txtStreet.getText();
			String state = txtState.getText();
			String city = txtCity.getText();
			String zipCode = txtZip.getText();
			String phone = txtPhone.getText();

			LibraryMember member = new LibraryMember(memberId, firstName + " " + lastName);

			//This user will be the logged in user
			SystemUser user = (SystemUser)sysUser;
			if(user != null){
				user.AddAdminRole();
				if(user.isAdmin()){
					AdminRole admin = new AdminRole();
					admin.addMember(member);
				}
			}

			System.out.println("\nsaved successfully!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("\nan exception occurred!");
		}


	}
	@FXML protected void handleResetButtonAction(ActionEvent event) throws Exception {

		txtmember_id.setText("");
		txtFirstName.setText("");
		txtLastName.setText("");
		txtStreet.setText("");
		txtState.setText("");
		txtCity.setText("");
		txtZip.setText("");
		txtPhone.setText("");

	}
}

package business;
import java.util.ArrayList;
import java.util.List;

public class LoginHelper {

	List<SystemUser> userList = new ArrayList();

	public LoginHelper(){

		//create two system user - with Admininstrator role
		SystemUser admin1 = new SystemUser("Peng", "Dong", "peng", "dong");
		admin1.AddAdminRole();

		SystemUser admin2 = new SystemUser("y", "Nepali", "Admin", "1");
		admin2.AddAdminRole();

		//create two system user - with Librarian role
		SystemUser librarian1 = new SystemUser("Librarian", "Librarian", "lib", "1");
		librarian1.AddLibrarianRole();

		SystemUser librarian2 = new SystemUser("Librarian", "Librarian", "Lib", "1");

		librarian2.AddLibrarianRole();

		//create one system user - with both roles
		SystemUser superAdmin = new SystemUser("Super", "Admin", "admin", "1");
		superAdmin.AddAdminRole();
		superAdmin.AddLibrarianRole();
		

		userList.add(admin1);
		userList.add(admin2);
		userList.add(librarian1);
		userList.add(librarian2);
		userList.add(superAdmin);

	}


	public SystemUser getByUsername(String username){

		SystemUser user = null;
		for(SystemUser sysUser: userList){
			if(sysUser.getUsername().equals(username)){
				user = sysUser;
				break;
			}
		}

		return user;

	}

}

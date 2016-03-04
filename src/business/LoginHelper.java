package business;
import java.util.*;

public class LoginHelper {

	List<SystemUser> userList = new ArrayList();

	public LoginHelper(){

		//create two system user - with Admininstrator role
		SystemUser admin1 = new SystemUser("Peng", "Dong", "peng", "dong");
		admin1.AddAdminRole();

		SystemUser admin2 = new SystemUser("Jivan", "Nepali", "jivan", "nepali");
		admin2.AddAdminRole();

		//create two system user - with Librarian role
		SystemUser librarian1 = new SystemUser("x", "x", "x", "x");
		librarian1.AddLibrarianRole();

		SystemUser librarian2 = new SystemUser("Mahamud", "Mahamud", "mahamud", "mahamud");
		librarian2.AddLibrarianRole();

		//create one system user - with both roles
		SystemUser superAdmin = new SystemUser("Donald", "Trump", "donald", "trump");
		superAdmin.AddAdminRole();
		superAdmin.AddLibrarianRole();

		userList.add(admin1);
		userList.add(admin2);
		userList.add(librarian1);
		userList.add(librarian2);
		userList.add(superAdmin);

	}


	public SystemUser getByUsername(String username){

		System.out.println("jivan == jivan: " + "jivan".equals("jivan"));
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

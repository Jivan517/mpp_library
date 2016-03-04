package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

	public class SystemUser implements IhaveRoles, Serializable{
	
	private static final long serialVersionUID = 73493544632078552L;
	
	private boolean isadmin;
	private boolean islibrarian;
	public long id;
	private PersonalInfo info;
	private AclUser aclUser;
	private List<IRole> userRoles = new ArrayList<IRole>();
	
	public SystemUser(String firstName, String lastName, String username, String password){
		info = new PersonalInfo(firstName, lastName);
		aclUser = new AclUser(username, password);
	}
	
	@Override
	public boolean isAdmin() {
		
		return isadmin;
	}
	@Override
	public boolean isLibrarian() {
		
		return islibrarian;
	}
	
	public String getUsername(){
		String user = this.aclUser.getUername(); 
		return user;
	}
	
	public String getPassword(){
		String pass = this.aclUser.getPassword();
		return pass;
	}
	public String getName(){
		return info.getName();
	}
	
	@Override
	public void AddAdminRole() {

		isadmin = true;
		IRole role = new AdminRole();
		this.userRoles.add(role);
	}
	@Override
	public void AddLibrarianRole() {

		islibrarian = true;
		IRole role = new LibrarianRole();
		this.userRoles.add(role);
	}
	@Override
	public void RemoveAdminRole() {

		isadmin = false;
		for(IRole r : this.userRoles){
			if(IAdminRole.class.isInstance(r))
			{
				userRoles.remove(r);
			}
		}
	}
	@Override
	public void RemoveLibrarianRole() {

		islibrarian = false;
		for(IRole r : this.userRoles){
			if(ILibrarianRole.class.isInstance(r))
			{
				userRoles.remove(r);
			}
		}
	}
}

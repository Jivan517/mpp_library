package business;

import java.io.Serializable;
import java.util.List;

	public class SystemUser implements IhaveRoles, Serializable{
	/**
		 * 
		 */
	private static final long serialVersionUID = 73493544632078552L;
	
	private boolean isadmin;
	private boolean islibrarian;
	public long id;
	public PersonalInfo info;
	public List<IRole> userRoles;
	
	public SystemUser(){
		
	}
	
	@Override
	public boolean isAdmin() {
		
		return isadmin;
	}
	@Override
	public boolean isLibrarian() {
		
		return islibrarian;
	}
	@Override
	public void AddAdminRole() {

		isadmin = true;
		IRole role = new AdminRole();
		this.userRoles.add(0,role);
	}
	@Override
	public void AddLibrarianRole() {

		islibrarian = true;
		IRole role = new LibrarianRole();
		this.userRoles.add(1,role);
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

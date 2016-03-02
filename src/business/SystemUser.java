package business;

import java.util.List;

public class SystemUser implements IhaveRoles {
private boolean isadmin;
private boolean islibrarian;
public long id;
public PersonalInfo info;
public List<IRole> userRoles;
@Override
public boolean isAdmin() {
	// TODO Auto-generated method stub
	return isadmin;
}
@Override
public boolean isLibrarian() {
	// TODO Auto-generated method stub
	return islibrarian;
}
@Override
public void AddAdminRole() {
	// TODO Auto-generated method stub
	isadmin = true;
	IRole role = new AdminRole();
	this.userRoles.add(0,role);
}
@Override
public void AddLibrarianRole() {
	// TODO Auto-generated method stub
	islibrarian = true;
	IRole role = new LibrarianRole();
	this.userRoles.add(1,role);
}
@Override
public void RemoveAdminRole() {
	// TODO Auto-generated method stub
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
	// TODO Auto-generated method stub
	islibrarian = false;
	for(IRole r : this.userRoles){
		if(ILibrarianRole.class.isInstance(r))
		{
			userRoles.remove(r);
		}
	}
}
}

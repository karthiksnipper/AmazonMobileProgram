package mock.manager;

import mock.pages.GooglePage;
import mock.pages.RemoveListPage;

public class ObjectManager {
	public GooglePage objInstance;
	public RemoveListPage removeListPageObjInstance;
	
	public ObjectManager () {}

	public GooglePage getKartPageInstance() {
		return(objInstance==null)? objInstance = new GooglePage(): objInstance;
	}
	
	public RemoveListPage getRemoveListPageInstance() {
		return(removeListPageObjInstance==null)? removeListPageObjInstance = new RemoveListPage(): removeListPageObjInstance;
	}
	
	
	
}

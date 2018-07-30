package mela.model;

import java.util.List;

public interface Update {

	List<UpdateItem> computeUpdateItems( LocationManager locationManager, int location );
	
	int getIndexAgent();
	
}

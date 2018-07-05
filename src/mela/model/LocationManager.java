/**
 * 
 */
package mela.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ludovicaluisavissat
 *
 */
public class LocationManager {

	private ArrayList<Location> locations = new ArrayList<Location>();		
	
	private HashMap<String,Location> directory = new HashMap<>();

	private double[][] distanceMatrix;

	public ArrayList<Location> getLocations() {
		return locations;
	}
	
	public Location createLocation( String name ) {
		if (directory.containsKey(name)) {
			throw new IllegalArgumentException("Duplicated location name!");
		}
		Location location = new Location( name , locations.size() );
		locations.add(location);
		directory.put(name, location);
		return location;
	}
	
	public Location getLocation( String name ) {
		return directory.get(name);
	}
	
	public int getLocationIndex( String name ) {
		Location l = getLocation(name);
		if (l != null) {
			return l.getIndex();
		}
		return -1;
	}
	
	public String getLocationName( int idx ) {
		return locations.get(idx).getName();
	}
	
	public int getNumberOfLocations() {
		return locations.size();
	}
	
	public void addEdge( Location l1 , Location l2 ) {
		
	}
	
	public ArrayList<Integer> indexNeigh (int currentLocIndex, int d){
//		ArrayList<Integer> listNeigh = new ArrayList<>();
//		for (int locToCheck = 0; locToCheck< AllLoc.size(); locToCheck++){
//			if (distanceMatrix[currentLocIndex][locToCheck] == d){
//				listNeigh.add(locToCheck);				
//			}			
//		}
//		return listNeigh;		
		return null;
	}
	
	public void BuildDistanceMatrix(){
		//TODO build matrix - both graph and grid, if useful
	}
	
	
	
	   

}

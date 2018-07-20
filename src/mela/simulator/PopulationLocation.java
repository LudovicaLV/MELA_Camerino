/**
 * 
 */
package mela.simulator;

import mela.model.State;

/**
 * @author ludovicaluisavissat
 *
 */
public class PopulationLocation implements StoppingPredicate {

	private String agentName;
	private String locationName;
	private double timeBound;
	
	
	public boolean continueSimulation( State s , int steps , double time ){
		boolean toReturn = (agentExist(agentName, locationName, s) || (timeBoundOver(time)));
		return toReturn;
		
	}
		
	public boolean agentExist (String agentName, String locationName, State s){
		//TODO fix this
		//int agentIndex = agentManager.agentIndex(agentName);
		//int locationIndex = locationManager.getIndexFromName(locationName);
		int agentIndex = 0;
		int locationIndex = 0;
		if (s.get(agentIndex, locationIndex) != 0){
			return true;				
		}
		return false;
	}
	
	
	public void setPopulationName(String name){
		this.agentName = name;
	}	
	
	public void setLocationName(String name){
		this.locationName = name;
	}
	
	public void setTimeBound(double time){
		this.timeBound = time;
	}
	
	public boolean timeBoundOver (double timeToCheck){
		boolean check = timeToCheck < timeBound;
		return check;
	}
	
}


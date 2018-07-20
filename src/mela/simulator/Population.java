/**
 * 
 */
package mela.simulator;

import mela.model.State;

/**
 * @author ludovicaluisavissat
 *
 */
public class Population implements StoppingPredicate {
	
	private String agentName;
	private double timeBound;
	
	public boolean continueSimulation( State s , int steps , double time ){
		boolean toReturn = ( agentExist(agentName, s) || (timeBoundOver(time)));
		return toReturn;
		
	}
	
	public boolean agentExist (String agentName, State s){
		//TODO fix this
		//int agentIndex = agentManager.agentIndex(agentName);
		int agentIndex = 0;
		for (int i=0; i < s.numberLocations(); i++){
			if (s.get(agentIndex, i) != 0){
				return true;				
			}
		}
		return false;
	}
	
	public void setPopulationName(String name){
		this.agentName = name;
	}
	
	public void setTimeBound(double time){
		this.timeBound = time;
	}
	
	public boolean timeBoundOver (double timeToCheck){
		boolean check = timeToCheck < timeBound;
		return check;
	}
	

}




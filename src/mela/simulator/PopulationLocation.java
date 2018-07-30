/**
 * 
 */
package mela.simulator;
import mela.model.Model;
import mela.model.State;

/**
 * @author ludovicaluisavissat
 *
 */
public class PopulationLocation implements StoppingPredicate {

	private String agentName;
	private String locationName;
	private double timeBound;
	private Model m;
	
	
	public boolean continueSimulation( State s , int steps , double time ){
		boolean toReturn = (agentExist(agentName, locationName, s) && (timeBoundOver(time)));
		return toReturn;
		
	}
		
	public boolean agentExist (String agentName, String locationName, State s){
		int agentIndex = m.getAgentManager().agentIndex(agentName);
		int locationIndex = m.getLocationManager().getIndexFromName(locationName);
		//TODO verify locationName here
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

	public void setModel(Model m) {
		this.m = m;		
	}
	
}


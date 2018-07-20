/**
 * 
 */
package mela.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

import mela.simulator.Transition;

/**
 * @author ludovicaluisavissat
 *
 */

public class Model {
		
	private AgentManager agentManager;
	private LocationManager locationManager;
	private BiFunction<Integer,Integer,Integer> agentLocationFunction;
	
	
	public void setAgentManager(AgentManager agentManager){
		this.agentManager = agentManager;
	}
	
	public void setLocationManager(LocationManager locationManager){
		this.locationManager = locationManager;
	}
	
	public void setBiFunction(BiFunction<Integer,Integer,Integer> agentLocationFunction){
		this.agentLocationFunction = agentLocationFunction;
	}
	
	/**
	 * @return initial state of the system: number of agents for each different type in each different location
	 */
	public State getInitialState() {
		int namesSize = agentManager.size();
		int allLocSize = locationManager.size();
		State initState = new State(namesSize, allLocSize, agentLocationFunction);
		// TODO initMatrix is initialised during the parsing of the model
		return initState;
	}

	
	/**
	 * @param current: current state of the system
	 * @return return the list of possible transitions given the current state and calling the agentManager and locationManager
	 */
	public List<Transition> getTransitions(State current) {		
		LinkedList<Transition> toReturn = new LinkedList<>();
		for ( int l=0 ; l<locationManager.size() ; l++ ) {
			for( int a=0 ; a<agentManager.size() ; a++ ) {
				if (current.get(a, l) != 0) {
					toReturn.addAll(agentManager.apply(a,l,current,locationManager));
				}
			}
		}
		return toReturn;
	}		

	
    public Agent addAgent(String name) {
    	if (agentManager.directory.containsKey(name)) {
    		throw new IllegalArgumentException("Duplicated agent name!");
    	}
    	Agent agent = new Agent(agentManager.agents.size(), name);
    	agentManager.directory.put(name, agent);
    	//add Agent to agents?
    	return agent;
    }    
	
	public LocationManager getLocationManager() {
		return locationManager;
	}
	
	public AgentManager getAgentManager() {
		return agentManager;
	}

	public BiFunction<Integer,Integer,Integer> getInitCond() {
		return agentLocationFunction;
	}
}

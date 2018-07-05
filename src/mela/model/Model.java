/**
 * 
 */
package mela.model;

import java.util.ArrayList;
import java.util.List;

import mela.simulator.Transition;

/**
 * @author ludovicaluisavissat
 *
 */
public class Model {
	
	private AgentManager agentManager;
	private LocationManager locationManager;
	private ParamManager paramManager;	
	private int[][] initMatrix;
	
	public Model(){
		this.agentManager = new AgentManager();
		this.locationManager = new LocationManager();
		this.paramManager = new ParamManager();
	}

	public State getInitialState() {
		int namesSize = agentManager.AgentNames.size();
		int allLocSize = locationManager.getAllLoc().size();
		initMatrix = new int[namesSize][allLocSize];
		State initState = new State(namesSize, allLocSize, initMatrix);
		// TODO initMatrix is initialised during the parsing of the model
		return initState;
	}

	public ArrayList<Transition> getTransitions(State current) {
//		ArrayList<Transition> Transitions = new ArrayList<Transition>();			    		
//		for (int agentIndex = 0; agentIndex < GlobalManager.getAgentManager().Agents.size(); agentIndex++) {								
//		for (int locationIndex = 0; locationIndex < GlobalManager.getLocationManager().AllLoc.size(); locationIndex++) {
//			if (current.get(agentIndex, locationIndex) != 0){
//				ArrayList<Transition> listTransitions = new ArrayList<Transition>();
//				for (Rule rule : GlobalManager.getAgentManager().Agents.get(agentIndex).getRuleList()) {				
//			    listTransitions = rule.BuildActionStep(GlobalManager.getAgentManager(), GlobalManager.getLocationManager(), locationIndex);
//			    for (int i=0; i < listTransitions.size(); i++){
//			    	Transitions.add(listTransitions.get(i));							
//				}
//			    listTransitions.clear();
//			    }}}}
		return null;
	}		


	public ParamManager getParamManager() {
		return paramManager;
	}
	
	public LocationManager getLocationManager() {
		return locationManager;
	}
	
	public AgentManager getAgentManager() {
		return agentManager;
	}

}

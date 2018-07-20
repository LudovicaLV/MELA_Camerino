/**
 * 
 */
package mela.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import mela.model.actions.Action;
import mela.model.actions.PassAction;
import mela.simulator.Transition;

/**
 * @author ludovicaluisavissat
 *
 */
public class AgentManager {
	
	public ArrayList<Agent> agents = new ArrayList<>(); 
	public HashMap<String,Agent> directory = new HashMap<>();
	//directory used to verify there are not duplicates in the agent names

	public Set<String> getAgentsNames() {
		return directory.keySet();
	}
    
    public Agent addAgent(String name) {
    	if (directory.containsKey(name)) {
    		throw new IllegalArgumentException("Duplicated agent name!");
    	}
    	Agent agent = new Agent( agents.size(), name);
    	directory.put(name, agent);
    	return agent;
    }    

	public int size() {
		return agents.size();
	}
	
	public int agentIndex (String name){
		Agent toCheck = directory.get(name);
		int index = agents.indexOf(toCheck);
		return index;
	}

	/**
	 * @param a: index agent
	 * @param l: index location
	 * @param current: current state of the system
	 * @param locationManager: spatial structure
	 * @return:  transition enabled by the agent in the location
	 */
	public Collection<? extends Transition> apply(int a, int l, State current, LocationManager locationManager) {
		return agents.get(a).apply(l,current,locationManager);
	}

}

/**
 * 
 */
package mela.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import mela.model.Actions.Action;
import mela.model.Actions.PassAction;
import mela.simulator.Transition;

/**
 * @author ludovicaluisavissat
 *
 */
public class AgentManager {
	
	public ArrayList<Agent> agents = new ArrayList<>(); 
	public HashMap<String,Agent> directory = new HashMap<>();

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

	public Collection<? extends Transition> apply(int a, int l, State current, LocationManager locationManager) {
		return agents.get(a).apply(l,current,locationManager);
	}

}

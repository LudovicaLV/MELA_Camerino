/**
 * 
 */
package mela.model;

import java.util.ArrayList;
import java.util.HashMap;

import mela.model.Actions.Action;
import mela.model.Actions.PassAction;

/**
 * @author ludovicaluisavissat
 *
 */
public class AgentManager {
	
	public ArrayList<Agent> Agents = new ArrayList<>(); 
	public ArrayList<String> AgentNames = new ArrayList<>(); 
	
    //name of the action -> index of passive agent
    public static HashMap<String, Integer> PassiveAgentIndex = new HashMap<>();	   
    //name of the action -> probability
    public static HashMap<String, Double> Probability = new HashMap<>();

	public ArrayList<String> getAgentsNames() {
		return AgentNames;
	}
    
    public void addAgent(Agent a) {
    	Agents.add(a);
    }
    
	 public void addAgentName(String Name){
		AgentNames.add(Name);
	}
	  
	 public static void DefineHashMap(){
			//passive action hashmap (index of the agents, probability)
			for (Agent a: GlobalManager.getAgentManager().Agents) {
				for (Action ac : a.getActionList()){
			        if (ac.getType() == 3){	
						PassAction passac = (PassAction) ac;
						PassiveAgentIndex.put(ac.getName(), a.index);
						Probability.put(ac.getName(), passac.getInfProb());
			}}}
		}

}

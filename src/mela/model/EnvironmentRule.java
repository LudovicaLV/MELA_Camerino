/**
 * 
 */
package mela.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

import mela.io.AllActionInfo;
import mela.simulator.ActionInfo;
import mela.simulator.Transition;

/**
 * @author ludovicaluisavissat
 *
 */
public class EnvironmentRule implements Rule {
	
	private final String info;
	private final int agentIndex;
	private final AgentStep step;
	private final double rate;
	private final Predicate<Integer> environmentSet;
	private final double effectProb;

	/**
	 * info: information about the action, for metadata
	 * agentIndex: index of active agent
	 * step: index and update for the agent
	 * rate: rate of the action
	 * environmentSet: to evaluate if the passive agent is in a location under the environment influence
	 * effectProb: probability of the action to be effective
	 */
	public EnvironmentRule(String info, int agentIndex, AgentStep step, double rate,
			Predicate<Integer> environmentSet, double effectProb) {
		super();
		this.info = info;
		this.agentIndex = agentIndex;
		this.step = step;
		this.rate = rate;
		this.environmentSet = environmentSet;
		this.effectProb = effectProb;
	}

	@Override
	/**
	 * this methods returns the set of enabled transitions, for passive agents which are located in the locations
	 * influenced by the environment.
	 * If we do not have passive agents, this method will not be called (the method getTransitions() in the model checks the presence of the agents)
	 */
	public Collection<? extends Transition> apply(int l, State current, LocationManager locationManager) {
		LinkedList<Transition> toReturn = new LinkedList<>();
		if (environmentSet.test(l)) {
			List<UpdateItem> updateItems = step.computeUpdateItems(locationManager, l);
			for (UpdateItem updateItem : updateItems) {
				List<AgentVariation> variations = updateItem.getVariations();
				//TODO: Built here the appropriate  ActionInfo
				int passAgentIndex = step.getAgentIndex();
				String infoRule = info;
				toReturn.add(new Transition(rate*current.get(passAgentIndex, l)*updateItem.getProb()*effectProb, variations, infoRule));
			}
			//TODO: Built here the appropriate  ActionInfo
			int passAgentIndex = step.getAgentIndex();
			String infoRule = "No change";
			toReturn.add(new Transition(rate*current.get(passAgentIndex, l)*(1-effectProb), new LinkedList<>(), infoRule));
		}
		return toReturn;
	}
	
	
	public static Predicate<Integer> createPredicate( ArrayList<Integer> locations ) {
		return l -> locations.contains(l);
	}
	
	public static Predicate<Integer> allPredicate( ) {
		return l -> true;
	}
	

    public static void createAddEnvRule(HashMap<String, AllActionInfo> map, String nameAction, AgentManager am, HashMap<String, Double> parameters){
    	 String info = nameAction + " " + map.get(nameAction).getType();
	     String agentName = map.get(nameAction).getAgentPerformingActive();
	     int agentIndex = am.agentIndex(agentName);
    	 String passAgentName = map.get(nameAction).getAgentPerformingPassive();
         int agentIndexPass = am.agentIndex(passAgentName);
         Update updatePassive = map.get(nameAction).getUpdatePassive();
         AgentStep passiveStep = new AgentStep(agentIndexPass, updatePassive);
         Predicate<Integer> environmentSet =  map.get(nameAction).getEnvPredicate();
         if (parameters.get(map.get(nameAction).getRateName()) == null) { 
	    	  throw new Error("Parameter " + map.get(nameAction).getRateName() + " is not defined.");
	     }	    	   
	     if (parameters.get(map.get(nameAction).getProbName()) == null) { 
	    	  throw new Error("Parameter " + map.get(nameAction).getProbName() + " is not defined.");
	     }
	     String rateName = map.get(nameAction).getRateName();
	     double rate = parameters.get(rateName);
         String passProbName = map.get(nameAction).getProbName();
         double passProb = parameters.get(passProbName);
         EnvironmentRule newEnv = new EnvironmentRule(info, agentIndex, passiveStep, rate, environmentSet, passProb);
         am.directory.get(passAgentName).addRule(newEnv); 
    }




}

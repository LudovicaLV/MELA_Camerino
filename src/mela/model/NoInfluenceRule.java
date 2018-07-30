/**
 * 
 */
package mela.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import mela.io.AllActionInfo;
import mela.simulator.ActionInfo;
import mela.simulator.Transition;

/**
 * @author ludovicaluisavissat
 *
 */

public class NoInfluenceRule implements Rule {
	
	private final String info;
	private final int agentIndex;
	private final Update update;
	private final double rate;

	
	public NoInfluenceRule(String info, int agentIndex, double rate, Update update) {
		super();
		this.info = info;
		this.agentIndex = agentIndex;
		this.update = update;
		this.rate = rate;
	}	

	@Override	
	/**
	 * this method creates the list of enabled transitions given the no-influence action 
	 * the use of updateItem and probability in this case is used for movement actions
	 */
	public Collection<? extends Transition> apply(int l, State current, LocationManager locationManager) {
		LinkedList<Transition> toReturn = new LinkedList<>();
		//TODO: Built here the appropriate  ActionInfo
		List<UpdateItem> updateItems = update.computeUpdateItems(locationManager, l);
		for (UpdateItem updateItem : updateItems) {
			List<AgentVariation> variations = updateItem.getVariations();
			String infoRule = info;
			toReturn.add(new Transition(rate*current.get(agentIndex, l)*updateItem.getProb(), variations, infoRule));
		}
		return toReturn;
	}
	
	public static void createAddNoInfRule(HashMap<String, AllActionInfo> map, String nameAction, AgentManager am, HashMap<String, Double> parameters){
	       String info = nameAction + " " + map.get(nameAction).getType();
	       String agentName = map.get(nameAction).getAgentPerformingActive();
	       int agentIndex = am.agentIndex(agentName);
	       Update update = map.get(nameAction).getUpdateActive();
	       if (parameters.get(map.get(nameAction).getRateName()) != null) { 
	       double rate = parameters.get(map.get(nameAction).getRateName()); 	       
	       NoInfluenceRule newNoInf = new NoInfluenceRule(info, agentIndex, rate, update);
	       am.directory.get(agentName).addRule(newNoInf); 
	       }
	       else {
	          throw new Error("Parameter " + map.get(nameAction).getRateName() + " is not defined.");
	       }  
	}
	
	


}

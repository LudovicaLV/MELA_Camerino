/**
 * 
 */
package mela.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
			toReturn.add(new Transition(rate*current.get(agentIndex, l)*updateItem.getProb(), variations, new ActionInfo()));
		}
		return toReturn;
	}
	
	


}

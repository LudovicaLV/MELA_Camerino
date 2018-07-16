/**
 * 
 */
package mela.model;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ludovicaluisavissat
 *
 */
public class DeterministicUpdate implements Update {
	
	private final int[] nextAgents;
	private final int src;
	
	public DeterministicUpdate( int src , int ... nextAgents ) {
		this.src = src;
		this.nextAgents= nextAgents;
	}
	
	/**
	 * return the list of updateItems
	 * as variations, it removes the current agent, it adds the new one(s), in the same location
	 * Change of state 1: add one new agents
     * Change of state 2: add two new agents
     * Demographic +: add two agent of the same type (birth action as (alpha, r).(P(l)||P(l)))
     * Demographic -: no variations (we already removed the existing one, nextAgents will be empty)
	 * this update has probability 1.0
	 *
	 */
	@Override
	public List<UpdateItem> computeUpdateItems(LocationManager locationManager, int location) {
		LinkedList<UpdateItem> toReturn = new LinkedList<>();
		LinkedList<AgentVariation> variations = new LinkedList<>();
		variations.add(new AgentVariation(src, location, -1));
		for (int idx : nextAgents) {
			variations.add(new AgentVariation(idx, location, +1));
		}
		toReturn.add(new UpdateItem(1.0, variations));
		return toReturn;
	}
	
}

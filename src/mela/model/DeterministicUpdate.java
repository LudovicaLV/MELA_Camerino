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

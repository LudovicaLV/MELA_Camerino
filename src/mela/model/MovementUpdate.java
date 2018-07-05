/**
 * 
 */
package mela.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import mela.simulator.ActionInfo;
import mela.simulator.Transition;

/**
 * @author ludovicaluisavissat
 *
 */
public class MovementUpdate implements Update {
	
	private final int src;
	
	public MovementUpdate( int src ) {
		this.src = src;
	}
	

	@Override
	public List<UpdateItem> computeUpdateItems(LocationManager locationManager, int location) {
		LinkedList<UpdateItem> toReturn = new LinkedList<>();
		Set<Integer> nextTo = locationManager.nextTo(location);
		double prob = 1.0/nextTo.size();
		for (Integer l2 : nextTo) {
			toReturn.add(new UpdateItem(prob, getVariation(location,l2)));
		}
		return toReturn;
	}

	private LinkedList<AgentVariation> getVariation(int startLocation, int endLocation) {
		LinkedList<AgentVariation> variations = new LinkedList<>();
		variations.add(new AgentVariation(src, startLocation, -1));
		variations.add(new AgentVariation(src, endLocation, 1));			
		return variations;
	}

}

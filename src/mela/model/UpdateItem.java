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
public class UpdateItem {

	private final double prob;
	
	private final LinkedList<AgentVariation> variations;

	public UpdateItem(double prob, LinkedList<AgentVariation> variations) {
		super();
		this.prob = prob;
		this.variations = variations;
	}

	public double getProb() {
		return prob;
	}

	public LinkedList<AgentVariation> getVariations() {
		return variations;
	}


}

/**
 * 
 */
package mela.model;

import java.util.List;

/**
 * @author ludovicaluisavissat
 *
 */
public class AgentStep {
	
	private final int agentIndex;
	
	private final Update update;

	public AgentStep(int agentIndex, Update update) {
		super();
		this.agentIndex = agentIndex;
		this.update = update;
	}

	public List<UpdateItem> computeUpdateItems(LocationManager locationManager, int l) {
		return update.computeUpdateItems(locationManager, l);
	}

	public int getAgentIndex() {
		return agentIndex;
	}

	

}

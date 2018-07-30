/**
 * 
 */
package mela.simulator;

import java.util.List;

import mela.model.AgentVariation;
import mela.model.State;

/**
 * @author ludovicaluisavissat
 *
 */
public class Transition {
	
	private final double rate;
	private final List<AgentVariation> v;
	private final String actionInfo;
	
	public Transition(double rate, List<AgentVariation> v, String actionInfo) {
		super();
		this.rate = rate;
		this.v = v;
		this.actionInfo = actionInfo;
	}

	public double getRate() {
		return rate;
	}

	public List<AgentVariation> getVariation() {
		return v;
	}

	public String getInfo() {
		return actionInfo;
	}
	
	public State apply(State current) {
		State newState = current.apply(v);
		return newState;
	}

}

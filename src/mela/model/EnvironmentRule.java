/**
 * 
 */
package mela.model;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

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
	public Collection<? extends Transition> apply(int l, State current, LocationManager locationManager) {
		LinkedList<Transition> toReturn = new LinkedList<>();
		if (environmentSet.test(l)) {
			List<UpdateItem> updateItems = step.computeUpdateItems(locationManager, l);
			for (UpdateItem updateItem : updateItems) {
				List<AgentVariation> variations = updateItem.getVariations();
				//TODO: Built here the appropriate  ActionInfo
				toReturn.add(new Transition(rate*current.get(agentIndex, l)*updateItem.getProb()*effectProb, variations, new ActionInfo()));
			}
			//TODO: Built here the appropriate  ActionInfo
			toReturn.add(new Transition(rate*current.get(agentIndex, l)*(1-effectProb), new LinkedList<>(), new ActionInfo()));
		}
		return toReturn;
	}


}

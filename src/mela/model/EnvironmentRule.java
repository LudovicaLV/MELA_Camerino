/**
 * 
 */
package mela.model;

import java.util.ArrayList;
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

	/**
	 * info: information about the action, for metadata
	 * agentIndex: index of passive agent
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
				toReturn.add(new Transition(rate*current.get(agentIndex, l)*updateItem.getProb()*effectProb, variations, new ActionInfo()));
			}
			//TODO: Built here the appropriate  ActionInfo
			toReturn.add(new Transition(rate*current.get(agentIndex, l)*(1-effectProb), new LinkedList<>(), new ActionInfo()));
		}
		return toReturn;
	}
	
	
	public static Predicate<Integer> createPredicate( ArrayList<Integer> locations ) {
		return l -> locations.contains(l);
	}
	
	public static Predicate<Integer> allPredicate( ) {
		return l -> true;
	}
	






}

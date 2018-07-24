/**
 * 
 */
package mela.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;

import mela.simulator.ActionInfo;
import mela.simulator.Transition;

/**
 * @author ludovicaluisavissat
 *
 */

public class InfluenceRule implements Rule {
	
	/**
	 * info: information for metadata
	 * rate: rate of the action
	 * passiveProb: probability of the action to be effective
	 * active: index of agent performing the action, its update
	 * passive: index of passive agent, its update
	 * influenceFunction: index of locations where the influence is felt
	 */
	private final String info;
	private final double rate;
	private final double passiveProb;
	private final AgentStep active;
	private final AgentStep passive;
	private final BiFunction<Integer,LocationManager,List<Integer>> influenceFunction;

	public InfluenceRule(String info, 
			double rate,
			AgentStep active , 
			BiFunction<Integer,LocationManager,List<Integer>> influenceFunction, 
			AgentStep passive ,
			double passiveProb ) {
		super();
		this.info = info;
		this.active = active;
		this.passive = passive;
		this.rate = rate;
		this.passiveProb = passiveProb;
		this.influenceFunction = influenceFunction;
	}	
	
	/**
	 * build the transitions with the updates for both the active and the passive, checking the presence of the passive agents
	 * it uses the method addTransitions to add both the updates
	 * it builds the two possible transitions, the effective (probability p) and not effective (probability 1-p)
	 */	
	@Override
	public Collection<? extends Transition> apply(int l, State current, LocationManager locationManager) {
		LinkedList<Transition> toReturn = new LinkedList<>();
		int activeMul = current.get(active.getAgentIndex(), l);
		List<UpdateItem> activeUpdateItems = active.computeUpdateItems(locationManager, l);
		for (Integer l2 : influenceFunction.apply(l, locationManager)) {
			int passiveMul = current.get(passive.getAgentIndex(), l2);
			if (passiveMul > 0) {
				List<UpdateItem> passiveUpdateItems = passive.computeUpdateItems(locationManager, l2);
				addTransitions( toReturn , rate*passiveProb*activeMul*passiveMul , activeUpdateItems , passiveUpdateItems );
				//TODO: Built here the appropriate  ActionInfo
				toReturn.add(new Transition(rate*(1-passiveProb)*activeMul*passiveMul, new LinkedList<>(), new ActionInfo()));
			}
		}
		return toReturn;
	}

	/**
	 * @param toReturn: list of enabled transitions
	 * @param rate: rate of the action
	 * @param activeUpdateItems: update of the active agent
	 * @param passiveUpdateItems: update of the passive agent
	 */
	private void addTransitions(LinkedList<Transition> toReturn, double rate, List<UpdateItem> activeUpdateItems,
			List<UpdateItem> passiveUpdateItems) {
		for (UpdateItem passiveItem : passiveUpdateItems) {
			for (UpdateItem activeItem : activeUpdateItems) {
				LinkedList<AgentVariation> variations = new LinkedList<>();
				variations.addAll(passiveItem.getVariations());
				variations.addAll(activeItem.getVariations());				
				toReturn.add(new Transition(rate*passiveItem.getProb()*activeItem.getProb(), variations, new ActionInfo()));
			}
		}		

	}


}

package mela.model;

import java.util.Collection;

import mela.simulator.Transition;

/**
 * This class represents the action executed by an agent.
 * 
 * 
 * @author ludovicaluisavissat
 *
 */
@FunctionalInterface
public interface Rule {
	
	/**
	 * Return the list of transitions enabled when the rule is applied.
	 * 
	 * @param l: the location where the rule is applied
	 * @param current: current state
	 * @param locationManager: Location Manager
	 * @return
	 */
	
	public Collection<? extends Transition> apply(int l, State current, LocationManager locationManager);
	
}




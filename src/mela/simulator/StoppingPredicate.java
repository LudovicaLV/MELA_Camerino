/**
 * 
 */
package mela.simulator;

import mela.model.Model;
import mela.model.State;

/**
 * @author ludovicaluisavissat
 *
 */
public interface StoppingPredicate  {

	
	/**
	 * @param s: current state of the system
	 * @param steps: number of steps
	 * @param time: time elapsed
	 * @return: if the simulation can continue or has to stop
	 */
	public boolean continueSimulation( State s , int steps , double time );

}

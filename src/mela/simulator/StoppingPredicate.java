/**
 * 
 */
package mela.simulator;

import mela.model.State;

/**
 * @author ludovicaluisavissat
 *
 */
public interface StoppingPredicate {
	
	public boolean continueSimulation( State s , int steps , double time );

}

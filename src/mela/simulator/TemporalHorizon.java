/**
 * 
 */
package mela.simulator;

import mela.model.State;

/**
 * @author ludovicaluisavissat
 *
 */
public class TemporalHorizon implements StoppingPredicate {
	
	private double temporalHorizon;

	
	public boolean continueSimulation( State s , int steps , double time ){
		boolean toReturn = (time < temporalHorizon);
		return toReturn;
		
	}
	
	public void setTemporalHorizon(double tempHorizon){
		this.temporalHorizon = tempHorizon;
	}

	
}

/**
 * 
 */
package mela.simulator;

import mela.model.State;

/**
 * @author ludovicaluisavissat
 *
 */
public class StepsPredicate implements StoppingPredicate {
	
	private int numberSteps;

	
	public boolean continueSimulation( State s , int steps , double time ){
		boolean toReturn = (steps < numberSteps);
		return toReturn;
		
	}
	
	public void setNumberSteps(int numSteps){
		this.numberSteps = numSteps;
	}

}

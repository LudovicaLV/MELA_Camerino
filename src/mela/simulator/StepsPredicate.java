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
	private double timeBound;

	
	public boolean continueSimulation( State s , int steps , double time ){
		boolean toReturn = ((steps < numberSteps) && (timeBoundOver(time)));
		return toReturn;
		
	}
	
	public void setNumberSteps(int numSteps){
		this.numberSteps = numSteps;
	}
	
	public void setTimeBound(double time){
		this.timeBound = time;
	}
	
	public boolean timeBoundOver (double timeToCheck){
		boolean check = timeToCheck < timeBound;
		return check;
	}
	



}

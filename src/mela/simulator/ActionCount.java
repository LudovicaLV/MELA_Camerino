/**
 * 
 */
package mela.simulator;

import mela.model.State;

/**
 * @author ludovicaluisavissat
 *
 */
public class ActionCount implements StoppingPredicate{
	
	private String nameAction;
	private int count;
	private double timeBound;
		
	
	public boolean continueSimulation( State s , int steps , double time ){
		boolean toReturn = ((Simulator.count(nameAction) < count) 	|| (timeBoundOver(time)));
		return toReturn;
		
	}
	
	public void setActionName(String name){
		this.nameAction = name;
	}
	
	public void setCount(int count){
		this.count = count;
	}

	
	public void setTimeBound(double time){
		this.timeBound = time;
	}
	
	public boolean timeBoundOver (double timeToCheck){
		boolean check = timeToCheck < timeBound;
		return check;
	}
	


}

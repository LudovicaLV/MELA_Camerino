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
		
	private int countAction = 0;
	
	public boolean continueSimulation( State s , int steps , double time ){
		if (Simulator.getNameAction() == nameAction ){
			countAction++;
		}
		boolean toReturn = ((countAction < count) && (timeBoundOver(time)));
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

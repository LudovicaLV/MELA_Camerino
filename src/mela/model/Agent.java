/**
 * 
 */
package mela.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import mela.model.Actions.Action;
import mela.simulator.Transition;

/**
 * @author ludovicaluisavissat
 *
 */
public class Agent {
	
	private final String name;
	private final int index;
	private final LinkedList<Rule> ruleList = new LinkedList<Rule>();
	
	public Agent(int index, String name) {
		this.index = index;
		this.name = name;
	}
	
	public int getIndex(){
		return index;
	}
	
	public void addRule(Rule r){
		ruleList.add(r);
	}
	
	public LinkedList<Rule> getRuleList() {
		return this.ruleList;
	}

	public Collection<? extends Transition> apply(int l, State current, LocationManager locationManager) {
		LinkedList<Transition> toReturn = new LinkedList<>();
		for (Rule r : ruleList) {
			toReturn.addAll(r.apply(l,current,locationManager));
		}
		return toReturn;
	}

}

/**
 * 
 */
package mela.model;

import java.util.ArrayList;

import mela.model.Actions.Action;

/**
 * @author ludovicaluisavissat
 *
 */
public class Agent {
	
	int index;
	ArrayList<Action> actionList = new ArrayList<Action>();
	ArrayList<Rule> ruleList = new ArrayList<Rule>();

	
	public Agent() {
		this.index = index;
		GlobalManager.getAgentManager().addAgent(this);
		//TODO sistemare: quando si fa il parsing dobbiamo aggiungere il nome dell'agente nell'AgentManager
	}
	
	public int getIndex(){
		return index;
	}
	
	public void addAction(Action a){
		actionList.add(a);
	}
	
	public ArrayList<Action> getActionList() {
		return this.actionList;
	}
	
	public void addRule(Rule r){
		ruleList.add(r);
	}
	
	public ArrayList<Rule> getRuleList() {
		return this.ruleList;
	}

}

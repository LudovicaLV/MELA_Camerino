/**
 * 
 */
package mela.model;

import java.util.ArrayList;
import java.util.List;
/**
 * @author ludovicaluisavissat
 *
 */
public class State {   
 
	private final int agents;
	private final int locations;
	private final int[][] state;  
	
	//I removed the private method, ok?
	
    public State(int agents, int locations, int[][] state){
    	this.agents = agents;
    	this.locations = locations;
    	this.state = new int[agents][locations];
    }
    
    public int get(int agent, int location) {
    	return this.state[agent][location];
    }
    
    public State apply( List<AgentVariation> updates ) {
    	int[][] newState = copyState();
    	for (AgentVariation av : updates) {
			newState[av.getAgentIndex() ][av.getLocationIndex()] += av.getVariation();
		}
    	return new State(this.agents,this.locations,newState);
    }

	private int[][] copyState() {
		int[][] newState = new int[agents][locations];
		for( int i=0 ; i<agents ; i++ ) {
			for( int j=0 ; j<locations ; j++ ) {
				newState[i][j] = state[i][j];
			}
		}
		return newState;
	}

    
}
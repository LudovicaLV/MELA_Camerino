/**
 * 
 */
package mela.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
/**
 * @author ludovicaluisavissat
 *
 */

public class State {   
 
	private final int agents;
	private final int locations;
	private final int[][] state;  
	
    private State(int agents, int locations, int[][] state){
    	this.agents = agents;
    	this.locations = locations;
    	this.state = state;
    }   

    /**
     * @param agents: number of agents
     * @param locations: number of locations
     * @param agentAllocationFunction: initial state of the system
     */
    public State(int agents, int locations, BiFunction<Integer, Integer, Integer> agentAllocationFunction) {
    	this.agents = agents;
    	this.locations = locations;
    	this.state = new int[agents][locations];
    	for( int i=0 ; i < agents ; i++ ) {
        	for( int j=0 ; j < locations ; j++ ) {
        		this.state[i][j] = agentAllocationFunction.apply(i, j);
        	}    		
    	}
	}

	/**
	 * @param agent: index agent
	 * @param location: index location
	 * @return: number of the required agent in the given location
	 */
	public int get(int agent, int location) {
    	return this.state[agent][location];
    }
    
    /**
     * @param updates: lit of agents' variation
     * @return new state of the system, after the variation have been applied
     */
    public State apply( List<AgentVariation> updates ) {
    	int[][] newState = copyState();
    	for (AgentVariation av : updates) {
			newState[av.getAgentIndex() ][av.getLocationIndex()] += av.getVariation();
		}
    	return new State(this.agents,this.locations,newState);
    }

	/**
	 * @return copy of the current state of the system
	 */
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
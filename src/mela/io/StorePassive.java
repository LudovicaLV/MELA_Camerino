/**
 * 
 */
package mela.io;

import mela.model.AgentStep;

/**
 * @author ludovicaluisavissat
 *
 */
public class StorePassive {
	
	public static String info;
	public static double prob;
	public static AgentStep agentStep;
	
	
	
	public static void setInfo(String info) {
		StorePassive.info = info;
	}
	public static void setProb(double prob) {
		StorePassive.prob = prob;
	}
	public static void setAgentStep(AgentStep agentStep) {
		StorePassive.agentStep = agentStep;
	}
	
	

}

/**
 * 
 */
package mela.io;

import java.util.List;
import java.util.function.BiFunction;

import mela.model.AgentStep;
import mela.model.LocationManager;

/**
 * @author ludovicaluisavissat
 *
 */
public class StoreInfluence {
	
	public static String info;
	public static double rate;
	public static AgentStep agentStep;
	public static BiFunction<Integer,LocationManager,List<Integer>> influenceFunction;
	
	
	public static void setInfo(String info) {
		StoreInfluence.info = info;
	}
	public static void setRate(double rate) {
		StoreInfluence.rate = rate;
	}
	public static void setAgentStep(AgentStep agentStep) {
		StoreInfluence.agentStep = agentStep;
	}
	public static void setInfluenceFunction(BiFunction<Integer, LocationManager, List<Integer>> influenceFunction) {
		StoreInfluence.influenceFunction = influenceFunction;
	}
	

}

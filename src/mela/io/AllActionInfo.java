/**
 * 
 */
package mela.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import mela.model.AgentStep;
import mela.model.LocationManager;
import mela.model.Update;

/**
 * @author ludovicaluisavissat
 *
 */
public class AllActionInfo {
	
	public static String agentPerformingActive;
	public static String agentPerformingPassive;
	public static String type;
	public static String rateName;
	public static String probName;
	public static Update updateActive;
	public static Update updatePassive;
	public static BiFunction<Integer,LocationManager,List<Integer>> infSet;
	public static Predicate<Integer> envPredicate;
	
	public void setAgentPerformingActive(String agentPerformingActive) {
		AllActionInfo.agentPerformingActive = agentPerformingActive;
	}
	public void setAgentPerformingPassive(String agentPerformingPassive) {
		AllActionInfo.agentPerformingPassive = agentPerformingPassive;
	}
	public void setType(String type) {
		AllActionInfo.type = type;
	}
	public void setRateName(String rateName) {
		AllActionInfo.rateName = rateName;
	}
	public void setProbName(String probName) {
		AllActionInfo.probName = probName;
	}
	public void setUpdateActive(Update updateActive) {
		AllActionInfo.updateActive = updateActive;
	}
	public void setUpdatePassive(Update updatePassive) {
		AllActionInfo.updatePassive = updatePassive;
	}
	
	//depending on the influence set
	//local
	public void setInfSetLocal() {
		AllActionInfo.infSet = ( (x,y) -> 
		createList(x)
	);
	}
	
	//neighbouring locations at distance d
	public void setInfSetNeigh(Integer d) {
		AllActionInfo.infSet = ( (x,y) -> 
		y.allTheIndexDistance(d, x)
	);	
    }	
		
	//all the locations	
	public void setInfSetAll() {
		AllActionInfo.infSet = ( (x,y) -> 
		y.allTheIndex()
	);	
    }		
	public void setEnvPredicate(Predicate<Integer> envPredicate) {
		AllActionInfo.envPredicate = envPredicate;
	}	
	
	public String getAgentPerformingActive() {
		return agentPerformingActive;
	}
	public String getAgentPerformingPassive() {
		return agentPerformingPassive;
	}
	public String getType() {
		return type;
	}
	public String getRateName() {
		return rateName;
	}
	public String getProbName() {
		return probName;
	}
	public Update getUpdateActive() {
		return updateActive;
	}
	public Update getUpdatePassive() {
		return updatePassive;
	}
	public BiFunction<Integer, LocationManager, List<Integer>> getInfSet() {
		return infSet;
	}
	public Predicate<Integer> getEnvPredicate() {
		return envPredicate;
	}
	

	
	
	public static ArrayList<Integer> createList (int x){
		ArrayList<Integer> newList = new ArrayList<Integer>();
		newList.add(x);
		return newList;
	}

}

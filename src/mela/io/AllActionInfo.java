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
	
	public String agentPerformingActive;
	public String agentPerformingPassive;
	public String type;
	public String rateName;
	public String probName;
	public Update updateActive;
	public Update updatePassive;
	public BiFunction<Integer,LocationManager,List<Integer>> infSet;
	public Predicate<Integer> envPredicate;
		
	
	public void setAgentPerformingActive(String agentPerformingActive) {
		this.agentPerformingActive = agentPerformingActive;
	}
	public void setAgentPerformingPassive(String agentPerformingPassive) {
		this.agentPerformingPassive = agentPerformingPassive;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setRateName(String rateName) {
		this.rateName = rateName;
	}
	public void setProbName(String probName) {
		this.probName = probName;
	}
	public void setUpdateActive(Update updateActive) {
		this.updateActive = updateActive;
	}
	public void setUpdatePassive(Update updatePassive) {
		this.updatePassive = updatePassive;
	}
	
	//depending on the influence set
	//local
	public void setInfSetLocal() {
		this.infSet = ( (x,y) -> 
		createList(x)
	);
	}
	
	//neighbouring locations at distance d
	public void setInfSetNeigh(Integer d) {
		this.infSet = ( (x,y) -> 
		y.allTheIndexDistance(d, x)
	);	
    }	
		
	//all the locations	
	public void setInfSetAll() {
		this.infSet = ( (x,y) -> 
		y.allTheIndex()
	);	
    }		
	public void setEnvPredicate(Predicate<Integer> envPredicate) {
		this.envPredicate = envPredicate;
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
	@Override
	public String toString() {
		return "AllActionInfo [agentPerformingActive=" + agentPerformingActive + ", agentPerformingPassive="
				+ agentPerformingPassive + ", type=" + type + ", rateName=" + rateName + ", probName=" + probName + "]";
	}

}

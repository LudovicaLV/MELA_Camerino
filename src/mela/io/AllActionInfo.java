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
//	public Update updateActive;
//	public Update updatePassive;
	public String symbolActive;
	public ArrayList<String> updateArrayActive = new ArrayList<String>();
	public String symbolPassive;
	public ArrayList<String> updateArrayPassive = new ArrayList<String>();	
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
	
	public void setSymbolActive(String symbolActive) {
		this.symbolActive = symbolActive;
	}
	public void setUpdateArrayActive(ArrayList<String> updateArrayActive) {
		this.updateArrayActive = updateArrayActive;
	}
	public void setSymbolPassive(String symbolPassive) {
		this.symbolPassive = symbolPassive;
	}
	public void setUpdateArrayPassive(ArrayList<String> updateArrayPassive) {
		this.updateArrayPassive = updateArrayPassive;
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
	public String getSymbolActive() {
		return symbolActive;
	}
	public ArrayList<String> getUpdateArrayActive() {
		return updateArrayActive;
	}
	public String getSymbolPassive() {
		return symbolPassive;
	}
	public ArrayList<String> getUpdateArrayPassive() {
		return updateArrayPassive;
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

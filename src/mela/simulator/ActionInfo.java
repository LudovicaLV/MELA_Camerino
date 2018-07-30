/**
 * 
 */
package mela.simulator;

import java.util.ArrayList;

import mela.model.LocationManager;
import mela.model.Update;

/**
 * @author ludovicaluisavissat
 *
 */
public class ActionInfo {
	
	private String name;
//	private String type;
//	private ArrayList<Integer> LocationActive;
//	private ArrayList<Integer> LocationPassive;
//	
//		
	
	public ActionInfo(String name){
	this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
//	public ActionInfo(String name, String type, ArrayList<Integer> LocationActive, ArrayList<Integer> LocationPassive){
//		this.name = name;
//		this.type = type;
//		this.LocationActive = LocationActive;
//		this.LocationPassive = LocationPassive;
//	}
//	
//	
//	public String printOut(LocationManager lm) {
//		String toReturn = name + " " + type; 
//		for (int i=0; i < LocationActive.size(); i++){
//			toReturn += lm.getLocationName(LocationActive.get(i));
//		}
//		for (int i=0; i < LocationPassive.size(); i++){
//			toReturn += lm.getLocationName(LocationPassive.get(i));
//		}
//		return toReturn;
//	}

	

}

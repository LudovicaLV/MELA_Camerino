/**
 * 
 */
package mela.model;

import java.util.ArrayList;

/**
 * @author ludovicaluisavissat
 *
 */
public class LocationNameCreation {
	
	public static ArrayList<Integer> createListName (int name){
		 ArrayList<Integer> ListName = new ArrayList<Integer>();
		 ListName.add(name);
		 return ListName;
		}
	
	
	public static ArrayList<Integer> createListOneD (int x){
		 ArrayList<Integer> ListOneD = new ArrayList<Integer>();
		 ListOneD.add(x);
		 return ListOneD;
		}
	
		public static ArrayList<Integer> createListTwoD (int x, int y){
		 ArrayList<Integer> ListTwoD = new ArrayList<Integer>();
		 ListTwoD.add(x);
		 ListTwoD.add(y);
		 return ListTwoD;
		}

		public static ArrayList<Integer> createListThreeD (int x, int y, int z){
		 ArrayList<Integer> ListThreeD = new ArrayList<Integer>();
		 ListThreeD.add(x);
		 ListThreeD.add(y);
		 ListThreeD.add(z);
		 return ListThreeD;
		}

		public static ArrayList<ArrayList<Integer>> createAllLocOneD(int x){
		 for (int i = 0; i < x; i++){
			 ArrayList<Integer> newList = createListOneD(i);	 
			 GlobalManager.getLocationManager().AllLoc.add(newList);
		 }
		 return GlobalManager.getLocationManager().AllLoc;
		}

		public static ArrayList<ArrayList<Integer>> createAllLocTwoD(int x, int y){
		 for (int i = 0; i < x; i++){
			   for (int j = 0; j < y; j++){
				   ArrayList<Integer> newList = createListTwoD(i, j);
				   GlobalManager.getLocationManager().AllLoc.add(newList);
			   }
		    }
		 return GlobalManager.getLocationManager().AllLoc;
		}

		public static ArrayList<ArrayList<Integer>> createAllLocThreeD(int x, int y, int z){
		 for (int i = 0; i < x; i++){
			   for (int j = 0; j < y; j++){
				   for (int k = 0; k < z; k++){
				   ArrayList<Integer> newList = createListThreeD(i,j,k);
				   GlobalManager.getLocationManager().AllLoc.add(newList);
			   }
		    }
		 }
		 return GlobalManager.getLocationManager().AllLoc;
		}	

}

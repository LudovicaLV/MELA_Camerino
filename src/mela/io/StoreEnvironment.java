/**
 * 
 */
package mela.io;

import java.util.function.Predicate;

/**
 * @author ludovicaluisavissat
 *
 */
public class StoreEnvironment {
	
	public static String info;
	public static double rate;
	public static Predicate<Integer> environmentSet;
	
	
	public static void setInfo(String info) {
		StoreEnvironment.info = info;
	}
	public static void setRate(double rate) {
		StoreEnvironment.rate = rate;
	}
	public static void setEnvironmentSet(Predicate<Integer> environmentSet) {
		StoreEnvironment.environmentSet = environmentSet;
	}
	
	
	

}

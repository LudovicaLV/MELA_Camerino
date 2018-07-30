/**
 * 
 */
package mela.simulator;

import mela.model.Model;

/**
 * @author ludovicaluisavissat
 *
 */
public interface DataHandler {

	void start(int iterations);
	
	void add(Trajectory t, int currentIteration, Model m);
	
	void commit();

}

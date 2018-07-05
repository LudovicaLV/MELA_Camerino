/**
 * 
 */
package mela.simulator;

/**
 * @author ludovicaluisavissat
 *
 */
public interface DataHandler {

	void start(int iterations);

	void add(Trajectory t);

	void commit();

}

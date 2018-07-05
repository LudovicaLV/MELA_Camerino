/**
 * 
 */
package mela.simulator;

/**
 * @author ludovicaluisavissat
 *
 */
public class Parameters {
	
	static int numberOfRuns;
	static StoppingPredicate stopPredicate;
	static DataHandler dataHandler;
	
	public Parameters(){
		this.numberOfRuns = numberOfRuns;
		this.stopPredicate = stopPredicate;
		this.dataHandler = dataHandler;		
	}

	public int getSimulationRuns() {
		return numberOfRuns;
	}

	public StoppingPredicate getStopPredicate() {
		return stopPredicate;
	}

	public DataHandler getDataHandler() {
		return dataHandler;
	}

}

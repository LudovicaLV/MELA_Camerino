/**
 * 
 */
package mela.simulator;

/**
 * @author ludovicaluisavissat
 *
 */
public class Parameters {
	
	private int numberOfRuns;
	private StoppingPredicate stopPredicate;
	private DataHandler dataHandler;

	public void setSimulationRuns(int numberOfRunsEntry){
		this.numberOfRuns = numberOfRunsEntry;
	}
	
	public void setStoppingPredicate(StoppingPredicate stopPredicateEntry){
		this.stopPredicate = stopPredicateEntry;
	}
	
	public void setDataHandler(DataHandler dataHandlerEntry){
		this.dataHandler = dataHandlerEntry;
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

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
	private DataPopulation dataPopulation;
	private DataAction dataAction;

	public void setSimulationRuns(int numberOfRunsEntry){
		this.numberOfRuns = numberOfRunsEntry;
	}
	
	public void setStoppingPredicate(StoppingPredicate stopPredicateEntry){
		this.stopPredicate = stopPredicateEntry;
	}
	
	public void setDataHandler(DataHandler dataHandlerEntry){
		this.dataHandler = dataHandlerEntry;
	}	
	
	public void setDataPopulation(DataPopulation dataPopEntry){
		this.dataPopulation = dataPopEntry;
	}	

	public void setDataAction(DataAction dataActionEntry){
		this.dataAction = dataActionEntry;
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
	
	public DataPopulation getDataPopulation() {
		return dataPopulation;
	}

	public DataAction getDataAction() {
		return dataAction;
	}

}

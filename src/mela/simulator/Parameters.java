/**
 * 
 */
package mela.simulator;

import java.util.LinkedList;

/**
 * @author ludovicaluisavissat
 *
 */
public class Parameters {
	
	private int numberOfRuns;
	private StoppingPredicate stopPredicate;
	private LinkedList<DataHandler> handler;

	public void setSimulationRuns(int numberOfRunsEntry){
		this.numberOfRuns = numberOfRunsEntry;
	}
	
	public void setStoppingPredicate(StoppingPredicate stopPredicateEntry){
		this.stopPredicate = stopPredicateEntry;
	}
	
	public void setDataHandler(LinkedList<DataHandler> dataHandlerEntry){
		this.handler = dataHandlerEntry;
	}	

	public int getSimulationRuns() {
		return numberOfRuns;
	}

	public StoppingPredicate getStopPredicate() {
		return stopPredicate;
	}

	public LinkedList<DataHandler> getDataHandlerList() {
		return handler;
	}
	

}

/**
 * 
 */
package mela.simulator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import mela.model.Model;
import mela.model.State;
import mela.simulator.Trajectory.TrajectoryStep;

/**
 * @author ludovicaluisavissat
 *
 */
public class DataPopulation implements DataHandler {
	
	private ArrayList<String> listNames;
	static String outputPop = "./Output/Population";

	@Override
	public void start(int iterations) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Trajectory t, int currentIteration, Model m) {
		PrintWriter writer_pop = null;
		try {
			writer_pop = new PrintWriter(outputPop+ "_" + currentIteration + ".txt", "UTF-8");		    
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		for (TrajectoryStep trStep : t.getData()){	
	    double time = trStep.getTime();
		State toWrite = trStep.getState();
		writer_pop.print(time + " ");	
    	for( int i=0 ; i < listNames.size() ; i++ ) {
    		int popToWrite = 0;
    		int agentIndex = m.getAgentManager().agentIndex(listNames.get(i));
        	for( int j=0 ; j < toWrite.getLocations() ; j++ ) {
        		popToWrite = popToWrite + toWrite.getState()[agentIndex][j];
        	} 
        	writer_pop.print(popToWrite + " ");
    	}	
    	writer_pop.println("");
		}
		writer_pop.close();
	}


	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void setNames(ArrayList<String> names){
		this.listNames = names;
	}

	
	
	

}

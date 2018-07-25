/**
 * 
 */
package mela.simulator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import mela.model.State;
import mela.simulator.Trajectory.TrajectoryStep;

/**
 * @author ludovicaluisavissat
 *
 */
public class DataAndMeta implements DataHandler {
	
	static String outputData = "./Output/Data";

	@Override
	public void start(int iterations) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Trajectory t, int currentIteration) {
		PrintWriter writer_data = null;
		try {
			writer_data = new PrintWriter(outputData+ "_" + currentIteration + ".txt", "UTF-8");
	    } catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		for (TrajectoryStep trStep : t.getData()){	
	    double time = trStep.getTime();
		State toWrite = trStep.getState();
		writer_data.print(time);	
        System.out.println(time);
    	for( int i=0 ; i < toWrite.getAgents() ; i++ ) {
        	for( int j=0 ; j < toWrite.getLocations() ; j++ ) {
        		writer_data.print(toWrite.getState()[i][j] + " ");
        	}    		
    	}
    	writer_data.println("");
		}
		writer_data.close();
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

}

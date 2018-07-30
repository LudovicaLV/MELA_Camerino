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
public class DataAction implements DataHandler {
	
	private ArrayList<String> listActions;
	private ArrayList<Integer> ActionsCount;
	static String outputAcCount = "./Output/ActionCount";

	@Override
	public void start(int iterations) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Trajectory t, int currentIteration, Model m) {
		PrintWriter writer_ac = null;
		try {
			writer_ac = new PrintWriter(outputAcCount+ "_" + currentIteration + ".txt", "UTF-8");		    
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		for (int i=0; i < listActions.size(); i++){
			ActionsCount.add(0);
		}
		for (TrajectoryStep trStep : t.getData()){	
	    double time = trStep.getTime();
		String toCheck = trStep.getActionInfo().substring(0, trStep.getActionInfo().indexOf(' '));				
		writer_ac.print(time + " ");	
    	for( int i=0 ; i < listActions.size() ; i++ ) {
    		if (listActions.get(i) == toCheck){
    			int newValue = ActionsCount.get(i) + 1;
    			ActionsCount.set(i, newValue);
        	} 
        	writer_ac.print(ActionsCount.get(i) + " ");
    	}	
    	writer_ac.println("");
		}
		writer_ac.close();
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	
	public void setActions(ArrayList<String> namesAc){
		this.listActions = namesAc;
	}
	
}

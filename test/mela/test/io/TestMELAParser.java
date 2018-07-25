/**
 * 
 */
package mela.test.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Random;

import org.junit.Test;

import mela.io.MELAParameters;
import mela.io.MELAparser;
import mela.io.ParseException;
import mela.io.TokenMgrError;
import mela.model.LocationManager;
import mela.model.Model;
import mela.simulator.Parameters;
import mela.simulator.Simulator;

/**
 * @author ludovicaluisavissat
 *
 */
public class TestMELAParser {
	
	Model m = new Model();
	Parameters p = new Parameters();
	
	//tests for LocationManager
	@Test
	public void testParser() throws ParseException {
		 MELAparser ParserMELA= new MELAparser();
		 String filenameModel = "./Models/SIR.mela";
		 String filenameParam = "./Parameters/Rules.txt";
		 m = ParserMELA.parseFromFile(filenameModel);
		 MELAParameters ParserParameters = new MELAParameters();
		 p = ParserParameters.parseFromFile(filenameParam);
		 
		 System.out.println(p.getSimulationRuns());
		 
//		 Random random = new Random();
//		 Simulator simulatorMELA = new Simulator(random);
//		 simulatorMELA.simulate(m, p);
		 //number of locations
		 int s = m.getLocationManager().size();	
		 assertEquals(s,10);
//		 //connection among locations
		 boolean edge = m.getLocationManager().edge("[0]", "[9]");
		 assertEquals(edge, true);
//		 //get name
//		 String name =  m.getLocationManager().getLocationName(10);
//		 assertEquals(name, "[2, 2]");
//		 //check index
//		 int i = m.getLocationManager().getIndexFromName("[1, 0]");
//		 assertEquals(i, 4);
		 
		 
		 //to check initial condition
		 int num = m.getInitCond().apply(0,1);
		 assertEquals(num, 10);
	
	//test for parameters
//    for (String name : parameters.keySet()){
//    	System.out.println(name + " has this value " + parameters.get(name));
//    }	
	
	      int t = m.getAgentManager().size();
	      assertEquals(t,2);
	      
	      int i = m.getAgentManager().agentIndex("P");
	      assertEquals(i, 0);
	      
//	      int l = m.getAgentManager().agentIndex("Q");
//	      assertEquals(l, 1);
	      
//	      int q = m.getAgentManager().agents.get(0).getRuleList().size();
//	      assertEquals(q,2);

	      //to test rate names
	      //something WRONG with the allActionInfo hashmap

//	      for (String name : allActionInfo.keySet()){
//	     	 System.out.println(name + " " + allActionInfo.get(name).getRateName());
//	      }
	      
	      //to test action type
//	      for (String nameAction : allActionInfo.keySet()) {
//	     	 System.out.println(nameAction + " " + allActionInfo.get(nameAction).getType());    
//	      }
	
    
	}
}

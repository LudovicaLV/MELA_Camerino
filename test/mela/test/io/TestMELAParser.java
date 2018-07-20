/**
 * 
 */
package mela.test.io;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import mela.io.MELAparser;
import mela.io.ParseException;
import mela.io.TokenMgrError;
import mela.model.LocationManager;
import mela.model.Model;

/**
 * @author ludovicaluisavissat
 *
 */
public class TestMELAParser {
	
	Model m = new Model();
	
	//tests for LocationManager
	@Test
	public void testParser() throws ParseException {
		 MELAparser ParserMELA= new MELAparser();
		 String filename = "/Users/ludovicaluisavissat/workspacejSSTL/MELA_Camerino/src/mela/io/SIR.mela";
		 m = ParserMELA.parseFromFile(filename);	
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
		 int num = m.getInitCond().apply(0, 0);
		 assertEquals(num, 5);
		 
		 
	}
	
	//test for parameters
//    for (String name : parameters.keySet()){
//    	System.out.println(name + " has this value " + parameters.get(name));
//    }
	
	
	
    

}

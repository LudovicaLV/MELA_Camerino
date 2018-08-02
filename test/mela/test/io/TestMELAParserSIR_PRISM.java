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
public class TestMELAParserSIR_PRISM {
	
	Model m = new Model();
	Parameters p = new Parameters();
	
	//tests for LocationManager
	@Test
	public void testParser() throws ParseException {
		 MELAparser ParserMELA= new MELAparser();
		 String filenameModel = "./Models/SIR_PRISM.mela";
		 String filenameParam = "./Parameters/RulesSIR.txt";
		 m = ParserMELA.parseFromFile(filenameModel);
		 MELAParameters ParserParameters = new MELAParameters();
		 p = ParserParameters.parseFromFile(filenameParam, m);		
		 Random random = new Random();
		 Simulator simulatorMELA = new Simulator(random);
		 simulatorMELA.simulate(m, p);
    
	}
}

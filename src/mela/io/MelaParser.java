package mela.io;

import java.io.File;

import mela.model.Model;
import mela.simulator.Parameters;

/**
* @author ludovicaluisavissat
*
*/
public class MelaParser {

	private static MelaParser instance;

	public static MelaParser getInstance() {
		if (instance == null) {
			instance = new MelaParser();
		}
		return instance;
	}

	public Model parseModel(File modelFile) {
		// TODO Write method for loading a model from file
		return null;
	}

	public Parameters parseParameters(File parametersFile) {
		// TODO Write method for loading simulation parameters from file
		return null;
	}

}
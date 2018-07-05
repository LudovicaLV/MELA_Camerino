package mela.model;

import java.util.ArrayList;

import mela.simulator.Transition;

@FunctionalInterface
public interface Rule {
	
	public ArrayList<Transition> BuildActionStep(AgentManager am, LocationManager lm, int locationIndex);
		

}




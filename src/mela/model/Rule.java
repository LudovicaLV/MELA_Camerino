package mela.model;

import java.util.Collection;

import mela.simulator.Transition;

@FunctionalInterface
public interface Rule {
	
	public Collection<? extends Transition> apply(int l, State current, LocationManager locationManager);
		
}




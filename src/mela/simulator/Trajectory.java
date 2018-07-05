/**
 * 
 */
package mela.simulator;

import java.util.LinkedList;

import mela.model.State;

/**
 * @author ludovicaluisavissat
 *
 */
public class Trajectory {

	private final LinkedList<TrajectoryStep> data;
	private double currentTime;
	
	
	public Trajectory(double time, State state) {
		this.data = new LinkedList<>();
		this.currentTime = time;
		this.add(null,state);
	}

	public void add(ActionInfo info, double dt, State state) {
		this.currentTime += dt;
		this.add(info,state);
	}

	private void add(ActionInfo info, State state) {
		this.data.add(new TrajectoryStep(info, currentTime, state));
	}

	public double getTime() {
		return currentTime;
	}
	
	public class TrajectoryStep {
		
		private ActionInfo info;
		
		private double time;
	
		private State s;

		public TrajectoryStep(ActionInfo info, double time, State s) {
			super();
			this.info = info;
			this.time = time;
			this.s = s;
		}

		public ActionInfo getInfo() {
			return info;
		}

		public double getTime() {
			return time;
		}

		public State getS() {
			return s;
		}


	}

}

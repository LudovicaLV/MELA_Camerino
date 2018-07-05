package mela.model.Actions;

import java.util.ArrayList;
import java.util.List;

public class EnvAction implements Action  {
	private String name;
	private double rate;
	private String symbol;
	private ArrayList<ArrayList<Integer>> infset;
	private String[] update;
	
	public EnvAction(String name, double rate, String symbol, ArrayList<ArrayList<Integer>> infset, String[] update){
		this.name = name;
		this.rate = rate;
		this.symbol = symbol;
		this.infset = infset;
		this.update = update;
	}

@Override
public int getType() {
	return Action.ACTION_TYPE_Env;
}

public String getName() {
	return name;
}

public Double getRate() {
	return rate;
}

public String getSymbol() {
	return symbol;
}

public ArrayList<ArrayList<Integer>> getInfSet() {
	return infset;
}

@Override
public String[] getUpdate() {
	return update;
}

@Override
public String printStr() {
	String ret = "->{" + infset + "}(" + name + "," + rate + ")." + update;
	return ret;
}


}




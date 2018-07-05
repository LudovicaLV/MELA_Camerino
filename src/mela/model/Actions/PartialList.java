package mela.model.Actions;

import java.util.ArrayList;

public class PartialList {
	
	ArrayList<InfAction> partialInf = new ArrayList<InfAction>();
	ArrayList<PassAction> partialPass = new ArrayList<PassAction>();
	ArrayList<EnvAction> partialEnv = new ArrayList<EnvAction>();
	

public ArrayList<InfAction> getPartialInf(){
	return this.partialInf;
}


public ArrayList<PassAction> getPartialPass(){
	return this.partialPass;
}

public ArrayList<EnvAction> getPartialEnv(){
	return this.partialEnv;
}


public void addInfAction(InfAction ia){
	partialInf.add(ia);
}

public void addPassAction(PassAction pa){
	partialPass.add(pa);
}

public void addEnvAction(EnvAction ea){
	partialEnv.add(ea);
}

}

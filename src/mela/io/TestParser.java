package mela.io;

public class TestParser {	

	public static void main(String[] args) throws Exception {
			
      MELAparser ParserMELA= new MELAparser();
      ParserMELA.parseFromFile("/Users/ludovicaluisavissat/workspacejSSTL/MELA_Camerino/src/mela/io/SIR.mela");
	  System.out.println("Model parsed correctly."); 

	}
}


	

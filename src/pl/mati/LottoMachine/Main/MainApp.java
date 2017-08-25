package pl.mati.LottoMachine.Main;

import pl.mati.LottoMachine.model.LottoMachine;

public class MainApp {

	public static void main(String[] args) {

		//how many 
		int numOfDraws1=50;
		int numOfDraws2=500000;		
		
		
		/*
		 *  We also measure execution time to perform this method (to make 50 and 500k single games). 
		 *  just curious about the efficiency
		 */
		long startTime = System.nanoTime();
		LottoMachine lotto1 = new LottoMachine(numOfDraws1, 6, 49);
		long endTime = System.nanoTime();
		System.out.println(numOfDraws1+" draws took: " + (endTime - startTime)/1000000+" miliseconds.");
		
		System.out.println("\n-------------------------\n");

		startTime = System.nanoTime();
		LottoMachine lotto2 = new LottoMachine(numOfDraws2, 6, 49);
		endTime = System.nanoTime();
		System.out.println(numOfDraws2+" draws took: " + (endTime - startTime)/1000000+" miliseconds.");

	}

}

package edu.neu.csye7374;

/**
 * 
 * @author Yash Zaveri
 * 
 */

public class Driver {
	public static void main(String[] args) {
		System.out.println("============Main Execution Start===================\n\n");

		StockMarket market = StockMarket.getInstance();
		market.demo();

		System.out.println("\n\n============Main Execution End===================");
	}

}

package com.easylearning.algos;

public class CalculateSqareRootTest {
	
    public static double calculateSqrt (int n) {
        
    double rootValue = 1.00;
    double num = n;
     
    for (int i = 0; i < n; i++) {
         
        rootValue = 0.5 * (rootValue + num/rootValue);
    }   
     
    //To make only 3 digit available after decimal point
    int returnValue = (int)(rootValue * 1000);  
    rootValue = returnValue;
    rootValue /=1000;
     
    System.out.println("Root Value Calculated : " + rootValue);
    System.out.println("Root Value By InBuild Method Method : " + Math.sqrt(n));
     
    return rootValue;
     
    }
     

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CalculateSqareRootTest.calculateSqrt(15);
		CalculateSqareRootTest.calculateSqrt(4);

		System.out.println("Square of  is: "+ Math.pow(12, 2));
		System.out.println("Cube of   is: "+ Math.pow(12, 3));
		System.out.println("Square Root of  is: "+ Math.sqrt(12));

	}

}

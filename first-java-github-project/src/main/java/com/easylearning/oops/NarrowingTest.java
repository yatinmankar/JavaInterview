package com.easylearning.oops;

public class NarrowingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i=5;
		Integer k = new Integer(10);
		i=k;
		System.out.println(i);
		Double d1 = new Double(20.56d);
		i=d1.intValue();
		System.out.println(i);
		
		System.out.println(1/0);
	}

}

package com.easylearning.oops;

public class HelloWorld {

	public static void main(String args[]){
		
		int newCapacity=16;
		newCapacity = newCapacity + (newCapacity >> 1);
		System.out.println(newCapacity);
		newCapacity = newCapacity + (newCapacity >> 1);
		System.out.println(newCapacity);
		
		System.out.println(12>>2);
		System.out.println(12>>>2);
		
		System.out.println(20>>2);
		System.out.println(20>>>2);
		
		System.out.println(27>>3);
		System.out.println(27>>>3);
		
		
		System.out.println(12<<2 );
		
		
		System.out.println(20<<2);
		
		
		System.out.println(27<<3);
		
		System.out.println(27<<3);
		

	}
	
}

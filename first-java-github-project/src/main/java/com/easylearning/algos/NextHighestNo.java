package com.easylearning.algos;
import java.util.Arrays;

public class NextHighestNo {

	public static String getOrder(char[] ch){
		
		String order="";
		
		for(int i=0; i<ch.length-1;i++){
			
			if(order.equals("")){
				if( ch[i] < ch[i+1])
					order="asc";
				else
					order="desc";
				
			}else if(order.equals("asc") && ch[i] > ch[i+1] ){
				order="No order";
				break;
			}else if(order.equals("desc") && ch[i] < ch[i+1] ){
				order="No order";
				break;
			}
			
				
			
		}
		
		return order;
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=1543211;
		char digits[] = new String(""+n).toCharArray(); 
		int l = digits.length; 
		findNext(digits, l); 
		
		

	}

//Java program to find next greater 
//number with same set of digits. 
 

	// Utility function to swap two digit 
	static void swap(char ar[], int i, int j) 
	{ 
		char temp = ar[i]; 
		ar[i] = ar[j]; 
		ar[j] = temp; 
	} 

	// Given a number as a char array number[], 
	// this function finds the next greater number. 
	// It modifies the same array to store the result 
	static void findNext(char ar[], int n) 
	{ 
		int i; 
		
		// I) Start from the right most digit 123455
		// and find the first digit that is smaller 
		// than the digit next to it. 
		for (i = n - 1; i > 0; i--) 
		{ 
			System.out.println("if ("+ar[i]+" > "+ar[i - 1]+")");
			if (ar[i] > ar[i - 1]) { 
				break; 
			} 
		} 
		
		// If no such digit is found, then all 
		// digits are in descending order means 
		// there cannot be a greater number with 
		// same set of digits 
		if (i == 0) 
		{ 
			System.out.println("Not possible"); 
		} 
		else
		{ 
			int x = ar[i - 1], min = i; 
			System.out.println("x "+x+" i "+i);
			
			// II) Find the smallest digit on right 
			// side of (i-1)'th digit that is greater 
			// than number[i-1] 
			for (int j = i + 1; j < n; j++) 
			{ 
				System.out.println(ar[j] +" > " +x +"&& "+ar[j] +" <" +ar[min]);
				if (ar[j] > x && ar[j] < ar[min]) 
				{ 
					min = j; 
				} 
			} 

			// III) Swap the above found smallest 
			// digit with number[i-1] 
			swap(ar, i - 1, min); 

			for (int k = 0; k < n; k++) 
				System.out.print(ar[k]); 
			
			System.out.println("------------------- "+i +"  "+n);
			// IV) Sort the digits after (i-1) 
			// in ascending order 
			
			Arrays.sort(ar, i, n); 
			System.out.print("Next number with same" + 
									" set of digits is "); 
			for (i = 0; i < n; i++) 
				System.out.print(ar[i]); 
		} 
	} 

} 


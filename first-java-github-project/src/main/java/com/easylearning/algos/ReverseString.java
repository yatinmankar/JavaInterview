package com.easylearning.algos;

public class ReverseString {

	
	public static String reverseString1(String s){
		
		int n=s.lastIndexOf(" ");
		System.out.println(n);
		StringBuffer sb=new StringBuffer();
		while(n >=0){
			sb.append(s.substring(n+1,s.length()));
			sb.append(" ");
			s=s.substring(0,n);
			n=s.lastIndexOf(" ");
			System.out.println(n);
	
		}		
		sb.append(s);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		String s= "  I love my india ";
	
		System.out.println(":"+reverseString1(s)+":");
		/*String s1[]=s.split(" ");
		
		for(int i=s1.length-1 ; i >=0 ; i--){
			System.out.print(s1[i] +" ");
		}*/
		
	}

}

package com.easylearning.algos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
//https://javarevisited.blogspot.com/2015/06/top-20-array-interview-questions-and-answers.html

public class FindPairInArray {
	
	//14. How find the first repeating element in an array of integers?
    public static void getFirstRepeatingElement(int arr[]){
    
    	Set<Integer> s1=new HashSet<Integer>();
    	for(int num: arr){
    		//System.out.println(" element "+num);
    		if(!s1.add(num)){
    			System.out.println("First repeting element "+num);
    			return;
    		}
    		
    		
    	}
    	return;
    	
    }

	//15. How find the first repeating element in an array of integers?
    public static void getFirstNonRepeatingElement(int arr[]){
    
    	Set<Integer> repetingElement=new HashSet<Integer>();
    	List<Integer>  list=new ArrayList<Integer>();
    	
    	for(int num: arr){
    		
    		//System.out.println(" element "+num);
    		if(!repetingElement.add(num)){
    			//System.out.println("before remove +"+num+" "+list);
    			list.remove((Object)num);
    			//System.out.println("After remove +"+num+" "+list);
    		}else{
    			list.add(num);
    		}
    		
    		
    	}
    	System.out.println("First not repeating element "+ list.get(0));
    	
    }

    

  //15. get sum of all subset
    public static TreeSet<Integer>  getSubSetSum(int arr[]){
        
    	TreeSet<Integer> sumSet=new TreeSet<Integer>();
    	List list=new ArrayList();
    	int sum=0;
    	for(int i=0; i<arr.length ; i++){
    		list.add(arr[i]);
    		sumSet.add(arr[i]);
    		sum=arr[i];
    		for(int j=0; j<arr.length ; j++){
    			if(!(i==j)){
    				sumSet.add(arr[i]+arr[j]);
    				sum=sum+arr[j];
    			}
    			sumSet.add(sum);
    			
    			list.add(arr[i]+arr[j]);
    			list.add(sum);
    		
    		}
    		
    	System.out.println("listy "+list);
    		
    	}
    	
    	
    	
    	return sumSet;
    	
    }
    
  //17. get least positive number from all sum of all subset
    
    public static void  getLeastPositiveNumSubSetSum(int arr[]){
    	
    	TreeSet<Integer> sumSet= getSubSetSum(arr);
    	System.out.println("sumset "+sumSet);
		int counter=1;
    	for(int sum:sumSet){
    		if(sum-1 > 0 ){
    			if(sum-1<=counter && !sumSet.contains(sum-1)){
    			System.out.println("Least positive number "+(sum-1));
    				return ;
    			}else if(sum-1>counter){
    				System.out.println("Least positive number "+(counter));
    				return ;
    			}
    		}
    		counter++;
    		
    	}
    
    }


	public static void main(String args[]){ 

		int arr[]={3,1,6,10};
		
		getFirstRepeatingElement(arr);
		
		int arr1[]={1, 1,3, 6, 10,1,10, 11,10, 15,6,11,0};
		
		getFirstNonRepeatingElement(arr1);
		
		getLeastPositiveNumSubSetSum(arr);
		
		//Set<Integer> sumSet= getSubSetSum(arr);
		
		//System.out.println(sumSet);
		
}
}

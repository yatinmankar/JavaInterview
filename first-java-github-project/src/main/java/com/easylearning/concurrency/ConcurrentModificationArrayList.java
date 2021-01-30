package com.easylearning.concurrency;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationArrayList {

	 /**
	  * @param args
	  */
	 public static void main(String[] args) {
	  final List<String> dataList=initializeList();
	  System.out.println("List "+dataList);
	  DelRunImpl delImpl=new DelRunImpl(dataList, "Grapes");
	  TraverseRunImpl traverseImpl=new TraverseRunImpl(dataList);

	  Thread traverseThread=new Thread(traverseImpl);
	  Thread delThread=new Thread(delImpl);
	  
	  traverseThread.start();
	  delThread.start();
	  
	  Runtime r = Runtime.getRuntime();
	 r.addShutdownHook(new Thread(){
		 public void run(){
			 System.out.println("List "+dataList);
		 }
		 
	 });
	 }
	 
	 /**
	  * Utility method returning list containing fruit names
	  * @return
	  */
	 private static List<String> initializeList(){
//	  List<String> dataList=new CopyOnWriteArrayList<String>();
	  List<String> dataList=new ArrayList<String>();
	  dataList.add("Apple");
	  dataList.add("Banana");
	  dataList.add("Water Melon");
	  dataList.add("Musk Melon");
	  dataList.add("Grapes");
	  dataList.add("Strawberry");
	  dataList.add("Mango");
	  
	  return dataList;
	 }

	}


 class DelRunImpl extends Thread{

	 private List<String> dataList;
	 private String delData; 
	 
	 /**
	  * Parameterized constructor containing datalist and date to be deleted.
	  * 
	  * @param dataList
	  * @param dataToDel
	  */
	 public DelRunImpl(List<String> dataList,String dataToDel) {
	  this.dataList=dataList;
	  this.delData=dataToDel;
	 }

	 /**
	  * Overridden run implementation where we iterate through the 
	  * list and check the contents 
	  * If it matches with the data to be deleted 
	  * Then current thread sleeps for 1000 milli seconds
	  * before deleting the value
	  */
	 @Override
	 public void run() {
	  Iterator<String> iterator = dataList.iterator();
	  
	  while(iterator.hasNext()){
	   String nextVal = iterator.next();
	   
	   if(nextVal.equals(delData)){
	    try {
	     Thread.currentThread().sleep(1000);
	    } catch (InterruptedException e) {
	     e.printStackTrace();
	    }
	    iterator.remove();
	    //dataList.remove(delData);
	   }
	   
	  }
	    
	 }

	}
 
 
 class TraverseRunImpl implements Runnable {

	 private List<String> dataList;
	 
	 /**
	  * Parameterized constructor 
	  */
	 public TraverseRunImpl(List<String> dataList) {
	  this.dataList=dataList;  
	 }

	 /**
	  * Overriden run method in which we iterate to next element 
	  * In between thread sleeps for 1000 milli seconds
	  */
	 public void run() {
	  Iterator<String> iterator = dataList.iterator();
	  
	  while(iterator.hasNext()){
	   System.out.println("Element is-"+ iterator.next());
	   try {
	    Thread.currentThread().sleep(1000);
	   } catch (InterruptedException e) {
	    e.printStackTrace();
	   }
	  }

	 }

	}
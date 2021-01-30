package com.easylearning.concurrency;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

class SyncObject1{
	public  static final Semaphore oddSema=new Semaphore(1);
	public  static final Semaphore evenSema=new Semaphore(0);
	//public static final Object obj=new Object();
}

class OddThread1 extends Thread{
	
	private int start;
	private String name;
	
	OddThread1(int id,String name){
		setName("Thread "+name);
		this.start=id;
		this.name=name;
		
	}
	
	public void run()   {
		int n=1;
		
			
	while(start<=10){
		//System.out.println(+n+" "+Thread.currentThread().getName());
		
		try {
			SyncObject1.oddSema.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " "+start);
		start=start+2;
		n++;
		SyncObject1.evenSema.release();
	}
		
	}
}

class EvenThread1 extends Thread{
	
	private int start;
	private String name;
	
	EvenThread1(int id,String name){
		setName("Thread "+name);
		this.start=id;
		this.name=name;
		
	}
	
	public void run()   {
		int n=1;
		
			
	while(start<=10){
		
		//System.out.println(+n+" "+Thread.currentThread().getName());
		try{
			SyncObject1.evenSema.acquire();
				
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " "+start);
		start=start+2;
		n++;
		SyncObject1.oddSema.release();
	}
			}
}


public class OddEvenSemaphore {
	
	public static void main(String args[]) throws InterruptedException{
		
		EvenThread1 t1= new EvenThread1(2,"even");
		OddThread1  t2= new OddThread1(1,"odd");
		
		t1.start();
		//TimeUnit.SECONDS.sleep(60);
		t2.start();
		
		
		
	}

}

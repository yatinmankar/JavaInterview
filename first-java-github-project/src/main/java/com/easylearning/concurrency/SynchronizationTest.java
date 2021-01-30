package com.easylearning.concurrency;
import java.util.concurrent.TimeUnit;

class Myclass1{
	
	public static  void method1(){
		synchronized(Myclass1.class){
		System.out.println(Thread.currentThread().getName() + " :" +"static synchronized 1 in"+ new java.util.Date());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " :" +"static synchronized 1 out"+ new java.util.Date());
		}
	}
	
public   void method2(){
	synchronized(this){
	System.out.println(Thread.currentThread().getName() + " :" +"object synchronized 2 in"+ new java.util.Date());
	try {
		TimeUnit.SECONDS.sleep(20);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(Thread.currentThread().getName() + " :" +"object synchronized 2 out"+ new java.util.Date());
	}
	}


public void method3(){
	
	System.out.println(Thread.currentThread().getName() + " :" +"method 3 in"+ new java.util.Date());
	try {
		TimeUnit.SECONDS.sleep(3);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(Thread.currentThread().getName() + " :" +"method 3 out"+ new java.util.Date());
	
}
}

class MyThread1 extends Thread{

	private final Myclass1 myclass1;
	private int id;
	MyThread1(Myclass1 myclass1,int id){
		this.myclass1=myclass1;
		this.id=id;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(id==1){
		Myclass1.method1();
				myclass1.method2();
				//myclass1.method3();		 
		}else{
			Myclass1.method1();
			myclass1.method2();
			
			//myclass1.method3();	
		}
	}
	
}

public class SynchronizationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Myclass1 c1= new Myclass1();
		Myclass1 c2= new Myclass1();
 
	
		MyThread1 t1=new MyThread1(c1,1);
		MyThread1 t2=new MyThread1(c1,2);
		t1.setName("Thread1");
		t2.setName("Thread2");
		t1.start();
		t2.start();
		
	}

}

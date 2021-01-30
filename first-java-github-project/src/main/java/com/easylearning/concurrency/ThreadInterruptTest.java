package com.easylearning.concurrency;
import java.util.concurrent.TimeUnit;

class Myclass extends Thread{
	private int id;
	
	Myclass(int id){
		this.id=id;
	}
	
	public void run(){
		
		try {
		if(id==1)
			Thread.sleep(10000);
		
		if(id==2)
			Thread.sleep(5000);
		
		
		
		for(int i=0;i<5;i++){
			
			System.out.println(id+"  id  "+"  i  "+i);
				
			
			
			
		}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}

public class ThreadInterruptTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Myclass t1=new Myclass(1);
		Myclass t2=new Myclass(2);
		
		
		t1.start();
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t1.interrupt();
		

	}

}

package com.easylearning.concurrency;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyThreads  implements Runnable{

	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread is running");
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread is finished");
		
	}

}

public class CyclicBarrierTest {
	
	public static void main(String args[]){
		MyThreads m1=new MyThreads();
		
		
/*		Executor e1= Executors.newFixedThreadPool(3);*/
	
		ExecutorService e1=new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
		
		for(int i=0;i<50;i++)
		e1.execute(m1);
		
		e1.shutdown();
		
	}

}

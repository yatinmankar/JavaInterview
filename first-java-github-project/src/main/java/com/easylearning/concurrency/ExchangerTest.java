package com.easylearning.concurrency;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Exchanger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

class SyncObject2{
	
	public static final Object obj=new Object();
	
	public  static final Semaphore prodSema=new Semaphore(1);
	public  static final Semaphore consumeSema=new Semaphore(0);
	public static volatile boolean flag=true;
}

class Producer implements Runnable{
	 
    Exchanger<Queue> exchanger;
    Queue queue ;
    Producer(Exchanger<Queue> exchanger, Queue queue ){
          this.queue=queue;
           this.exchanger=exchanger;
    }
    
    public void produce(Queue queue) throws InterruptedException{
    	
    	//SyncObject2.prodSema.acquire();
    	
    	//SyncObject2.consumeSema.release();
    	exchanger.exchange(queue);
    	
    //	SyncObject2.consumeSema.release();
   
    	
    	
    }
    
    
    public void run(){
    
           for(int i=1;i<=50;i++){
        	   
        	   queue.add(i);
        	   if(i%5==0){
        		   
        		   try {
        			 //  System.out.println("Produced "+i);
					produce(queue);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	   }
        	  // System.out.println("Produced "+i);
        	   
        	   
           }
           
           SyncObject2.flag=false;
           //SyncObject2.consumeSema.release();
                 // System.out.println("Produced : "+i);
           
           System.out.println("Producer thread finished");
                 
           }
    }
    



 
/**
 * Consumer Class.
 */
class Consumer extends Thread{
    Producer prod;
    Exchanger<Queue> exchanger;
    Queue queue;
    Consumer(Exchanger<Queue> exchanger,Queue queue){
    	this.queue=queue;
        this.exchanger=exchanger;
    }
    
    public void run(){
    	
    	while(SyncObject2.flag){
    	
    	try {
    	
    		System.out.println("In consumer thread "+queue.size());
    		
    	//	SyncObject2.consumeSema.acquire();
    		if(SyncObject2.flag){
    			Queue prevQueue=this.queue;
    			for(int i=0 ; i<queue.size();i++)
    				System.out.println("Consumed "+queue.poll());
    		
    		
    		exchanger.exchange(prevQueue);
    		
    		}
    	//	SyncObject2.prodSema.release();
    		
    
    
    	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	}
    	 System.out.println("consumer thread finished");
    }   
}



public class ExchangerTest {
	
	//SynchronousQueue queue = new SynchronousQueue();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Queue queue = new LinkedBlockingQueue();
        final Exchanger<Queue> exchanger=new Exchanger<Queue>();
        System.out.println("Exchanger has been created");
        Producer prod=new Producer(exchanger,queue);
        Consumer cons=new Consumer(exchanger,queue);
       // Consumer cons1=new Consumer(exchanger,queue);
        
        Thread prodThread=new Thread(prod,"prodThread");
        Thread consThread=new Thread(cons,"consThread");
      //  Thread consThread1=new Thread(cons,"consThread");

        prodThread.start();     //start producer thread.
        consThread.start();     //start consumer thread.
       // consThread1.start();     //start consumer thread.
		

	}

}

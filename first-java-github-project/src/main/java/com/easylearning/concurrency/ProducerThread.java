package com.easylearning.concurrency;
import java.util.List;

class SharedResource{
	volatile boolean stopFlag=true;
}

public class ProducerThread extends Thread {

	private final List list;
	private final SharedResource resource ;
	ProducerThread(SharedResource resource, List list){
		this.resource=resource;
		this.list=list;
	}
	
	public void run(){
		
			
			synchronized(resource){
				
				for(int i=1; i <100; i++){
					list.add(i);
					System.out.println("Produced "+i);
					try {
						if(i%1==0){
						resource.notifyAll();
						 resource.wait();
						 Thread.sleep(10);
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
				System.out.println("Producer finished producing");
				System.out.println("Producer Sending singal to stop consumer");
				resource.stopFlag=false;
				resource.notifyAll();
			}
		}
		
	
}


class ConsumerThread extends Thread {

	private final List list;
	private final SharedResource resource ;
	ConsumerThread(SharedResource resource, List list){
		this.resource=resource;
		this.list=list;
	}
	
	public void run(){
			synchronized(resource){
				while(resource.stopFlag){
					try {
						if(list.size()==0){
						//	System.out.println("waiting for list item " + Thread.currentThread().getName());
							resource.wait();
							resource.notifyAll();
						}
							if(list.size() >0)
								System.out.println("consme item  "+list.remove(0));

							resource.notifyAll();
						
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				resource.notifyAll();
				
				}
			}
	}



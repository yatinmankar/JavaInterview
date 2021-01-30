package com.easylearning.concurrency;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PoisonPillTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		final SharedResource resource=new SharedResource();
		final List list=new LinkedList<Integer>();
		
		ProducerThread p1=new ProducerThread(resource,list);
		ConsumerThread c1=new ConsumerThread(resource,list);
		c1.setName("Consumer 1");
		ConsumerThread c2=new ConsumerThread(resource,list);
		c2.setName("Consumer 2");
		ConsumerThread c3=new ConsumerThread(resource,list);
		c3.setName("Consumer 3");
		ConsumerThread c4=new ConsumerThread(resource,list);
		c4.setName("Consumer 4");
		
		c1.start();
		c2.start();
		c3.start();
		c4.start();
		TimeUnit.MILLISECONDS.sleep(1);
		p1.start();
	}

}

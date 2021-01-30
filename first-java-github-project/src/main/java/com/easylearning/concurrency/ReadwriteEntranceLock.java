package com.easylearning.concurrency;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReadwriteEntranceLock {
	
	public static ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
	public static ReadLock read=lock.readLock();
	public static WriteLock write=lock.writeLock();
	

	public static void accessReadResource() throws InterruptedException{
		read.lock();
		System.out.println("accessReadResource called");
		TimeUnit.SECONDS.sleep(5);
		
		read.unlock();
		System.out.println("accessReadResource leaving");
	}

	public static void accessWriteResource()  throws InterruptedException{
		write.lock();
		System.out.println("accessWriteResource called");
		TimeUnit.SECONDS.sleep(3);
		write.unlock();
		System.out.println("accessWriteResource leaving");
	}

	
	
	public static void main(String args[]) throws InterruptedException{
		
		final  ReadwriteEntranceLock obj = new ReadwriteEntranceLock();
		
		Thread t1=new Thread(new Runnable(){
			public void run(){
				try {
					obj.accessReadResource();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t2=new Thread(new Runnable(){
			public void run(){
				try {
					obj.accessReadResource();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t3=new Thread(new Runnable(){
			public void run(){
				try {
					obj.accessWriteResource();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		Thread t4=new Thread(new Runnable(){
			public void run(){
				try {
					obj.accessWriteResource();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		Thread t5=new Thread(new Runnable(){
			public void run(){
				try {
					obj.accessReadResource();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		TimeUnit.SECONDS.sleep(1);
		t5.start();
	}
	
}

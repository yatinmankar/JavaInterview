package com.easylearning.concurrency;
class SyncObject{
	public  static  int threadToRun=1;
	public static final Object obj=new Object();
}
class Thread1 extends Thread{
	
	private int threadId;
	private String name;
	Thread1(int id,String name){
		setName("Thread "+id);
		this.threadId=id;
		this.name=name;
		
	}
	
	public void run()   {
		int n=1;
		synchronized (SyncObject.obj) {
			
	while(n<10){
		while(threadId!=SyncObject.threadToRun){
			try {
				//System.out.println(Thread.currentThread().getName() + "is waiting");
				SyncObject.obj.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		n++;
/*		if(SyncObject.threadToRun==1 && SyncObject.threadToRun==threadId){
*/			if(threadId==1){
			System.out.print("My name is "+name);
			SyncObject.threadToRun=2;
			SyncObject.obj.notifyAll();
		}else if (SyncObject.threadToRun==2 && SyncObject.threadToRun==threadId){
			System.out.print( " "+name);
			SyncObject.threadToRun=3;
			SyncObject.obj.notifyAll();
		}else if (SyncObject.threadToRun==3 && SyncObject.threadToRun==threadId){
			System.out.print(name+"\n");
			SyncObject.threadToRun=1;
			SyncObject.obj.notifyAll();
		}
		
	
		 }
	}
		
	}
	
}


public class ThreadSyncTest {
	
	public static void main(String args[]) throws InterruptedException{
		Thread1 t1=new Thread1(1,"Yatin");
		Thread1 t2=new Thread1(2,"Sadanand ");
		Thread1 t3=new Thread1(3,"mankar");
		
		t3.start();
		
		Thread.sleep(1000);
		t1.start();

		t2.start();

		
	}

}

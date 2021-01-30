package com.easylearning.oops;
import java.util.concurrent.TimeUnit;

class Engine 
{
	// starting an engine.
	public void work()
	{
		
		System.out.println("Engine of car has been started ");
		
	}
	
	public void finalize(){
		System.out.println("Engine object destoyed ");
	}
	
}

final class Car 
{
	
	// For a car to move, 
	// it need to have a engine.
	private Engine engine; 
	
	
	
	Car(Engine engine)
	{
		this.engine = engine; //Aggregation
	}
	
	Car()
	{
		this.engine = new Engine(); //Composition
	}
	
	
	// car start moving by starting engine
	public void move() 
	{
		
		if(engine != null)
		{
			engine.work();
			System.out.println("Car is moving ");
		}
	}
	
	public void finalize(){
		System.out.println("car object destoyed ");
	}
}



public class CompositionTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Runtime r= Runtime.getRuntime();
	
		Engine engine = new Engine();
		
		/*Car aggr = new Car(engine); 
		aggr.move();
		aggr=null;
		*/
		
		Car comp = new Car();
		comp.move();
		comp=null;
		
		
		
		
		System.gc();
		TimeUnit.SECONDS.sleep(5);
		

	}

}

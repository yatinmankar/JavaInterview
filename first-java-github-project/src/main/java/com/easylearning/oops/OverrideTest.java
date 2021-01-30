package com.easylearning.oops;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;


class Test{
	public static void print(){
		System.out.println("Hello print........");
	}
	
	public  void print1(){
		System.out.println("Hello print1 ");
	}
}


class Execute1{

}


class MyExceotion extends RuntimeException{
	
}


class MyExceotion1 extends Exception{
	/*MyExceotion1(){
		
	}*/
	MyExceotion1(String s){
		super(s);
	}
}

/*class MyExceotion2 extends MyExceotion1{
	
}*/


class Grand{
	/*Grand(){
		System.out.println(" Grand constructor");
		
	}*/
	
//	static{
//		System.out.println(" Grand static");
//	}
//	{
//		System.out.println(" Grand instance");
//	}
}

class Parent extends Grand{
	
	String name;
	
	/*Parent(){
		System.out.println(" Parent constructor");
		
		// gnd=new Grand();
	}*/
	
//	static{
//		System.out.println(" Parent static");
//	}
//	
//	{
//		System.out.println(" Parent instance");
//	}
//	Grand gnd=new Grand();
	
	void method1() throws  MyExceotion1 {
		System.out.println("Parent method1");
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void statMethod1(){
		System.out.println(" parent stat");
	}
	
	public static void privMethod1(){
		System.out.println(" parent private");
	}
}

class child extends Parent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int salary;
	
//	static{
//		System.out.println(" child static");
//	}
	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}

//	{
//		System.out.println(" child instance");
//	}
	child(int n){
		System.out.println(" child constructor");
		
	}
	
	
void method1() throws MyExceotion1{
	System.out.println("child method1");
	}

public String getDescription(Object obj){ 
	System.out.println("OBJECT specific");

	return obj.toString();
	} 
public String getDescription(String obj){ 
	System.out.println("String specific");
			return obj; 


		

}

public String getDescription(StringBuilder obj){ 
	System.out.println("String specific");
			return obj.toString(); 

}

public static void statMethod1(){
	System.out.println(" child stat");
}

public static void privMethod1(){
	System.out.println(" child private");
}

}
public class OverrideTest {
	
	public static void execute(Test obj){
		System.out.println("obj "+obj);
		obj.print();
	//	obj.print1();
	}
	
	public static void main(String args[]) {
		
		
		/*execute(null); */
		
		
		Parent p = new child(5);
		p.statMethod1();
		p.privMethod1();
		
	
		
		/*child c1 = (child)new Parent();
		c1.name="asds12323";
		c1.salary=10;
		*/
	
		//p.method1();
/*		
		System.out.println(p instanceof Parent);
		System.out.println(p instanceof child);
		
		child c = new child();
		System.out.println(c instanceof Parent);
		System.out.println(c instanceof child);*/
		
		
		/*Parent p1 = new Parent();
		System.out.println(p1 instanceof Parent);
		System.out.println(p1 instanceof child);*/
		
		try{
			
			/*p.method1();
			Object obj=null;
			String s=null;
			c.getDescription(s);
			
			Parent p2 = new Parent();
			Parent p3=p1;
			System.out.println(p1.equals(p2));
			System.out.println(p2.equals(p1));
			boolean b1=false;
			if(b1=true )
				System.out.println("......... "+b1);
			
			System.out.println(".3333.... "+b1);
			
			long l=12378261784361232L;
			float f=l;
			double d=f;
			
			System.out.println (b);
			System.out.println (i);
			System.out.println (l);
			System.out.println (f);
			System.out.println (d);
			
			int i=1;
			i=i++ + i++ + i++ - --i + i + i;*/
			
			
			
			
		}catch(Exception me1){
			
		
		}
		
		
	}

}

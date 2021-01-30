package com.easylearning.collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

final class Employee implements Comparable{
	private int id;
	private String name;
	private String lname;
	
	Employee(int id,String name,String lname){
		this.id=id;
		this.name=name;
		this.lname=lname;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLName() {
		return name;
	}
	
/*	public int hashCode(){
		int hash=id;
		hash=hash+name.hashCode();
		hash=hash+lname.hashCode();
		hash=hash^43;
		return hash;
	//	return 1;
	}*/
	
	/*public boolean equals(Object obj){
		
		boolean check=false;
		
		if(obj ==null)
			return false;
		
		if(!(obj instanceof Employee)){
			return false;
		}
		
		Employee e=(Employee)obj;
		
		if(e.getId()==this.getId() && e.getName()==this.getName() && e.getLName()==this.getLName())
			return true;
		
		return check;
	}*/

	
	
	public int compareTo(Object o) {
		if(o ==null)
			 throw new NullPointerException();
		
		if(!(o instanceof Employee)){
			throw new ClassCastException();
		}
		
		Employee obj=(Employee)o;
		
      if(this.getId()!=obj.getId())
   	     return this.getId()- obj.getId();
		
   			 int nameDiff = name.compareTo(obj.name);
      if(nameDiff != 0){
          return nameDiff;
      }
      
       nameDiff = lname.compareTo(obj.lname);
      
      if(nameDiff != 0){
          return nameDiff;
      }
      
      return 0;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + " " + lname +"]";
	}
	
	
}


public class TreeMapSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub y vcg v````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````
		Employee e1= new Employee(1,"Yatin","Mankar");
		Employee e2= new Employee(1,"Yatin","Mankar");
		Employee e3= new Employee(3,"qwe","qwe");
		Employee e4= new Employee(4,"asd","asd");
		Employee e5= new Employee(5,"zxc","zxc");
		Employee e6=null;
		
		/*System.out.println(e1.hashCode());
		System.out.println(e2.hashCode());*/
		
	   Set<Employee> s1=new HashSet<Employee>();
	   s1.add(e1);
	   s1.add(e2);
	   s1.add(e3);
	
	   System.out.println(s1.size());
	   

	   
	  /* Set<Employee> s2=new TreeSet<Employee>();
	   s2.add(e1);
	   s2.add(e2);
	 //  s2.add(e3);
	   s2.add(e1);
	   s2.add(e2);
	//   s2.add(e3);
	   
	   System.out.println(s2.size());
	   System.out.println(s2);
	   
	   
//	   Map<Employee,String> map=new LinkedHashMap<Employee,String>();
	   Map<Employee,String> map=new TreeMap<Employee,String>();
	  // map.put(e6, "ooooo");
	   map.put(e4, null);
	   map.put(e1, null);
	   map.put(e2, null);
	   map.put(e3, null);
	   
	   map.put(e5, null);
	
	  
	   System.out.println(map.size());
	   System.out.println(map);*/
	   
	   
	}


}

package com.easylearning.oops;
import java.util.ArrayList;
import java.util.LinkedList;

class Course implements Cloneable{
	String cname1;
	String cname2;
	
	Course(String name1,String name2){
		this.cname1=name1;
		this.cname2=name2;
	}
	
	public String getCname1() {
		return cname1;
	}
	public void setCname1(String cname1) {
		this.cname1 = cname1;
	}
	public String getCname2() {
		return cname2;
	}
	public void setCname2(String cname2) {
		this.cname2 = cname2;
	}

	@Override
	public String toString() {
		return "Course [cname1=" + cname1 + ", cname2=" + cname2 + "]";
	}
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
}
class Student implements Cloneable{
	String rno;
	Course course;
	ArrayList list;
	public Student(String rno, Course course, ArrayList list) {
		super();
		this.rno = rno;
		this.course = course;
		this.list = list;
	}
	public String getRno() {
		return rno;
	}
	public void setRno(String rno) {
		this.rno = rno;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public ArrayList getList() {
		return (ArrayList)list.clone();
	}
	public void setList(ArrayList list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Student [rno=" + rno + ", course=" + course + ", list=" + list +  "]";
	}
	
/*Shallow copy*/	
protected Object clone() throws CloneNotSupportedException{
	Student s = (Student)super.clone();
	return s;
}

/*Deep copy*/	
/*	protected Object clone() throws CloneNotSupportedException{
		Student s = (Student)super.clone();
		s.course=(Course)course.clone();
		s.list=(ArrayList)list.clone();
		return s;
	}*/
	
}


public class ShalloDeepCopyTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		
		Course c1=new Course("HSc","science");
		LinkedList list=new LinkedList();
		list.add(1);
		Student s1=new Student("1",c1,list);
		Student s2=(Student)s1.clone();
		System.out.println(s1);
		System.out.println(s2);
		list.add(2);
		c1.setCname2("Ärts");
		System.out.println(s1);
		System.out.println(s2);
		
		
	}

}

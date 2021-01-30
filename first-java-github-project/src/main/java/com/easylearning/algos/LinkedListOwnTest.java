package com.easylearning.algos;

import java.util.concurrent.TimeUnit;

public class LinkedListOwnTest {
	public static CustomLinkedList list1;
	public static CustomLinkedList list2;
	
	public static void main(String[] args) {
 
		// Default constructor - let's put "0" into head element.
		list1 = new CustomLinkedList<Integer>();
 
		// add more elements to LinkedList
		list1.addAtStart(50);
		list1.addAtStart(10);
		list1.add(70);
		list1.add(70);
		list1.add(70);
		list1.add(90);
		list1.add(100);

		
		
 
		list2 = new CustomLinkedList<Integer>();
		 
		// add more elements to LinkedList
		list2.addAtStart(30);
		list2.addAtStart(20);
		list2.add(40);
		list2.add(60);
		list2.add(70);
		list2.add(70);
		list2.add(70);
		list2.add(80);
		list2.add(110);

		
		System.out.println("---------------------------------------------");
		
		list1.printList(list1);
		list2.printList(list2);
		
		System.out.println("Sorted List---------------------------------------------");
		
		CustomLinkedList sortedList=list1.getSortedList(list2, list1);
		sortedList.printList(sortedList);
		System.out.println("---------------------------------------------");
		/*
		 * Please note that primitive values can not be added into LinkedList directly. They must be converted to their
		 * corresponding wrapper class.
		 */
 
		System.out.println("Print: list1: \t\t" + list1);
		System.out.println(".size(): \t\t\t\t" + list1.size());
		System.out.println(".get(3): \t\t\t\t" + list1.get(3) + " (get element at index:3 - list starts from 0)");
		System.out.println(".remove(2): \t\t\t\t" + list1.remove(2) + " (element removed)");
		System.out.println(".get(3): \t\t\t\t" + list1.get(3) + " (get element at index:3 - list starts from 0)");
		System.out.println(".size(): \t\t\t\t" + list1.size());
		System.out.println("Print again: list1: \t" + list1);
	}
 
}
 
class CustomLinkedList<T> {
 
	private static int counter;
	private Node<T> head;
 
	public Node<T> getHead(){
		return head;
	}
	
	public void setHead(Node<T> n){
		 head=n;
	}
	
	// Default constructor
	public CustomLinkedList() {
 
	}
 
	public  CustomLinkedList getSortedList (CustomLinkedList list1, CustomLinkedList list2){
		
		
		if(list1==null){
	
			return list2;
		}
		if(list2==null){
			
			return list1;
		}
		
		
		CustomLinkedList sortedList=new CustomLinkedList();
		Node sortheadNode=null;
		Node s=null;
		
		
		Node<Integer> p = list1.getHead();
		Node<Integer> q = list2.getHead();
		
		if(p==null){
			sortheadNode=q;
			sortedList.setHead(sortheadNode);
			return sortedList;
		}
		if(q==null){
			sortheadNode=p;
			sortedList.setHead(sortheadNode);
			return sortedList;
		}
		
		
		if(p.getData()<=q.getData()){
	       
			sortedList.setHead(p);
			sortheadNode=p;
			p=p.getNext();
		}else{
			sortedList.setHead(q);
			sortheadNode=q;
			q=q.getNext();
			
		}
		/*System.out.println(p);
		System.out.println(q);
		System.out.println(sortheadNode);*/
	
		
		while(p!=null && q!=null){
			
			//System.out.println(p.getData()  +"<" + q.getData());
			
			if(p.getData()<=q.getData()){

				sortheadNode.setNext(p);

				sortheadNode=sortheadNode.getNext();
				//System.out.println("IN p queuq "+p.getData()+ " s "+sortheadNode);
				p=p.getNext();
				
			}else{
				
				sortheadNode.setNext(q);

				sortheadNode=sortheadNode.getNext();
				//System.out.println("IN q queuq "+q.getData()+ " s "+sortheadNode);
				q=q.getNext();
				
			}
		/*	try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			//printList(sortedList);
		}

	/*	System.out.println(" S loop  "+sortheadNode);
		System.out.println(" p loop  "+p);
		System.out.println(" q loop  "+q);*/

		while(p!=null){
			sortheadNode.setNext(p);
			sortheadNode=sortheadNode.getNext();
			p=p.getNext();
		}
		
		while(q!=null){
			sortheadNode.setNext(q);
			sortheadNode=sortheadNode.getNext();
			q=q.getNext();
		}
		
		
		//sortedList.setHead(sortheadNode);
		return sortedList;
		
	}
	
	
	// appends the specified element to the end of this list.
	public void add(Object data) {
 
		// Initialize Node only incase of 1st element
		if (head == null) {
			head = new Node(data);
		}
 
		Node crunchifyTemp = new Node(data);
		Node crunchifyCurrent = head;
 
		// Let's check for NPE before iterate over crunchifyCurrent
		if (crunchifyCurrent != null) {
 
			// starting at the head node, crawl to the end of the list and then add element after last node
			while (crunchifyCurrent.getNext() != null) {
				crunchifyCurrent = crunchifyCurrent.getNext();
			}
 
			// the last node's "next" reference set to our new node
			crunchifyCurrent.setNext(crunchifyTemp);
		}
 
		// increment the number of elements variable
		incrementCounter();
		
	}
 
	private static int getCounter() {
		return counter;
	}
 
	private static void incrementCounter() {
		counter++;
	}
 
	private void decrementCounter() {
		counter--;
	}
 
	// inserts the specified element at the specified position in this list
	public void add(Object data, int index) {
		Node crunchifyTemp = new Node(data);
		Node crunchifyCurrent = head;
 
		// Let's check for NPE before iterate over crunchifyCurrent
		if (crunchifyCurrent != null) {
			// crawl to the requested index or the last element in the list, whichever comes first
			for (int i = 0; i < index && crunchifyCurrent.getNext() != null; i++) {
				crunchifyCurrent = crunchifyCurrent.getNext();
			}
		}
 
		// set the new node's next-node reference to this node's next-node reference
		crunchifyTemp.setNext(crunchifyCurrent.getNext());
 
		// now set this node's next-node reference to the new node
		crunchifyCurrent.setNext(crunchifyTemp);
 
		// increment the number of elements variable
		incrementCounter();
	}
 
	public Object get(int index)
	// returns the element at the specified position in this list.
	{
		// index must be 1 or higher
		if (index < 0)
			return null;
		Node crunchifyCurrent = null;
		if (head != null) {
			crunchifyCurrent = head.getNext();
			for (int i = 0; i < index; i++) {
				if (crunchifyCurrent.getNext() == null)
					return null;
 
				crunchifyCurrent = crunchifyCurrent.getNext();
			}
			return crunchifyCurrent.getData();
		}
		return crunchifyCurrent;
 
	}
 
	// removes the element at the specified position in this list.
	public boolean remove(int index) {
 
		// if the index is out of range, exit
		if (index < 1 || index > size())
			return false;
 
		Node crunchifyCurrent = head;
		if (head != null) {
			for (int i = 0; i < index; i++) {
				if (crunchifyCurrent.getNext() == null)
					return false;
 
				crunchifyCurrent = crunchifyCurrent.getNext();
			}
			
			crunchifyCurrent.setNext(crunchifyCurrent.getNext().getNext());
 
			// decrement the number of elements variable
			decrementCounter();
			return true;
 
		}
		return false;
	}
 
	// returns the number of elements in this list.
	public int size() {
		return getCounter();
	}
 
	public String toString() {
		String output = "";
 
		if (head != null) {
			output += "[" + head.getData().toString() + "]";
			Node crunchifyCurrent = head.getNext();
			
			while (crunchifyCurrent != null) {
				output += "[" + crunchifyCurrent.getData().toString() + "]";
				crunchifyCurrent = crunchifyCurrent.getNext();
			}
 
		}
		return output;
	}
	
	
	public void printList(CustomLinkedList printList) {
		String output = "";
 
		Node head1=printList.getHead();
		
		if (head1 != null) {
			//System.out.println("head is not null "+head1);
			output += "[" + head1.getData().toString() + "]";
			//System.out.println(head1.getNext());
			Node crunchifyCurrent = head1.getNext();
			
			while (crunchifyCurrent != null) {
				output += "[" + crunchifyCurrent.getData().toString() + "]";
				crunchifyCurrent = crunchifyCurrent.getNext();
			}
 
		}
		
		System.out.println(output);
//		return output;
	}
	
	
	public void addAtStart(Object data){
		Node startNode=head;
		if(startNode==null){
			head=new Node(data);
		}else{
			Node newNode=new Node(data);
			newNode.setNext(startNode);
			head=newNode;
			
		}
		incrementCounter();
		//System.out.println(head);
	}
	
	public boolean deleteFromStart(){
		
	return false;
	}

	
	
	private class Node<T> {
		// reference to the next node in the chain, or null if there isn't one.
		Node next;
 
		// data carried by this node. could be of any type you need.
		T data;
 
		// Node constructor
		public Node(T dataValue) {
			next = null;
			data = dataValue;
		}
 
		// another Node constructor if we want to specify the node to point to.
		@SuppressWarnings("unused")
		public Node(T dataValue, Node nextValue) {
			next = nextValue;
			data = dataValue;
		}
 
		// these methods should be self-explanatory
		public T getData() {
			return data;
		}
 
		@SuppressWarnings("unused")
		public void setData(T dataValue) {
			data = dataValue;
		}
 
		public Node getNext() {
			return next;
		}
 
		public void setNext(Node nextValue) {
			next = nextValue;
		}

		@Override
		public String toString() {
			return "Node [Data()=" + getData()+ "]";
		}
 
		
	}
}
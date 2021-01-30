package com.easylearning.collections;
// A Java program to swap kth Nodes from the beginning with 
// kth Nodes from the end 

class Nodes 
{ 
	int data; 
	Nodes next; 
	Nodes(int d) { data = d; next = null; } 
} 

public class SwapLinkedListNodes 
{ 
	Nodes head; 

	/* Utility function to insert a Nodes at the beginning */
	void push(int new_data) 
	{ 
		Nodes new_Nodes = new Nodes(new_data); 
		new_Nodes.next = head; 
		head = new_Nodes; 
	} 

	/* Utility function for displaying linked list */
	void printList() 
	{ 
		Nodes Nodes = head; 
		while (Nodes != null) 
		{ 
			System.out.print(Nodes.data + " "); 
			Nodes = Nodes.next; 
		} 
		System.out.println(""); 
	} 

	/* Utility function for calculating length of linked list */
	int countNodess() 
	{ 
		int count = 0; 
		Nodes s = head; 
		while (s != null) 
		{ 
			count++; 
			s = s.next; 
		} 
		return count; 
	} 

	/* Function for swapping kth Nodess from both ends of 
	linked list */
	void swapKth(int k) 
	{ 
		// Count Nodess in linked list 
		int n = countNodess(); 

		// Check if k is valid 
		if (n < k) 
			return; 

		// If x (kth Nodes from start) and y(kth Nodes from end) 
		// are same 
		if (2*k - 1 == n) 
			return; 

		// Find the kth Nodes from beginning of linked list. 
		// We also find previous of kth Nodes because we need 
		// to update next pointer of the previous. 
		Nodes x = head; 
		Nodes x_prev = null; 
		for (int i = 1; i < k; i++) 
		{ 
			x_prev = x; 
			x = x.next; 
		} 

		// Similarly, find the kth Nodes from end and its 
		// previous. kth Nodes from end is (n-k+1)th Nodes 
		// from beginning 
		Nodes y = head; 
		Nodes y_prev = null; 
		for (int i = 1; i < n - k + 1; i++) 
		{ 
			y_prev = y; 
			y = y.next; 
		} 

		// If x_prev exists, then new next of it will be y. 
		// Consider the case when y->next is x, in this case, 
		// x_prev and y are same. So the statement 
		// "x_prev->next = y" creates a self loop. This self 
		// loop will be broken when we change y->next. 
		if (x_prev != null) 
			x_prev.next = y; 

		// Same thing applies to y_prev 
		if (y_prev != null) 
			y_prev.next = x; 

		// Swap next pointers of x and y. These statements 
		// also break self loop if x->next is y or y->next 
		// is x 
		Nodes temp = x.next; 
		x.next = y.next; 
		y.next = temp; 

		// Change head pointers when k is 1 or n 
		if (k == 1) 
			head = y; 

		if (k == n) 
			head = x; 
	} 

	// Driver code to test above 
	public static void main(String[] args) 
	{ 
		SwapLinkedListNodes llist = new SwapLinkedListNodes(); 
		for (int i = 8; i >= 1; i--) 
			llist.push(i); 

		System.out.print("Original linked list: "); 
		llist.printList(); 
		System.out.println(""); 

		for (int i = 1; i < 9; i++) 
		{ 
			llist.swapKth(i); 
			System.out.println("Modified List for k = " + i); 
			llist.printList(); 
			System.out.println(""); 
		} 
	} 
} 





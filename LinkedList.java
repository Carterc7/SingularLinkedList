package app;

// Carter Campbell
// This is my own work

public class LinkedList 
{
Node head;


static class Node
{
	int data; // variable for data held by node
	Node next; // variable for node
	
	
	Node(int data) // default-constructor to create a new node
	{
		this.data = data;
	}
	
	
}

public static void main(String[] args)
{
	LinkedList list = new LinkedList(); // create an instance of the LinkedList class
	LinkedList listRev = new LinkedList();
	LinkedList list2 = new LinkedList();
	
	
	list.insert(11); //
	list.insert(4);  //
	list.insert(10); ///// inserting integers by value into list1 
	list.insert(5);  //
	list.insert(20); //
	// list.removeFront(list);
	// list.removeBack(list);
	
	System.out.println("Sorted List:");
	list.printList(); 
	list.front(list); 
	list.back(list); 
	list.determineIfEmpty();
	list.numberOfElements(list);
	
	listRev.reverseOrder(11); //
	listRev.reverseOrder(4);  //
	listRev.reverseOrder(10); ///// reversing the order of the list1 values
	listRev.reverseOrder(5);  //
	listRev.reverseOrder(20); //
	
	System.out.println("");
	System.out.println("Reversed List: ");
	listRev.printList();
	
	System.out.println("");
	list.mergeList(list, list2); // merge list1 and list2
	list.printList();
	
	
	
}
// insert method for linked list
public void insert(int val)
{
	if(head == null) // insert front O(1) 
	{
		head = new Node(val);
		return;
	}
	else
	{
		Node newNode = new Node(val); // creating a new node
		Node temp = head; // temp value that is iterated through the list
		Node previous = temp; // previous value to keep track of value before temp
		// iterate through the list
		while(temp != null)
		{
			if(newNode.data < temp.data) // insert before head value O(n)
			{
				newNode.next = temp; // swap pointers
				head = newNode;
				return;
			}
			else
			{													// O(n)
				while(temp != null && temp.data < newNode.data) // insert after head value
				{
					previous = temp; 
					temp = temp.next; // iterate through the list while maintaining 
										// while loop conditions
				}
				previous.next = newNode; // swap pointers to insert the newNode
				newNode.next = temp;	// at correct position 
				return;
			}
			
		}
		
	}
}

// method to print the linked list O(n)
public void printList()
{
	Node temp = head;
	while(temp != null) // iterate through the list
	{
		System.out.println(temp.data + " "); // print the value of temp
		temp = temp.next; // continue through the loop
	}
}

// prints the head of the linked list O(1)
public void front(LinkedList list)
{
	if(head == null)
	{
		System.out.println("The list is empty");
	}
	else
	{
		System.out.println("Head of list: " + head.data);
	}
}

// prints the last element of the linked list
public void back(LinkedList list)
{
	// O(1)
	if(head == null)
	{
		System.out.println("The list is empty");
	}
	else
	{
		Node temp = head;
		Node previous = temp;
		while(temp.next != null) // iterate to the last node of the list O(n)
		{
			temp = temp.next; // continue the loop
			previous = temp;
		}
		System.out.println("Back of List: " + temp.data); // print last node
	}
}

// removes the front value of the list O(1)
public void removeFront(LinkedList list)
{
	if(head != null) // if list is not empty
	{
		Node temp = head;
		temp = temp.next; // set temp to second value
		head = temp; // set head to second value
		// head is now second value so the first value is removed.
	}
}

// removes the last value of the list O(n)
public void removeBack(LinkedList list)
{
	Node temp = head;
	Node previous = temp;
	while(temp.next.next != null) // iterate to the second to last value
	{
		temp = temp.next;
	}
	temp.next = null; // set last value to null
}

// prints out the number of elements in the LinkedList O(n)
public void numberOfElements(LinkedList list)
{
	int counter = 0; // set counter 
	Node currentNode = list.head;
	while(currentNode != null) // iterate through the list
	{
		counter++; // increment the counter for every iteration
		currentNode = currentNode.next; // continue the loop
	}
	System.out.println("Number of elements: " + counter); // print the counter
	
}

// Reverse of insert method
public void reverseOrder(int val)
{
	if(head == null)
	{
		head = new Node(val);
		return;
	}
	else
	{
		Node newNode = new Node(val);
		Node temp = head;
		Node previous = temp;
		while(temp != null)
		{
			if(newNode.data > temp.data) 
			{
				newNode.next = temp;
				head = newNode;
				return;
			}
			else 
			{
				while(temp != null && temp.data > newNode.data)
				{
					previous = temp;
					temp = temp.next;
				}
				previous.next = newNode;
				newNode.next = temp;
				return;
			}
			
		}
	}
		
}

// merges the values of list1 and list2 by value O(n)
public void mergeList(LinkedList list2, LinkedList list)
{
	System.out.println("Merged List: ");
	list2.insert(7); 
	list2.insert(19);
	list2.insert(3);
	
	Node temp = head;
	while(temp.next != null) // iterate through list2
	{
		list.insert(temp.data); // insert list2 values into list 1
		temp = temp.next; // continue the loop
	}
	
}

// determines if list is empty or populated O(1)
public void determineIfEmpty()
{
	if(head == null)
	{
		System.out.println("List is empty");
	}
	else
	{
		System.out.println("List is not empty");
	}
}


}
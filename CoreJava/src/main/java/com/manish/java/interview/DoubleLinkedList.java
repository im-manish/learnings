package com.manish.java.interview;

/**
 * @author Manish
 *
 */
// There are some employee manager relationship and based on input string , we have to print complete hierarchy.

//Ajay-> Ramesh
//Deepesh-> Animesh
//Mohan->Ajay
//Rahul-> Mohan

//Input: Rahul
//Output: Rahul->Mohan->Ajay->Ramesh
//A complete working Java program to demonstrate all

//Class for Doubly Linked List
public class DoubleLinkedList {
	Node head; // head of list

	// Doubly Linked list Node
	class Node {
		int data;
		Node prev;
		Node next;

		// Constructor to create a new node
		// next and prev is by default initialized as null
		Node(int d) { data = d; }
	}
	
	public void append(int data) {
		Node newNode = new Node(data);
		Node last = head;
		newNode.next= null;
		if(head == null) {
			newNode.prev= null;
			newNode.next = null;
			head = newNode;
			return ;
		}
		while(last.next !=null) {
			last = last.next;
		}
		last.next = newNode;
		newNode.prev = last;
		
	}
	
	public void insertAfter(Node prev, int data) {
		if(null == prev) {
			System.out.println("The given previous node can not be null");
			return;
		}
		Node newNode = new Node(data);
		newNode.prev = prev;
		newNode.next = prev.next;
		prev.next = newNode;
		if(newNode.next != null) {
			newNode.next.prev = newNode;
		}
	}
	
	public void push(int data) {
		
		Node newNode = new Node(data);
		newNode.prev = null;
		Node first = head;
		if(null == first) {
			newNode.next = null;
			head = newNode;
			return;
		}
		newNode.next = first;
		first.prev = newNode;
	}
	
	public void printNode() {
		Node first = head;
		System.out.println("Traversing the node in forward direction");
		while(first != null) {
			System.out.println(first.data +"\t");
			first = first.next;
		}
		
		
	}

}


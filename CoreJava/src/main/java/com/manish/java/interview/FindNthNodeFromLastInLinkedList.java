package com.manish.java.interview;

import com.manish.java.interview.ReverseLinkedList.LinkedList;
import com.manish.java.interview.ReverseLinkedList.Node;

public class FindNthNodeFromLastInLinkedList {
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(new Node(10));
		linkedList.head.next = new Node(5);
		linkedList.head.next.next= new Node(4);
		linkedList.head.next.next.next= new Node(43);
		linkedList.head.next.next.next.next= new Node(44);
		linkedList.head.next.next.next.next.next= new Node(45);
		findNthNodeFromLast(linkedList.head,4);
	}

	private static void findNthNodeFromLast(Node head, int i) {
		if(null == head) {
			System.out.println("Empty List");
			return;
		}
		Node main = head,ref = head;
		int count =1;
		while(count <= i) {
			ref = ref.next;
			count++;
		}
		while(ref != null) {
			ref = ref.next;
			main = main.next;
		}
		System.out.println(main.data);
		
	}
	

}

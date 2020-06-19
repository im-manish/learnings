package com.manish.java.interview;

import com.manish.java.interview.ReverseLinkedList.LinkedList;
import com.manish.java.interview.ReverseLinkedList.Node;

/**
 * @author Manish
 *
 */
public class IdentifyAndBreakLoopInLinkedList {
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(new Node(10));
		linkedList.head.next = new Node(5);
		linkedList.head.next.next= new Node(4);
		linkedList.head.next.next.next= new Node(43);
		linkedList.head.next.next.next.next= new Node(44);
		linkedList.head.next.next.next.next.next= new Node(45);
		linkedList.head.next.next.next.next.next.next= linkedList.head.next.next;
		//printLinkedList(linkedList.head);
		Node whereBothMeet = detectLoopInLinkedList(linkedList.head);
		breakTheCycleAndPrint(whereBothMeet,linkedList.head);
		printLinkedList(linkedList.head);
	}

	private static void breakTheCycleAndPrint(Node whereBothMeet, Node head) {
		if(null == whereBothMeet || null == head) {
			System.out.println("Empty list");
			return;
		}
		Node previous = null;
		while(!head.equals(whereBothMeet)) {
			previous = whereBothMeet;
			whereBothMeet = whereBothMeet.next;
			head = head.next;
		}
		if(null == previous) {
			System.out.println("Some Error");
			return;
		}
		previous.next = null;
		return ;
		
	}

	private static Node detectLoopInLinkedList(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				System.out.println("Loop Detected at "+slow.data);
				return slow;
			}
		}
		System.out.println("No Cycle");
		return null;
	}

	private static void printLinkedList(Node head) {
		if(null == head) {
			System.out.println("Empty Linked List");
			return ;
		}
		do {
			System.out.println(head.data);
			head = head.next;
		} while(head != null);
		
		
	}

}

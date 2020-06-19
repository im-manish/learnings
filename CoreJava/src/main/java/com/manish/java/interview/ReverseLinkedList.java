package com.manish.java.interview;

/**
 * @author Manish
 *
 */
public class ReverseLinkedList {
	
	public static class Node{
		Node next;
		int data;
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + data;
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (data != other.data)
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			return true;
		}
		
	}
	public static class LinkedList{
		Node head;
		public LinkedList(Node head) {
			this.head = head;
		}
	}
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList(new Node(5));
		linkedList.head.next = new Node(30);
		linkedList.head.next.next = new Node(4);
		linkedList.head.next.next.next = new Node(6);
		printTheLinkedList(linkedList.head);
		//printReverseLinkedListWithoutChanging(linkedList.head);
		
		/*Node reverseHead = reverseALinkedList(linkedList.head);
		printTheLinkedList(reverseHead);*/
		Node reverseHead1 = usingRecursion(linkedList.head);
		printTheLinkedList(reverseHead1);
	}
	
	

	private static Node usingRecursion(Node node) {
		if(node.next == null) {
			return node;
		}
		Node head = usingRecursion(node.next);
		node.next.next = node;
		node.next = null;
		return head;
	}



	private static Node reverseALinkedList(Node head) {
		Node curr = head;
		Node next = null;
		Node previous= null;
		while(curr != null) {
			next = curr.next;
			curr.next = previous;
			previous = curr;
			curr = next;
		}
		return previous;
	}
	
	
	private static void printReverseLinkedListWithoutChanging(Node head) {
		if(head == null) {
			return ;
		}
		printReverseLinkedListWithoutChanging(head.next);
		System.out.println(head.data);
	}

	public static void printTheLinkedList(Node node) {
		while(node != null) {
			System.out.println(node.data);
			node=node.next;
		}
	}

}


package com.manish.java.data_structure;

/**
 * @author Manish
 *
 */
public class Tree {
	
	Node root;
	
	public Tree(Node root) {
		this.root=root;
	}
	
	static class Node {
		int data;
		Node left,right;
		public Node(int data) {
			this.data = data;
			left = right = null;
		}
		
	}
	
	public static Tree constructTree() {
		Tree tree = new Tree(new Node(5));
		tree.root.left = new Node(10);
		tree.root.right = new Node(5);
		tree.root.left.left= new Node(12);
		return tree;
	}
	public static void main(String[] args) {
		Tree tree = constructTree();
		System.out.println("Inorder Traversal\n");
		inorderTraversal(tree.root);
		System.out.println("\npreorder Traversal\n");
		preOrderTraversal(tree.root);
		System.out.println("\npostorder Traversal\n");
		postOrderTraversal(tree.root);
	}
	private static void postOrderTraversal(Node root) {
		if(null == root) {
			return ;
		}
		inorderTraversal(root.left);
		inorderTraversal(root.right);
		System.out.println(root.data);
		
	}
	private static void preOrderTraversal(Node root) {
		if(null == root) {
			return ;
		}
		System.out.println(root.data);
		inorderTraversal(root.left);
		inorderTraversal(root.right);
		
	}
	private static void inorderTraversal(Node root) {
		if(null == root) {
			return ;
		}
		inorderTraversal(root.left);
		System.out.println(root.data);
		inorderTraversal(root.right);
	}
	

		
	}
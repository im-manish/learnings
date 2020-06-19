package com.manish.java.data_structure;

/**
 * @author Manish
 *
 */
public class SymetricTree extends Tree {

	public SymetricTree(Node root) {
		super(root);
	}
	public static void main(String[] args) {
		Tree tree = constructSymetricTree();
		boolean isTreeSymetric = isTreeSymetric(tree.root);
		System.out.println("Tree is symetric "+isTreeSymetric);
	}
	private static boolean isTreeSymetric(Node root) {
		return isMirror(root,root);
	}
	private static boolean isMirror(Node node1, Node node2) {
		   // if both trees are empty, then they are mirror image 
        if (node1 == null && node2 == null) 
            return true; 
   
        // For two trees to be mirror images, the following three 
        // conditions must be true 
        // 1 - Their root node's key must be same 
        // 2 - left subtree of left tree and right subtree 
        //      of right tree have to be mirror images 
        // 3 - right subtree of left tree and left subtree 
        //      of right tree have to be mirror images 
        if (node1 != null && node2 != null && node1.data == node2.data) {
        	return (isMirror(node1.left, node2.right)  && isMirror(node1.right, node2.left)); 
        }
        // if neither of the above conditions is true then 
        // root1 and root2 are mirror images 
        return false; 
	}
	private static Tree constructSymetricTree() {
		Tree tree = new Tree(new Node(5));
		tree.root.left = new Node(10);
		tree.root.left.left= new Node(12);
		tree.root.left.right= new Node(14);
		tree.root.right = new Node(10);
		tree.root.right.left = new Node(14);
		tree.root.right.right = new Node(12);
		return tree;
		
	}

}

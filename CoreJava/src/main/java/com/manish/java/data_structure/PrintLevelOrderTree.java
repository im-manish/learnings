package com.manish.java.data_structure;

/**
 * @author Manish
 *
 */
public class PrintLevelOrderTree extends Tree {

	public PrintLevelOrderTree(Node root) {
		super(root);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Tree constructTree = constructTree();
		printLevelOrder(constructTree.root);
		
	}

	private static void printLevelOrder(Node root) {
		int height = getHeightOfTree(root);
		//for(int i=0;i<)
		
	} 

	private static int getHeightOfTree(Node root) {
		if(null == root) {
			return 0;
		}
		int lHeight = getHeightOfTree(root.left);
		int rHeight = getHeightOfTree(root.right);
		if(lHeight > rHeight) {
			return lHeight +1;
		} else {
			return rHeight+1;
		}
	}

}

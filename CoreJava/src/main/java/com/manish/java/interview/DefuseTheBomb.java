package com.manish.java.interview;

/**
 * @author Manish
 *
 */
public class DefuseTheBomb {
	
	public static void main(String[] args) {
		
		int[] message = {2,3,6,1,4};
		int[] defugeMessage = getDefuseMessage(message,5);
		System.out.println(defugeMessage);
		
	}

	private static int[] getDefuseMessage(int[] message, int k) {
		int[] defuseMessage = new int[message.length];
		if(k==0) {
			return message; 
		}
		for(int i=0;i<defuseMessage.length;i++) {
			int count = 0;
			if(k > 0) {
				
				
			}
		}
	
		return defuseMessage;
	}

}

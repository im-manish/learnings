package com.canvera.java.innerclasses;

public class InnerClassQuiz {
	public static void main(String[] args) {
		Outer.main();
	}
}

 class Outer{
    private int x;
    private int y;
    Outer(){
        x = 4;
        y = 3;
        
    }
    Outer(int z){
    	
       new Outer();
    	//this();
        x += z;
        y -= z;
    }
    class Inner{
        Inner(){
            x ++ ;
            y += 2;
        }
        Inner(int i){
            this();
            x -= i;
            y += i;
            System.out.print(x ++ + " " + -- y + " ");
        }
    }
    public static void main(){
        Inner inner = new Outer(3).new Inner(2);
    	
    }
}
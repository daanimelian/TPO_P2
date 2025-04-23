package main;

import Clases.ArrayStack;

public class MainCuartoEjercicio {
	
	public static void main(String[] args) {
	
		ArrayStack<Integer> stack = new ArrayStack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		
		
	ArrayStack<Integer> invertido = ArrayStack.invertirStack(stack);
	

	
	System.out.println("------Invertido------");
		while(!invertido.isEmpty()) {
			System.out.println(invertido.pop());
		}

	
	
	
	}

}

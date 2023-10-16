package udemy.data.structure.algorithms.stack;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.push(6);
		stack.push(7);
		stack.push(10);
		
		stack.printStack();
		System.out.println("Hight: " + stack.getHeight());
		System.out.println("------------------");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println("------------------");
		stack.printStack();
		System.out.println("Hight: " + stack.getHeight());
		
		String s1 = "()()())";
        String s2 = "()(()";
        String s3 = "(()())";
        System.out.println(isBalancedParentheses(s1)); // true
        System.out.println(isBalancedParentheses(s2)); // false
        System.out.println(isBalancedParentheses(s3)); // true
        
        StackLetCode<Integer> intStack = new StackLetCode<>();
        intStack.push(3);
        intStack.push(2);
        intStack.push(5);
        intStack.push(1);
        intStack.push(4);

        Object x = 5;
        
        System.out.println("Before sorting:");
        intStack.printStack();

        sortStack(intStack);

        System.out.println("\nAfter sorting:");
        intStack.printStack();
		
	}
	
	/**
	 * The reverseString method takes a single parameter String, which is the string you want to reverse.

Return a new String with the letters in reverse order.

This method will be written in the same class as the main method so it will be static.  For more information on static methods click on "Hints."
	 */
	public static String reverseString(String value) {
		StackLetCode<Character> charsStack = new StackLetCode<Character>();
		for(int i=0; i<value.length(); i++) {
			charsStack.push(value.charAt(i));
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		Character popChar = charsStack.pop();
		while (popChar != null) {
			stringBuilder.append(popChar);
			popChar = charsStack.pop();		
		}
		return stringBuilder.toString();
	}
	
	/**
	 * Check to see if a string of parentheses is balanced or not.
	 * By "balanced," we mean that for every open parenthesis, there is a matching closing parenthesis in the correct order. 
	 * For example, the string "((()))" has three pairs of balanced parentheses, so it is a balanced string. 
	 * On the other hand, the string "(()))" has an imbalance, as the last two parentheses do not match, so it is not balanced.  Also, the string ")(" is not balanced because the close parenthesis needs to follow the open parenthesis.
	 * @param value
	 * @return
	 */
	public static boolean isBalancedParentheses(String value) {
		
		StackLetCode<Character> stack = new StackLetCode<Character>();
		
		for(int i=0; i<value.length(); i++) {
			Character parenthes = value.charAt(i);
			
			if(parenthes == '(') {
				stack.push(parenthes);
			}else {
				Character top = stack.pop();
				if(top == null || parenthes.equals(top))
					return false;
			}
		}
		
		if(!stack.isEmpty())
			return false;
		
		return true;
		
	}
	
	/**
	 * The sortStack method takes a single argument, a Stack object.  
	 * The method should sort the elements in the stack in ascending order (the lowest value will be at the top of the stack) using only one additional stack.  
	 * The function should use the pop, push, peek, and isEmpty methods of the Stack object.
	 * @param s
	 */
    // Method to sort stack
	private static void sortStack(StackLetCode<Integer> stack) {
		if(stack != null && !stack.isEmpty()) {
			Integer top = stack.pop();
			sortStack(stack);
			sortedInsert(stack, top);
		}
	}
	
	private static void sortedInsert(StackLetCode<Integer> stack, Integer x) {
		if(stack.isEmpty() || x > stack.peek()) {
			stack.push(x);
			return;
		}
		
		Integer temp = stack.pop();
		sortedInsert(stack, x);
		stack.push(temp);		
	}
	

	
	    
 

	
}

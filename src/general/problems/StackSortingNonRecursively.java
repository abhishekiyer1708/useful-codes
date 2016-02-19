package general.problems;

import java.util.Stack;

public class StackSortingNonRecursively {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(4);
		s.push(3);
		s.push(7);
		s.push(1);
		s.push(2);
		
		
		
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
	
	static void sortStack (Stack<Integer> s) {
		Stack<Integer> temp = new Stack<Integer>();
		while (!s.isEmpty()) {
			int i = s.pop();
			while (!temp.isEmpty() && temp.peek() > i) {
				s.push(temp.pop());
			}
			temp.push(i);
		}
		
		while (!temp.isEmpty()) {
			s.push(temp.pop());
		}
	}

}

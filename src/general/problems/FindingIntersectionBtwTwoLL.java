package general.problems;
import java.util.HashSet;
import java.util.Stack;

//import simplelinkedlist.SimpleLinkedList.Node;


public class FindingIntersectionBtwTwoLL {
	
	/*Here's a solution that only requires iterating each list twice 
	 * (the first time to calculate their length; if the length is given you only need to iterate once).

	The idea is to ignore the starting entries of the longer list 
	(merge point can't be there), so that the two pointers are an equal distance from the end of the list.
	 Then move them forwards until they merge.

	lenA = count(listA) //iterates list A
	lenB = count(listB) //iterates list B

	ptrA = listA
	ptrB = listB

	//now we adjust either ptrA or ptrB so that they are equally far from the end
	while(lenA > lenB):
	    ptrA = ptrA->next
	    lenA--
	while(lenB > lenA):
	    prtB = ptrB->next
	    lenB--

	while(ptrA != NULL):
	    if (ptrA == ptrB):
	        return ptrA //found merge point
	    ptrA = ptrA->next
	    ptrB = ptrB->next*/
	
	/* Another solution is using stacks. Push all elements into statcks and keep popping them until they
	 * are not same.
	 */
	
	
	/**
	 * @param args
	 */
	/*public static void main(String[] args) 
	{
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		n1.next = n2;
		Node n3 = new Node(3);
		n2.next = n3;
		Node n4 = new Node(4);
		n3.next = n4;

		Node m1 = new Node(100);
		Node m2 = new Node(101);
		m1.next = m2;
		Node m3 = new Node(102);
		m2.next = m3;
		m3.next = n2;

		Node intersect = getIntersect(makeStack(n1), makeStack(m1));
		System.out.println("Intersection is at " + intersect.value);
		
	}
	
	public static Stack <Node> makeStack(Node n)
	{
		Stack <Node> s = new Stack();
		while(n != null)
		{
			s.push(n);
			n = n.next;
		}
		return s;
	}
	public static Node getIntersect(Stack <Node> a, Stack <Node> b)
	{
		if(a.peek() != b.peek()) 
			return null;
		else
		{
			Node intersectNode = a.peek();
			while(!a.isEmpty() && !b.isEmpty())
			{
				if(a.peek() != b.peek())
					return intersectNode;
				intersectNode = a.peek();
				a.pop();
				b.pop();
			}
			return intersectNode;
		}
	}
}*/
}

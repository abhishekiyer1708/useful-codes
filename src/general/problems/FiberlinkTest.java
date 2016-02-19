package general.problems;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;



/*iCafe India owns several cyber cafes. A research firm did an analysis of their customer data and found that if a customer arrives to the cafe and there is no computer available for them to use, the customer will turn around and leave thus costing the firm revenue. Your task is to write a program that tells the company how many customers left without using the cafe so that they can increase their computers in a cafe.

Problem Definition:

Write a function "runCustomerSimulation" that takes two inputs - an integer: total number of computers in a cafe and a string: a sequence of uppercase letters. Letters in the sequence occur in pairs.  The first occurrence indicates the arrival of a customer; the second indicates the departure of that same customer. A customer will be serviced if there is an unoccupied customer. No letter will occur more than two times.

Customers who leave without using a computer always depart before customers who are currently using the computers. There are at most 20 computers per cafe.

 

Output:

For each set of input the function should output a number telling how many customers, if any walked away without using a computer. Return 0 if all the customers were able to use a computer.

 

runCustomerSimulation (2, "ABBAJJKZKZ") should return 0

runCustomerSimulation (3, "GACCBDDBAGEE") should return 1

runCustomerSimulation (3, "GACCBGDDBAEE") should return 0

runCustomerSimulation (1, "ABCBCA") should return 2*/


public class FiberlinkTest {

	public static void main(String[] args) {
		System.out.println(runCustomerSimulation(1, "ABCBCA"));

	}
	
	public static int runCustomerSimulation(int numComputers, String customers) {
		HashSet<Character> cafeSimulator = new HashSet<Character>(numComputers);
		char[] sequenceArray = customers.toCharArray();
		int i,customersLost=0;
		List<Character> lostCustomer = new ArrayList<Character>();
		for (i=0;i<sequenceArray.length;i++) {
			if (cafeSimulator.size()!=numComputers && !cafeSimulator.contains(sequenceArray[i])) {
				cafeSimulator.add(sequenceArray[i]);
			} else if (cafeSimulator.contains(sequenceArray[i])) {
				cafeSimulator.remove(sequenceArray[i]);
			} else {
				if (!lostCustomer.contains(sequenceArray[i])) {
					lostCustomer.add(sequenceArray[i]);
					customersLost++;
				}			
			}
		}
		return customersLost;
	}

}

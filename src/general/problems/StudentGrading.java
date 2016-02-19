package general.problems;

import java.util.Scanner;

public class StudentGrading {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		System.out.println("Enter quiz 1 grade: ");
		
		int quiz1Marks = console.nextInt();
		System.out.println("Enter quiz 2 grade: ");
		int quiz2Marks = console.nextInt();
		int quiz3Marks = 3;
		int midterm = 5;
		int participationMarks = 6;
		int labMarks = 9;
		int firstPrj = 8;
		int secondPrj = 4;
		int finalExam = 3;
		
		double finalscore = 0.05*(quiz1Marks+quiz2Marks+quiz3Marks) + 0.2 * midterm + 0.05 * participationMarks + 0.2 * labMarks + 0.05 * firstPrj + 0.1 * secondPrj + 0.25 * finalExam;
		double finalPercentage = finalscore * 100;
		
		if ( finalPercentage >= 90)
	       {System.out.print("A");
	       }
	      else if (finalPercentage >=70)
	       
	       {System.out.print("B");}
	      else if (finalPercentage >=60 )
	       
	       {System.out.print("C");
	       }
	       else
	       {System.out.print("F");
	       
	       }

	}

}

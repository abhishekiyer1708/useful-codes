package general.problems;

public class MaxSubsequenceOfArray {

	public static void main(String[] args) {
		System.out.println(max_sum_in_subarray_of_minimum_length(new int[] {1, -4, 6, -3, 4, 1, -9}, 4));

	}
	
	public static int max_sum_in_subarray_of_minimum_length(int [] array, int min_length){

	    int running_sum=0, max_sum_up_to_here=0, max_sum=0;

	    int begin=0, end=0, max_start=0;

	  /* max_sum_up_here = sum of all elements in array up to length L */

	    for(int i=0;i<min_length;i++){

	        max_sum_up_to_here+=array[i];
	    }

	  /* running sum and max sum = max_sum_up_here */

	    running_sum = max_sum_up_to_here;
	    max_sum= running_sum;

	  /* Iterate through all elements starting from L i.e minimum length */

	    for(int i=min_length;i<array.length;i++) {

	  /* min_sum_up_to_here = min_sum_up_to_here +
	   next element in array - (i-L)th element in array */    

	        max_sum_up_to_here+=array[i]-array[i-min_length];

	  /* if running_sum + next element in array > max_sum_up_to here then 
	         running_sum = running_sum + next element in array 
	     else running_sum = max_sum_up_to_here */

	        if( (running_sum+array[i]) > max_sum_up_to_here ){


	            running_sum = running_sum+array[i];
	            max_start = i-min_length+1;

	         }else{

	            running_sum= max_sum_up_to_here;
	        }

	     /* if running sum > max_sum then max_sum = running sum */

	        if( max_sum < running_sum ){


	            max_sum = running_sum;

	            begin =max_start;

	            end=i;

	        }

	    }

	     /* max_sum gives sum of contiguous sub array of length L and begin and end gives indexes of the sub array*/  

	    return max_sum;
	}

}

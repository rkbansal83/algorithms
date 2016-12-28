package algos;

import java.util.Scanner;

/**
 * A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if left rotations are performed on array , then the array would become .

Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.
 * @author RAVI
 *
 *Sample Input

5--> num of arary elements  4---> num of rotations 

1 2 3 4 5
Sample Output

5 1 2 3 4
*/
public class ArrayLeftRotations {

	public static int[] arrayLeftRotation(int[] a, int n, int k) {
		 int[] newarray = new int[n];
	      for (int n_i = 0 ; n_i<n ; n_i++){
	          int newpos = n_i-k;
	          if(newpos<0) newpos = newpos+n;
	          newarray[newpos] = a[n_i];
	          
	      }
	        return newarray;
    }   
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
	
}

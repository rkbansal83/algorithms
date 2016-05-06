package algos;

import java.util.ArrayList;

/**
 *************************************************************************
 * Description: 
 * 
 * Print concentric rectangular pattern in a 2d matrix. 
 * Let us show you some examples to clarify what we mean. 
 * 
 * Example 1: 
 * Input: A = 4. 
 * Output: 
 *  4 4 4 4 4 4 4 
 *  4 3 3 3 3 3 4 
 *  4 3 2 2 2 3 4 
 *  4 3 2 1 2 3 4 
 *  4 3 2 2 2 3 4 
 *  4 3 3 3 3 3 4 
 *  4 4 4 4 4 4 4 
 *  
 * Example 2: 
 * Input: A = 3. 
 * Output: 
 *  3 3 3 3 3 
 *  3 2 2 2 3 
 *  3 2 1 2 3 
 *  3 2 2 2 3 
 *  3 3 3 3 3 
 *  
 *  The outermost rectangle is formed by A, then the next outermost is 
 *  formed by A-1 and so on. 
 *  
 *  You will be given A as an argument to the function you need to 
 *  implement, and you need to return a 2D array.
 */
public class RectangularPreetyPrint {
	
	 
	 public static ArrayList<ArrayList<Integer>> prettyPrint(int A) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		 int numElems = A*2-1;
		 int r1 =0;
		 int r2= numElems-1;
		 int c1 =0;
		 int c2 = numElems-1;
		 
		 int[][] spiralMatrix = new int[numElems][numElems];

		 
		 while(A>0) {
			 for(int i=c1;i<=c2;i++){
				 spiralMatrix[r1][i] = A;
			 }
			 for(int j=r1+1;j<=r2;j++){
				 spiralMatrix[j][c2] = A;
			 }
			 
			 for(int i=c2-1;i>=c1;i--){
				 spiralMatrix[r2][i] = A;
			 }
			 for(int j=r2-1;j>=r1+1;j--){
				 spiralMatrix[j][c1] =A;
			 }
			 A--;
			 r1++;
			 r2--;
			 c1++;
			 c2--;
		 }
		 
		 for(int i=0;i<spiralMatrix.length;i++){
		        result.add(new ArrayList<Integer>());
		        for(int j=0;j<spiralMatrix[0].length;j++){
		        	result.get(i).add(spiralMatrix[i][j]);
		        }
		 }
		 return result;
	 }
	
	 public static void display(ArrayList<ArrayList<Integer>> matrix) {
		 for(int i=0;i<matrix.size();i++) {
			 ArrayList<Integer> lst =  matrix.get(i);
			  for(Integer elem:lst) {
				  System.out.print(" "+elem);
			  }
			  System.out.println("");
		 }
		 
	 }
	 public static void main(String[] args) {
		 int A = 4;
		 display(prettyPrint(A));
		 
	 }
	 
	 

}

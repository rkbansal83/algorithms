package algos;
/**
 * A robot is located at the top-left corner of an A x B grid (
 * @author RAVI
 *The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked ‘Finish’ in the diagram below).

	How many possible unique paths are there?

Note: A and B will be such that the resulting answer fits in a 32 bit signed integer. 
 */
public class GridUniquePaths {
	public int uniquePaths(int a, int b) {
	    int num = a+b-2;
	    a--;
	    b--;
	    int val = 1;
	    int res = 1;
	    if(a==0 || b==0)
	        return res;
	    int max = Math.max(a,b);
	    while(num>max) {
	        
	        res = (res* num)/val;
	        num--;
	        val++;
	        
	    }
	    return res;
	}
}

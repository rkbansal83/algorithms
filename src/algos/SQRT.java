package algos;

/**
 * Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

Example :

Input : 11
Output : 3
 * @author RAVI
 *
 */
public class SQRT {
	public int sqrt(int a) {
	    if(a==1 || a==0)
	        return a;
	    int low =1;
	    int high =a;
	    int res =0;
	    while(low <=high) {
	        int  mid =   low + (high-low)/2;
	         if(mid == a/mid)
	            return mid;              
	        if(mid >= a/mid)
	            high=mid-1;
	        else{
	            res = mid;
	            low = mid+1;
	        }         
	        
	    }
	    return res;
	}
}

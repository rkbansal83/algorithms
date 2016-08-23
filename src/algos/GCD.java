package algos;


/**
 * 
 * @author RAVI
 * Given 2 non negative integers m and n, find gcd(m, n)

	GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
	Both m and n fit in a 32 bit signed integer.

	Example

	m : 6
	n : 9

	GCD(m, n) : 3 
 */
public class GCD {

public int gcd(int a, int b) {
	    
	    if(a<b){
	        int temp = a;
	        a = b;
	        b=temp;
	    }
	    if(b==0)
	        return a;
	    
	    if(a%b==0)
	        return b;
	        
	    else
	        return gcd(b,a%b);
	    
	}
}

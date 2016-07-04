package algos;

import java.util.ArrayList;

/**
 * Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124
Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
A : For the purpose of this question, YES
Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 * @author RAVI
 *
 */
public class AddOneToNumber {

	public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
	    int size = a.size();
	    int carry = 1;
	    
	    for(int i=a.size()-1;i>=0;i--) {
	        int num = a.get(i);
	        num = num + carry;
	        carry =0;
	        if(num==10){
	            num=0;
	            carry =1;
	            
	        }
	        a.set(i,num);
	    }
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    
	    if(carry==1)
	        res.add(carry);
	    for(int x:a){
	        if(x==0 && res.size()==0)
	            continue;
	        res.add(x);
	    }
	    return res;
	}
}




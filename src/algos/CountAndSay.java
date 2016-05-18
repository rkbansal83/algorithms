package algos;
/**
 * 
 		The count-and-say sequence is the sequence of integers beginning as follows:
		
		1, 11, 21, 1211, 111221, ...
		1 is read off as one 1 or 11.
		11 is read off as two 1s or 21.
		
		21 is read off as one 2, then one 1 or 1211.
		
		Given an integer n, generate the nth sequence.
		
		Note: The sequence of integers will be represented as a string.
		
		Example:
		
		if n = 2,
		the sequence is 11.
 * @author RAVI
 *
 */
public class CountAndSay {

	
	public String countAndSay(int a) {
	    if(a<=0)
	    return null;
	    
	    String result="1";
	    while(a>1) {
	        StringBuilder sb = new StringBuilder();
	        int count =1;
	        for(int i=1;i<result.length();i++) {
	            
	            if(result.charAt(i)==result.charAt(i-1)) {
	                count++;
	               
	            }
	            else{
	                sb.append(count).append(result.charAt(i-1));
	                count=1;
	            }
	            
	            
	        }
	        sb.append(count).append(result.charAt(result.length()-1));
	        result = sb.toString();
	        a--;
	    }
	    
	    return result;
	}
}

package algos;

/**
 * Given an input string, reverse the string word by word.

Example:

Given s = "the sky is blue",

return "blue is sky the".

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.
 * @author RAVI
 *
 */
public class ReverseWordsWithString {
	public static final Character SPACE =' ';
	public String reverseWords(String a) {
	    StringBuffer res = new StringBuffer();
	    char[] ch = a.toCharArray();
	    int wordStart=0;
	    for(int i=ch.length-1;i>=0;) {
	        if(ch[i]!=SPACE){
	             wordStart =checkForWord(ch,i);
	             addToResult(ch,wordStart,i,res);
	             i = wordStart-1;
	       }
	        else
	              i--;
	       }
	    return res.substring(0,res.length()-1);
	}
	
	public int checkForWord(char[] ch, int idx){
	    while(idx>=0 && ch[idx]!=' ')
	        idx--;
	    return idx+1;
	}
	
	public void addToResult(char[] ch,int start,int end,StringBuffer res) {
	    while(start<=end){
	        res.append(ch[start]);
	        start++;
	        
	    }
	   res.append(SPACE);
	}
}

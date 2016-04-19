package algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneMnemonicsUsingRecursion {

	
	static final HashMap<Character,String> map = new HashMap<Character,String>(){{
        put('0',"0");
        put('1',"1");
		put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }} ;
	
	public static void main(String[] args){
		String digits="234";
		List<String> result = getMnemonics(digits);
		System.out.println(result);
	}
	
	public static List<String> getMnemonics(String digits){
		char[] ch = new char[digits.length()];
		List<String> result = new ArrayList<String>();
		generateMnemonics(digits,0,ch,result);
		return result;
	}
	
	public static void generateMnemonics(String digits,int idx,char[] ch,List<String> list) {
		if(digits.length()==idx)
		{
			list.add(new String(ch));
			return ;
		}
		String letters = map.get(digits.charAt(idx));
		for(int i=0;i<letters.length();i++) {
			ch[idx] = letters.charAt(i);
			generateMnemonics(digits,idx+1,ch,list);
		}
	}
	
}

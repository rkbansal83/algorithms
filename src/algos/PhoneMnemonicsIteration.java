package algos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneMnemonicsIteration {
	
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
		List<String> result = getMnemoincs(digits,map);
		System.out.println(result);
	}
	public static List<String> getMnemoincs(String digits,HashMap<Character,String> map) {
		List<String> result = new ArrayList<String>();
		result.add("");
		for(int i=0;i<digits.length();i++) {
			char ch = digits.charAt(i);
			String letters = map.get(ch);
			result = explode(letters,result);
		}
		return result;
	}
	
	public static List<String> explode(String letters,List<String> res) {
		List<String> interimResult = new ArrayList<String>();
		for(String str:res) {
				for(int i=0;i<letters.length();i++)
					interimResult.add(str+letters.charAt(i));
		}
		return interimResult;
	}
}


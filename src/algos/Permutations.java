package algos;

import java.util.HashSet;

public class Permutations {

	private static final String EMPTY ="";
	
	public static HashSet<String> getPermutations(String input) {
		HashSet<String> permutations = new HashSet<String>();
		
		if(EMPTY.equals(input)) {
			permutations.add(input);
			return permutations;
		}
		
		char firstChar = input.charAt(0);	
		String remainingString = input.substring(1);
		HashSet<String> words = getPermutations(remainingString);
		
		for(String word:words) {
			
			for(int i=0;i<=word.length();i++) {
				
				String prefix  = word.substring(0, i);
				String suffix = word.substring(i);
				permutations.add(prefix+firstChar+suffix);
			}
		}
		
		
		return permutations;
		
	}
	
	public static void main(String s[]) {
		
		System.out.println(getPermutations("abc"));
	}
	

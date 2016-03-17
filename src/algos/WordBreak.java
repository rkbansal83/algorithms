package algos;

import java.util.Arrays;
import java.util.HashSet;

/**
 * This program will check if a given String can be broken into valid words of
 * dictionary (dictionary is in memory)
 * 
 * @author RAVI
 *
 */
public class WordBreak {

	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>(Arrays.asList("cat", "big", "is"));
		String input = "bigiscat";
		String output = isStringValid(input, dict);
		System.out.println(output);
	}

	// This is recursive solution - Run time complexity can be further improved
	// using dynamic programming.

	public static String isStringValid(String input, HashSet<String> dict) {
		if (dict.contains(input))
			return input;
		int length = input.length();
		for (int i = 1; i < length; i++) {
			String prefix = input.substring(0, i);
			if (dict.contains(prefix)) {
				String suffix = input.substring(i, length);
				String segments = isStringValid(suffix, dict);
				if (segments != null)
					return prefix + " " + segments;
			}

		}

		return null;
	}

}

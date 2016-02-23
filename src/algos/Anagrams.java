package algos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Anagrams {

	public static void groupAnagrams(List<String> anagrams) {
		Collections.sort(anagrams, new AnagramComparator());
	}

	public static class AnagramComparator implements Comparator<String> {
		public String sortString(String input) {
			char ch[] = input.toCharArray();
			Arrays.sort(ch);
			return new String(ch);
		}

	public int compare(String input1, String input2) {
			return sortString(input1).compareTo(sortString(input2));
		}
	}
	
	public static void main(String[] args) {
			List<String> list = new ArrayList<String>();
			list.add("india");
			list.add("indik");
			list.add("jklmn");
			list.add("diain");
			list.add("nmjkl");
			System.out.println("before grouping " + list);
			groupAnagrams(list);
			System.out.println("after grouping " + list);
	}

}

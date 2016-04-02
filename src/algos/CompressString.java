package algos;

public class CompressString {

	public static void main(String[] args) {
		String input = "aabbbccc";
		String output = compress(input);
		System.out.println(output);
	}

	public static String compress(String input) {
		if (input == null || input.length() == 0)
			return null;
		StringBuffer output = new StringBuffer();
		char last = input.charAt(0);
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			if (last == input.charAt(i))
				count++;
			else {
				output.append(last).append(count);
				last = input.charAt(i);
				count = 1;
			}
		}

		output.append(last).append(count);
		return output.toString();
	}
}

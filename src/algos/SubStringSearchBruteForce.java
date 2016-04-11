package algos;

public class SubStringSearchBruteForce {
	
	
	public static void main(String[] arg) {
		String input = "abcdefg";
		String pattern = "cd";
		
		int index = isSubString(input,pattern);
		
		System.out.println("Substring at"+index);
	}
	
	public static int isSubString(String input,String pattern) {
		
		int subIndex = -1;
		
		int inLen ;
		int pLen ;
		
		if(input==null|| pattern==null || (inLen=input.length())==0 ||(pLen=pattern.length())==0 || inLen<pLen)
			return subIndex;
		
		int j;
		for(int i=0;i<inLen-pLen;i++)
		{
			for(j=0;j<pLen;j++) {
				if(input.charAt(i+j)!=pattern.charAt(j))
					break;
			}
			if(j==pLen)
				return i;
		}
		
		return subIndex;
	}
	
}

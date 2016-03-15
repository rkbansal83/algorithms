package algos;

public class SubsetSum {

	public static boolean isSubset(int[] arr, int sum) {
		
		boolean dp[][] = new boolean[arr.length][sum+1];
		
		//initialize first row and column.
		for(int i=0;i<arr.length;i++)
			dp[i][0] = true;
		
		for(int i=1;i<=sum;i++){
			if(i==arr[0])
				dp[0][i] = true;
			
		}
		
		for(int i=1;i<arr.length;i++){
			for(int j=1;j<=sum;j++) {
				
				if(j-arr[i]>=0)
					dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
				else
					
					dp[i][j] = dp[i-1][j];
			}
			
		}
		
		return dp[arr.length-1][sum];
	}
	
	
	public static void main(String[] str) {
		int[] arr = {1,2,5,6};
		
		//test case when subset exists
		boolean subSetExists = isSubset(arr,3);
		System.out.println(subSetExists);
		
		//test case when subset does not exist
		subSetExists = isSubset(arr,10);
		System.out.println(subSetExists);
	}
}

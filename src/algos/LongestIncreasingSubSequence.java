package algos;



public class LongestIncreasingSubSequence {
	
	public static void main(String s[]) {
		int arr[] = {3, 10, 2, 1, 20};
		LIS(arr);
	}
	
	public static void LIS(int arr[]) {
        int num = arr.length;
        int prevIndx[] = new int[num];
        
        for(int i=0;i<num;i++) {
             prevIndx[i]=-1;
        }
        
        int dp[] = new int[num];
        dp[0]=1;
        if(num==1)
               System.out.println(dp[0]);
        else{
            for(int i=1;i<arr.length;i++)
                {
                    dp[i]=1;
                for(int j=i-1;j>=0;j--){
                    if(arr[i]>arr[j] && dp[i]<dp[j]+1)
                        {
                        
                        dp[i]=dp[j]+1;
                        prevIndx[i]=j;
                    }
                    
                }
                
            }
        int max = 1;
        int maxIndex=0;
        for(int k = 0; k < dp.length; k++)
        {
            if(max < dp[k])
            {
                max = dp[k];
                maxIndex=k;
            }
        }
        System.out.println("Length of LIS ="+max);    
        int iterate = maxIndex;
        System.out.println("The longest increasing subsequence is (Reverse Order just for output purposes) ");
        while(iterate!=-1){
        	System.out.print(arr[iterate]+" ");
        	iterate= prevIndx[iterate];
        }
        
    }
 }
}

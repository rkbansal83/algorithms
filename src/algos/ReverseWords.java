package algos;

public class ReverseWords {

	 public static void main(String[] args) {
	        char[] str = "This is a string".toCharArray();
	        int start=0;
	        int end = str.length-1;
	        
	        for(int i=0;i<str.length;i++){
	        	
	        	if(str[i]==' ' && i>0){
	        		getReverse(str,start,i-1);
	        		start=i+1;
	        	}
	        	else if(i==str.length-1)
	        		getReverse(str,start,str.length-1);
	        }
	        
	        getReverse(str,0,str.length-1);
	        System.out.println(str);
	 }
	 
	 public static void getReverse(char[] str,int start,int end){
		  while(start<end){
			 swap(str,start,end);
			 start++;
			 end--;
		 }
	 }
	
	 
	 public static void swap(char[] str,int start,int dest){
		 char temp = str[start];
		 str[start] = str[dest];
		 str[dest]= temp;
		 
	 }
}

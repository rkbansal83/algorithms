package algos;

import java.util.ArrayList;

/*Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. 
Find all possible words that can be formed by a sequence of adjacent charactersNote that we can move to any of 8 adjacent characters,
but a word should not have multiple instances of same cell.*/

public class BoggleSolver {
	
	static ArrayList<String> dict = new ArrayList<String>();
	static ArrayList<String> result = new ArrayList<String>();
	
	private static void populateDict(String...words){
		for (String word:words)
			dict.add(word);
	}
	
	public static void findWordsRecursively(char[][] board,boolean[][] visited,int row,int col,String currString){
		visited[row][col] = true;
		
		if(dict.contains(currString))
			result.add(currString);
			
		for(int i=row-1;i<=row+1 && i<board.length;i++){
			for(int j=col-1;j<=col+1 && j<board[0].length;j++){
				if(i>=0 && j>=0 && !visited[i][j]  )
					findWordsRecursively(board,visited,i,j,currString.concat(String.valueOf(board[i][j])));
			}
		}
		visited[row][col]=false;
	}
	
	public static void find(char[][] board) {
		
		boolean visited[][] = new boolean[board.length][board[0].length];
		
		
		for(int row=0;row<board.length;row++)
			for(int col=0;col<board[0].length;col++)
				findWordsRecursively(board,visited,row,col,String.valueOf(board[row][col]));
		
		System.out.println(result);
	}
	
	
	public static void main(String[] args) {
		  
		  char boggle[][] = {
				  {'G','I','Z'},
				  {'U','E','K'},
				  {'Q','S','E'} 		  
				  };
		  populateDict("GEEKS","FOR","QUIZ","GO","Q");
		  
		  find(boggle);
	}
}

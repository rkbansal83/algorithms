package ds.trees;

public class BalancedBST<E  extends Comparable<? super E>> {

	public  TNode<E> createBalancedBST(int[] sortedArray) {
		
		return createBST(sortedArray,0,sortedArray.length-1);
	}
	
	private TNode<E> createBST(int[] sortedArray,int start, int end) {
		if(start>end)
			return null;
		int mid = (start+end)/2;
		TNode<E> root = new TNode(sortedArray[mid]);
		root.setLeft(createBST(sortedArray,start,mid-1));
		root.setRight(createBST(sortedArray,mid+1,end));
		return root;
		
	}
	
	public static void main(String[] args)
    {
              
        //Create A BST from sorted array
        int[] arr = {1,2,3,4,5};
        BalancedBST<Integer> BalancedBst = new BalancedBST<Integer>();
        TNode<Integer> root = BalancedBst.createBalancedBST(arr);
        System.out.println(BalancedBTree.checkIfBalanced(root));
    }
}

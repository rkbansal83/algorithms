package ds.trees;

public class ValidateBST {

	public static boolean checkBST(TNode<Integer> n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		return checkBST(n.left, min, n.data) && checkBST(n.right, n.data, max) ;
	}
	
	public static void main(String[] args)
    {
    	
    	//Create a BST Tree
	  	BST<Integer> bst = new BST<Integer>();
	  	bst.setRoot(new TNode(5));
		bst.add(1,bst.getRoot());
		bst.add(4,bst.getRoot());
		bst.add(6,bst.getRoot());
		bst.add(2,bst.getRoot());
        System.out.println("inorder traversal of BST returns sorted array ");
        bst.inOrderTraversal(bst.getRoot());
        boolean isBST = checkBST(bst.getRoot(),null,null);
        System.out.println("is valid BST ::" + isBST);
    }
	
}

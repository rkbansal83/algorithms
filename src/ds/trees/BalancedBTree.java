package ds.trees;

// This class will check if the given binary tree is balanced or not.
public class BalancedBTree {

	
	// this function returns height of tree rooted at currentNode if the tree is balanced
    // otherwise it returns -1
    private static int checkBalance(TNode currentNode)
    {
        if (currentNode == null) 
        {
            return 0;
        }
         
        // check if left sub-tree is balanced
        int leftSubtreeHeight = checkBalance(currentNode.left);
        if (leftSubtreeHeight == -1) return -1;
         
        // check if right sub-tree is balanced
        int rightSubtreeHeight = checkBalance(currentNode.right);
        if (rightSubtreeHeight == -1) return -1;
         
        // if both sub-trees are balanced, check the difference of heights
        // should be less than or equal to 1 
        if (Math.abs(leftSubtreeHeight - rightSubtreeHeight) > 1)
        {
            return -1;
        }
 
        // if tree rooted at this node is balanced, return height if tree rooted at this this node
        return (Math.max(leftSubtreeHeight, rightSubtreeHeight) + 1);
    }
     
     
    public static boolean checkIfBalanced(TNode root)
    {
        if (checkBalance(root) == -1)
        {
            return false;
        }
        return true;
    }	
    
    public static void main(String[] args)
    {
    	
    	//Create a balanced Tree
    	BTree<Integer> btree = new BTree<Integer>();
		btree.root = createBalancedTree();
        System.out.println("tree is balanced: "+checkIfBalanced(btree.getRoot()));
        
      //Create a balanced Tree
        BTree<Integer> ubtree = new BTree<Integer>();
        ubtree.root = createUnBalancedTree();
        System.out.println("tree is balanced: "+checkIfBalanced(ubtree.getRoot()));
    }

    /*
	 * Create a sample tree
	 *              1
	 *      2               3
	 * 4        5       6       7
	 * 
	 */
	public static TNode<Integer> createBalancedTree() {
		TNode<Integer> root = new TNode(1, new TNode(2, new TNode(4), new TNode(5)),
				new TNode(3, new TNode(6), new TNode(7)));
		return root;
	}
	
	
	/*
	 * Create a sample tree
	 *              1
	 *      2               
	 * 4        5              
	 * 
	 */
	public static TNode<Integer> createUnBalancedTree() {
		TNode<Integer> root = new TNode(1);
		TNode<Integer> lTree = new TNode(2, new TNode(4), new TNode(5));
		root.setLeft(lTree);
		return root;
	}
}
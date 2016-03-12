package ds.trees;

public class LowestCommonAncestor {

	public static TNode findLCA(TNode root, TNode a, TNode b) {
		if (root == null) {
			return null;
		}

		if (root.equals(a) || root.equals(b)) { 
			// if at least one matched, no need to continue
			// this is the LCA forightthis root
			return root;
		}

		TNode left= findLCA(root.left, a, b);
		TNode right= findLCA(root.right, a, b);

		if (left!= null && right!= null) {
			return root;  // TNodes are each on a seaparate branch
		}

		// either one node is on one branch, 
		// or none was found in any of the branches
		return left!= null? left: right;
	}


	// This is for testing purpose.
	public static void main(String[] args) {
		BTree<Integer> btree = new BTree<Integer>();

		//Create a sample Tree
		btree.root = createSampleTree();

		TNode<Integer> A = btree.getRoot().getLeft().getLeft();   // Node 4
		TNode<Integer> B = btree.getRoot().getRight();            // Node 3
		TNode<Integer> lca = findLCA(btree.getRoot(),A, B);
		System.out.println("LCA of " + A.getData() + " and " + B.getData() + " is " + lca);
	}


	/*
	 * Create a sample tree
	 *              1
	 *      2               3
	 * 4        5       6       7
	 * 
	 */
	public static TNode<Integer> createSampleTree() {
		TNode<Integer> root = new TNode(1, new TNode(2, new TNode(4), new TNode(5)),
				new TNode(3, new TNode(6), new TNode(7)));
		return root;
	}
}

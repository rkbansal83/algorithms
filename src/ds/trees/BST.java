package ds.trees;

public class BST<E  extends Comparable<? super E>> {
	TNode<E> root;
    
    public void setRoot(TNode<E> root) {
		this.root = root;
	}

	public TNode<E> getRoot() {
        return root;
    }
	
	TNode<E> add(E item, TNode<E> root) {
	    if (root==null) {
	        return new TNode<E>(item, null, null);
	    }
	    if (item.compareTo(root.data)<0) {       
	       	root.left = add( item,root.left);
	    }
	    else {
	        root.right = add( item, root.right);
	    }
	    return root;
	}

	
	public  void inOrderTraversal(TNode root) {
		if(root!=null) {
			inOrderTraversal(root.left);
			System.out.println(" "+root.data);
			inOrderTraversal(root.right);
		}
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
	      
	    }
	
}

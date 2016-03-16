package ds.trees;

public class BTree<E  extends Comparable<? super E>> {

	TNode<E> root;
    
    public void setRoot(TNode<E> root) {
		this.root = root;
	}

	public TNode getRoot() {
        return root;
    }
    
 }

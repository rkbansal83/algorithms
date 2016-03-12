package ds.trees;

public class TNode<E> {

	public E data;
    public TNode right;
    public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public TNode getRight() {
		return right;
	}

	public void setRight(TNode right) {
		this.right = right;
	}

	public TNode getLeft() {
		return left;
	}

	public void setLeft(TNode left) {
		this.left = left;
	}

	public TNode left;
	
    public TNode(E data) {
        this.data = data;
        this.right =null;
        this.left=null;
    }
    
    public TNode(E data, TNode left, TNode right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
    }
    
    public String toString() {
        return data+""; 
    }
}

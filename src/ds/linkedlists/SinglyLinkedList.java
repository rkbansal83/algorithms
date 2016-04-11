package ds.linkedlists;

public class SinglyLinkedList<T> {

	Node<T> head;
	
	public void setHead(Node<T> head) {
		this.head = head;
	}


	public Node<T> getHead() {
		return head;
	}

	int size;
	
	public Node<T> add(T data) {
		
		Node<T> nodeToBeAdded = new Node<T>(data);
		
		if(head==null){
			head = nodeToBeAdded;
		}
		else
		{
			Node<T> runner = head;
			while(runner.next!=null){
				runner = runner.next;
			}
			runner.next = nodeToBeAdded;
		}
		size++;		
		return head;
		
	}
	
	
	public void display(Node<T> head) {
		Node<T> current = head;
		
		while(current!=null) {
			System.out.print(current.data+"->");
			current = current.next;
		}
		System.out.print("null");
		
	}
	
	
	
	public Node<T> reverse(Node<T> head){
		Node<T> current = head;
		Node<T> previous = null;
		
		while(current!=null) {
			Node<T> temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
			
		}
		
		return previous;
	}
	
	
	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
		
		list.add(5);
		list.add(10);
		list.add(15);
		list.add(20);
		
		list.display(list.head);
		
		list.head = list.reverse(list.getHead());
		
		System.out.println("\n Reversed");
		
		list.display(list.head);
	}
	
}

package ds.stacks;

public class SortStack {

	public static void main(String[] arg) {
		Stack<Integer> stack = new Stack<Integer>();
		populateStack(stack);
		stack.display();
		sort(stack);
		System.out.println("\n after sorting");
		stack.display();
	}
	
	private static void populateStack(Stack<Integer> stack) {
		stack.push(10);
		stack.push(8);
		stack.push(11);
		stack.push(12);
		stack.push(5);
		stack.push(6);
	}
	
	public static void sort(Stack<Integer> stack) {
		if(!stack.isEmpty()) {
			Integer itm = stack.pop();
			sort(stack);
			insert(stack,itm);
		}
	}
	
	
	private static void insert(Stack<Integer> stack, Integer value) {
		if(stack.isEmpty() || stack.peek().compareTo(value)<=0){
			stack.push(value);
		}
		else{
			int topElm = stack.pop();
			insert (stack,value);
			stack.push(topElm);
		}
	}
}

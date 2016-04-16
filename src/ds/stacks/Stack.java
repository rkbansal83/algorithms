package ds.stacks;

import java.util.Arrays;

public class Stack<E> {
	E[] data;
	int top;
	int DEFAULT_CAPACITY=10;
	
	public boolean isEmpty() {
		return  (top==-1);
	}
	
	public Stack(){
		data = (E[]) new Object[DEFAULT_CAPACITY];
		this.top = -1;
	}

	public void push(E value) {
		if(data.length-1==top) {
			this.data = resize(data.length*2);
		}
		data[++top] = value;
	}
	
	public E[] resize(int capacity) {
		return Arrays.copyOf(data, capacity);
	}
	
	public E pop() {
		if(top==-1)
			throw new RuntimeException("stack is empty");
		E itm = data[top];
		data[top] = null;
		top--;
		return itm;
	}
	
	public E peek() {
		if(top==-1)
			throw new RuntimeException("stack is empty");
		return data[top];
	}
	
	public void display() {
		for(int i=top;i>0;i--) {
			System.out.print(data[i]+"->");
			
		}
		System.out.print(data[0]);
	}
	
}

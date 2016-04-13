package algos;

public class BinaryMinHeap<T extends Comparable<T>> {
	
	private T[] data;
	private int heapSize;
	public T[] getData() {
		return data;
	}
	public int getHeapSize() {
		return heapSize;
	}
	public BinaryMinHeap(int size) {
		data =(T[]) new Comparable[size];
		heapSize = 0;
	}
	public T getMinimum() {
		if (isEmpty())
			throw new RuntimeException("Heap is empty");
		else
			return data[0];
	}
	public boolean isEmpty() {
        return (heapSize == 0);
	}
	private int getParentIndex(int nodeIndex) {
		return (nodeIndex - 1) / 2;
	}
	public void insert(T value) {
		if (heapSize == data.length)
			throw new RuntimeException("Heap's underlying storage is overflow");
		else {
			heapSize++;
			data[heapSize - 1] = value;
			shiftUp(heapSize - 1);
		}
	}
	private void shiftUp(int nodeIndex) {
		int parentIndex;
		T tmp;
		if (nodeIndex != 0) {
			parentIndex = getParentIndex(nodeIndex);
			if (data[parentIndex].compareTo(data[nodeIndex])>0) {
				tmp = data[parentIndex];
				data[parentIndex] = data[nodeIndex];
				data[nodeIndex] = tmp;
				shiftUp(parentIndex);
			}
		}
	}
	public void removeMin() {
		if (heapSize == 0)
			throw new RuntimeException("Heap is Empty");
		else {
			data[0] = data[heapSize - 1] ;
			data[heapSize-1] = null;
			heapSize--;
			sinkDown(0);
		}
	}
	private void sinkDown(int nodeIndex) {
		int left = nodeIndex*2+1;
		int right = nodeIndex*2+2;
		int min = nodeIndex;
		if(left<heapSize && data[left].compareTo(data[min])<0)
			min = left;
		if(right<heapSize && data[right].compareTo(data[min])<0)
			min = right;
		
		if(min!=nodeIndex){
			T temp = data[min];
			data[min] = data[nodeIndex];
			data[nodeIndex] = temp;
			sinkDown(min);
		}
		
	}
	public static <T> void display(BinaryMinHeap minHeap){
		T[] arr = (T[]) minHeap.getData();
		for(int i=0;i<minHeap.getHeapSize();i++)
			System.out.print(arr[i]+"->");
	}
	public static void main(String[] args){
		BinaryMinHeap minHeap = new BinaryMinHeap(5);
		minHeap.insert(5);
		minHeap.insert(2);
		minHeap.insert(3);
		minHeap.insert(4);
		minHeap.insert(10);
		display(minHeap);	
		minHeap.removeMin();
		System.out.println("\nRemoved Min");	
		display(minHeap);
	}
}

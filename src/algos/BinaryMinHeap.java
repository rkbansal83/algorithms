package algos;

public class BinaryMinHeap {
	
	private int[] data;
	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}
	private int heapSize;

	public int getHeapSize() {
		return heapSize;
	}

	public void setHeapSize(int heapSize) {
		this.heapSize = heapSize;
	}

	public BinaryMinHeap(int size) {
		data = new int[size];
		heapSize = 0;
	}

	public int getMinimum() {
		if (isEmpty())
			throw new HeapException("Heap is empty");
		else
			return data[0];
	}


	public boolean isEmpty() {
        return (heapSize == 0);
  }
	private int getParentIndex(int nodeIndex) {
		return (nodeIndex - 1) / 2;
	}

	public class HeapException extends RuntimeException {
		public HeapException(String message) {
			super(message);
		}
	}

	public void insert(int value) {
		if (heapSize == data.length)
			throw new HeapException("Heap's underlying storage is overflow");
		else {
			heapSize++;
			data[heapSize - 1] = value;
			shiftUp(heapSize - 1);
		}
	}

	private void shiftUp(int nodeIndex) {
		int parentIndex, tmp;
		if (nodeIndex != 0) {
			parentIndex = getParentIndex(nodeIndex);
			if (data[parentIndex] > data[nodeIndex]) {
				tmp = data[parentIndex];
				data[parentIndex] = data[nodeIndex];
				data[nodeIndex] = tmp;
				shiftUp(parentIndex);
			}
		}
	}
	
	
	public void removeMin() {
		if (heapSize == 0)
			throw new HeapException("Heap is Empty");
		else {
			data[0] = data[heapSize - 1] ;
			heapSize--;
			sinkDown(0);
		}
	}
	
	private void sinkDown(int nodeIndex) {
		int left = nodeIndex*2+1;
		int right = nodeIndex*2+2;
		int min = nodeIndex;
		if(left<heapSize && data[left]<data[min])
			min = left;
		if(right<heapSize && data[right]<data[min])
			min = right;
		
		if(min!=nodeIndex){
			int temp = data[min];
			data[min] = data[nodeIndex];
			data[nodeIndex] = temp;
			sinkDown(min);
		}
		
	}
	
	
	public static void display(BinaryMinHeap minHeap){
		int[] arr = minHeap.getData();
		
		for(int i=0;i<minHeap.getHeapSize();i++)
			System.out.print(arr[i]+" ");
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

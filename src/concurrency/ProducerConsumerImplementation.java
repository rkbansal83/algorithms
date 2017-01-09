package concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerImplementation {

	
	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int capacity = 10;
		Producer p1 = new Producer(queue,capacity,"p1");
		Producer p2 = new Producer(queue,capacity,"p2");
		Consumer c1 = new Consumer(queue,capacity,"c1");
		Consumer c2 = new Consumer(queue,capacity,"c2");
		p1.start();
		c1.start();
		c2.start();
		p2.start();
		
		
	}
	
	
}

class Producer extends  Thread {
	Queue<Integer> queue;
	int MAX_SIZE;
	String name ;
	Producer(Queue<Integer> queue,int maxSize,String name) {
		this.queue=queue;
		this.MAX_SIZE=maxSize;
		this.name = name;
	}
	
	public void run() {
		System.out.println("thread running " + name);
		try {   
				int i=0;
				while(true)
					produce(++i);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void produce(int item) throws InterruptedException {
		synchronized(queue) {
				while(queue.size()==MAX_SIZE){
					System.out.println("Thread Name:: "+name+ " Queue is full ");
					queue.wait();
				}
				System.out.println("thread running " + this.name + " producing item "+item);
				queue.add(item);
				queue.notifyAll();
				
		}
	//to test we can producer thread to sleep	Thread.sleep(10000);
	}
  }


class Consumer extends Thread {
	Queue<Integer> queue;
	int MAX_SIZE;
	String name;
	
	Consumer(Queue<Integer> queue,int maxSize,String name ) {
		this.queue=queue;
		this.MAX_SIZE=maxSize;
		this.name = name;
	}
	
	public void run() {
		System.out.println("thread running " + name);
		try{
			while(true)
				consume();
		}
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public void consume() throws InterruptedException {
		synchronized(queue) {
			while(queue.isEmpty()){
				System.out.println("Thread Name:: "+name+" Queue is empty");
				queue.wait();
			}
			System.out.println("thread running " + name+"consumed item" +queue.poll());
			queue.notifyAll();
		}
	}
	
}
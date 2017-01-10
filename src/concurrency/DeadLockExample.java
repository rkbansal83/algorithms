package concurrency;

// This example will cause a deadlock among threads
// in order to avoid deadlock , we need to make sure that thread1 and thread2 acquire the locks on resources r1 and r2 in same order
public class DeadLockExample {

	public static void main(String args[]) {
		SharedResource r1= new SharedResource();
		SharedResource r2= new SharedResource();

		Worker1 w1 = new Worker1(r1,r2,"thread1");
		Worker2 w2 = new Worker2(r1,r2,"thread2");

		Thread t1=new Thread(w1);
		Thread t2=new Thread(w2);

		t1.start();
		t2.start();
	}

}


class SharedResource 
{
 // just a class without much details , objects of this class will be used as shared resources which will be acquired by threads.
}
class Worker1 implements Runnable {
	SharedResource r1,r2;
	String name;
	public Worker1(SharedResource r1,SharedResource r2,String name){
		this.r1=r1;
		this.r2=r2;
		this.name=name;
	}
	public void run() {
		System.out.println("Thread :: "+name+ " starting");
		synchronized(r1){
			try {
				Thread.sleep(1000); //sleeping a thread to cause a delay 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Thread :: "+name+ " trying to get lock on resource r2");
			synchronized(r2){
				System.out.println("Thread :: "+name+ " got all locks");
			}
		}

	}
}

class Worker2 implements Runnable {
	SharedResource r1,r2;
	String name;
	public Worker2(SharedResource r1,SharedResource r2,String name){
		this.r1=r1;
		this.r2=r2;
		this.name=name;
	}
	public void run() {
		System.out.println("Thread :: "+name+ " starting");
		synchronized(r2){
			System.out.println("Thread :: "+name+ " trying to get lock on resource r1");
			synchronized(r1){
				System.out.println("Thread :: "+name+ " got all locks");
			}
		}


	}
}




package concurrency;

/**
 * Create two threads. Let one thread print Odd numbers and the other thread print Even numbers.   
 * Assume natural numbers 1, 2, 3... , from 1 thru 100. * Numbers must be printed in their natural order i.e. 
 * 1 and then 2 and then 3 etc.   

 * @author RAVI
 *
 */
public class OddEvenProblem {

	public static void main(String[] args) {
		int maxCount=100;
		Result result=new Result();
		OddEvenThread odd= new OddEvenThread(maxCount, true, result);
		OddEvenThread even=new OddEvenThread(maxCount,false,result);
		Thread oddThread=new Thread(odd);
		Thread evenThread=new Thread(even);
		oddThread.start();
		evenThread.start();
	}


}
class OddEvenThread implements Runnable {
	int max_count;
	boolean isOdd;
	Result result;
	public OddEvenThread(int maxCount,boolean isOdd,Result result) {
		this.max_count=maxCount;
		this.isOdd=isOdd;
		this.result=result;
	}

	public void run() {
		int start=isOdd?1:2;
		try{
			while(start<=max_count){
				if(start%2==0)
					result.displayEven(start);
				else
					result.displayOdd(start);
				start=start+2;
			}
		}
		catch(InterruptedException ex) { ex.printStackTrace(); }
	}
}

class Result {
	boolean isOdd = true;

	public synchronized void displayEven(int i) throws InterruptedException{
		while(isOdd==true){
			wait();
		}
		System.out.println(i);
		isOdd=true;
		notifyAll();
	}

	public synchronized void displayOdd(int i) throws InterruptedException{
		while(isOdd==false){
			wait();
		}
		System.out.println(i);
		isOdd=false;
		notifyAll();
	}
}
class SimpleThread extends Thread{
 private String threadName;
 public SimpleThread(String name){
	this.threadName = name;
 }
public void run(){
 for(int i = 1; i <= 5; i++){
	System.out.println(threadName + " is running:" + i);
	try{
         Thread.sleep(500);
	 //System.out.println(threadName + " is running.");
	}catch (InterruptedException e){
	 System.out.println(threadName + " Was interrupted.");  
	}
  }
  
 }
}

public class SimpleMultithread{
 public static void main(String[] args){
  SimpleThread t1 = new SimpleThread("Thread A");
  SimpleThread t2 = new SimpleThread("Thread B");
  
  t1.start();
  t2.start();
  System.out.println("Main method finished");
 }
}
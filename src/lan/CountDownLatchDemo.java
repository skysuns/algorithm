package lan;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
//CountDownLatch:使某个线程等待其他若干个线程执行完后，再继续执行
public class CountDownLatchDemo {
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
	public static void main(String[] args) throws InterruptedException{
		CountDownLatch sdl = new CountDownLatch(2);
		for(int i=0; i<2; i++){
			new Thread(new Task("work"+i, 5000, sdl)).start();
		}
		sdl.await();
		System.out.println("all work done at "+sdf.format(new Date()));  		
	}
	static class Task implements Runnable{
		String workName;
		int workTime;
		CountDownLatch latch;
		
		public Task(String workName, int workTime, CountDownLatch latch) {
			super();
			this.workName = workName;
			this.workTime = workTime;
			this.latch = latch;
		}

		public void run(){
			try{
				System.out.println("Worker " + workName + "do work begin at " + sdf.format(new Date()));
				Thread.sleep(workTime);
				System.out.println("Worker "+workName +"do work complete at "+sdf.format(new Date()));
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			finally{
				latch.countDown();
			}
		}
	}
}

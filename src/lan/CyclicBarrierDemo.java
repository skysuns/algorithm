package lan;

import java.util.concurrent.CyclicBarrier;
//一组线程等待至某个状态，然后让这组线程再继续执行，等待线程释放后可重用
public class CyclicBarrierDemo {
	public static final int THREAD_NUM = 5;
	public static void main(String[] args){
		CyclicBarrier cb = new CyclicBarrier(THREAD_NUM, new Runnable(){			
			public void run(){
				System.out.println("Inside Barrier");
			}
		});
		for(int i=0; i<THREAD_NUM; i++){
			new Thread(new Worker(cb, i)).start();
		}
	}
	static class Worker implements Runnable{
		CyclicBarrier cb;
		int no;		
		
		public Worker(CyclicBarrier cb, int no) {
			super();
			this.cb = cb;
			this.no = no;
		}


		public void run(){
			try{
				System.out.println("worker " + no + "start working!");
				cb.await();
				System.out.println("worker " + no + "finish Working!");
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}

package lan;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//用来限制同时访问特定资源的线程数目，常用于流量控制
public class SemaphoreDemo {
	public static final int THREAD_NUM = 30;
	public static ExecutorService es = Executors.newFixedThreadPool(THREAD_NUM);
	public static Semaphore sp = new Semaphore(10);
	public static int flag = 0;
	public static void main(String[] args){
		for(int i=0; i<THREAD_NUM; i++){
			es.submit(new Runnable(){
				public void run(){
					try{
						sp.acquire();
						synchronized(SemaphoreDemo.class){
							flag++;
							System.out.println(flag + " save data " + sp.getQueueLength());
						}						
						Thread.sleep(5000);
						sp.release();
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			});
		}
		es.shutdown();
//		try{
//			es.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
		while (!es.isTerminated()) {  
            // 如果所有线程执行完成,那么挑出该循环.  
        }  
		System.out.println("Finish!");
	}
}

package lan;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
//利用阻塞队列实现生产者消费者模式
public class ProducerConsumer {
	public static void main(String[] args){
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>(10);
		Producer producer = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);
		for(int i=0; i<10; i++){
			if(i<5){
				new Thread(producer, "P"+i).start();
			}else{
				new Thread(consumer, "C"+i).start();
			}
		}
		try{
			Thread.sleep(10);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		producer.shutDown();
		consumer.shutDown();
		System.out.println("Finished!");
	}
	public static class Producer implements Runnable{
		private final BlockingQueue<Integer> blockingQueue;
		private volatile boolean flag;
		private Random random;
		public Producer(BlockingQueue<Integer> blockingQueue) {
			super();
			this.blockingQueue = blockingQueue;
			flag = false;
			random = new Random();
		}
		public void run(){
			while(!flag){
				int info = random.nextInt(100);
				try{
					blockingQueue.put(info);
					System.out.println(Thread.currentThread().getName()+" producer "+info);
					Thread.sleep(50);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
		}
		public void shutDown(){
			flag = true;
		}
	}
	public static class Consumer implements Runnable{
		private final BlockingQueue<Integer> blockingQueue;
		private volatile boolean flag;
		public Consumer(BlockingQueue<Integer> blockingQueue) {
			super();
			this.blockingQueue = blockingQueue;
			flag = false;
		}
		public void run(){
			while(!flag){
				int info;
				try{
					info = blockingQueue.take();
					System.out.println(Thread.currentThread().getName()+" consumer "+info);
	                Thread.sleep(50);
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			
		}
		public void shutDown(){
			flag = true;
		}
	}
}

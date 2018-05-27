package lan;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ProducerConsumer2 {
	public static void main(String[] args){
		Buffer buffer = new Buffer(10);
		Producer producer = new Producer(buffer);
		Consumer consumer = new Consumer(buffer);
		//创建线程执行生产和消费
        for(int i=0;i<3;i++){
            new Thread(producer,"producer-"+i).start();
        }
        for(int i=0;i<3;i++){
            new Thread(consumer,"consumer-"+i).start();
        }
	}
	//模拟生产和消费的对象
	static class Buffer{
		private int maxSize;
		private List<Date> storage;
		public Buffer(int maxSize) {
			super();
			this.maxSize = maxSize;
			storage = new LinkedList<>();
		}
		//生产者方法
		public synchronized void put(){
			try{
				while(storage.size() == maxSize){
					System.out.println(Thread.currentThread().getName());
					wait();
				}
				storage.add(new Date());
				System.out.println(Thread.currentThread().getName()+" put: " + storage.size());
				Thread.sleep(100);
				notifyAll();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		//消费者方法
		public synchronized void take(){
			try{
				while(storage.size() == 0){
					System.out.println(Thread.currentThread().getName());
					wait();
				}
				((LinkedList<Date>)storage).poll();
				System.out.println(Thread.currentThread().getName()+" take: " + storage.size());
				Thread.sleep(100);
				notifyAll();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	static class Producer implements Runnable{
		private Buffer buffer;
	    Producer(Buffer b){
	        buffer=b;
	    }
	    @Override
	    public void run() {
	        while(true){
	            buffer.put();
	        }
	    } 
	}
	static class Consumer implements Runnable{
		private Buffer buffer;
	    Consumer(Buffer b){
	        buffer=b;
	    }
	    @Override
	    public void run() {
	        while(true){
	            buffer.take();
	        }
	    }
	}
}

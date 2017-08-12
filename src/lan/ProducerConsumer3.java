package lan;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//利用对象锁、条件对象及相关的await、signalAll方法实现生产者消费者模式
public class ProducerConsumer3 {
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
		private  final Lock lock;
	    private  final Condition notFull;
	    private  final Condition notEmpty;
		private int maxSize;
		private List<Date> storage;
		public Buffer(int maxSize) {
			super();
			lock=new ReentrantLock();
	        notFull=lock.newCondition();
	        notEmpty=lock.newCondition();
			this.maxSize = maxSize;
			storage = new LinkedList<>();
		}
		//生产者方法
		public void put(){
			lock.lock();
			try{
				while(storage.size() == maxSize){
					System.out.println(Thread.currentThread().getName());
					notFull.await();
				}
				storage.add(new Date());
				System.out.println(Thread.currentThread().getName()+" put: " + storage.size());
				Thread.sleep(100);
				notEmpty.signalAll();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				lock.unlock();
			}
		}
		//消费者方法
		public void take(){
			lock.lock();
			try{
				while(storage.size() == 0){
					System.out.println(Thread.currentThread().getName());
					notEmpty.await();
				}
				((LinkedList<Date>)storage).poll();
				System.out.println(Thread.currentThread().getName()+" take: " + storage.size());
				Thread.sleep(100);
				notFull.signalAll();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			finally{
				lock.unlock();
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

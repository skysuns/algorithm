package lan;

//多个线程间共享数据，每个线程执行的代码不同，即需要不同的Runnable
//可以通过将数据封装成一个单独的类实现
public class ShareDataDemo2 {
	public static void main(String[] args){
		final Data data = new Data();
		for(int i=0; i<2; i++){
			new Thread(new Runnable(){
				public void run(){
					data.dec();
				}
			}).start();;
			new Thread(new Runnable(){
				public void run(){
					data.add();
				}
			}).start();
		}
	}
	static class Data{
		private int data = 10;
		public synchronized void dec(){
			data--;
			System.out.println("当前线程为：" + Thread.currentThread().getName()+" data为 " + data);
		}
		public synchronized void add(){
			data++;
			System.out.println("当前线程为：" + Thread.currentThread().getName()+" data为 " + data);
		}
	}
}

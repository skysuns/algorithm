package lan;

//如果每个线程执行的代码相同，可以使用同一个Runnable对象
public class ShareDataDemo {
	public static void main(String[] args){
		Ticket t = new Ticket();
		new Thread(t).start();
		new Thread(t).start();
	}
	static class Ticket implements Runnable{
		private int ticket = 10;
		public void run(){
			synchronized(ShareDataDemo.class){
				while(ticket>0){
					ticket--;
					System.out.println("当前票数为：" + ticket);				
				}
			}
			
		}
	}
}

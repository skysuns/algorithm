package offer;

public class Fibonacci9 {
	public int Fibonacci(int n) {
		if(n<=1){
			return n;
		}
		int f1 = 0;
		int f2 = 1;
		int res = 0;
		for(int i=2; i<=n; i++){
			if(f1+f2>Integer.MAX_VALUE){
				return Integer.MAX_VALUE;
			}
			res = f1+f2;
			f1=f2;
			f2=res;			
		}
		return res;
	}	 
}

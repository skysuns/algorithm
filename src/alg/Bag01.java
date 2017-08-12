package alg;

public class Bag01 {
	private static boolean flag = true;
	public static void main(String[] args){
		int[] v = {5,4,3};
		int[] p = {20,10,12};
		int data = bag01(v, p, 10);
		if(flag == true){
			System.out.println(data);
		}else{
			System.out.println("Data is invalid");
		}		
	}
	private static int bag01(int[] v, int[] p, int c){
		 if(v==null || v.length==0 || p==null || p.length==0 || v.length!=p.length || c<=0){
			 flag = false;
			 return 0;
		 }
		 int[][] dp = new int[v.length+1][c+1];   //前i个宝石装入容器为c的背包，最大可获得的利益
		 for(int i=0; i<=v.length; i++){
			 for(int j=0; j<=c; j++){
				 System.out.println(i+"pp"+j);
				 dp[i][j] = (i==0?0:dp[i-1][j]);
				 if(i>0 && j>v[i-1]){
					 if(dp[i][j]<dp[i-1][j-v[i-1]]+p[i-1]){
						 dp[i][j] = dp[i-1][j-v[i-1]]+p[i-1];
					 }
				 }
			 }
		 }
		 return dp[v.length][c];
	}
	 
}

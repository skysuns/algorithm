package test;

import java.util.Scanner;

public class IQIYI_3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] temp = new int[n][2];
        for(int i=0; i<n; i++){
            int t = scanner.nextInt();
            m -= t;
            temp[i][0] = 0;
            temp[i][1] = scanner.nextInt() - t ;
        }

        System.out.println(result(temp,0,m,n,0));

    }

    public static int result(int[][] temp , int k, int m, int n, int res){
        if(res>m ){
            return 0;
        }
        if(res == m){
            return 1;
        }
        if(k>=n){
            return 0;
        }
        int count = 0;
        for(int i=0; i<=temp[k][1] &&i<=m; i++ ){
            temp[k][0] = i;
            count += result(temp,k+1,m, n,res+i);
        }
        return count;
    }
}

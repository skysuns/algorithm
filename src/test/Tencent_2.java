package test;

import java.util.Scanner;

/**
 * Created by isun3 on 2018/4/6.
 */
public class Tencent_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k = scanner.nextInt();
        int A = scanner.nextInt();
        int X = scanner.nextInt();
        int B = scanner.nextInt();
        int Y = scanner.nextInt();

        long result = 0;
        for(int i=0; i<=X; i++){
            for(int j=0; j<=Y; j++){
                if(i*A+j*B==k){
                    result = (result+Cal(X,i)*Cal(Y,j)%1000000007)%1000000007;
                }
            }
        }
        System.out.println(result);

    }

    public static int Cal(int N , int k)
    {
        if(0 == k || 0 == N)
        {
            return 1;
        }

        if(N < k)
        {
            return 0;
        }

        if(N == k)
        {
            return 1;
        }

        return (Cal(N-1,k) + Cal(N-1,k-1))%1000000007;
    }
    //
    ////求排列数
    //public static long A(int up,int bellow)
    //{
    //	long result=1;
    //	for(int i=up;i>0;i--)
    //	{
    //		System.out.println(result);
    //		result*=bellow;
    //		bellow--;
    //	}
    //	return result;
    //}
    ////求组合数，这个也不需要了。定义式，不使用互补率
    //public static long C2(int up,int below)
    //{
    //	if(up == 0 || below ==0){
    //		return 1;
    //	}
    //	//分母
    //	long denominator=A(up,up);//A(6,6)就是求6*5*4*3*2*1,也就是求6的阶乘
    //	//分子
    //	long numerator=A(up,below);//分子的排列数
    //	return numerator/denominator;
    //
    //}

}

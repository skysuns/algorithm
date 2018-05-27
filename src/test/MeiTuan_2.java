package test;

import java.util.Scanner;

/**
 * Created by isun3 on 2018/4/10.
 */
public class MeiTuan_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i=0; i<t; i++){
            int n = scanner.nextInt();
            isSplit(n);
        }
    }

    public static void isSplit(int n){
        for(int i=3; i<=n; i+=2){
            if(n%i==0 && n/i%2==0){
                System.out.println(i+" "+n/i);
                return;
            }
        }
        System.out.println(false);
    }
}

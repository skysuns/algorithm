package test;

import java.util.Arrays;
import java.util.Scanner;

public class IQIYI_2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] temp = new int[3];
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        temp[0] = m;
        temp[1] = n;
        temp[2] = k;

        //小到大
        Arrays.sort(temp);

        int res = temp[2]*2-temp[0]-temp[1];
        if(res%2==0){
            System.out.println(res/2);
        }else{
            System.out.println((res+1)/2+1);
        }

    }
}

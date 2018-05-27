package test;

import java.util.Scanner;

public class MinSheng {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine();
        String str2 = input.nextLine();
        if(str1.compareToIgnoreCase(str2)>0){
            System.out.println(1);
        }else if(str1.compareToIgnoreCase(str2)<0){
            System.out.println(-1);
        }else {
            System.out.println(0);
        }
    }
}

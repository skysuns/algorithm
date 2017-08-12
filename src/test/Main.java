package test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
    	Scanner in = new Scanner(System.in);
    	int n = Integer.parseInt(in.nextLine());
    	int[][] data = new int[n][2];
    	for(int i=0; i<n; i++){
    		String str = in.nextLine();
    		String[] sp = str.split(" ");
    		data[i][0]= Integer.parseInt(sp[0]); 
    		data[i][1]= Integer.parseInt(sp[1]);
    	}        
        in.close();
        
        //1.对战斗力进行排序
        //2.将战斗力低的与战斗力高的进行对解决
        //3.战斗力相同时，暂时不对决，留到下次对决
        System.out.println();
    }   
}

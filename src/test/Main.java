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
        
        //1.��ս������������
        //2.��ս�����͵���ս�����ߵĽ��жԽ��
        //3.ս������ͬʱ����ʱ���Ծ��������´ζԾ�
        System.out.println();
    }   
}

package test;

import java.util.Scanner;

public class Tips {
	public static void main(String[] args){        
		/*      
		 *      输入数据形式  
		 *      10
		 *      1 2 4 3 4 1 2 5 2 0
		 */
		Scanner in = new Scanner(System.in);
    	int n = Integer.parseInt(in.nextLine());
        String str = in.nextLine();
        in.close();        
        String[] sp = str.split(" ");	
        int[] data = new int[n];  
        for(int i=0; i<n; i++){
        	data[i]= Integer.parseInt(sp[i]);           
        }
	}
	
	public void tips(){
		/*      
		 *      输入数据形式  
		 *      2
		 *      1 2 
         *      2 3
		 */		
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
	}
}

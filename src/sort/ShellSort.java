package sort;

import java.util.Arrays;

public class ShellSort {
	private static boolean flag = true;
	public static void main(String[] args){
		int[] data = {1,2,7,5,10,3,8,3,11};
		shellSort(data);
		if(flag == true){
			System.out.println(Arrays.toString(data));
		}else{
			System.out.println("Data is invalid");
		}
	}
	public static void shellSort(int[] array){
		if(array==null || array.length==0){
			flag = false;
			return;
		}
		int d = array.length/2;
		while(d>0){
			for(int i=d; i<array.length; i++){
				int temp = array[i];
				for(int j=i-d; j>=0; j-=d){
					if(array[j]>temp){
						array[j+d]=array[j];
					}else{
						array[j+d]=temp;
						break;
					}
				}
			}
			d/=2;
		}
	}
}

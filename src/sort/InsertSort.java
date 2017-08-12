package sort;

import java.util.Arrays;

public class InsertSort {
	private static boolean flag = true;
	public static void main(String[] args){
		int[] data = {1,2,7,5,10,3,8};
		insertSort(data);
		if(flag == true){
			System.out.println(Arrays.toString(data));
		}else{
			System.out.println("Data is invalid");
		}
	}
	public static void insertSort(int[] array){
		if(array==null || array.length == 0){
			flag = false;
			return;
		}
		for(int i=1; i<array.length; i++){
			int temp = array[i];
			for(int j= i-1; j>=0; j--){
				if(array[j] > temp){
					array[j+1] = array[j];
				}else{
					array[j+1]=temp;
					break;
				}
			}
		}
	}
}

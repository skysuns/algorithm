package sort;

import java.util.Arrays;


public class QuickSort {
	private static boolean flag = true;
	public static void main(String[] args){
		int[] data = {1,2,7,5,10,3,8};
		quickSort(data, data.length, 0, data.length-1);
		if(flag == true){
			System.out.println(Arrays.toString(data));
		}else{
			System.out.println("Data is invalid");
		}
	}
	//采用了分治和递归的思想
	public static void quickSort(int[] data, int length, int start, int end) {
		if(data==null || length==0 || start<0 || end>=length){
			flag = false;
			return;
		}
		
		if(start == end){
			return;
		}
		
		////////////////核心////////////////////
		int division = start-1;
		for(int i=start; i<end; i++){
			if(data[i] < data[end]){
				division++;
				if(division != i){
					swap(data, i, division);
				}
			}			
		}
		division++;
		swap(data,end,division);
		///////////////////////////////////////
		
		if(division>start){
			quickSort(data, length, start, division-1);
		}
		if(division<end){
			quickSort(data, length, division+1, end);
		}
		
	}
	
	public static void swap(int[] data, int i, int j){
		int temp = data[i];
		data[i]=data[j];
		data[j]=temp;
	}
}

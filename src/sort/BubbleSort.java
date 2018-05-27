package sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args){
		int[] data = {1,2,7,5,10,3,8};
		bubbleSort(data);
		System.out.println(Arrays.toString(data));
	}

	public static int[] bubbleSort(int[] arr){
		if(arr==null || arr.length==0){
			return arr;
		}
		for(int i=arr.length-1; i>=0; i--){
			for(int j=0; j<i; j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}

	public static int[] bubbleSortOptimizaiton(int[] arr){
		if(arr==null || arr.length==0){
			return arr;
		}
		boolean flag = false;   
		for(int i=arr.length-1; i>=0; i--){
			flag = false;
			for(int j=0; j<i; j++){
				if(arr[j]>arr[j+1]){
					flag = true;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=temp;
				}
			}
			if(flag == false){
				break;
			}
		}
		return arr;
	}
	public static int[] bubbleSortOptimizaitons(int[] arr){
		if(arr==null || arr.length==0){
			return arr;
		}
		int flag = 0;   
		for(int i=arr.length-1; i>=flag; i--){
			flag = arr.length;
			for(int j=0; j<i; j++){
				if(arr[j]>arr[j+1]){
					flag = j;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		return arr;
	}
}

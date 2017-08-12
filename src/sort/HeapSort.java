package sort;

import java.util.Arrays;

public class HeapSort {
	private static boolean flag = true;
	public static void main(String[] args){
		int[] data = {1,2,7,5,10,3,8};
		heapSort(data, data.length);
		if(flag == true){
			System.out.println(Arrays.toString(data));
		}else{
			System.out.println("Data is invalid");
		}		
	}
	public static void heapSort(int[] data, int length){
		if(data==null || length==0){
			flag = false;
			return;
		}
		for(int i=length/2; i>=0; i--){
			heapCore(data, length, i);
		}
		for(int i=length-1; i>0; i--){
			int temp = data[i];
			data[i] = data[0];
			data[0] = temp;
			heapCore(data, i, 0);
		}
	}
	public static void heapCore(int[] data, int length, int parent){
		int child=2*parent+1;
		int temp = data[parent];
		while(child<length){
			if(child+1<length && data[child]<data[child+1]){
				child = child+1;
			}
			if(data[child] <= temp){
				break;
			}
			data[parent]=data[child];
			
			parent = child;
			child = 2*parent+1;
		}
		data[parent]=temp;
	}
}

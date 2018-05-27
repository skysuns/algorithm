package sort;

import java.util.Arrays;

public class HeapSort {
	private static boolean flag = true;
	public static void main(String[] args){
		int[] data = {93,72,48,53,45,30,18,36,15,80};
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
		for(int i=length/2; i>=0; i--){ //<4n
			heapCore(data, length, i);
		}
		for(int i=length-1; i>0; i--){  //<2n*log(n)
			int temp = data[i];
			data[i] = data[0];
			data[0] = temp;
			heapCore(data, i, 0);
		}
	}
	public static void heapCore(int[] data, int length, int parent){  //<2(h-1)
		int child=2*parent+1;
		int temp = data[parent];
		while(child<length){
			if(child+1<length && data[child]>data[child+1]){
				child = child+1;
			}
			if(data[child] >= temp){
				break;
			}
			data[parent]=data[child];

			parent = child;
			child = 2*parent+1;
		}
		data[parent]=temp;
	}
}

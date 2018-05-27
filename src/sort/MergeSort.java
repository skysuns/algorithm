package sort;

import java.util.Arrays;

public class MergeSort {
	private static boolean flag = true;
	public static void main(String[] args){
		int[] data = {1,2,7,5,10,3,8};
		mergeSort(data, data.length);
		if(flag == true){
			System.out.println(Arrays.toString(data));
		}else{
			System.out.println("Data is invalid");
		}
	}
	public static void mergeSort(int[] data, int length){
		if(data==null || length==0){
			flag = false;
			return;
		}
		for(int gap=1; gap<length; gap=2*gap){
			int i=0;
			for(; i+2*gap-1<length; i+=2*gap){
				mergeCore(data, i, i+gap-1, i+2*gap-1);
			}
			if(i+gap-1<length){
				mergeCore(data, i, i+gap-1, length-1);
			}
		}
	}
	public static void mergeCore(int[] data, int low, int mid, int high){
		int i=low;
		int j=mid+1;
		int k=0;
		int[] temp = new int[high-low+1];
		while(i<=mid && j<=high){
			if(data[i]<=data[j]){
				temp[k++]=data[i++];				
			}else{
				temp[k++]=data[j++];
			}
		}
		while(i<=mid){
			temp[k++]=data[i++];
		}
		while(j<=high){
			temp[k++]=data[j++];
		}
		for(i=low, k=0; i<=high; i++, k++){
			data[i]=temp[k];
		}		
	}
}

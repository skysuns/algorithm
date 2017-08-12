package sort;

import java.util.Arrays;

public class SelectedSort {
	private static boolean flag = true;
	public static void main(String[] args){
		int[] data = {1,2,7,5,10,3,8};
		selectedSort(data);
		if(flag == true){
			System.out.println(Arrays.toString(data));
		}else{
			System.out.println("Data is invalid");
		}
	}
	public static void selectedSort(int[] array){
		if(array==null || array.length==0){
			flag = false;
			return;
		}
		for(int i=0; i<array.length-1; i++){
			int k=i;
			for(int j=i+1; j<array.length; j++){
				if(array[k]>array[j]){
					k=j;
				}
			}
			if(k!=i){
				int temp = array[k];
				array[k] = array[i];
				array[i] = temp;
			}
		}
	}
}

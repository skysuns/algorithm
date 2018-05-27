package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.Executors;

public class RadixSort {
	public static void main(String[] args){
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		String s = "";
		s.length();
		int[] count = new int[8];
		count[s.charAt(1)]++;
		int[] data = {1,2,7,5,10,3,8};
		radixSort(data, 0, data.length, 3);
		System.out.println(Arrays.toString(data));
		Executors.newScheduledThreadPool(5);
	}
	
	public static void radixSort(int[] data, int start, int end, int digit){
		int radix = 10;
		int[] count = new int[radix];
		int[] bucket = new int[end-start+1];
		
		for(int d=0; d<digit; d++){
			for(int i=0; i<radix; i++){
				count[i] = 0;
			}			
			for(int i=start; i<end; i++){
				int j = getDigit(data[i], d);
				count[j]++;
			}
			
			for(int i=1; i<radix; i++){
				count[i]=count[i]+count[i-1];
			}
			for(int i=end-1; i>=start; i--){   
				int j=getDigit(data[i], d);
				bucket[count[j]-1] = data[i];
				count[j]--;
			}
			
			for(int i=start, j=0; i<end; i++, j++){
				data[i]=bucket[j];
			}			
		}
	}
	
	public static int getDigit(int data, int d){
		int a[] = {1, 10, 100};
		return ((data/a[d])%10);
	}
}

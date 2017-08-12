package search;

public class BinarySearch {
	public static void main(String[] args){
		int[] array = {1,2,3,4,5,6,7};
		int s = binarySearch(array, 4, 0, array.length);
		int sl = binarySearchLoop(array, 4, 0, array.length);
		System.out.println(s+"ok"+sl);
	}
	
	//�ݹ鷨
	public static int binarySearch(int[] array, int k, int start, int end){
		if(start>end){
			return -1;
		}
		int mid = start+(end-start)/2; //��Ҫ��start+(end-start)>>2,��������stackOverFlow�쳣
		if(array[mid] < k){
			return binarySearch(array, k, mid+1, end);
		}else if(array[mid] > k){
			return binarySearch(array, k, start, mid-1);
		}else{
			return mid;
		}
	}
	
	//ѭ����
	public static int binarySearchLoop(int[] array, int k, int start, int end){
		if(start > end){
			return -1;
		}
		int mid = start+(end-start)/2;
		while(start<=end){
			if(array[mid] < k){
				start = mid+1;
			}else if(array[mid] > k){
				end = mid-1;
			}else{
				return mid;
			}
			mid = start+(end-start)/2;
		}
		return -1;
	}
}

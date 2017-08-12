package test;

public class Test {
	
	public static void main(String[] args){
		int[] arr = {1,2,3,3,3,3,4,5};
		GetNumberOfK(arr, 3);
	}
	public static int GetNumberOfK(int [] array , int k) {
	       if(array==null || array.length==0){
	           return 0;
	       }
	       int start = binarySearchFirst(array, k, 0, array.length-1);
	       int end = binarySearchLast(array, k, 0, array.length-1);
	       System.out.println(start + "" +end);
	       if(start!=-1 && end!=-1){
	           return end-start+1;
	       }
	       return 0;
	    }
	    public static int binarySearchFirst(int[] array, int k, int start, int end){
	        if(start>end){
	            return -1;
	        }
	        int mid = start + (end-start)/2;
	        if(array[mid] > k){
	            return binarySearchFirst(array, k, start, mid-1);
	        }else if(array[mid] < k){
	            return binarySearchFirst(array, k, mid+1, end);
	        }else if(mid-1>=0 && array[mid-1] == k){
	            return binarySearchFirst(array, k, start, mid-1);
	        }else{
	            return mid;
	        }
	    }
	    
	    public static int binarySearchLast(int[] array, int k, int start, int end){
	        if(start>end){
	            return -1;
	        }
	        int mid = (end+start)>>1;
	        if(array[mid] > k){
	            return binarySearchLast(array, k, start, mid-1);
	        }else if(array[mid] < k){
	            return binarySearchLast(array, k, mid+1, end);
	        }else if(mid+1<array.length && array[mid+1] == k){
	            return binarySearchLast(array, k, mid+1, end);
	        }else{
	            return mid;
	        }
	    }
}

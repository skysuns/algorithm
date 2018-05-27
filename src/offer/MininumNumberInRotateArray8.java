package offer;

public class MininumNumberInRotateArray8 {
	public int minNumberInRotateArray(int [] array) {
	    if(array == null || array.length == 0){
	    	return 0;
	    }
	    int start = 0; 
	    int end = array.length-1;
	    int mid = start;
	    while(array[start] >= array[end]){
	    	if(end-start==1){
	    		mid = end;
	    		break;
	    	}
	    	mid = (end+start)/2; //牛客网不支持移位运算符>>2
	    	if(array[start]==array[mid] && array[end]==array[mid]){
	    		return mid = minInOrder(array, start, end);
	    	}
	    	if(array[start] <= array[mid]){ // <=
	    		start = mid;
	    	}
	    	else if(array[mid] <= array[end]){
	    		end = mid;
	    	}
	    }
	    return array[mid];
    }
	public int minInOrder(int[] arr, int start, int end){
		int res = arr[start];
		for(int i= start+1; i<=end; i++){
			if(res>arr[i]){
				res = arr[i];
			}
		}
		return res;
	}
}

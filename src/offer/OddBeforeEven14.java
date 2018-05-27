package offer;

public class OddBeforeEven14 {
	public void reOrderArray(int [] array) {
        if(array==null || array.length==0){
        	return;
        }
        int oddLength = 0;
        int len = array.length;
        for(int i=0; i<len; i++){
        	if((array[i]&0x1) != 0){
        		oddLength++;
        	}
        }
        int[] arr = new int[len];
        int oddIndex = 0, evenIndex = oddLength;
        for(int i=0; i<len; i++){
        	if((array[i]&0x1) != 0){
        		arr[oddIndex++] = array[i];
        	}else{
        		arr[evenIndex++] = array[i];
        	}
        }
        for(int i=0; i<len; i++){
        	array[i]=arr[i];
        }        
    }
}

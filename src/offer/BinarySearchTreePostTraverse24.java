package offer;

public class BinarySearchTreePostTraverse24 {
    public boolean VerifySquenceOfBST(int [] sequence) {
    	if(sequence==null || sequence.length == 0){
    		return false;
    	}
        return isPost(sequence, 0, sequence.length-1);
    }
    public boolean isPost(int[] sequence, int start, int end){
    	if(start >= end){	//start==end��Ӧ����Ҷ�ӽ�㣬start>end��Ӧ���ǿ���
    		return true;
    	}
    	
    	int i = end-1;
    	for(; i>=start; i--){
    		if(sequence[i] < sequence[end]){
    			break;
    		}
    	}
    	
    	for(int j=i; j>=start; j--){
    		if(sequence[j] >sequence[end]){
    			return false;
    		}
    	}
    	
    	return isPost(sequence, start,i) && isPost(sequence, i+1, end-1);
    }
}

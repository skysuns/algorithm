package offer;

public class Rectangle9 {
    public int RectCover(int target) {
    	
    	if(target<=2){
    		return target;
    	}
    	int pre1Rect = 2;
    	int pre2Rect = 1;
    	int res = 0;
    	for(int i=3; i<=target; i++){
    		if(Integer.MAX_VALUE < pre1Rect + pre2Rect){
    			return Integer.MAX_VALUE;
    		}
    		res = pre1Rect + pre2Rect;
    		pre1Rect = pre2Rect;
    		pre2Rect = res;    		
    	}
    	return res;		
    }
}

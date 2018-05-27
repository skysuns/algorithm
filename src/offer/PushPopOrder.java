package offer;

import java.util.Stack;

public class PushPopOrder {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	if(pushA==null || popA==null || pushA.length == 0 || popA.length == 0){
    		return false;
    	}
        boolean flag = true;
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for(int i=0; i<popA.length; i++){
        	while(stack.empty() || stack.peek()!= popA[i]){
        		if(j==pushA.length){
        			break;
        		}
        		stack.push(pushA[j++]);
        	}
        	if(popA[i] == stack.peek()){
        		stack.pop();
        	}else{
        		flag = false;
        		break;
        	}
        }
        return flag;
    }
}

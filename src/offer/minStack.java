package offer;

import java.util.Stack;

public class minStack {	
	private boolean flag = true;
	Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> min = new Stack<Integer>();
	public void push(int node) {
        data.push(node);
        if(min.empty() || node < min()){
        	min.push(node);
        }else{
        	min.push(min());
        }
    }	 	
	    
	public void pop() {
		if(!data.empty() && !min.empty()){
			min.pop();
			data.pop();
		}
	}  		    
	    
	public int min() {
		if(!data.empty() && !min.empty()){
			flag = true;
			return min.peek();
		}	
		flag = false;
		return 0;   
	}	    	   
}

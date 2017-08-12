package offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintLinkedList5 {
	class ListNode {
	       int val;
	       ListNode next = null;
	
	       ListNode(int val) {
	           this.val =val;
	       }
	}
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
		ArrayList<Integer> list = new ArrayList<Integer>();
		LinkedList<Integer> linked = new LinkedList<Integer>();
		while(listNode != null){
			linked.push(listNode.val);
			listNode = listNode.next;
		}
		while(!linked.isEmpty()){
			list.add(linked.pop());
		}
		return list;
	}
}

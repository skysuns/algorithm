package offer;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class LinkedListCopy {
    public RandomListNode Clone(RandomListNode pHead)
    {
       if(pHead == null){
           return null;
       } 
       
       RandomListNode current = pHead;
       while(current != null){
           RandomListNode newCurrent = new RandomListNode(current.label);
           RandomListNode next = current.next;
           newCurrent.next = next;
           current.next = newCurrent;           
           current = next;
       }
        
       current = pHead; 
       while(current != null){
           if(current.random != null){
               RandomListNode random = current.random;
               RandomListNode randomNew = random.next;
               RandomListNode currentNew = current.next;
               currentNew.random = randomNew;
           }
           current = current.next.next;
       }
       
       current = pHead; 
       RandomListNode headNew = pHead.next;
       RandomListNode currentNew = headNew;
       while(current != null){           
           current.next = current.next.next;
           if(currentNew.next != null){
               currentNew.next = currentNew.next.next;
           } 
           current = current.next;
           currentNew = currentNew.next;
       }
       return headNew;
    }
}

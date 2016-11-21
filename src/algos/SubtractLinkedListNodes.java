package algos;

/**
 * 
 *  Given a singly linked list, modify the value of first half nodes such that :

	1st node’s new value = the last node’s value - first node’s current value
	2nd node’s new value = the second last node’s value - 2nd node’s current value
	
	Example :

	Given linked list 1 -> 2 -> 3 -> 4 -> 5,

	You should return 4 -> 2 -> 3 -> 4 -> 5
 * 
 *
 */
public class SubtractLinkedListNodes {
	 	class ListNode {
		      public int val;
		      public ListNode next;
		      ListNode(int x) { val = x; next = null; }
		  }
	public ListNode subtract(ListNode a) {
	    ListNode slow =a;
	    ListNode fast=a;
	    

	    ListNode head = a;

	    ListNode middle = null;

	    while(fast!=null && fast.next!=null)
	        {

                if(fast.next.next!=null) // in case numOfNodes are even , we need to stay at middle
	                slow=slow.next;
	            fast = fast.next.next;
	            
	        }
	   if(slow==fast)
	        return a;
	        
	   middle = slow; 
	   ListNode secondHalf = middle.next;
	   middle.next = null;
	   
	   ListNode reversed = reverse(secondHalf);
	  
	   ListNode  temp1  = reversed;
	   
	   while(temp1!=null ){
	       head.val = temp1.val - head.val;
	       temp1 = temp1.next;
	       head = head.next;
	   }
	   
	   middle.next = reverse(reversed);
	   
	   
	   return a;
	            
	}
	
	
	public ListNode reverse(ListNode head){
		ListNode current = head;
		ListNode previous = null;
		
		while(current!=null) {
			ListNode temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
			
		}
		
		return previous;
	}
}

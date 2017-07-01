import java.util.*;


public class ExchangeLinkedList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode swapNodes(ListNode head,int k){
		ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start, newstart = start;
	    slow.next = head;
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=k+1; i++)   {
	    	if(i<k) newstart = newstart.next;
	        fast = fast.next;
	    }
	    System.out.println("fast:"+ fast.val);
	    
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    System.out.println("slow:"+ slow.val);
	    System.out.println("newstart:"+ newstart.val);

	    ListNode temp2 = slow.next;
	    System.out.println("temp2:"+ temp2.val);
	    
	    ListNode temp2next = slow.next.next;
	    System.out.println("temp2next:"+ temp2next.val);
	    ListNode temp1 = newstart.next;
	    System.out.println("temp1:"+ temp1.val);
	    ListNode temp1next = newstart.next.next;
	    System.out.println("temp1next:"+ temp1next.val);
	    if(newstart!=temp2 && slow!=temp1){
	    newstart.next = temp2;
	    temp2.next = temp1next;
	    slow.next = temp1;
	    temp1.next = temp2next;
	    }
	    else{
	    	if(newstart==temp2){
	    		slow.next = temp1;
	    		temp1.next = temp2;
	    		temp2.next = temp1next;
	    	}
	    	else{
	    		newstart.next = temp2;
	    		temp2.next = temp1;
	    		temp1.next = temp2next;
	    	}
	    }
	    return start.next;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExchangeLinkedList obj = new ExchangeLinkedList();
		ListNode node1 = obj.new ListNode(1);
		ListNode node2 = obj.new ListNode(2);
		ListNode node3 = obj.new ListNode(3);
		ListNode node4 = obj.new ListNode(4);
		ListNode node5 = obj.new ListNode(5);
		ListNode node6 = obj.new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		ListNode root = obj.swapNodes(node1, 3);
		while(root!=null){
			System.out.println(root.val);
			root=root.next;
		}
	}

}

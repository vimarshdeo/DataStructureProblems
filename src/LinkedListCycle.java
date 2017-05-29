import java.util.*;

public class LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public boolean hasCycle(ListNode head) {
		if(head==null || head.next==null) return false;
		if(head.next==head) return true;
		ListNode slow = head, fast = head;
		while(fast.next!=null && fast.next.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast) break;
		}
		if(slow==fast) return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListCycle obj = new LinkedListCycle();
		ListNode node1 = obj.new ListNode(1);
		ListNode node2 = obj.new ListNode(2);
		ListNode node3 = obj.new ListNode(3);
		ListNode node4 = obj.new ListNode(4);
		ListNode node5 = obj.new ListNode(5);
		ListNode node6 = obj.new ListNode(6);
		ListNode node7 = obj.new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node2;
		System.out.println(obj.hasCycle(node1));
	}

}

import java.util.*;

public class PalindromeLinkedList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public boolean isPalindrome(ListNode head) {
		if(head==null || head.next==null) return true;
		ListNode slow = head, fast = head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast!=null){
			slow = slow.next;
		}
		ListNode temp2 = reverse(slow);
		ListNode temp1 = head;
		while(temp1!=null  && temp2!=null){
			if(temp1.val!=temp2.val){
				return false;
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		
		return true;
	}
	public ListNode reverse(ListNode cur){
		ListNode prev = null;
		while(cur!=null){
			ListNode temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeLinkedList obj = new PalindromeLinkedList();
		ListNode head1 = obj.new ListNode(1);
		ListNode node1 = obj.new ListNode(2);
		head1.next  = node1;
		ListNode node2 = obj.new ListNode(3);
		ListNode node3 = obj.new ListNode(4);
		ListNode node31 = obj.new ListNode(5);
		ListNode node4 = obj.new ListNode(4);
		ListNode node5 = obj.new ListNode(3);
		ListNode node6 = obj.new ListNode(2);
		ListNode node7 = obj.new ListNode(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node31;
		node31.next  = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		System.out.println(obj.isPalindrome(head1));
	}

}

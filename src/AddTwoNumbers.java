import java.util.*;


public class AddTwoNumbers {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		int sum = 0;
		ListNode dummy = new ListNode(0);
		ListNode prev = dummy;
		int carry = 0;
		while(l1!=null || l2!=null || carry!=0){
			ListNode temp = new ListNode(0);
			sum = (l1!=null?l1.val:0)+(l2!=null?l2.val:0)+carry;
			temp.val = sum%10;
			carry = sum/10;
			prev.next = temp;
			prev = prev.next;
			
			if(l1!=null) l1 = l1.next;
			if(l2!=null) l2 = l2.next;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddTwoNumbers obj = new AddTwoNumbers();
		ListNode head1 = obj.new ListNode(1);
		ListNode node1 = obj.new ListNode(7);
		head1.next  = node1;
		ListNode head2 = obj.new ListNode(9);
		ListNode node21 = obj.new ListNode(4);
		ListNode node22 = obj.new ListNode(9);
		ListNode node2 = obj.new ListNode(8);
		ListNode node3 = obj.new ListNode(3);
		//ListNode node4 = obj.new ListNode(4);
		//ListNode node5 = obj.new ListNode(5);
		//ListNode node6 = obj.new ListNode(6);
		//ListNode node7 = obj.new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		//node3.next = node4;
		//node4.next = node5;
		//node5.next = node6;
		//node6.next = node7;
		//node7.next = node2;
		head2.next = node21;
		node21.next = node22;
		node22.next = node2;
		ListNode res = obj.addTwoNumbers(head1, head2);
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}
	}

}

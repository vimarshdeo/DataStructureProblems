import java.util.*;

public class MergeTwoLists {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<l2.val){
			l1.next = mergeTwoLists(l1.next,l2);
			return l1;
		}
		else{
			l2.next = mergeTwoLists(l1,l2.next);
			return l2;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeTwoLists obj = new MergeTwoLists();
		ListNode head1 = obj.new ListNode(0);
		ListNode head2 = obj.new ListNode(1);
		ListNode node1 = obj.new ListNode(2);
		ListNode node11 = obj.new ListNode(4);
		ListNode node2 = obj.new ListNode(3);
		ListNode node21 = obj.new ListNode(7);
		head1.next = node1;
		node1.next = node11;
		head2.next = node2;
		node2.next = node21;
		ListNode res = obj.mergeTwoLists(head1, head2);
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}
	}

}

import java.util.*;

public class ReverseLinkedList {
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; next = null; }
	}
	public ListNode reverseList(ListNode head) {
		if(head==null || head.next==null) return head;
		ListNode prev = null;
		ListNode cur = head;
		ListNode temp;
		while(cur!=null){
			temp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLinkedList obj = new ReverseLinkedList();
		ListNode node1 = obj.new ListNode(1);
		ListNode node2 = obj.new ListNode(2);
		ListNode node3 = obj.new ListNode(3);
		ListNode node4 = obj.new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		ListNode res = obj.reverseList(node1);
		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}
	}

}

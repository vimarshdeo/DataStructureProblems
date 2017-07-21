import java.util.*;

public class AddOneLinkedList {
	public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
	}
	public static ListNode plusOne(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode i = dummy;
		ListNode j = dummy;
		while(j.next!=null){
			j = j.next;
			if(j.val!=9){
				i = j;
			}
		}
		if(j.val!=9){
			j.val++;
		}
		else{
			i.val++;
			i = i.next;
			while(i!=null){
				i.val=0;
				i = i.next;
			}
		}
		if(dummy.val==0) return dummy.next;
		return dummy;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddOneLinkedList obj = new AddOneLinkedList();
			ListNode node1 = new ListNode(9);
			ListNode node2 = new ListNode(9);
			ListNode node3 = new ListNode(9);
			node1.next = node2;
			node2.next = node3;
			ListNode res = obj.plusOne(node1);
			while(res!=null){
				System.out.println(res.val);
				res = res.next;
			}
	}

}

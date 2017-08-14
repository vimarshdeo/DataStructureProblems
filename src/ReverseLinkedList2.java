import java.util.*;


public class ReverseLinkedList2 {
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
			next = null;
		}
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		for(int i=0;i<m-1;i++){
			pre = pre.next;
		}
		ListNode start = pre.next;
		ListNode then = start.next;
		for(int i=0;i<n-m;i++){
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode obj1 = new ListNode(1);
		ListNode obj2 = new ListNode(2);
		ListNode obj3 = new ListNode(3);
		ListNode obj4 = new ListNode(4);
		ListNode obj5 = new ListNode(5);
		obj1.next = obj2;
		obj2.next = obj3;
		obj3.next = obj4;
		obj4.next = obj5;
		ReverseLinkedList2 obj = new ReverseLinkedList2();
		
		ListNode head = obj.reverseBetween(obj1, 1, 4);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}

}

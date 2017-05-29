import java.util.*;



public class IntersectionLinkedList {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int length1 = getlength(headA);
		int length2 = getlength(headB);
		if(length1<length2){
			while(length2!=length1){
				headB = headB.next;
				length2--;
			}
		}
		else if(length1>length2){
			while(length1!=length2){
				headA = headA.next;
				length1--;
			}
		}
		while(headA!=null){
			if(headA==headB){
				return headA;
			}
			headA = headA.next;
			headB = headB.next;
		}
		return null;
	}
	public int getlength(ListNode head){
		if(head==null) return 0;
		int count = 0;
		while(head!=null){
			count++;
			head = head.next;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntersectionLinkedList obj = new IntersectionLinkedList();
		ListNode head1 = obj.new ListNode(1);
		ListNode node1 = obj.new ListNode(1);
		head1.next  = node1;
		ListNode head2 = obj.new ListNode(10);
		ListNode node21 = obj.new ListNode(20);
		ListNode node22 = obj.new ListNode(30);
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
		//node7.next = node2;
		head2.next = node21;
		node21.next = node22;
		node22.next = node2;
		ListNode ans = obj.getIntersectionNode(head1, head2);
		System.out.println(ans.val);
	}

}

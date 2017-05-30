import java.util.*;

public class MergeKSortedLists {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists==null || lists.length==0) return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
			@Override
			public int compare(ListNode ob1, ListNode ob2){
				return ob1.val-ob2.val;
			}
		});
		for(ListNode temp:lists){
			pq.add(temp);
		}
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while(!pq.isEmpty()){
			ListNode temp = pq.poll();
			cur.next = temp;
			cur = cur.next;
			if(cur.next!=null){
				pq.add(cur.next);
			}
		}
		return dummy.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeKSortedLists obj = new MergeKSortedLists();
		ListNode head1 = obj.new ListNode(0);
		ListNode head2 = obj.new ListNode(1);
		ListNode head3 = obj.new ListNode(2);
		ListNode node1 = obj.new ListNode(3);
		ListNode node2 = obj.new ListNode(4);
		ListNode node3 = obj.new ListNode(5);
		ListNode node4 = obj.new ListNode(6);
		ListNode node5 = obj.new ListNode(7);
		ListNode node6 = obj.new ListNode(8);
		head1.next = node1;
		node1.next = node3;
		
		head2.next = node2;
		node2.next = node6;
		
		head3.next = node4;
		node4.next = node5;
		
		ListNode[] lists = {head1,head2,head3};
		ListNode res = obj.mergeKLists(lists);

		while(res!=null){
			System.out.println(res.val);
			res = res.next;
		}
	}
}

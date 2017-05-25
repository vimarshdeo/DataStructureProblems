import java.util.*;

public class DeepCopylist {
	class RandomListNode {
	    int label;
	    RandomListNode next, random;
	    RandomListNode(int x) { this.label = x; }
	};
	public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head;
        while(iter!=null){
        	RandomListNode temp = new RandomListNode(iter.label);
        	temp.next = iter.next;
        	iter.next = temp;
        	iter = iter.next.next;
        }
        iter=head;
        while(iter!=null){
        	iter.next.random = iter.random.next;
        	iter = iter.next.next;
        }
        RandomListNode pseudo = new RandomListNode(0);
        RandomListNode temp = pseudo;
        iter = head;
        while(iter!=null){
        	temp.next = iter.next;
        	temp = temp.next;
        	iter.next = iter.next.next;
        	iter = iter.next;
        }
        return pseudo.next;
    }
	public static void main(String[] args) {
		DeepCopylist obj = new DeepCopylist();
		RandomListNode node = obj.new RandomListNode(1);
		RandomListNode node1 = obj.new RandomListNode(2);
		RandomListNode node2 = obj.new RandomListNode(3);
		RandomListNode node3 = obj.new RandomListNode(4);
		RandomListNode node4 = obj.new RandomListNode(5);
		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = null;
		node.random = node4;
		node1.random = node3;
		node2.random = node;
		node3.random = node1;
		node4.random = node2;
		RandomListNode res = obj.copyRandomList(node);
		while(res!=null){
			System.out.println(res.label);
			res = res.next;
		}
	}

}

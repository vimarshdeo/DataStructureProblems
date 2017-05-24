import java.util.*;

public class LfuCache {
	private HashMap<Integer,Integer> map = null;
	private HashMap<Integer, Node> hmap = null;
	private Node head = null;
	private int cap = 0;
	public LfuCache(int capacity) {
		cap = capacity;
		map = new HashMap<Integer, Integer>();
		hmap = new HashMap<Integer, Node>();
	}
	public int get(int key) {
		if(map.containsKey(key)){
			increaseCount(key);
			return map.get(key);
		}
		return -1;
	}
	public void put(int key, int value) {
		if(cap==0) return;
		if(map.containsKey(key)){
			map.put(key, value);
		}
		else{
			if(map.size()<cap){
				map.put(key, value);
			}
			else{
				removeOld();
				map.put(key, value);
			}
			addToHead(key);
		}
		increaseCount(key);
	}
	public void addToHead(int key){
		if(head==null){
			head = new Node(0);
			head.set.add(key);
		}
		else{
			if(head.count==0){
				head.set.add(key);
			}
			else{
				Node temp = new Node(0);
				temp.set.add(key);
				temp.next = head;
				head.prev = temp;
				head = temp;
			}
		}
		hmap.put(key, head);
	}
	public void increaseCount(int key){
		Node node = hmap.get(key);
		node.set.remove(key);
		if(node.next == null){
			node.next = new Node(node.count+1);
			node.next.set.add(key);
			node.next.prev = node;
		}
		else if(node.next.count==node.count+1){
			node.next.set.add(key);
		}
		else{
			Node temp = new Node(node.count+1);
			temp.set.add(key);
			temp.next = node.next;
			node.next.prev = temp;
			node.next = temp;
			temp.prev = node;
		}
		hmap.put(key, node.next);
		if(node.set.size()==0) removeNode(node);
	}
	
	public void removeOld(){
		if(head==null){
			return;
		}
		int old = 0;
		for(int temp:head.set){
			old = temp;
			break;
		}
		map.remove(old);
		hmap.remove(old);
		head.set.remove(old);
		if(head.set.size()==0){
			removeNode(head);
		}
	}
	public void removeNode(Node temp){
		if(temp.prev==null){
			head = temp.next;
			head.prev = null;
		}
		else{
			temp.prev.next = temp.next;
			if(temp.next!=null){
				temp.next.prev = temp.prev;
			}
		}
	}
	public class Node{
		public int count =0;
		public LinkedHashSet<Integer> set = null;
		Node prev,next;
		public Node(int c){
			count = c;
			set = new LinkedHashSet<Integer>();
			prev=next=null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LfuCache obj = new LfuCache(2);
		obj.put(1,1);
		System.out.println(obj.get(1));
		obj.put(2, 2);
		System.out.println(obj.get(2));
		obj.put(3, 3);
		System.out.println(obj.get(1));
	}

}

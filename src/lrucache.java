import java.util.*;

public class lrucache {
	public static class DoubleList{
	public
		int key;
		int value;
		DoubleList next;
		DoubleList prev;
	}
	DoubleList head;
	DoubleList tail;
	int capacity;
	int count;
	HashMap<Integer, DoubleList> map;
	public lrucache(int capacity) {
		head = new DoubleList();
		tail = new DoubleList();
		map = new HashMap<Integer,DoubleList>();
		this.capacity = capacity;
		head.next = tail;
		tail.prev = head;
		head.prev = null;
		tail.next = null;
		count=0;
	}
	private void addnode(DoubleList node){
		node.next = head.next;
		head.next.prev = node;
		node.prev = head;
		head.next = node;
	}
	private void movetohead(DoubleList node){
		DoubleList temp = node;
		node = head.next;
		head.next = temp;
	}
	private void removenode(DoubleList node){
		DoubleList pre = node.prev;
		DoubleList nex = node.next;
		pre.next = nex;
		nex.prev = pre;
	}
	private int poptail(){
		DoubleList node = tail.prev;
		removenode(node);
		return node.key;
	}
	public int get(int key) {
		if(map.containsKey(key)){
			DoubleList temp = map.get(key);
			this.movetohead(temp);
			return temp.value;
		}
		else{
			return -1;
		}
	}
	public void put(int key, int value) {
		DoubleList val = map.get(key);
		if(val==null){
			DoubleList node = new DoubleList();
			node.key = key;
			node.value = value;
			this.addnode(node);
			map.put(key, node);
			count++;
			while(count>capacity){
				int keytoremove = this.poptail();
				map.remove(keytoremove);
				count--;
			}
		}
		else{
			val.value = value;
			this.movetohead(val);
		}
	}
	public static void main(String[] args) {
		/*DoubleList node = new DoubleList();
		node.key = 1;
		node.value = 34;*/
		lrucache obj = new lrucache(5);
		obj.put(1,34);
		System.out.println(obj.get(1));
		obj.put(2,56);
		obj.put(3, 78);
		obj.put(4,65);
		obj.put(5,43);
		obj.put(6,32);
		System.out.println(obj.get(1));
		System.out.println(obj.get(2));
		System.out.println(obj.get(3));
		System.out.println(obj.get(4));
		System.out.println(obj.get(5));
		System.out.println(obj.get(6));
	}

}

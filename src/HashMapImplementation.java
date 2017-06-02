import java.util.*;

public class HashMapImplementation<K,V> {
	static class Entry<K,V>{
		K key;
		V value;
		Entry<K,V> prev;
		Entry<K,V> next;
		public Entry(K key, V value){
			this.key = key;
			this.value = value;
			prev = next = null;
		}	
	}
	protected ArrayList<Entry<K,V>> table;
	public HashMapImplementation(int capacity){
		table = new ArrayList<Entry<K,V>>();
		for(int i = 0;i<capacity;i++){
			table.add(null);
		}
	}
	public void put(K key, V value) {
		Entry<K,V> node = getNodeforKey(key);
		if(node!=null){
			node.value = value;
			return;
		}
		Entry<K,V> temp = new Entry<K, V>(key,value);
		int hashindex = getHashIndex(key);
		Entry<K,V> temp1 = table.get(hashindex);
		if(temp1!=null){
			temp.next = table.get(hashindex);
			temp.next.prev = temp;
		}
		table.set(hashindex, temp);
	}
	public V get(K key) {
		Entry<K,V> node = getNodeforKey(key);
		return (node==null?null:node.value);
	}
	private Entry<K,V> getNodeforKey(K key){
		int hashindex = getHashIndex(key);
		Entry<K,V> node = table.get(hashindex);
		while(node!=null){
			if(node.key==key){
				return node;
			}
			node = node.next;
		}
		return null;
	}
	public void remove(K key) {
		Entry<K,V> node = getNodeforKey(key);
		if(node!=null){
			if(node.prev!=null){
				node.prev.next = node.next;
				
			}
			else{
				int hashindex = getHashIndex(key);
				table.set(hashindex, node.next);
			}
			if(node.next!=null){
				node.next.prev = node.prev;
			}
		}
	}
	public void printMap(){
		for(int i = 0;i<table.size();i++){
			System.out.print("{");
			Entry<K,V> node = table.get(i);
			while(node!=null){
				System.out.print("("+node.key+"-"+node.value+"), ");
				node = node.next;
			}
			System.out.println("}");
		}
	}
	private int getHashIndex(K Key){
		return Math.abs(Key.hashCode()%table.size());
	}
	public static void main(String[] args) {
		HashMapImplementation<Integer, Integer> map = new HashMapImplementation<>(10);
        map.put(5,15);
        map.put(6, 20);
        map.put(16, 21);
        map.put(11, 25);
        map.put(1, 26);
        map.put(1, 27);
        map.put(4, 18);
        map.put(9, 1);
        map.put(7, 8);
        map.put(17, 28);
        //System.out.println(map.get(16));
        //System.out.println(map.toString());
        System.out.println("Initial Map : ");
        map.printMap();
        int keyToRemove = 1;
        System.out.println("Removing entry with key " + keyToRemove);
        map.remove(keyToRemove);
        System.out.println("After Removing entry with key " + keyToRemove);
        map.printMap();

        keyToRemove = 11;
        System.out.println("Removing entry with key " + keyToRemove);
        map.remove(keyToRemove);
        System.out.println("After Removing entry with key " + keyToRemove);
        map.printMap();

        int keyToAddd = 101;
        System.out.println("After adding an entry with key " + keyToAddd);
        map.put(keyToAddd, 1);
        map.printMap();

	}

}

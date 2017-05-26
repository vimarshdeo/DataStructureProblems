import java.util.*;

public class InsertGetRandom {
	private List<Integer> list;
	private HashMap<Integer, Integer> map;
	private Random random;
	public InsertGetRandom() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer,Integer>();
		random = new Random();
	}
	public boolean insert(int val) {
		if(map.containsKey(val)){
			return false;
		}
		map.put(val, list.size());
		list.add(val);
		return true;
	}
	public boolean remove(int val) {
		if(!map.containsKey(val)) return false;
		int pos = map.get(val);
		if(pos!=list.size()-1){
			int newval = list.get(list.size()-1);
			list.set(list.size()-1,val);
			list.set(pos, newval);
			map.put(newval, pos);
		}
		list.remove(list.size()-1);
		map.remove(val);
		return true;
	}
	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertGetRandom obj = new InsertGetRandom();
		System.out.println(obj.insert(1));
		System.out.println(obj.insert(2));
		System.out.println(obj.insert(3));
		System.out.println(obj.insert(4));
		System.out.println(obj.insert(5));
		System.out.println(obj.insert(1));
		System.out.println(obj.remove(1));
		System.out.println(obj.remove(1));
		System.out.println(obj.remove(5));
		System.out.println(obj.getRandom());
		System.out.println(obj.getRandom());
	}

}

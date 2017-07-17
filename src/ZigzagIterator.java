import java.util.*;

public class ZigzagIterator {
	private List<Integer> list1;
	private List<Integer> list2;
	int list1index;
	int list2index;
	int flag;
	public ZigzagIterator(List<Integer> list1, List<Integer> list2){
		this.list1 = list1;
		this.list2 = list2;
		list1index = 0;
		list2index = 0;
		flag = 0;
	}
	public int next(){
		int result = 0;
		if(list1index==list1.size()){
			result = list2.get(list2index++);
		}
		else if(list2index==list2.size()){
			result = list1.get(list1index++);
		}
		else{
			if(flag==0){
				result = list1.get(list1index++);
				flag = 1;
			}
			else{
				result = list2.get(list2index++);
				flag = 0;
			}
		}
		return result;
	}
	public boolean hasNext(){
		return (list1index<list1.size()?true:false)||(list2index<list2.size()?true:false);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		list1.add(7);
		ZigzagIterator obj = new ZigzagIterator(list1,list2);
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		System.out.println(obj.next());
		System.out.println(obj.hasNext());
		//System.out.println(obj.next());
		
		
	}

}

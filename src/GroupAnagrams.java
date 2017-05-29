import java.util.*;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		HashMap<String,List<String>> map = new HashMap<>();
		if(strs==null || strs.length==0) return res;
		Arrays.sort(strs);
		for(String s:strs){
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			String str = new String(temp);
			if(!map.containsKey(str)){
				map.put(str, new ArrayList<String>());
			}
			map.get(str).add(s);
 		}
		
			res.addAll(map.values());
			return res;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupAnagrams obj = new GroupAnagrams();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = obj.groupAnagrams(strs);
		for(List<String> temp:res){
			System.out.println(".................");
			for(String s:temp)
				System.out.println(s);
		}
	}

}

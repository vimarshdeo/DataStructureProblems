import java.util.*;
	
public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<>();
		if(strings==null || strings.length==0) return res;
		HashMap<String,List<String>> map = new HashMap<>();
		for(String str:strings){
			int offset= str.charAt(0)-'a';
			System.out.println("String: "+str);
			System.out.println("offset: "+offset);
			StringBuilder s = new StringBuilder();
			for(int i=0;i<str.length();i++){
				char c = (char)(str.charAt(i)-offset);
				if(c<'a'){
					c += 26;
				}
				System.out.println("c: "+c);
				s.append(c);
			}
			String s1 = s.toString();
			if(!map.containsKey(s1)){
				map.put(s1, new ArrayList<String>());
			}
			map.get(s1).add(str);
		}
		for(String s:map.keySet()){
			List<String> list = map.get(s);
			Collections.sort(list);
			res.add(list);
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupShiftedStrings obj = new GroupShiftedStrings();
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		List<List<String>> res  =obj.groupStrings(strings);
		for(List<String> list:res){
			System.out.println("next list");
			System.out.println(list.toString());
		}
	}

}

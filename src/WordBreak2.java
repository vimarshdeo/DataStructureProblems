import java.util.*;

public class WordBreak2 {
	HashMap<String,List<String>> map = new HashMap<>();
	public List<String> wordBreak(String s, List<String> wordDict) {
		if(map.containsKey(s)) return map.get(s);
		List<String> list = new ArrayList<>();
		if(s.length()==0 || s==null){
			String str = "";
			list.add(str);
			return list;
		}
		for(String word:wordDict){
			if(s.startsWith(word)){
				List<String> sublist = wordBreak(s.substring(word.length()),wordDict);
				for(String str:sublist){
					list.add(word+(str.isEmpty()?"":(" "+str)));
				}
			}
		}
		map.put(s, list);
		return list;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak2 obj = new WordBreak2();
		List<String> wordDict = new ArrayList<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		for(String s:obj.wordBreak("catsanddog", wordDict)){
			System.out.println(s);
		}
	}

}

import java.util.*;

public class WordSquare {
	TrieNode root = new TrieNode();
	public class TrieNode{
		List<String> list = new ArrayList<>();
		TrieNode[] next = new TrieNode[26];
	}
	public void buildtree(String[] words){
		for(String s:words){
			TrieNode temp = root;
			for(char c:s.toCharArray()){
				temp.list.add(s);
				if(temp.next[c-'a']==null){
					temp.next[c-'a'] = new TrieNode();
				}
				temp = temp.next[c-'a'];
			}
			temp.list.add(s);
		}
	}
	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> res = new ArrayList<>();
		if(words.length==0 || words==null || words[0].length()==0) return res;
		buildtree(words);
		recursivesearch(res,words[0].length(),new ArrayList<>());
		return res;
	}
	
	public void recursivesearch(List<List<String>> res, int len, List<String> ans){
		if(ans.size()==len){
			res.add(new ArrayList<>(ans));
			return;
		}
		int index = ans.size();
		StringBuilder str = new StringBuilder();
		for(String s:ans){
			str.append(s.charAt(index));
		}
		String s = str.toString();
		TrieNode temp = root;
		for(int i=0;i<s.length();i++){
			if(temp.next[s.charAt(i)-'a']!=null){
				temp = temp.next[s.charAt(i)-'a'];
			}
			else{
				temp = null;
				break;
			}
		}
		if(temp!=null){
			for(String s1:temp.list){
				ans.add(s1);
				recursivesearch(res,len,ans);
				ans.remove(ans.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSquare obj = new WordSquare();
		String[] words = {"area","lead","wall","lady","ball"};
		List<List<String>> res = obj.wordSquares(words);
		for(List<String> list:res){
			System.out.println("[");
			for(String s:list){
				System.out.println(s);
			}
			System.out.println("]");
		}
	}

}

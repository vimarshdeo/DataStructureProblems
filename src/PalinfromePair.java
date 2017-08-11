import java.util.*;

public class PalinfromePair {
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		if(words==null || words.length==0 || words[0].length()==0) return res;
		HashMap<String,Integer> map = new HashMap<>();
		for(int i=0;i<words.length;i++) map.put(words[i], i);
		for(int i=0;i<words.length;i++){
			for(int j=0;j<=words[i].length();j++){
				String left = words[i].substring(0, j);
				String right = words[i].substring(j);
				if(ispalindrome(left)){
					String rightrev = new StringBuilder(right).reverse().toString();
					if(map.containsKey(rightrev)&&map.get(rightrev)!=i){
						res.add(Arrays.asList(map.get(rightrev),i));
					}
				}
				if(ispalindrome(right)){
					String leftrev = new StringBuilder(left).reverse().toString();
					if(map.containsKey(leftrev)&&map.get(leftrev)!=i&&right.length()!=0){
						res.add(Arrays.asList(i,map.get(leftrev)));
					}
				}
			}
		}
		return res;
	}
	public boolean ispalindrome(String s){
		int i=0;
		int j=s.length()-1;
		while(i<j){
			if(s.charAt(i++)!=s.charAt(j--)) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalinfromePair obj = new PalinfromePair();
		String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
		List<List<Integer>> res = obj.palindromePairs(words);
		for(List<Integer> l:res){
			System.out.println(l.toString());
		}
	}

}

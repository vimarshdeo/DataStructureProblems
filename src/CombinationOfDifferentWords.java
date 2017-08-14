import java.util.*;

public class CombinationOfDifferentWords {
	public List<String> CombinationDif(String[] strs){
		List<String> res = new ArrayList<>();
		if(strs==null || strs.length==0) return res;
		helper(strs,res,new StringBuilder(""), 0);
		return res;
		
	}
	public void helper(String[] strs, List<String> res, StringBuilder s, int wordindex ){
		if(s.length()==strs.length){
			res.add(s.toString());
			return;
		}
		for(int i = 0;i<strs[wordindex].length();i++){
			s.append(strs[wordindex].charAt(i));
			helper(strs,res,s,wordindex+1);
			s.deleteCharAt(s.length()-1);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CombinationOfDifferentWords obj = new CombinationOfDifferentWords();
		String[] strs = {"abc","def","gh"};
		List<String> res = obj.CombinationDif(strs);
		for(String s:res)
			System.out.println(s);
	}

}

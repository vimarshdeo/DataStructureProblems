import java.util.*;

public class PalindromePartioning {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		if(s==null || s.length()==0) return res;
		helper(s,0,res,new ArrayList<String>());
		return res;
	}
	public void helper(String s, int pos, List<List<String>> res, List<String> list){
		if(pos==s.length()){
			res.add(new ArrayList<>(list));
			return;
		}
		for(int i=pos;i<s.length();i++){
			if(ispalindrome(s.substring(pos, i+1))){
				list.add(s.substring(pos,i+1));
				helper(s,i+1,res,list);
				list.remove(list.size()-1);
			}
		}
	}
	public boolean ispalindrome(String s){
		int start = 0;
		int end = s.length()-1;
		while(start<end){
			if(s.charAt(start++)!=s.charAt(end--)) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartioning obj = new PalindromePartioning();
		String s = "aab";
		List<List<String>> res= obj.partition(s);
		for(List<String> list:res){
			System.out.println(list.toString());
		}
	}

}

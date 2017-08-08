import java.util.*;

public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		if(word==null || word.length()==0) return res;
		helper(res,word,"",0,0);
		return res;
	}
	private void helper(List<String> res,String word, String ans, int pos, int count){
		if(pos==word.length()){
			if(count>0) ans += count;
			res.add(ans);
		}
		else{
			helper(res,word,ans,pos+1,count+1);
			helper(res,word,ans+(count>0?count:"")+word.charAt(pos),pos+1,0);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralizedAbbreviation obj = new GeneralizedAbbreviation();
		List<String> res = obj.generateAbbreviations("word");
		for(String s:res){
			System.out.println(s);
		}
	}

}

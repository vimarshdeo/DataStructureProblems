import java.util.*;

public class ValidWordSquare {
	public boolean validwordsquare(String[] words){
		if(words.length==0 || words[0].length()==0 || words==null) return true;
		for(int i =0;i<words.length;i++){
			for(int j=0;j<words[i].length();j++){
				if(i>=words[j].length() || j>=words[i].length() || words[i].charAt(j)!=words[j].charAt(i)){
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"abcd","bnrt","crm","dt"};
		ValidWordSquare obj = new ValidWordSquare();
		
		System.out.println(obj.validwordsquare(arr));
	}

}

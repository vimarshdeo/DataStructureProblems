import java.util.*;

public class WildCardMatching {
	public boolean isMatch(String s, String p) {
		int sindex,pindex,starindex,match;
		sindex=pindex=0;
		starindex=-1;
		match=0;
		while(sindex<s.length()){
			if(pindex<p.length() && (p.charAt(pindex)=='?'||p.charAt(pindex)==s.charAt(sindex))){
				pindex++;
				sindex++;
			}
			else if(pindex<p.length() && p.charAt(pindex)=='*'){
				starindex = pindex;
				match = sindex;
				pindex++;
			}
			else if(starindex!=-1){
				pindex = starindex+1;
				match++;
				sindex = match;
			}
			else return false;
		}
		while(pindex<p.length() && p.charAt(pindex)=='*') pindex++;
		return pindex==p.length();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildCardMatching obj = new WildCardMatching();
		System.out.println(obj.isMatch("aa", "?****"));
	}

}

import java.util.*;

public class MaxProductOfWordLengths {
	public int maxProduct(String[] words) {
		if(words==null || words.length==0) return 0;
		int n = words.length;
		int[] len = new int[n];
		for(int i=0;i<n;i++){
			String s  = words[i];
			for(int j=0;j<s.length();j++){
				len[i] |= (1<<(s.charAt(j)-'a'));
			}
		}
		int maxproduct = 0;
		for(int i=0;i<n-1;i++){
			for(int j = i+1;j<n;j++){
				if(((len[i] & len[j])==0) && ((words[i].length()*words[j].length())>maxproduct)){
					maxproduct = (words[i].length()*words[j].length());
				}
			}
		}
		return maxproduct;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxProductOfWordLengths obj = new MaxProductOfWordLengths();
		String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
		System.out.println(obj.maxProduct(words));
	}

}

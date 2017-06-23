import java.util.*;

public class FindAnagrams {
	public static List<Integer> findAnagrams(String s, String p) {
		ArrayList<Integer> res = new ArrayList<>();
		if(s==null || s.length()==0 || p==null || p.length()==0) return res;
        int[]  find = new int[256];
        Arrays.fill(find,0);
        for(char c:p.toCharArray()){
        	find[c]++;
        }
        int right=0;
        int left = 0;
        int count=p.length();
        while(right<s.length()){
        	if(find[s.charAt(right)]>=1){
        		count--;
        	}
        	find[s.charAt(right)]--;
        	right++;
        	if(count==0){
        		res.add(left);
        	}
        	if(right-left==p.length()){
        		if(find[s.charAt(left)]>=0){
        			count++;
        		}
        		find[s.charAt(left)]++;
        		left++;
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbaebabacd";
		String p = "abc";
		for(int i:findAnagrams(s,p)){
			System.out.println(i);
		}
	}

}

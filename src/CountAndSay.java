import java.util.*;

public class CountAndSay {
	public String countAndSay(int n) {
		if(n==0) return null;
		StringBuilder cur = new StringBuilder("1");
		StringBuilder prev = new StringBuilder();
		int count =1;
		char a;
		for(int i = 1;i<n;i++){
			prev = cur;
			cur = new StringBuilder();
			count  = 1;
			a = prev.charAt(0);
			for(int j = 1;j<prev.length();j++){
				if(prev.charAt(j)!=a){
					cur.append(count).append(a);
					a=prev.charAt(j);
					count =1;
				}
				else{
					count++;
				}
			}
			cur.append(count).append(a);
		}
		return cur.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountAndSay obj = new CountAndSay();
		System.out.println(obj.countAndSay(4));
	}

}

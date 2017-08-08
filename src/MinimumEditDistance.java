import java.util.*;

public class MinimumEditDistance {
	public int minimumedit(String s1, String s2){
		if((s1==null || s1.length()==0)&&(s2==null || s2.length()==0)) return 0;
		if(s1==null || s1.length()==0) return s2.length();
		if(s2==null || s2.length()==0) return s1.length();
		int l1 = s1.length();
		int l2 = s2.length();
		int[][] dp = new int[l2+1][l1+1];
		for(int i =0;i<dp.length;i++){
			dp[i][0] = i;
		}
		for(int i=0;i<dp[0].length;i++){
			dp[0][i] = i;
		}
		for(int i=1;i<dp.length;i++){
			for(int j=1;j<dp[0].length;j++){
				if(s1.charAt(j-1)==s2.charAt(i-1)){
					dp[i][j] = dp[i-1][j-1];
				}
				else{
					dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]))+1;
				}
			}
		}
		return dp[dp.length-1][dp[0].length-1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumEditDistance obj = new MinimumEditDistance();
		System.out.println(obj.minimumedit("abcdef", "abzej"));
	}

}

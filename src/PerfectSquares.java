import java.util.*;

public class PerfectSquares {
	public int numSquares(int n) {
		if(n<=3) return n;
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		for(int i=4;i<=n;i++){
			dp[i] = i;
			for(int j=1;j<i;j++){
				int temp = j*j;
				if(temp>i){
					break;
				}
				dp[i] = Math.min(dp[i], 1+dp[i-temp]);
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PerfectSquares obj = new PerfectSquares();
		System.out.println(obj.numSquares(13));
	}

}

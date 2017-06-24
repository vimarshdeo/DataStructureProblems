import java.util.*;

public class LongestIncreasingPathMatrix {
	int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
	
	public int longestIncreasingPath(int[][] matrix) {
		if(matrix==null || matrix.length==0) return 0;
		int max = 0;
		int[][] dp = new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				int len = dfs(matrix,dp,i,j);
				max = Math.max(max, len);
			}
		}
		return max;
	}
	public int dfs(int[][] matrix, int[][] dp, int i, int j){
		if(dp[i][j]!=0) return dp[i][j];
		int max = 1;
		for(int[] dir:dirs){
			int x = i+dir[0];
			int y = j+dir[1];
			if(x<0 || x>=matrix.length || y<0 || y>=matrix[0].length || matrix[i][j]>=matrix[x][y]) continue;
			int len = 1+dfs(matrix,dp,x,y);
			max = Math.max(max, len);
		}
		dp[i][j] = max;
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreasingPathMatrix obj = new LongestIncreasingPathMatrix();
		int[][] matrix = {{9,9,9},{6,7,8},{2,1,1}};
		System.out.println(obj.longestIncreasingPath(matrix));
	}

}

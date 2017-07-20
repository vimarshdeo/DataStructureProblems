import java.util.*;
	
public class AndroidPatternDesign {
	public int numberOfPatterns(int m, int n) {
		int[][] visited = new int[10][10];
		visited[1][3] = visited[3][1] = 2;
		visited[3][9] = visited[9][3] = 6;
		visited[9][7] = visited[7][9] = 8;
		visited[1][7] = visited[7][1] = 4;
		visited[1][9] = visited[9][1] = visited[3][7] = visited[7][3] = visited[2][8] = visited[8][2] = visited[4][6] = visited[6][4] = 5;
		boolean[] visit = new boolean[10];
		int res = 0;
		for(int i = m;i<=n;i++){
			res += dfs(visited,visit,1,i-1)*4;
			res += dfs(visited,visit,2,i-1)*4;
			res += dfs(visited,visit,5,i-1);
		}
		return res;
	}
	public int dfs(int[][] visited, boolean[] visit, int cur, int remaining){
		if(remaining<0) return 0;
		if(remaining==0) return 1;
		int res = 0;
		visit[cur] = true;
		for(int i = 1;i<=9;i++){
			if(!visit[i] && (visited[cur][i]==0 || visit[visited[cur][i]])){
				res += dfs(visited, visit, i, remaining-1);
			}
		}
		visit[cur] = false;
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AndroidPatternDesign obj = new AndroidPatternDesign();
		System.out.println(obj.numberOfPatterns(3, 5));
	}

}

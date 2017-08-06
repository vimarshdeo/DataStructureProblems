import java.util.*;

public class ShortestDistanceFromAllBuildings {
	public int shortestDistance(int[][] grid) {
		if(grid==null || grid.length==0 || grid[0].length==0) return 0;
		int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
		int m = grid.length;
		int n = grid[0].length;
		int[][] distance = new int[m][n];
		int[][] reach = new int[m][n];
		int numbuildings = 0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==1){
					numbuildings++;
					Queue<int[]> q = new LinkedList<>();
					boolean[][] visited = new boolean[m][n];
					q.add(new int[]{i,j});
					int dist = 1;
					while(!q.isEmpty()){
						int size = q.size();
						for(int k = 0;k<size;k++){
							int[] temp = q.poll();
							for(int[] dir:dirs){
								int x = temp[0]+dir[0];
								int y = temp[1]+dir[1];
								if(x<0||x>=m||y<0||y>=n||grid[x][y]!=0||visited[x][y]) continue;
								visited[x][y] = true;
								distance[x][y] += dist;
								reach[x][y]++;
								q.add(new int[]{x,y});
							}
						}
						dist++;
					}
				}
			}
		}
		int shortd = Integer.MAX_VALUE;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==0 && reach[i][j]==numbuildings){
					shortd = Math.min(shortd, distance[i][j]);
				}
			}
		}
		return shortd==Integer.MAX_VALUE?-1:shortd;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShortestDistanceFromAllBuildings obj = new ShortestDistanceFromAllBuildings();
		int[][] grid = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
		System.out.println(obj.shortestDistance(grid));
	}

}

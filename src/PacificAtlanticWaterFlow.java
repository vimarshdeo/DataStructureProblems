import java.util.*;

public class PacificAtlanticWaterFlow {
	int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
		if(matrix==null||matrix.length==0||matrix[0].length==0) return res;
		int row = matrix.length;
		int col = matrix[0].length;
		boolean[][] atlantic = new boolean[row][col];
		boolean[][] pacific = new boolean[row][col];
		Queue<int[]> aque = new LinkedList<>();
		Queue<int[]> pque = new LinkedList<>();
		for(int i =0;i<row;i++){
			pacific[i][0] = true;
			pque.add(new int[]{i,0});
			atlantic[i][col-1] = true;
			aque.add(new int[]{i,col-1});
		}
		for(int i = 0;i<col;i++){
			pacific[0][i] = true;
			pque.add(new int[]{0,i});
			atlantic[row-1][i] = true;
			aque.add(new int[]{row-1,i});
		}
		bfs(pacific,pque,matrix);
		bfs(atlantic,aque,matrix);
		for(int i=0;i<row;i++){
			for(int j = 0;j<col;j++){
				if(pacific[i][j]&&atlantic[i][j]){
					res.add(new int[]{i,j});
				}
			}
		}
		return res;
	}
	
	public void bfs(boolean[][] visited,Queue<int[]> que, int[][] matrix){
		int row  = matrix.length;
		int col =  matrix[0].length;
		while(!que.isEmpty()){
			int[] temp = que.poll();
			for(int[] dir:dirs){
				int x = temp[0]+dir[0];
				int y = temp[1]+dir[1];
				if(x<0||x>=row||y<0||y>=col||visited[x][y]||matrix[x][y]<matrix[temp[0]][temp[1]]) continue;
				visited[x][y] = true;
				que.add(new int[]{x,y});
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();
		int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		List<int[]> res = obj.pacificAtlantic(matrix);
		for(int[] temp:res){
			System.out.println(temp[0]+"-"+temp[1]);
		}
	}

}

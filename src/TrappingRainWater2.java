import java.util.*;

public class TrappingRainWater2 {
	public class Cell{
		int row;
		int col;
		int height;
		public Cell(int r, int c, int h){
			row = r;
			col = c;
			height = h;
		}
	}
	public int trapRainWater(int[][] heights) {
		if(heights==null || heights.length==0 || heights[0].length==0) return 0;
		PriorityQueue<Cell> pq = new PriorityQueue<Cell>(1,new Comparator<Cell>(){
			@Override
			public int compare(Cell a, Cell b){
				return a.height-b.height;
			}
		});
		int m = heights.length;
		int n = heights[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i=0;i<m;i++){
			visited[i][0] = true;
			visited[i][n-1] = true;
			pq.add(new Cell(i,0,heights[i][0]));
			pq.add(new Cell(i,n-1,heights[i][n-1]));
		}
		for(int i=0;i<n;i++){
			visited[0][i] = true;
			visited[m-1][i] = true;
			pq.add(new Cell(0,i,heights[0][i]));
			pq.add(new Cell(m-1,i,heights[m-1][i]));
		}
		int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
		int res = 0;
		while(!pq.isEmpty()){
			Cell c = pq.poll();
			for(int[] dir:dirs){
				int x= c.row+dir[0];
				int y = c.col+dir[1];
				if(x<0||x>=m||y<0||y>=n||visited[x][y]) continue;
				visited[x][y] = true;
				res += Math.max(0, c.height-heights[x][y]);
				pq.add(new Cell(x,y,Math.max(c.height, heights[x][y])));
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrappingRainWater2 obj = new TrappingRainWater2();
		int[][] heights = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
		System.out.println(obj.trapRainWater(heights));
	}

}

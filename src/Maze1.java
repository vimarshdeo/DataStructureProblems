import java.util.*;

public class Maze1 {
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		if(maze==null || maze.length==0 || maze[0].length==0) return false;
		int r = maze.length;
		int c = maze[0].length;
		boolean[][] visited = new boolean[r][c];
		Queue<int[]> que = new LinkedList<>();
		que.add(start);
		visited[start[0]][start[1]] = true;
		int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
		while(!que.isEmpty()){
			int[] temp = que.poll();
			if(temp[0]==destination[0] && temp[1]==destination[1]) return true;
			for(int[] dir:dirs){
				int newx = temp[0]+dir[0];
				int newy = temp[1]+dir[1];
				while(newx>=0 && newx<r && newy>=0 && newy<c && maze[newx][newy]==0){
					newx+= dir[0];
					newy+= dir[1];
				}
				if(!visited[newx-dir[0]][newy-dir[1]]){
					visited[newx-dir[0]][newy-dir[1]] = true;
					que.add(new int[]{newx-dir[0],newy-dir[1]});
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maze1 obj = new Maze1();
		int[][] grid = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start = {0,4};
		int[] end = {4,4};
		System.out.println(obj.hasPath(grid, start, end));
	}

}

import java.util.*;

public class Maze2 {
	public class Point{
		int x;
		int y;
		int l;
		public Point(int x, int y, int l){
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}
	
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
		if(maze==null || maze.length==0 || maze[0].length==0) return -1;
        int m = maze.length;
        int n = maze[0].length;
        int[][] length = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(length[i], Integer.MAX_VALUE);
        Queue<Point> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        
        q.add(new Point(start[0],start[1],0));
        while(!q.isEmpty()){
            Point p = q.poll();
            if(length[p.x][p.y]<=p.l) continue;
            length[p.x][p.y] = p.l;
            for(int[] dir:dirs){
                int newx = p.x;
                int newy = p.y;
                int len = p.l;
                while(newx>=0 && newx<m && newy>=0 && newy<n && maze[newx][newy]==0){
                    newx = newx+dir[0];
                    newy = newy+dir[1];
                    len++;
                }
                newx -= dir[0];
                newy -= dir[1];
                len--;
                q.add(new Point(newx,newy, len));
            }
        }
        return length[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:length[destination[0]][destination[1]];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maze2 obj = new Maze2();
		int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
		int[] start={0,4};
		int[] end = {4,4};
		System.out.println(obj.shortestDistance(maze, start, end));
	}

}

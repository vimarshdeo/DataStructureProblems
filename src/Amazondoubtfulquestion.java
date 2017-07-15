import java.util.*;

public class Amazondoubtfulquestion {
	int[][] dirs={{1,-1},{1,0},{1,1}};
	public boolean findpath(int[][] matrix){
		if(matrix==null) return true;
		int index = 0;
		for(int i=0;i<matrix[0].length;i++){
			if(matrix[0][i]==1){
				index++;
			}
		}
		if(index==0) return true;
		int count = 0;
		boolean[] path = new boolean[index];
		for(int i=0;i<matrix[0].length;i++){
			if(matrix[0][i]==1){
				System.out.println(i);
				helper(matrix, 0, i, path, count );
				count++;
			}
		}
		for(int i=0;i<index;i++){
			if(path[i]==false) return false;
		}
		return true;
	}
	
	public void helper(int[][] matrix, int i, int j, boolean[] path, int count){
		System.out.println("enter: "+i+" "+j);
		
		if(matrix[i][j]==0){
			path[count] = false;
			return;
		}
		path[count] = true;
		matrix[i][j] = 0;
		for(int[] dir:dirs){
			int newx= i+dir[0];
			int newy= j+dir[1];
			if(newx>=matrix.length || newy<0 || newy>=matrix[0].length) continue;
			helper(matrix, newx,newy,path,count);
			if(path[count]==true) return;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Amazondoubtfulquestion obj = new Amazondoubtfulquestion();
		int[][] matrix = {{1,1,1},{1,0,1},{0,1,0}};
		System.out.println(obj.findpath(matrix));
	}

}

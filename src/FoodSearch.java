import java.util.*;

public class FoodSearch {
	int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
	int minlen = Integer.MAX_VALUE;
	public int foodsearch(char[][] matrix){
		if(matrix.length==0 || matrix[0].length==0 ||matrix==null) return 0;
		
		for(int i=0;i<matrix.length;i++){
			for(int j = 0;j<matrix[0].length;j++){
				if(matrix[i][j]=='*'){
					dfs(matrix,i,j,0);
					
				}
			}
		}
		return minlen;
	}
	public void dfs(char[][] matrix, int i, int j, int len){
		if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]=='X' ) return;
		if(matrix[i][j]=='#'){
			System.out.println("#");
			minlen = Math.min(minlen, len);
		}
		if(matrix[i][j]=='O'){
			System.out.println("O");
			matrix[i][j] = 'X';
			for(int[] dir:dirs){
				int newx = i+dir[0];
				int newy = j+dir[1];
				dfs(matrix,newx,newy,len+1);
			}
			matrix[i][j]='O';
		}if(matrix[i][j]=='*'){
			System.out.println("*");
			matrix[i][j] = 'X';
			for(int[] dir:dirs){
				int newx = i+dir[0];
				int newy = j+dir[1];
				dfs(matrix,newx,newy,len+1);
			}
			matrix[i][j]='*';
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FoodSearch obj = new FoodSearch();
		char[][] arr = {{'X','X','X','X','X','X'},{'X','*','O','O','O','X'},{'X','O','O','#','O','X'},{'X','X','X','X','X','X'}};
		System.out.println(obj.foodsearch(arr));
	}

}

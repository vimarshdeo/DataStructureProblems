import java.util.*;

public class NumMatrix2DMutable {
	int m,n;
	int[][] rowsum;
	int[][] matrix;
	public NumMatrix2DMutable(int[][] matrix){
		this.matrix = matrix;
		m = matrix.length;
		n = matrix[0].length;
		rowsum = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j = 0;j<n;j++){
				if(j==0) rowsum[i][j] = matrix[i][j];
				else{
					rowsum[i][j] = rowsum[i][j-1]+matrix[i][j];
				}
			}
		}
	}
	
	public void update(int row,int col, int val){
		for(int i=col;i<matrix[0].length;i++){
			rowsum[row][i] = rowsum[row][i] - matrix[row][col]+val;
		}
		matrix[row][col] = val;
	}
	
	public int sumregion(int row1, int col1, int row2, int col2){
		int ret = 0;
		for(int i = row1;i<=row2;i++){
			if(col1==0) ret += rowsum[i][col2];
			else{
				ret += (rowsum[i][col2]-rowsum[i][col1-1]);
			}
		}
		return ret;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9,}};
		NumMatrix2DMutable obj = new NumMatrix2DMutable(matrix);
		System.out.println(obj.sumregion(1, 1, 2, 2));
		obj.update(1, 1, 0);
		
		System.out.println(obj.sumregion(1, 1, 2, 2));
	}

}

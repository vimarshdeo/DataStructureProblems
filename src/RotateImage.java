import java.util.*;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if(matrix.length==0 || matrix[0].length==0) return;
		for(int i=0;i<matrix.length;i++){
			for(int j = i;j<matrix[0].length;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length/2;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[i][matrix[0].length-j-1];
				matrix[i][matrix[0].length-j-1] = temp;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateImage obj = new RotateImage();
		int[][] arr = {{1,2,3,},{4,5,6},{7,8,9}};
		obj.rotate(arr);
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.println(arr[i][j]);
			}
		}
	}

}

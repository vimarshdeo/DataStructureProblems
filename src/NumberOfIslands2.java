import java.util.*;

public class NumberOfIslands2 {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> res = new ArrayList<>();
		if(m==0 || n==0) return res;
		int[] root = new int[m*n];
		Arrays.fill(root, -1);
		int count = 0;
		int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
		for(int[] pos:positions){
			count++;
			int index = n*pos[0]+pos[1];
			root[index] = index;
			for(int[] dir:dirs){
				int x = pos[0]+dir[0];
				int y = pos[1]+dir[1];
				int index1 = x*n+y;
				if(x<0||x>=m||y<0||y>=n||root[index1]==-1) continue;
				int newindex = findroot(root,index1);
				if(index!=newindex){
					root[index] = newindex;
					index = newindex;
					count--;
				}
			}
			res.add(count);
		}
		return res;
	}
	public int findroot(int[] root, int index){
		while(index!=root[index]) index = root[index];
		return index;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfIslands2 obj = new NumberOfIslands2();
		int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}};
		List<Integer> res = obj.numIslands2(3, 3, positions);
		for(int i:res)
			System.out.println(i);
	}

}

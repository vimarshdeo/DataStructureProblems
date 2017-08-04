import java.util.*;

public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int res = 0;
		if(points==null || points.length==0 || points[0].length==0) return res;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<points.length;i++){
			int[] p1 = points[i];
			for(int j=0;j<points.length;j++){
				if(i==j) continue;
				int[] p2 = points[j];
				int dist = finddist(p1,p2);
				map.put(dist, map.getOrDefault(dist, 0)+1);
			}
			for(int val:map.values()){
				res += val * (val-1);
			}
			map.clear();
		}
		return res;
	}
	
	public int finddist(int[] p1, int[] p2){
		int dx = p1[0] - p2[0];
		int dy = p1[1] - p2[1];
		return dx*dx + dy*dy;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfBoomerangs obj = new NumberOfBoomerangs();
		int[][] points = {{0,0},{1,0},{2,0}};
		System.out.println(obj.numberOfBoomerangs(points));
	}

}

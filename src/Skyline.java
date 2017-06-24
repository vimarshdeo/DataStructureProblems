import java.util.*;

public class Skyline{
	public class building implements Comparable<building>{
		public int x;
		public int height;
		public boolean isStart;
		@Override
		public int compareTo(building a){
			if(this.x!=a.x){
				return this.x-a.x;
			}
			else{
				return (this.isStart?-this.height:this.height) - (a.isStart?-a.height:a.height);
			}
		}
	}
	public List<int[]> getSkyLine(int[][] buildings){
		List<int[]> res = new ArrayList<>();
		if(buildings.length==0 || buildings==null) return res;
		int index = 0;
		building[] newbuild = new building[buildings.length*2];
		for(int[] b:buildings){
			newbuild[index] = new building();
			newbuild[index].x = b[0];
			newbuild[index].isStart = true;
			newbuild[index].height = b[2];
			
			newbuild[index+1] = new building();
			newbuild[index+1].x = b[1];
			newbuild[index+1].isStart = false;
			newbuild[index+1].height = b[2];
			index = index+2;
		}
		Arrays.sort(newbuild);
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		int prevmax = 0;
		que.add(0);
		for(building b:newbuild){
			if(b.isStart==true){
				que.add(b.height);
			}
			else{
				que.remove(b.height);
			}
			int curmax = que.peek();
			if(curmax!=prevmax){
				res.add(new int[]{b.x,curmax});
				prevmax = curmax;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Skyline obj = new Skyline();
		int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
		for(int[] res:obj.getSkyLine(buildings)){
			System.out.println(res[0]+" , "+res[1]);
		}
	}

}

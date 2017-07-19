import java.util.*;

public class QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>(){
			@Override
			public int compare(int[] ob1, int[]ob2){
				return (ob1[0]!=ob2[0]?ob2[0]-ob1[0]:ob1[1]-ob2[1]);
			}
		});
		List<int[]> res = new ArrayList<>();
		for(int[] num:people){
			res.add(num[1],num);
		}
		return res.toArray(new int[people.length][people[0].length]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueReconstructionByHeight obj = new QueueReconstructionByHeight();
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] res = obj.reconstructQueue(people);
		for(int[] n:res){
			System.out.println(n[0]+" "+n[1]);
		}
	}

}

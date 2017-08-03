import java.util.*;

public class Heaters {
	public int findRadius(int[] houses, int[] heaters){
		Arrays.sort(heaters);
		int result = Integer.MIN_VALUE;
		for(int house:houses){
			int index = Arrays.binarySearch(heaters, house);
			if(index<0){
				index = -(index+1);
			}
			int dist1 = (index-1)>=0?house-heaters[index-1]:Integer.MAX_VALUE;
			int dist2 = index<heaters.length?heaters[index]-house:Integer.MAX_VALUE;
			
			result = Math.max(result, Math.min(dist1, dist2));
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] houses = {1,2,3};
		int[] heaters = {2};
		Heaters obj = new Heaters();
		System.out.println(obj.findRadius(houses,heaters));
	}

}

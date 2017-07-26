import java.util.*;

public class MeetingRooms2 {
	public static class Interval {
	    int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
	}
	public int minMeetingRooms(Interval[] intervals) {
		if(intervals==null || intervals.length==0) return 0;
		int[] start = new int[intervals.length];
		int[] end = new int[intervals.length];
		for(int i=0;i<intervals.length;i++){
			start[i] = intervals[i].start;
			end[i] = intervals[i].end;
		}
		Arrays.sort(start);
		Arrays.sort(end);
		int endptr = 0;
		int rooms = 0;
		for(int i=0;i<start.length;i++){
			if(start[i]<end[endptr]){
				rooms++;
			}
			else{
				endptr++;
			}
		}
		return rooms;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval[] intervals = new Interval[3];
		Interval i1 = new Interval(0,30);
		Interval i2 = new Interval(5,10);
		Interval i3 = new Interval(15,20);
		intervals[0] = i1;
		intervals[1] = i2;
		intervals[2] = i3;
		MeetingRooms2 obj = new MeetingRooms2();
		System.out.println(obj.minMeetingRooms(intervals));
		
	}

}

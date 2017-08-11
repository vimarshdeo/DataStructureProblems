import java.util.*;

public class FindItinery {
	public List<String> findItinerary(String[][] tickets) {
		List<String> res = new ArrayList<>();
		if(tickets==null || tickets.length==0 || tickets[0].length==0) return res;
		Stack<String> stk = new Stack<>();
		HashMap<String,PriorityQueue<String>> map = new HashMap<>();
		for(int i=0;i<tickets.length;i++){
			if(!map.containsKey(tickets[i][0])){
				map.put(tickets[i][0], new PriorityQueue<String>());
			}
			PriorityQueue<String> p = map.get(tickets[i][0]);
			p.add(tickets[i][1]);
			map.put(tickets[i][0], p);
		}
		stk.push("JFK");
		while(!stk.isEmpty()){
			while(map.containsKey(stk.peek()) && !map.get(stk.peek()).isEmpty()){
				
				stk.push(map.get(stk.peek()).poll());
			}
			res.add(0,stk.pop());
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindItinery obj = new FindItinery();
		String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		List<String> res = obj.findItinerary(tickets);
		for(String s:res){
			System.out.println(s);
		}
	}

}

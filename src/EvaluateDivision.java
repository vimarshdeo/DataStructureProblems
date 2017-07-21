import java.util.*;

public class EvaluateDivision {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		double[] res = new double[queries.length];
		if(equations.length==0 || equations==null) return res;
		HashMap<String,List<String>> map = new HashMap<>();
		HashMap<String,List<Double>> valuemap  =new HashMap<>();
		for(int i=0;i<equations.length;i++){
			String[] q = equations[i];
			if(!map.containsKey(q[0])){
				map.put(q[0], new ArrayList<String>());
				valuemap.put(q[0],new ArrayList<Double>());
			}
			if(!map.containsKey(q[1])){
				map.put(q[1], new ArrayList<String>());
				valuemap.put(q[1],new ArrayList<Double>());
			}
			map.get(q[0]).add(q[1]);
			map.get(q[1]).add(q[0]);
			valuemap.get(q[0]).add(values[i]);
			valuemap.get(q[1]).add(1/values[i]);
		}
		for(int i = 0;i<queries.length;i++){
			String[] q = queries[i];
			res[i] = dfs(q[0],q[1],map,valuemap,new HashSet<String>(),1.0);
			if(res[i]==0.0) res[i] = -1.0;
		}
		return res;
	}
	
	public double dfs(String start, String end, HashMap<String, List<String>> map, HashMap<String,List<Double>> valuemap, HashSet<String> set, double cur){
		if(set.contains(start)) return 0.0;
		if(!map.containsKey(start)) return 0.0;
		if(start.equals(end)) return cur;
		double tmp = 0.0;
		set.add(start);
		List<String> list = map.get(start);
		List<Double> valuelist  = valuemap.get(start);
		for(int i=0;i<list.size();i++){
			tmp = dfs(list.get(i),end,map,valuemap,set,cur*valuelist.get(i));
			if(tmp!=0) break;
		}
		set.remove(start);
		return tmp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

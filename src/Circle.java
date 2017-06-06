import java.util.*;

public class Circle {
	public String[] doesCircleExist(String[] commands){
		String[] res = new String[Integer.parseInt(commands[0])];
		int index = 0;
		char dir = 1;
		for(int i=1;i<=Integer.parseInt(commands[0]);i++){
			if(commands[i].length()==1 && commands[i].equals("L")||commands[i].equals("R")){
				res[index++] = "YES";
				continue;
			}
			int intitalx = 0;
			int initialy = 0;
			int direction =1;//up direction
			int newx = intitalx;
			int newy = initialy;
			HashMap<Integer, Integer> map = new HashMap<>();
			map.put(0, 0);
			for(char c:commands[i].toCharArray()){
				if(direction == 1){
					if(c=='G'){
						newy++;
						if(map.containsKey(newx) && map.get(newx)==newy){
							System.out.println("contains");
							res[index++] = "YES";
							break;
						}
						else{
							map.put(newx, newy);
						}
					}
					else if(c=='L'){
						dir = 4;
					}
					else
						dir = 2;
				}
				else if(direction==2){//right direction
					if(c=='G'){
						newx++;
						if(map.containsKey(newx) && map.get(newx)==newy){
							System.out.println("contains");
							res[index++] = "YES";
							break;
						}
						else{
							map.put(newx, newy);
						}
					}
					else if(c=='L'){
						dir = 1;
					}
					else
						dir = 3;
				}
				else if(direction==3){//down direction
					if(c=='G'){
						newy--;
						if(map.containsKey(newx) && map.get(newx)==newy){
							res[index++] = "YES";
							break;
						}
						else{
							map.put(newx, newy);
						}
					}
					else if(c=='L'){
						dir = 2;
					}
					else
						dir = 4;
				}
				else{//left direction
					if(c=='G'){
						newx--;
						if(map.containsKey(newx) && map.get(newx)==newy){
							res[index++] = "YES";
							break;
						}
						else{
							map.put(newx, newy);
						}
					}
					else if(c=='L'){
						dir = 3;
					}
					else
						dir = 1;
				}
			}

			res[index++] = "NO";
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle obj = new Circle();
		String[] arr = {"2","GRGL","L"};
		String[] res = obj.doesCircleExist(arr);
		for(String s: res){
			System.out.println(s);
		}
		
	}

}

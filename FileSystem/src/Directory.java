import java.util.*;

public class Directory extends Entity{
	List<Entity> list;
	public Directory(String name,Directory parent){
		super(name,parent);
		list = new ArrayList<Entity>();
	}

	@Override
	public int size() {
		int size = 0;
		for(Entity e:list){
			size += e.size();
		}
		return size;
	}
	public void addEntry(Entity e){
		list.add(e);
	}
}

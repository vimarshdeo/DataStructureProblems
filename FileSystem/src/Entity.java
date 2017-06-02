import java.util.*;

public abstract class Entity {
	protected Directory parent;
	protected String name;
	protected long creationtime;
	protected long updatedtime;
	public Entity(String name, Directory parent){
		this.parent = parent;
		this.name = name;
		creationtime = System.currentTimeMillis();
	}
	public abstract int size();
	public String getFullPath(){
		if(parent==null){
			return name;
		}
		else{
			return parent.getFullPath()+"/"+name;
		}
	}
	public long lastUpdated(){
		return updatedtime;
	}
	public void setname(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
}

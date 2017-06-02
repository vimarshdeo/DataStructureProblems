import java.util.*;

public class File extends Entity{
	protected String content;
	protected int size;
	public File(String name, Directory parent, int size) {
		super(name,parent);
		this.size = size;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	public void setContent(String s){
		content = s;
	}
	public String getContent(){
		return content;
	}

}

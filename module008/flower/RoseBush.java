package module008.flower;

import java.util.ArrayList;
import java.util.List;

public class RoseBush extends Rose {
	
	private List<Rose> rose = new ArrayList<>();
	
	public RoseBush(String name, Color color, Rose... roses) {
		super(name, color);
		for(Rose r : roses){
			this.rose.add(r);		
		}		
	}

	public List<Rose> getRose() {
		return rose;
	}
	
	public void printInfo() {
		System.out.println(getName() + ", color " + getColor() + " flores " + getRose().size());
	}
}

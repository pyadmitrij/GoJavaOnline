package Flower;

import java.util.ArrayList;
import java.util.List;

public class RoseBush extends Rose {

	private String name = "RoseBush";
	
	private List<Rose> rose = new ArrayList<>();
	
	public RoseBush(Color color, int n) {
		super(color);
		for (int i = 0; i < n ; i++){
			Rose r = new Rose(color);
			this.rose.add(r);		
		}		
	}

	public String getName() {
		return name;
	}

	public List<Rose> getRose() {
		return rose;
	}
	
	public void printInfo() {
		System.out.println(getName() + ", color " + getColor() + ", flores " + getRose().size());
	}
}

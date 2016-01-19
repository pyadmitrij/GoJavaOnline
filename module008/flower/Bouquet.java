package module008.flower;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
	
	private List<Flower> flower;
	
	public Bouquet(Flower... flowers) {
		flower = new ArrayList<>();
		for(Flower f : flowers)
			this.flower.add(f);
	}

	public List<Flower> getFlower() {
		return flower;
	}

	public void setFlower(Flower... flowers) {
		for (Flower f : flowers)
			this.flower.add(f) ;
	}

}

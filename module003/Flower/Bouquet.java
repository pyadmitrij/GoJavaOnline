package flower;

import java.util.ArrayList;

public class Bouquet {
	
	private ArrayList<Flower> flower = new ArrayList<>();
	
	public Bouquet(Flower... flowers){
		for(Flower f : flowers)
			this.flower.add(f);
	}

	public ArrayList<Flower> getFlower() {
		return flower;
	}

	public void setFlower(Flower... flowers) {
		for (Flower f : flowers)
			this.flower.add(f) ;
	}

}

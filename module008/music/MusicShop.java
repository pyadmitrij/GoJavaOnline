package module008.music;

import java.util.ArrayList;
import java.util.List;

public class MusicShop {
	
	private List<MusicInstr> instrument;

	public MusicShop(MusicInstr... instr){
		instrument = new ArrayList<>();
		for(MusicInstr i : instr)
			this.instrument.add(i);
	}

	public List<MusicInstr> getInstrument() {
		return instrument;
	}

	public void setInstrument(MusicInstr... instrument) {
		for(MusicInstr i : instrument)
			this.instrument.add(i);
	}

}

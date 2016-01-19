package module008.music;

import java.util.ArrayList;
import java.util.List;

public class MusicShop {
	
private List<MusicInstr> instr = new ArrayList<>();

	public MusicShop(MusicInstr... instr){
		for(MusicInstr i : instr)
			this.instr.add(i);
	}

	public List<MusicInstr> getInstr() {
		return instr;
	}

	public void setInstr(MusicInstr... instr) {
		for(MusicInstr i : instr)
			this.instr.add(i);
	}

}

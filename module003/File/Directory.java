package File;

import java.util.ArrayList;
import java.util.List;

public class Directory {
	
	private List<File> file = new ArrayList<>();
	
	public Directory(){}

	public Directory(File... files){
		for(File f : files)
			this.file.add(f);
	}

	public List<File> getFile() {
		return file;
	}

	public void setFile(File... files) {
		for(File f : files)
			this.file.add(f);
	}

}

package module008.file;

import java.util.ArrayList;
import java.util.List;

public class Directory {
	
	private List<File> file;

	public Directory(File... files){
		file = new ArrayList<>();
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

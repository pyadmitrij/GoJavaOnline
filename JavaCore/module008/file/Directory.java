package module008.file;

import java.util.ArrayList;
import java.util.List;

public class Directory {
	
	private List<File> files;

	public Directory(File... files){
		this.files = new ArrayList<>();
		for(File f : files)
			this.files.add(f);
	}

	public List<File> getFiles() {
		return files;
	}

	public void addFile(File... files) {
		for(File f : files)
			this.files.add(f);
	}
}

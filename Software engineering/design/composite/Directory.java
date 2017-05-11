package patterns.design.composite;

import java.util.ArrayList;

public class Directory extends FileSystem {

	String name;
	ArrayList<FileSystem> subdirs;
	
	public Directory(String name) {
		this.name = name;
		// inizializzo la lista di elementi che comporranno
		// una istanza di Directory
		subdirs = new ArrayList<FileSystem>();
	}
	
	// vari metodi per gestire gli elementi aggregati
	
	public void add(FileSystem item) {
		subdirs.add(item);
	}

	public void remove(FileSystem item) {
		subdirs.remove(item);
	}

	public String getDir() {
		return this.name;
	}
	
	@Override
	public void getName() {
		for(FileSystem child : subdirs) {
			if (child.getClass().toString().matches(".*\\.Directory$")) {
				System.out.println("->" + ((Directory) child).getDir());
			}
			
			child.getName();
		}
	}

}

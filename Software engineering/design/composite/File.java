package patterns.design.composite;

// classe foglia o nodo terminale

public class File extends FileSystem {
	
	String name;
	double size;

	public File(String name, double i) {
		this.name = name;
		this.size = i;
	}
	
	@Override
	public void getName() {
		System.out.println(name);
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

}

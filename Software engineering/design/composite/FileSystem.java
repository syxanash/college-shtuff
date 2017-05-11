package patterns.design.composite;


public abstract class FileSystem {
	// metodo astratto che dovrà essere implementato
	// da ogni classe che estende Filesystem
	public abstract void getName();

	// metodi pubblici che serviranno alle classi intermedie
	// composte tipo Directory per aggiungere o rimuovere
	// nuovi elementi
	// se questi metodi dovessero mancare e li aggiungessi solo
	// nella classe Directory, il client non potrebbe poi utilizzarli
	// in quanto utilizzerebbe l'interfaccia FileSystem che non possiede
	// tali metodi. Inoltre poichè non serviranno alla classe foglia File
	// non sono stati resi abstract come invece lo è getName che serve
	// anche per la classe File
	public void add(FileSystem item) {}
	public void remove(FileSystem item) {}
}

package patterns.design.composite;

public class Client {
	public static void main(String[] args) {
		FileSystem myOS = new Directory("Musica");
				
		FileSystem mp3_file = new File("jazz_music.mp3", 5.4);
		FileSystem prog_file = new File("genesis_album.mp3", 920.3);
		
		myOS.add(mp3_file);
		myOS.add(prog_file);
		
		FileSystem conf_folder = new Directory("Config");
		
		myOS.add(conf_folder);
		
		conf_folder.add(new File("conf.txt", 1));
		conf_folder.add(new Directory("MoreConf"));
		
		System.out.println("calling operation: ");

		myOS.getName();
	}
}

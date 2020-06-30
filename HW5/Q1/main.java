
public class main {

	public static void main(String[] args) {
		FileSystemTree fSTree = new FileSystemTree("root");
		
		fSTree.addDir("root/new_directory");
		fSTree.addDir("root/Second_new_Directory");
		fSTree.addDir("root/Second_new_Directory/AB");
		fSTree.addDir("root/Second_new_Directory/AB");
		
		fSTree.addFile("root/new_file.txt");
		fSTree.addFile("root/new_directory/new_doc_file.doc");
		fSTree.addFile("root/Second_new_Directory/c");
		
		System.out.println("Searching for files with the word new");
		fSTree.search("new");
		System.out.println();
		
		fSTree.printFileSystem();
		
		fSTree.remove("root/Second_new_Directory");
		
		fSTree.remove("root/new_directory/new_doc_file.doc");
		System.out.println();
		
		fSTree.printFileSystem();
	}

}

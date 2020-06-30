import java.io.*;
import java.nio.file.*;
import java.util.*;


public class FileSystemTree{
	private FileNode root;
	private int size;
	
	private boolean addNode(String path, char type) {
		String temp = "";
		FileNode node = root;
		if(root == null) {
			root = new FileNode(path, type, path);
			return true;
		}
		for(int i = 0; i<path.length();i++) {
			if(path.charAt(i) == '/') {
				node = traverse(node, temp);
				if(isFile(node)) {
					System.out.println("cannot create a File after a file "+temp);
					return false;
				}
				temp = "";
			}else {
				temp = temp + path.charAt(i);
			}	
		}
		for(int i = 0; i < node.childNodes.size();i++) {
			if(node.childNodes.get(i).data.equals(temp)) {
				System.out.println("Directory/File already exists in the path: " + path);
				return false;
			}
		}
		node.addChild(temp, type, path);
		return true;
	}
	
	private FileNode findNode(String path) {
		String temp = "";
		FileNode node = root;
		for(int i = 0; i<path.length();i++) {
			if(path.charAt(i) == '/') {
				node = traverse(node, temp);
				temp = "";
			}else {
				temp = temp + path.charAt(i);
			}	
		}
		node = traverse(node, temp);
		return node;
	}
	
	//Traverses the tree from the given @param node to the provided 
	//@param path provided the path exists in the tree
	private FileNode traverse(FileNode node, String path) {
		if(node.data.equals(path)) return node;
		for (int i = 0; i < node.childNodes.size(); i++) {
			if(node.childNodes.get(i).data.equals(path)) return node.childNodes.get(i);
		}
		throw new NoSuchElementException(path);
	}
	//Checks if the given @param node is a file
	private boolean isFile(FileNode n) {
		if(n.type == 'F') return true;
		return false;
	}
	
	public FileSystemTree(String str) {
		size = 0;
		addDir(str);
	}
	
	//Add a directory to the file system provided @param path is valid 
	//and does not attempt to create duplicates
	//otherwise throws a FileAlreadyExistsException or a NoSuchFileException if path is invalid
	public void addDir(String path) {
		if(addNode(path, 'D')) {
			System.out.println("Directory added successfully: " + path);
			/*Path directory = Paths.get(path);
			try {
				Path p = Files.createDirectory(directory);
				size++;
			} catch (IOException e) {//if file already exists throw exception
				e.printStackTrace();
			}*/
		}
	}
	
	//Add a File to the file system provided @param path is valid 
	//and does not attempt to create duplicates
	//otherwise throws a FileAlreadyExistsException or a NoSuchFileException if path is invalid
	public void addFile(String path) {
		if(addNode(path, 'F')) {
			System.out.println("File added successfully: " + path);
			/*Path directory = Paths.get(path);
			try {
				Path p = Files.createFile(directory);
				size++;
			} catch (IOException e) {//if file already exists throw exception
				e.printStackTrace();
			}*/
		}
	}
	
	public void remove(String path) {
		System.out.println("\n\nRemoving "+path+"...");
		
		Scanner inputScanner = new Scanner(System.in);
		FileNode node = findNode(path);
		
		Path p = Paths.get(path);
		
		if(node.childNodes.size() != 0) {
			System.out.println("\nWarning : Folder not empty");
			System.out.println("Contents");
			ListContents(node);
			System.out.print("Remove Directory Y/N: ");
			char choice = inputScanner.next().charAt(0);
			if(choice != 'y' && choice != 'Y' && choice != 'n' && choice != 'N') {
				throw new InputMismatchException();
			}else if(choice == 'n' || choice == 'N') return;
		}
		for(int i=0;i<node.parentNode.childNodes.size();i++) {
			if(node.parentNode.childNodes.get(i).equals(node)) {
				node.parentNode.childNodes.remove(i);
			}
		}
			/*else if (choice == 'y' || choice == 'Y') {
				try {
					removeDir(p);
					System.out.println("Removed "+path);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else {
			try {
				Files.delete(p);
				System.out.println("Removed "+path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		
		
	}
	
	/*private void removeDir(Path path) throws IOException {
		if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
		    try (DirectoryStream<Path> entries = Files.newDirectoryStream(path)) {
		      for (Path entry : entries) {
		        removeDir(entry);
		      }
		    }
		  }
		  Files.delete(path);
	}*/
	
	private void ListContents(FileNode node) {
		for (int i = 0; i < node.childNodes.size(); i++) {
			System.out.print(node.childNodes.get(i).data+" ");
		}
		System.out.println();
	}
	
	public void search(String key) {
		search(root,key);
	}
	
	private void search(FileNode node,String key) {
		if(key.length()<node.data.length()) {
			int j =0;
			for(int i=0;i<node.data.length();i++) {
				if(key.charAt(j) == node.data.charAt(i)) {
					j++;
				}else {
					j = 0;
				}
				if (key.length() == j) {
					if(node.type == 'F') {
						System.out.println("File - "+node.path);
					}else {
						System.out.println("dir - "+node.path);
					}
					break;
				}			
			}
		}
		for (int i = 0; i < node.childNodes.size(); i++) {
			search(node.childNodes.get(i), key);
		}
	}
	
	public void printFileSystem() {
		printFileSystem(root);
	}
	
	private void printFileSystem(FileNode node) {
		if(node == null) return;
		System.out.print(node.data + " ");
		for (int i = 0; i < node.childNodes.size(); i++) {
			printFileSystem(node.childNodes.get(i));
		}
	}
	
	private static class FileNode{
		private ArrayList<FileNode> childNodes;
		private FileNode parentNode = null;
		private String data;
		private String path;
		private char type;
		
		public FileNode(String e, char T, String path) {
			this(e, T, null, path);
		}
		
		private FileNode(String e, char T, FileNode parent,String path) {
			childNodes = new ArrayList<FileNode>();
			data = e;
			type = T;
			parentNode = parent;
			this.path = path;
		}
		
		public void addChild(String e,char T, String path) {
			FileNode newChild = new FileNode(e,T,this, path);
			childNodes.add(newChild);
		}
	}
}

import java.io.*;
import java.util.*;


public class SimpleTextEditor {
	private List<Character> myText;
	private File myFile;
	
	public SimpleTextEditor(String FileName,int ListType) {
		myFile = new File(FileName);
		if(ListType == 0) {
			myText = new LinkedList<Character>();
		}else if(ListType == 1) {
			myText = new ArrayList<Character>();
		}
	}
	
	public void Read() throws FileNotFoundException {
		FileInputStream inputStream = new FileInputStream(myFile);
		int i;
		try {
			while ((i = inputStream.read()) != -1) {
				myText.add((char)i);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Readitr() throws FileNotFoundException{
		FileInputStream inputStream = new FileInputStream(myFile);
		ListIterator<Character> itr = myText.listIterator();
		int i = 0;
		
		try {	
			while ((i = inputStream.read()) != -1) {
				itr.add((char)i);	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void write() throws IOException {
		FileOutputStream outputStream = new FileOutputStream(myFile);
		
		for (int i = 0; i < myText.size(); i++) {
			outputStream.write(myText.get(i));
		}
		
	}
	
	private void writeitr() throws IOException {
		FileOutputStream outputStream = new FileOutputStream(myFile);
		Iterator<Character> itr = myText.iterator();
		
		while (itr.hasNext()) {
			outputStream.write(itr.next());
		}
		
	}
	
	
	public void add(String txt, int Index) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(myFile);
		
		for(int i=0;i<txt.length();i++) {
			myText.add(Index++, txt.charAt(i));
		}
		
		write();
		
	}
	
	public void additr(String txt, int Index) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(myFile);
		ListIterator<Character> itr = myText.listIterator(Index);
		
		for(int i=0;i<txt.length();i++) {
			itr.add(txt.charAt(i));
		}
		
		writeitr();
	
	}
	
	public void replace(String oldtxt, String newtxt) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(myFile);
		int j =0;
		for(int i=0;i<myText.size();i++) {
			if(oldtxt.charAt(j) == myText.get(i)) {
				j++;
			}else {
				j = 0;
			}
			if(oldtxt.length() == j) {
				if(oldtxt.length()>=newtxt.length()) {
					int k;
					for(k = 0;k<newtxt.length();k++) {
							myText.set(i-j+k+1,newtxt.charAt(k));
						}
					for (int m = newtxt.length(); m < oldtxt.length();m++) {
						myText.remove(i-j+newtxt.length()+1);
					}
				}else {
					for (int k = 0; k < oldtxt.length(); k++) {
						myText.set(i-j+k+1,newtxt.charAt(k));
					}
					for (int k=newtxt.length()-1; k > oldtxt.length()-1 ; k--) {
						myText.add(i-j+oldtxt.length()+1, newtxt.charAt(k));
					}
				}
				j=0;
			}
		}
		
		write();
	}
	
	public void replaceitr(String oldtxt, String newtxt) throws IOException {
		FileOutputStream outputStream = new FileOutputStream(myFile);
		
		ListIterator<Character> itr = myText.listIterator();
		
		int Index = Finditr(oldtxt);
		if(Index!=-1) {
			itr = myText.listIterator(Index);
			if(oldtxt.length()>=newtxt.length()) {
				for(int k = 0;k<newtxt.length();k++) {
						//myText.set(itr.nextIndex()+k+1,newtxt.charAt(k));
					itr.next();
					itr.set(newtxt.charAt(k));
					}
				for (int k = newtxt.length(); k < oldtxt.length();k++) {
					//myText.remove(itr.nextIndex()+1);
					itr.next();
					itr.remove();
				}
			}else {
				for (int k = 0; k < oldtxt.length(); k++) {
					//myText.set(itr.nextIndex()+k+1,newtxt.charAt(k));
					itr.next();
					itr.set(newtxt.charAt(k));
				}
				for (int k=oldtxt.length(); k < newtxt.length() ; k++) {
					itr.add(newtxt.charAt(k));
				}
			}
		}
		
		writeitr();
	}
	
	public int Find(String txt) {
		int j =0;
		for(int i=0;i<myText.size();i++) {
			if(txt.charAt(j) == myText.get(i)) {
				j++;
			}else {
				j = 0;
			}
			if (txt.length() == j) {
				return i-txt.length()+1;
			}
		}
		return -1;
	}
	
	public int Finditr(String txt) {
		ListIterator<Character> itr = myText.listIterator();
		int j = 0;
		while (itr.hasNext()) {
			if(txt.charAt(j) == itr.next()) {
				j++;
			}else {
				j=0;
			}
			if (txt.length() == j) {
				return itr.nextIndex()-txt.length();
			}
		}
		return -1;
	}
	
	
	public int size() {
		return myText.size();
	}
	
	public String toString() {
		for (int i = 0; i < myText.size(); i++) {
			System.out.print(myText.get(i));
		}
		return "a";
	}
}

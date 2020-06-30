import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		File log = new File("log.txt");
		ArrayList<String> logStr = new ArrayList<String>(); 
		
		SimpleTextEditor tEditor = new SimpleTextEditor("LinkedList_test.txt",0);
		
		try {
			/////////////////////////////////////////
			//Testing Functions without iterator
			//testing LinckedList
			tEditor.write();
			logStr.add("Logging Methods of Linked List without iterator\n\n"); 
			long start = System.nanoTime();
			tEditor.Read();
			long timeElapsed = System.nanoTime() - start;
			
			logStr.add("Time elapsed for Read function = "+timeElapsed/1000+"  Micro Second\n");
			
			start = System.nanoTime();
			tEditor.add("Hello my name is Muhammed welcome aboard", 0);
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for add function from the head of the list = "+timeElapsed/1000+"  Micro Second\n");
			
			tEditor.toString();
			System.out.println();
			
			start = System.nanoTime();
			tEditor.add(" My friend", 5);
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for add function from the middle of the list = "+timeElapsed/1000+"  Micro Second\n");

			
			tEditor.toString();
			System.out.println();
			
			start = System.nanoTime();
			tEditor.replace("welcome aboard", "come along");
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for replace function = "+timeElapsed/1000+"  Micro Second\n");

			
			tEditor.toString();
			System.out.println();
			
			tEditor.replace("come along", "glad to have you");
			tEditor.toString();
			System.out.println();
			
			start = System.nanoTime();
			System.out.println("the word glad begins at index "+tEditor.Find("glad"));
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for Find function = "+timeElapsed/1000+"  Micro Second\n");

			//////////////////////////////////////////////////////////////////////////////////////////
			//testing with iterator
			tEditor = new SimpleTextEditor("LLiteratortest.txt",0);
			tEditor.write();;
			
			logStr.add("\n****************************************************************\n");
			logStr.add("Logging Methods of Linked List with iterator:\n\n");
			start = System.nanoTime();
			tEditor.Readitr();
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for Read function = "+timeElapsed/1000+"  Micro Second\n");

			
			start = System.nanoTime();
			tEditor.additr("Hello my name is Muhammed welcome aboard", 0);//adding at the start of the text
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for add function from the head of the list = "+timeElapsed/1000+"  Micro Second\n");
			
			tEditor.toString();
			System.out.println();

			start = System.nanoTime();
			tEditor.additr(" My friend", 5);//adding at an index of the text
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for add function from the middle of the list = "+timeElapsed/1000+"  Micro Second\n");
			
			tEditor.toString();
			System.out.println();

			start = System.nanoTime();
			tEditor.replaceitr("welcome aboard", "come along");
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for replace function = "+timeElapsed/1000+"  Micro Second\n");
			
			tEditor.toString();
			System.out.println();
			
			
			tEditor.replaceitr("come along", "glad to have you");
			tEditor.toString();
			System.out.println();
			

			start = System.nanoTime();
			System.out.println("the word glad begins at index "+tEditor.Finditr("glad"));
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for Find function = "+timeElapsed/1000+"  Micro Second\n");
			
			System.out.println();
			
			//////////////////////////////////////////////
			//testing arrayList
			tEditor = new SimpleTextEditor("ArrayList_test.txt",1);
			tEditor.write();

			logStr.add("\n****************************************************************\n");
			logStr.add("Logging Methods of Array List without iterator\n\n");
			start = System.nanoTime();
			tEditor.Read();
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for Read function = "+timeElapsed/1000+"  Micro Second\n");

			
			start = System.nanoTime();
			tEditor.add("Hello my name is Muhammed welcome aboard", 0);
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for add function from the head of the list = "+timeElapsed/1000+"  Micro Second\n");

			
			tEditor.toString();
			System.out.println();

			start = System.nanoTime();
			tEditor.add(" My friend", 5);
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for add function from the middle of the list = "+timeElapsed/1000+"  Micro Second\n");

			
			tEditor.toString();
			System.out.println();

			start = System.nanoTime();
			tEditor.replace("welcome aboard", "come along");
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for replace function = "+timeElapsed/1000+"  Micro Second\n");
			
			tEditor.toString();
			System.out.println();
			
			tEditor.replace("come along", "glad to have you");
			tEditor.toString();
			System.out.println();

			start = System.nanoTime();
			System.out.println("the word glad begins at index "+tEditor.Find("glad"));
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for Find function = "+timeElapsed/1000+"  Micro Second\n");
			
			///////////////////////////////////////////////////////
			
			//Testing Functions with iterator
			tEditor = new SimpleTextEditor("AL_iterator_test.txt",1);
			tEditor.write();;

			logStr.add("\n****************************************************************\n");
			logStr.add("Logging Methods of Array List with iterator\n\n");
			start = System.nanoTime();
			tEditor.Readitr();
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for Read function = "+timeElapsed/1000+"  Micro Second\n");

			
			start = System.nanoTime();
			tEditor.additr("Hello my name is Muhammed welcome aboard", 0);//adding at the start of the text
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for add function from the head of the list = "+timeElapsed/1000+"  Micro Second\n");

			
			tEditor.toString();
			System.out.println();

			start = System.nanoTime();
			tEditor.additr(" My friend", 5);//adding at an index of the text
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for add function from the middle of the list = "+timeElapsed/1000+"  Micro Second\n");

			tEditor.toString();
			System.out.println();

			start = System.nanoTime();
			tEditor.replaceitr("welcome aboard", "come along");
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for replace function = "+timeElapsed/1000+"  Micro Second\n");

			
			tEditor.toString();
			System.out.println();
			
			
			tEditor.replaceitr("come along", "glad to have you");
			tEditor.toString();
			System.out.println();
			

			start = System.nanoTime();
			System.out.println("the word glad begins at index "+tEditor.Finditr("glad"));
			timeElapsed = System.nanoTime() - start;
			logStr.add("Time elapsed for Find function = "+timeElapsed/1000+"  Micro Second\n");

			System.out.println();
			
			write(logStr, log);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void write(ArrayList<String> str, File file) throws IOException {
		FileOutputStream output = new FileOutputStream(file);
		
		for(int i=0;i<str.size();i++) {
			for(int j=0;j<str.get(i).length();j++)
				output.write(str.get(i).charAt(j));
		}
	}

}

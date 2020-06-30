import java.util.Random;
import java.util.TreeSet;


public class main {

	public static void main(String[] args) {
		Random random;
		BST<Integer> bst10k[] = new BST[10];
		for(int i=0;i<10;i++) {
			bst10k[i] = new BST<Integer>();
			random = new Random();
			for (int j = 0; j < 10000; j++) {
				bst10k[i].add(random.nextInt());
			}
		}
		
		BST<Integer> bst20k[] = new BST[10];
		
		for(int i=0;i<10;i++) {
			bst20k[i] = new BST<Integer>();
			random = new Random();
			for (int j = 0; j < 20000; j++) {
				bst20k[i].add(random.nextInt());
			}
		}
		
		BST<Integer> bst40k[] = new BST[10];
		
		for(int i=0;i<10;i++) {
			bst40k[i] = new BST<Integer>();
			random = new Random();
			for (int j = 0; j < 40000; j++) {
				bst40k[i].add(random.nextInt());
			}
		}
		
		BST<Integer> bst80k[] = new BST[10];
		
		for(int i=0;i<10;i++) {
			bst80k[i] = new BST<Integer>();
			random = new Random();
			for (int j = 0; j < 80000; j++) {
				bst80k[i].add(random.nextInt());
			}
		}
		
		RBBST<Integer> RBbst10k[] = new RBBST[10];
		
		for(int i=0;i<10;i++) {
			RBbst10k[i] = new RBBST<Integer>();
			random = new Random();
			for (int j = 0; j < 10000; j++) {
				RBbst10k[i].add(random.nextInt());
			}
		}
		
		RBBST<Integer> RBbst20k[] = new RBBST[10];
		
		for(int i=0;i<10;i++) {
			RBbst20k[i] = new RBBST<Integer>();
			random = new Random();
			for (int j = 0; j < 20000; j++) {
				RBbst20k[i].add(random.nextInt());
			}
		}
		
		RBBST<Integer> RBbst40k[] = new RBBST[10];
		
		for(int i=0;i<10;i++) {
			RBbst40k[i] = new RBBST<Integer>();
			random = new Random();
			for (int j = 0; j < 40000; j++) {
				RBbst40k[i].add(random.nextInt());
			}
		}
		
		RBBST<Integer> RBbst80k[] = new RBBST[10];
		
		for(int i=0;i<10;i++) {
			RBbst80k[i] = new RBBST<Integer>();
			random = new Random();
			for (int j = 0; j < 80000; j++) {
				RBbst80k[i].add(random.nextInt());
			}
		}
		
		
		TreeSet<Integer> javaRBbst10k[] = new TreeSet[10];
		
		for(int i=0;i<10;i++) {
			javaRBbst10k[i] = new TreeSet<Integer>();
			random = new Random();
			for (int j = 0; j < 10000; j++) {
				javaRBbst10k[i].add(random.nextInt());
			}
		}
		
		TreeSet<Integer> javaRBbst20k[] = new TreeSet[10];
		
		for(int i=0;i<10;i++) {
			javaRBbst20k[i] = new TreeSet<Integer>();
			random = new Random();
			for (int j = 0; j < 20000; j++) {
				javaRBbst20k[i].add(random.nextInt());
			}
		}
		
		TreeSet<Integer> javaRBbst40k[] = new TreeSet[10];
		
		for(int i=0;i<10;i++) {
			javaRBbst40k[i] = new TreeSet<Integer>();
			random = new Random();
			for (int j = 0; j < 40000; j++) {
				javaRBbst40k[i].add(random.nextInt());
			}
		}
		
		TreeSet<Integer> javaRBbst80k[] = new TreeSet[10];
		
		for(int i=0;i<10;i++) {
			javaRBbst80k[i] = new TreeSet<Integer>();
			random = new Random();
			for (int j = 0; j < 80000; j++) {
				javaRBbst80k[i].add(random.nextInt());
			}
		}
		
		
		/*BTree<Integer> Btree10k[] = new BTree[10];
		
		for(int i=0;i<10;i++) {
			Btree10k[i] = new BTree<Integer>(4);
			random = new Random();
			for (int j = 0; j < 10000; j++) {
				Btree10k[i].insert(random.nextInt());
			}
		}
		
		BTree<Integer> Btree20k[] = new BTree[10];
		
		for(int i=0;i<10;i++) {
			Btree20k[i] = new BTree<Integer>(4);
			random = new Random();
			for (int j = 0; j < 20000; j++) {
				Btree20k[i].insert(random.nextInt());
			}
		}
		
		BTree<Integer> Btree40k[] = new BTree[10];
		
		for(int i=0;i<10;i++) {
			Btree40k[i] = new BTree<Integer>(4);
			random = new Random();
			for (int j = 0; j < 40000; j++) {
				Btree40k[i].insert(random.nextInt());
			}
		}
		
		BTree<Integer> Btree80k[] = new BTree[10];
		
		for(int i=0;i<10;i++) {
			Btree80k[i] = new BTree<Integer>(4);
			random = new Random();
			for (int j = 0; j < 80000; j++) {
				Btree80k[i].insert(random.nextInt());
			}
		}*/
		
		
		SkipList<Integer> SL10k[] = new SkipList[10];
		
		for(int i=0;i<10;i++) {
			SL10k[i] = new SkipList<Integer>();
			random = new Random();
			for (int j = 0; j < 10000; j++) {
				SL10k[i].add(random.nextInt());
			}
		}
		
		SkipList<Integer> SL20k[] = new SkipList[10];
		
		for(int i=0;i<10;i++) {
			SL20k[i] = new SkipList<Integer>();
			random = new Random();
			for (int j = 0; j < 20000; j++) {
				SL20k[i].add(random.nextInt());
			}
		}
		
		SkipList<Integer> SL40k[] = new SkipList[10];
		
		for(int i=0;i<10;i++) {
			SL40k[i] = new SkipList<Integer>();
			random = new Random();
			for (int j = 0; j < 40000; j++) {
				SL40k[i].add(random.nextInt());
			}
		}
		
		SkipList<Integer> SL80k[] = new SkipList[10];
		
		for(int i=0;i<10;i++) {
			SL80k[i] = new SkipList<Integer>();
			random = new Random();
			for (int j = 0; j < 80000; j++) {
				SL80k[i].add(random.nextInt());
			}
		}
		
		
		
		System.out.println("testing insertion time for each data structure...");
		
		double start;
		double[] BSTtimeElapsed = new double[4];
		int[] addedBST10k = new int[10];
		int[] addedBST20k = new int[10];
		int[] addedBST40k = new int[10];
		int[] addedBST80k = new int[10];
		
		System.out.print("BST10k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedBST10k[j] = random.nextInt(); 
				bst10k[j].add(addedBST10k[j]);
				
			}
			BSTtimeElapsed[0] = System.nanoTime() - start;
		}
		System.out.println(BSTtimeElapsed[0]/1000000 + " ms");
		
		System.out.print("BST20k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedBST20k[j] = random.nextInt(); 
				bst20k[j].add(addedBST20k[j]);
			}
			BSTtimeElapsed[1] = System.nanoTime() - start;
		}
		System.out.println(BSTtimeElapsed[1]/1000000 + " ms");
		
		System.out.print("BST40k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedBST40k[j] = random.nextInt(); 
				bst40k[j].add(addedBST40k[j]);
			}
			BSTtimeElapsed[2] = System.nanoTime() - start;
		}
		System.out.println(BSTtimeElapsed[2]/1000000 + " ms");
		
		System.out.print("BST80k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedBST80k[j] = random.nextInt(); 
				bst80k[j].add(addedBST80k[j]);
			}
			BSTtimeElapsed[3] = System.nanoTime() - start;
		}
		System.out.println(BSTtimeElapsed[3]/1000000 + " ms");
		
		System.out.print("avg insertion time for BST: ");
		System.out.println(((BSTtimeElapsed[0]+BSTtimeElapsed[1]+BSTtimeElapsed[2]+BSTtimeElapsed[3])/4)/1000000 + " ms\n\n");
		
		double[] RBBSTtimeElapsed = new double[4];
		int[] addedRBBST10k = new int[10];
		int[] addedRBBST20k = new int[10];
		int[] addedRBBST40k = new int[10];
		int[] addedRBBST80k = new int[10];
		
		System.out.print("RBBST10k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedRBBST10k[j] = random.nextInt(); 
				RBbst10k[j].add(addedRBBST10k[j]);
			}
			RBBSTtimeElapsed[0] = System.nanoTime() - start;
		}
		System.out.println(RBBSTtimeElapsed[0]/1000000 + " ms");
		
		System.out.print("RBBST20k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedRBBST20k[j] = random.nextInt(); 
				RBbst20k[j].add(addedRBBST20k[j]);
			}
			RBBSTtimeElapsed[1] = System.nanoTime() - start;
		}
		System.out.println(RBBSTtimeElapsed[1]/1000000 + " ms");
		
		System.out.print("RBBST40k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedRBBST40k[j] = random.nextInt(); 
				RBbst40k[j].add(addedRBBST40k[j]);
			}
			RBBSTtimeElapsed[2] = System.nanoTime() - start;
		}
		System.out.println(RBBSTtimeElapsed[2]/1000000 + " ms");
		
		System.out.print("RBBST80k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedRBBST80k[j] = random.nextInt(); 
				RBbst80k[j].add(addedRBBST80k[j]);
			}
			RBBSTtimeElapsed[3] = System.nanoTime() - start;
		}
		System.out.println(RBBSTtimeElapsed[3]/1000000 + " ms");
		
		System.out.print("avg insertion time for RBBST: ");
		System.out.println(((RBBSTtimeElapsed[0]+RBBSTtimeElapsed[1]+RBBSTtimeElapsed[2]+RBBSTtimeElapsed[3])/4)/1000000 + " ms\n\n");
		
		double[] javaRBBSTtimeElapsed = new double[4];
		int[] addedJRBBST10k = new int[10];
		int[] addedJRBBST20k = new int[10];
		int[] addedJRBBST40k = new int[10];
		int[] addedJRBBST80k = new int[10];
		
		System.out.print("javaRBBST10k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedJRBBST10k[j] = random.nextInt(); 
				javaRBbst10k[j].add(addedJRBBST10k[j]);
			}
			javaRBBSTtimeElapsed[0] = System.nanoTime() - start;
		}
		System.out.println(javaRBBSTtimeElapsed[0]/1000000 + " ms");
		
		System.out.print("javaRBBST20k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedJRBBST20k[j] = random.nextInt(); 
				javaRBbst20k[j].add(addedJRBBST20k[j]);
			}
			javaRBBSTtimeElapsed[1] = System.nanoTime() - start;
		}
		System.out.println(javaRBBSTtimeElapsed[1]/1000000 + " ms");
		
		System.out.print("javaRBBST40k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedJRBBST40k[j] = random.nextInt(); 
				javaRBbst40k[j].add(addedJRBBST40k[j]);
			}
			javaRBBSTtimeElapsed[2] = System.nanoTime() - start;
		}
		System.out.println(javaRBBSTtimeElapsed[2]/1000000 + " ms");
		
		System.out.print("javaRBBST80k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedJRBBST80k[j] = random.nextInt(); 
				javaRBbst80k[j].add(addedJRBBST80k[j]);
			}
			javaRBBSTtimeElapsed[3] = System.nanoTime() - start;
		}
		System.out.println(javaRBBSTtimeElapsed[3]/1000000 + " ms");
		
		System.out.print("avg insertion time for javaRBBST: ");
		System.out.println(((javaRBBSTtimeElapsed[0]+javaRBBSTtimeElapsed[1]+javaRBBSTtimeElapsed[2]+javaRBBSTtimeElapsed[3])/4)/1000000 + " ms\n\n");
		
		
		double[] SLtimeElapsed = new double[4];
		int[] addedSL10k = new int[10];
		int[] addedSL20k = new int[10];
		int[] addedSL40k = new int[10];
		int[] addedSL80k = new int[10];
		
		System.out.print("SL10k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedSL10k[j] = random.nextInt();
				SL10k[j].add(addedSL10k[j]);
			}
			SLtimeElapsed[0] = System.nanoTime() - start;
		}
		System.out.println(SLtimeElapsed[0]/1000000 + " ms");
		
		System.out.print("SL20k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedSL20k[j] = random.nextInt();
				SL20k[j].add(addedSL20k[j]);
			}
			SLtimeElapsed[1] = System.nanoTime() - start;
		}
		System.out.println(SLtimeElapsed[1]/1000000 + " ms");
		
		System.out.print("SL40k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedSL40k[j] = random.nextInt();
				SL40k[j].add(addedSL40k[j]);
			}
			SLtimeElapsed[2] = System.nanoTime() - start;
		}
		System.out.println(SLtimeElapsed[2]/1000000 + " ms");
		
		System.out.print("SL80k: ");
		for(int i=0;i<10;i++) {
			random = new Random();
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				addedSL80k[j] = random.nextInt();
				SL80k[j].add(addedSL80k[j]);
			}
			SLtimeElapsed[3] = System.nanoTime() - start;
		}
		System.out.println(SLtimeElapsed[3]/1000000 + " ms");
		
		System.out.print("avg insertion time for javaRBBST: ");
		System.out.println(((SLtimeElapsed[0]+SLtimeElapsed[1]+SLtimeElapsed[2]+SLtimeElapsed[3])/4)/1000000 + " ms\n\n");
	
		
		System.out.println("testing deletion time for each data structure...");
			
		System.out.print("BST10k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				bst10k[j].remove(addedBST10k[j]);
			}
			BSTtimeElapsed[0] = System.nanoTime() - start;
		}
		System.out.println(BSTtimeElapsed[0]/1000000 + " ms");
		
		System.out.print("BST20k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				bst20k[j].remove(addedBST20k[j]);
			}
			BSTtimeElapsed[1] = System.nanoTime() - start;
		}
		System.out.println(BSTtimeElapsed[1]/1000000 + " ms");
		
		System.out.print("BST40k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				bst40k[j].remove(addedBST40k[j]);
			}
			BSTtimeElapsed[2] = System.nanoTime() - start;
		}
		System.out.println(BSTtimeElapsed[2]/1000000 + " ms");
		
		System.out.print("BST80k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				bst80k[j].remove(addedBST80k[j]);
			}
			BSTtimeElapsed[3] = System.nanoTime() - start;
		}
		System.out.println(BSTtimeElapsed[3]/1000000 + " ms");
		
		System.out.print("avg deletion time for BST: ");
		System.out.println(((BSTtimeElapsed[0]+BSTtimeElapsed[1]+BSTtimeElapsed[2]+BSTtimeElapsed[3])/4)/1000000 + " ms\n\n");
		
		
		System.out.print("RBBST10k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				RBbst10k[j].remove(addedRBBST10k[j]);
			}
			RBBSTtimeElapsed[0] = System.nanoTime() - start;
		}
		System.out.println(RBBSTtimeElapsed[0]/1000000 + " ms");
		
		System.out.print("RBBST20k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				RBbst20k[j].remove(addedRBBST20k[j]);
			}
			RBBSTtimeElapsed[1] = System.nanoTime() - start;
		}
		System.out.println(RBBSTtimeElapsed[1]/1000000 + " ms");
		
		System.out.print("RBBST40k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				RBbst40k[j].remove(addedRBBST40k[j]);
			}
			RBBSTtimeElapsed[2] = System.nanoTime() - start;
		}
		System.out.println(RBBSTtimeElapsed[2]/1000000 + " ms");
		
		System.out.print("RBBST80k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				RBbst80k[j].remove(addedRBBST80k[j]);
			}
			RBBSTtimeElapsed[3] = System.nanoTime() - start;
		}
		System.out.println(RBBSTtimeElapsed[3]/1000000 + " ms");
		
		System.out.print("avg deletion time for RBBST: ");
		System.out.println(((RBBSTtimeElapsed[0]+RBBSTtimeElapsed[1]+RBBSTtimeElapsed[2]+RBBSTtimeElapsed[3])/4)/1000000 + " ms\n\n");
		
		System.out.print("javaRBBST10k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				javaRBbst10k[j].remove(addedJRBBST10k[j]);
			}
			javaRBBSTtimeElapsed[0] = System.nanoTime() - start;
		}
		System.out.println(javaRBBSTtimeElapsed[0]/1000000 + " ms");
		
		System.out.print("javaRBBST20k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				javaRBbst20k[j].remove(addedJRBBST20k[j]);
			}
			javaRBBSTtimeElapsed[1] = System.nanoTime() - start;
		}
		System.out.println(javaRBBSTtimeElapsed[1]/1000000 + " ms");
		
		System.out.print("javaRBBST40k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				javaRBbst40k[j].remove(addedJRBBST40k[j]);
			}
			javaRBBSTtimeElapsed[2] = System.nanoTime() - start;
		}
		System.out.println(javaRBBSTtimeElapsed[2]/1000000 + " ms");
		
		System.out.print("javaRBBST80k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				javaRBbst80k[j].remove(addedJRBBST80k[j]);
			}
			javaRBBSTtimeElapsed[3] = System.nanoTime() - start;
		}
		System.out.println(javaRBBSTtimeElapsed[3]/1000000 + " ms");
		
		System.out.print("avg deletion time for javaRBBST: ");
		System.out.println(((javaRBBSTtimeElapsed[0]+javaRBBSTtimeElapsed[1]+javaRBBSTtimeElapsed[2]+javaRBBSTtimeElapsed[3])/4)/1000000 + " ms\n\n");
		
		
		System.out.print("SL10k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				SL10k[j].remove(addedSL10k[j]);
			}
			SLtimeElapsed[0] = System.nanoTime() - start;
		}
		System.out.println(SLtimeElapsed[0]/1000000 + " ms");
		
		System.out.print("SL20k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				SL20k[j].remove(addedSL20k[j]);
			}
			SLtimeElapsed[1] = System.nanoTime() - start;
		}
		System.out.println(SLtimeElapsed[1]/1000000 + " ms");
		
		System.out.print("SL40k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				SL40k[j].remove(addedSL40k[j]);
			}
			SLtimeElapsed[2] = System.nanoTime() - start;
		}
		System.out.println(SLtimeElapsed[2]/1000000 + " ms");
		
		System.out.print("SL80k: ");
		for(int i=0;i<10;i++) {
			start = System.nanoTime();
			for (int j = 0; j < 10; j++) {
				SL80k[j].remove(addedSL80k[j]);
			}
			SLtimeElapsed[3] = System.nanoTime() - start;
		}
		System.out.println(SLtimeElapsed[3]/1000000 + " ms");
		
		System.out.print("avg insertion time for javaRBBST: ");
		System.out.println(((SLtimeElapsed[0]+SLtimeElapsed[1]+SLtimeElapsed[2]+SLtimeElapsed[3])/4)/1000000 + " ms\n\n");
	}

}

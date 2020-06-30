package softwareStore;
import java.util.Scanner;

import softwareStore.BST.BSTNode;

public class SStore {
	BST<software> products;
	Scanner input = new Scanner(System.in);
	private static final String PASSWORD = "12345"; 
	
	public SStore() {
		products = new BST<software>();
		products.add(new software("Adobe Photoshop 6.0", 29.99, 1));
		products.add(new software("Adobe Photoshop 6.2", 39.99, 1));
		products.add(new software("Norton 4.5", 19.99, 1));
		products.add(new software("Norton 5.5", 29.99, 1));
		products.add(new software("Adobe Flash 3.3", 9.99, 1));
		products.add(new software("Adobe Flash 3.3", 10.99, 1));
	}
	
	public void mainMenu() {
		while(true) {	
			System.out.println("Choose Login type:");
			System.out.println("0- exit\n1- Admin\n2- Customre");
			System.out.print("Choice: ");
			
			int choice = input.nextInt();
			
			switch (choice) {
			case 0:
				return;
				
			case 1:
				adminMenu();
				break;
				
			case 2:
				customerMenu();
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}
	
	private void adminMenu() {
		System.out.println("\nAdmin Login Menu\n");
		System.out.print("please enter a password: ");
		String pw = input.next();
		while(!pw.equals(PASSWORD)) {
			System.out.println("wrong PassWord please try again");
			System.out.println("\nAdmin Login Menu\n");
			System.out.println("please enter a password");
			pw = input.next();
		}
		updateMenu();
	}
	
	private void updateMenu() {
		while (true) {
			System.out.println("choose what you want to do:");
			System.out.println("0- up\n1- add a product\n2- remove a product\n 3- update a product");
			System.out.print("choice: ");
			int choice = input.nextInt();
			
			switch (choice) {
			case 0:
				return;
			case 1:
				add();
				break;
				
			case 2:
				remove();
				break;
				
			case 3:
				update();
				break;
				
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}
	
	private void add() {
		System.out.print("enter the name of the product: ");
		input.nextLine();
		String name = input.nextLine();
		
		System.out.print("enter the price of the product: ");
		double price = input.nextDouble();
		
		System.out.print("enter the quantity of the product: ");
		int q = input.nextInt();
		
		products.add(new software(name, price, q));
	}
	
	private void remove() {
		products.print();
		System.out.print("enter the name of the product: ");
		input.nextLine();
		String name = input.nextLine();
		System.out.println(name);
		products.remove(new software(name, 0, 0));
	}
	
	private void update() {
		products.print();
		
		System.out.print("enter the name of the product: ");
		input.nextLine();
		String name = input.nextLine();
		BSTNode<software> temp = products.search(new software(name,0,0), products.getroot());
		if(temp != null) {
			while(true) {
				System.out.println("choose what to do:");
				System.out.println("0-up\n1-change name\n2-change price\n3-change quantity");
				System.out.print("Choice: ");
				int choice = input.nextInt();
				switch (choice) {
				case 0:
					return;
				case 1:
					System.out.print("enter new name: ");
					input.nextLine();
					name = input.nextLine();
					temp.data.name = name;
					break;
					
				case 2:
					System.out.print("enter new price: ");
					double price = input.nextDouble();
					temp.data.price = price;
					break;
					
				case 3:
					System.out.print("enter new quantity: ");
					int q = input.nextInt();
					temp.data.quantity = q;
					break;
					
				default:
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			}
	
		}else System.out.println("product not found");
	}
	
	private void customerMenu() {
		while(true) {
			products.print();
			System.out.println("choose what you want to do:");
			System.out.println("0- up\n1- Buy a product");
			System.out.print("choice: ");
			int choice = input.nextInt();
			switch (choice) {
			case 0:
				return;

			case 1:
				System.out.print("Enter the product name: ");
				input.nextLine();
				String name = input.nextLine();
				BSTNode<software> temp = products.search(new software(name,0,0), products.getroot());
				if(temp.data.quantity == 1) {
					products.remove(new software(name,0,0));
				}else {
					temp.data.quantity -= 1;
				}
				System.out.println("product purchesed successfully");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}
	}
	
	private static class software implements Comparable<software>{
		double price;
		int quantity;
		String name;
		
		public software(String n,double d, int q) {
			name = n;
			price = d;
			quantity = q;
		}

		@Override
		public int compareTo(software o) {
			if(name.compareTo(o.name) > 0) {
				return 1;
			}else if(name.compareTo(o.name) < 0) {
				return -1;
			}else 
				return 0;
		}
		
		@Override
		public String toString() {
			return name + " " + price + " " + quantity + "\n";
		}
	}
}

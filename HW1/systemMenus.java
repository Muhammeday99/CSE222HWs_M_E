import java.util.Scanner;

public class systemMenus {
	
	private void out(String str) {
		System.out.println(str);
	}
	
	private static int getchoice() {
		Scanner input = new Scanner(System.in);
		
		int choice = input.nextInt();
		
		return choice;
	}
	
	public boolean mainMenu(Admin admin) {
		out("Welcome to our cargo System");
		out("1-Login as an Administrator");
		out("2-Login as a Branch Employee");
		out("3-Login as a Transportation Personnele");
		out("4-Login as a Customer");
		out("0- Exit");
		
		
		System.out.print("Choice: ");
		
		int choice = getchoice();
		
		switch (choice) {
		case 1:
			AdminMenu(admin);
			break;
			
		case 2:
			branchEmployeeMenu(admin);
			break;
			
		case 3:
			transportperMenu(admin);
			break;
			
		case 4:
			customerMenu(admin);
			break;
			
		case 0:
			return true;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		return false;
	}
	
	private void AdminMenu(Admin admin) {
		out("\nYou logged in as an Admin");
		out("Please Choose an action from below:");
		out("1- Add a branch");
		out("2- Remove a branch");
		out("3- Add an employee");
		out("4- Remove an employee");
		out("5- Show Branches");
		out("0- Go back");
		
		System.out.print("Choice: ");
		
		int choice = getchoice();
		
		switch (choice) {
		case 1: 
			addBranch(admin);
			break;
			
		case 2:
			removeBranch(admin);
			break;
			
		case 3:
			addEmployee(admin);
			break;
			
		case 4:
			removeEmployee(admin);
			break;
			
		case 5:
			admin.ShowBranches();
			break;
			
		case 0:
			return;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		AdminMenu(admin);
	}
	
	
	private void branchEmployeeMenu(Admin admin) {
		out("\nYou Logged in as a Branch Employee");
		out("Please Choose an action from below:");
		out("1- Add a Shipment");
		out("2- Change a Shipment Status");
		out("0- Go back");
	
		System.out.print("Choice: ");
		
		int choice = getchoice();
		
		switch (choice) {
		case 1: 
			addShipment(admin);
			break;
			
		case 2:
			ChangeShipmentStatus(admin);
			break;
			
		case 0:
			return;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		branchEmployeeMenu(admin);
	
	}
	
	private void transportperMenu(Admin admin) {
		out("\nYou Logged in as a Transportation Personnele");
		out("Please Choose an action from below:");
		out("1- Mark Shipment as delivered");
		out("0- Go back");
	
		System.out.print("Choice: ");
		
		int choice = getchoice();
		
		switch (choice) {
		case 1: 
			markAsdelivered(admin);
			break;
			
		case 0:
			return;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		transportperMenu(admin);
	
	}
	
	private void customerMenu(Admin admin) {
		out("\nYou Logged in as a Customer");
		out("Please Choose an action from below:");
		out("1- Display Shipment info");
		out("0- Go back");
	
		System.out.print("Choice: ");
		
		int choice = getchoice();
		
		switch (choice) {
		case 1: 
			ShipmentInfo(admin);
			break;
			
		case 0:
			return;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		customerMenu(admin);
		
	}
	
	private void addBranch(Admin admin) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.addBranch(name);
	}
	
	private void removeBranch(Admin admin) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.removeBranch(name);
	}
	
	private void addEmployee(Admin admin) {
		out("\nPlease Select employee type:");
		out("1- Branch emplyee");
		out("2- Transportation Personnele");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Choice: ");
		int type = input.nextInt();
		
		admin.addEmployee(type);
	}
	
	private void removeEmployee(Admin admin) {
		out("\nPlease Select employee type:");
		out("1- Branch emplyee");
		out("2- Transportation Personnele");
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Choice: ");
		int type = input.nextInt();
		
		System.out.print("please enter Employee Name: ");
		String name = input.next();
		
		admin.removeEmployee(type, name);
	}
	
	private void addShipment(Admin admin) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.addShipment(name);
	}
	
	private void ChangeShipmentStatus(Admin admin) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.ChangeShipmentStatus(name);
	}
	
	private void markAsdelivered(Admin admin) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.markAsDelivered(name);
	}
	
	private void ShipmentInfo(Admin admin) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.ShipmentInfo(name);
	}

	
}

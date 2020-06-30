import java.util.Scanner;

public class systemMenus implements CargoCompany{
	private Admin admin;
	
	private void out(String str) {
		System.out.println(str);
	}
	
	private static int getchoice() {
		Scanner input = new Scanner(System.in);
		
		int choice = input.nextInt();
		
		return choice;
	}
	
	public boolean mainMenu(Admin admin) {
		this.admin = admin;
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
			AdminMenu();
			break;
			
		case 2:
			branchEmployeeMenu();
			break;
			
		case 3:
			transportperMenu();
			break;
			
		case 4:
			customerMenu();
			break;
			
		case 0:
			return true;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		return false;
	}
	
	private void AdminMenu() {
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
			addBranch();
			break;
			
		case 2:
			removeBranch();
			break;
			
		case 3:
			addEmployee();
			break;
			
		case 4:
			removeEmployee();
			break;
			
		case 5:
			admin.ShowBranches();
			break;
			
		case 0:
			return;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		AdminMenu();
	}
	
	
	private void branchEmployeeMenu() {
		out("\nYou Logged in as a Branch Employee");
		out("Please Choose an action from below:");
		out("1- Add a Shipment");
		out("2- Change a Shipment Status");
		out("0- Go back");
	
		System.out.print("Choice: ");
		
		int choice = getchoice();
		
		switch (choice) {
		case 1: 
			addShipment();
			break;
			
		case 2:
			ChangeShipmentStatus();
			break;
			
		case 0:
			return;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		branchEmployeeMenu();
	
	}
	
	private void transportperMenu() {
		out("\nYou Logged in as a Transportation Personnele");
		out("Please Choose an action from below:");
		out("1- Mark Shipment as delivered");
		out("0- Go back");
	
		System.out.print("Choice: ");
		
		int choice = getchoice();
		
		switch (choice) {
		case 1: 
			markAsdelivered();
			break;
			
		case 0:
			return;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		transportperMenu();
	
	}
	
	private void customerMenu() {
		out("\nYou Logged in as a Customer");
		out("Please Choose an action from below:");
		out("1- Display Shipment info");
		out("0- Go back");
	
		System.out.print("Choice: ");
		
		int choice = getchoice();
		
		switch (choice) {
		case 1: 
			ShipmentInfo();
			break;
			
		case 0:
			return;
	
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		customerMenu();
		
	}
	
	@Override
	public void addBranch() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.addBranch(name);
	}
	
	@Override
	public void removeBranch() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.removeBranch(name);
	}
	
	@Override
	public void addEmployee() {
		int type = 0;
		out("\nPlease Select employee type:");
		out("1- Branch emplyee");
		out("2- Transportation Personnele");
		
		Scanner input = new Scanner(System.in);
		try {	
			System.out.print("Choice: ");
			type = input.nextInt();
			if(type != 1 && type != 2) {
				throw new Exception();
			}
		}
		catch (Exception e) {
			out("invalid input: "+type);
			return;
		}
		admin.addEmployee(type);
	}
	
	@Override
	public void removeEmployee() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("please enter Employee Name: ");
		String name = input.next();
		
		admin.removeEmployee(name);
	}
	
	@Override
	public void addShipment() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.addShipment(name);
	}
	
	@Override
	public void ChangeShipmentStatus() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.ChangeShipmentStatus(name);
	}
	
	@Override
	public void markAsdelivered() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.markAsDelivered(name);
	}
	
	@Override
	public void ShipmentInfo() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the branch name: ");
		String name = input.next();
		
		admin.ShipmentInfo(name);
	}

	
}

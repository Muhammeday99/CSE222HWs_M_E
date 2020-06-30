import java.util.Scanner;

public class Admin {
	private Branch[] branches;
	private int numOfBranches, capacity;
	
	private void checkFull() {
		if(branches.length == numOfBranches) {
			capacity *= 2;
			Branch[] temp = new Branch[capacity];
			for (int i = 0; i < branches.length; i++) {
				temp[i] = branches[i];
			}
			branches = temp;
		}
	}
	
	public Admin() {
		numOfBranches = 0;
		capacity = 10;
		branches = new Branch[capacity];
	}
	
	public void addBranch(String branchName) {
		for (int i = 0; i < numOfBranches; i++) {
			if (branches[i].getBranchName() == branchName) {
				System.out.println("this branch already exists");
				return;
			}
		}
		checkFull();
		branches[numOfBranches] = new Branch(branchName);
		numOfBranches++;
	}
	
	public void removeBranch(String branchName) {
		for (int i = 0; i < numOfBranches; i++) {
			if(branches[i].getBranchName().equals(branchName)) {
				for (int j = i; j < numOfBranches-1; j++) {
					branches[j] = branches[j+1];
				}
				numOfBranches--;
				return;
			}
		}
		System.out.println("This branch doesn't exist");
	}
	
	public void addEmployee(int type) {
		System.out.print("Please enter branch name: ");
		Scanner input = new Scanner(System.in);
		String branch = input.next();
		
		for (int i = 0; i < numOfBranches; i++) {
			if(branches[i].getBranchName().equals(branch)) {
				System.out.print("Please enter employee name: ");
				String name = input.next(); 
				if(type == 1) {
					BranchEmployee employee = new BranchEmployee(name);
					branches[i].addBranchEmployee(employee);
				}else if(type == 2) {
					TransportEmployee employee = new TransportEmployee(name);
					branches[i].addTransportEmployee(employee);
				}else {
					System.out.println("invalid input");
				}
				return;
			}
		}
		
		System.out.println("Branch does not exist");
	}
	
	public void removeEmployee(int type, String name) {
		System.out.print("Please enter branch name: ");
		Scanner input = new Scanner(System.in);
		String branch = input.next();
		
		for (int i = 0; i < numOfBranches; i++) {
			if (branches[i].getBranchName().equals(branch)) {
				if (type == 1) {
					branches[i].removeBranchEmployee(name);
				}
				else if(type == 2) {
					branches[i].removeTransportEmployee(name);
				}else {
					System.out.println("invalid input");
				}
				return;
			}
		}
		System.out.println("Branch does not exist");
	}
	
	public void ShowBranches() {
		for (int i = 0; i < numOfBranches; i++) {
			System.out.println(branches[i].getBranchName());
		}
	}
	
	public void addShipment(String branchName) {
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < numOfBranches; i++) {
			if(branches[i].getBranchName().equals(branchName)) {
				System.out.print("Please enter Senders Name: ");
				String sender = input.next();
				System.out.print("Please enter Recievers Name: ");
				String reciever = input.next();
				
				branches[i].addShipment(sender, reciever);
				return;
			}
		}
		System.out.println("Branch does not exist");
	}
	
	public void ChangeShipmentStatus(String branchName) {
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < numOfBranches; i++) {
			if(branches[i].getBranchName().equals(branchName)) {
				System.out.print("Please enter Shipment id: ");
				int id = input.nextInt();
				branches[i].ChangeShipmentStatus(id);
				return;
			}
		}
		System.out.println("Branch does not exist");
	}

	public void markAsDelivered(String branchName) {
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < numOfBranches; i++) {
			if(branches[i].getBranchName().equals(branchName)) {
				System.out.print("Please enter Shipment id: ");
				int id = input.nextInt();
				branches[i].MarkAsDelivered(id);
				return;
			}
		}
		System.out.println("Branch does not exist");
	}
	
	public void ShipmentInfo(String branchName) {
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < numOfBranches; i++) {
			if(branches[i].getBranchName().equals(branchName)) {
				System.out.print("Please enter Shipment id: ");
				int id = input.nextInt();
				branches[i].ShipmentInfo(id);
				return;
			}
		}
		System.out.println("Branch does not exist");
	}

}

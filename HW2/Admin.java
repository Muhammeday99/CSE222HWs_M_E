import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
	private ArrayList<Branch> branches;
	private int numOfBranches;
	
	public Admin() {
		numOfBranches = 0;
		branches = new ArrayList<Branch>();
	}
	
	public void addBranch(String branchName) {
		for (int i = 0; i < numOfBranches; i++) {
			if (branches.get(i).getBranchName().equals(branchName)) {
				System.out.println("this branch already exists");
				return;
			}
		}
		
		branches.add(new Branch(branchName));
		numOfBranches++;
	}
	
	public void removeBranch(String branchName) {
		for (int i = 0; i < numOfBranches; i++) {
			if(branches.get(i).getBranchName().equals(branchName)) {
				branches.remove(i);
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
			if(branches.get(i).getBranchName().equals(branch)) {
				System.out.print("Please enter employee name: ");
				String name = input.next(); 
				if(type == 1) {
					BranchEmployee employee = new BranchEmployee(name);
					branches.get(i).addEmployee(employee);
				}else if(type == 2) {
					TransportEmployee employee = new TransportEmployee(name);
					branches.get(i).addEmployee(employee);
				}
				return;
			}
		}
		
		System.out.println("Branch does not exist");
	}
	
	public void removeEmployee(String name) {
		System.out.print("Please enter branch name: ");
		Scanner input = new Scanner(System.in);
		String branch = input.next();
		
		for (int i = 0; i < numOfBranches; i++) {
			if (branches.get(i).getBranchName().equals(branch)) {
					branches.get(i).removeEmployee(name);
				}
				return;
			}
		System.out.println("Branch does not exist");
	}
	
	public void ShowBranches() {
		for (int i = 0; i < numOfBranches; i++) {
			System.out.println(branches.get(i).getBranchName());
		}
	}
	
	public void addShipment(String branchName) {
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < numOfBranches; i++) {
			if(branches.get(i).getBranchName().equals(branchName)) {
				System.out.print("Please enter Senders Name: ");
				String sender = input.next();
				System.out.print("Please enter Recievers Name: ");
				String reciever = input.next();
				
				branches.get(i).addShipment(sender, reciever);
				return;
			}
		}
		System.out.println("Branch does not exist");
	}
	
	public void ChangeShipmentStatus(String branchName) {
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < numOfBranches; i++) {
			if(branches.get(i).getBranchName().equals(branchName)) {
				System.out.print("Please enter Shipment id: ");
				int id = input.nextInt();
				branches.get(i).ChangeShipmentStatus(id);
				return;
			}
		}
		System.out.println("Branch does not exist");
	}

	public void markAsDelivered(String branchName) {
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < numOfBranches; i++) {
			if(branches.get(i).getBranchName().equals(branchName)) {
				System.out.print("Please enter Shipment id: ");
				int id = input.nextInt();
				branches.get(i).MarkAsDelivered(id);
				return;
			}
		}
		System.out.println("Branch does not exist");
	}
	
	public void ShipmentInfo(String branchName) {
		Scanner input = new Scanner(System.in);
		
		for (int i = 0; i < numOfBranches; i++) {
			if(branches.get(i).getBranchName().equals(branchName)) {
				System.out.print("Please enter Shipment id: ");
				int id = input.nextInt();
				branches.get(i).ShipmentInfo(id);
				return;
			}
		}
		System.out.println("Branch does not exist");
	}

}

import java.util.ArrayList;

public class Branch {
	private String branchName;
	private	ArrayList<Employee> Employees;
	private ArrayList<Shipment> shipments;
	private int numOfEmployees,numOfShipments;
	
	
	public Branch(String name) {
		setBranchName(name);
		Employees = new ArrayList<Employee>();
		shipments = new ArrayList<Shipment>();
		numOfEmployees = 0;
		numOfShipments = 0;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String name) {
		branchName = name;
	}
	
	public int getNumOfEmployees() {
		return numOfEmployees;
	}
	
	public void addEmployee(Employee employee) {
		for (int i = 0; i < numOfEmployees; i++) {
			if (Employees.get(i) == employee) {
				System.out.println("this employee already exists");
				return;
			}
		}
		
		Employees.add(employee);
		System.out.println("Added employee " + Employees.get(numOfEmployees).getName());
		numOfEmployees++;
	}
	
	public void removeEmployee(String employee) {
		for (int i = 0; i < numOfEmployees; i++) {
			if(Employees.get(i).getName().equals(employee)) {
				System.out.println("Removed employee " + Employees.get(i).getName());
				Employees.remove(i);
				numOfEmployees--;
				return;
			}
		}
		System.out.println("This employee doesn't exist in this branch");
	}
	
	
	
	public void addShipment(String Sender, String reciever) {
		shipments.add(new Shipment(Sender, reciever, numOfShipments, "Accepted"));
		System.out.println("Added Shipment");
		for (int i = 0; i < numOfEmployees; i++) {
			Employees.get(i).addShipment(shipments.get(numOfShipments));
		}
		shipments.get(numOfShipments).toString();
		
		numOfShipments++;
	}
	
	public void ChangeShipmentStatus(int id) {
		for (int i = 0; i < numOfShipments; i++) {
			if (shipments.get(i).getId() == id) {
				for (int j = 0; j < numOfEmployees; j++) {
					Employees.get(j).ChangeShipmentStatus(shipments.get(i));
				}
				return;
			}
		}
		System.out.println("Shipment does not exist");
	}
	
	public void MarkAsDelivered(int id) {
		for (int i = 0; i < numOfShipments; i++) {
			if (shipments.get(i).getId() == id) {
				for (int j = 0; j < numOfEmployees; j++) {
					Employees.get(j).DeliverShipment(shipments.get(i));
				}
				System.out.println("Delivered Shipment of id: "+shipments.get(i).getId());
				return;
			}
		}
		System.out.println("Shipment does not exist");
	}
	
	public void ShipmentInfo(int id) {
		for (int i = 0; i < numOfShipments; i++) {
			if (shipments.get(i).getId() == id) {
				shipments.get(i).toString();
				return;
			}
		}
		System.out.println("Shipment does not exist");
	}
}

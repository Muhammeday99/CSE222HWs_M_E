
public class Branch {
	private String branchName;
	private	BranchEmployee[] branchEmployees;
	private TransportEmployee[] transportEmployees;
	private Shipment[] shipments;
	private int numOfBranchEmployees,numOfTEmployees,numOfShipments,Employeecapacity,ShipmentsCapacity,TEmployeeCapacity;
	
	private void checkFull(int key) {
		if(key == 1) {
			if(branchEmployees.length == numOfBranchEmployees) {
				Employeecapacity *= 2;
				BranchEmployee[] temp = new BranchEmployee[Employeecapacity];
				for (int i = 0; i < branchEmployees.length; i++) {
					temp[i] = branchEmployees[i];
				}
				branchEmployees = temp;
			}
		}
		else if(key == 2){
			if(shipments.length == numOfShipments) {
				ShipmentsCapacity *= 2;
				Shipment[] temp = new Shipment[ShipmentsCapacity];
				for (int i = 0; i < shipments.length; i++) {
					temp[i] = shipments[i];
				}
				shipments = temp;
			}
		}
		else if(key == 3) {
			if(transportEmployees.length == numOfTEmployees) {
				TEmployeeCapacity *= 2;
				TransportEmployee[] temp = new TransportEmployee[TEmployeeCapacity];
				for (int i = 0; i < transportEmployees.length; i++) {
					temp[i] = transportEmployees[i];
				}
				transportEmployees = temp;
			}
		}
	}
	
	public Branch(String name) {
		setBranchName(name);
		Employeecapacity = ShipmentsCapacity = TEmployeeCapacity = 10;
		branchEmployees = new BranchEmployee[Employeecapacity];
		shipments = new Shipment[ShipmentsCapacity];
		transportEmployees = new TransportEmployee[TEmployeeCapacity];
		numOfBranchEmployees = 0;
		numOfShipments = 0;
		numOfTEmployees = 0;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String name) {
		branchName = name;
	}
	
	public int getNumOfBranchEmployees() {
		return numOfBranchEmployees;
	}
	
	public void addBranchEmployee(BranchEmployee employee) {
		for (int i = 0; i < numOfBranchEmployees; i++) {
			if (branchEmployees[i] == employee) {
				System.out.println("this employee already exists");
				return;
			}
		}
		
		checkFull(1);
		branchEmployees[numOfBranchEmployees] = employee;
		System.out.println("Added employee " + branchEmployees[numOfBranchEmployees].getName());
		numOfBranchEmployees++;
	}
	
	public void removeBranchEmployee(String employee) {
		for (int i = 0; i < numOfBranchEmployees; i++) {
			if(branchEmployees[i].getName().equals(employee)) {
				System.out.println("Removed employee " + branchEmployees[i].getName());
				for (int j = i; j < numOfBranchEmployees-1; j++) {
					branchEmployees[j] = branchEmployees[j+1];
				}
				numOfBranchEmployees--;
				return;
			}
		}
		System.out.println("This employee doesn't exist in this branch");
	}
	
	public void addTransportEmployee(TransportEmployee employee) {
		for (int i = 0; i < numOfBranchEmployees; i++) {
			if (transportEmployees[i] == employee) {
				System.out.println("this employee already exists");
				return;
			}
		}
		
		checkFull(3);
		transportEmployees[numOfTEmployees] = employee;
		System.out.println("Added employee " + transportEmployees[numOfTEmployees].getName());
		numOfTEmployees++;
	}
	
	public void removeTransportEmployee(String Name) {
		for (int i = 0; i < numOfTEmployees; i++) {
			if(transportEmployees[i].getName().equals(Name)) {
				System.out.println("Removed employee " + transportEmployees[i].getName());
				for (int j = i; j < numOfTEmployees-1; j++) {
					transportEmployees[j] = transportEmployees[j+1];
				}
				numOfTEmployees--;
				return;
			}
		}
		System.out.println("This employee doesn't exist in this branch");
	}
	
	public void addShipment(String Sender, String reciever) {
		checkFull(2);
		shipments[numOfShipments] = new Shipment(Sender, reciever, numOfShipments, "Accepted");
		System.out.println("Added Shipment");
		for (int i = 0; i < numOfBranchEmployees; i++) {
			branchEmployees[i].addShipment(shipments[numOfShipments]);
		}
		shipments[numOfShipments].toString();
		
		numOfShipments++;
	}
	
	public void ChangeShipmentStatus(int id) {
		for (int i = 0; i < numOfShipments; i++) {
			if (shipments[i].getId() == id) {
				for (int j = 0; j < numOfBranchEmployees; j++) {
					branchEmployees[j].sendShipment(shipments[i]);
				}
				return;
			}
		}
		System.out.println("Shipment does not exist");
	}
	
	public void MarkAsDelivered(int id) {
		for (int i = 0; i < numOfShipments; i++) {
			if (shipments[i].getId() == id) {
				for (int j = 0; j < numOfTEmployees; j++) {
					transportEmployees[j].DeliverShipment(shipments[i]);
				}
				System.out.println("Delivered Shipment of id: "+shipments[i].getId());
				return;
			}
		}
		System.out.println("Shipment does not exist");
	}
	
	public void ShipmentInfo(int id) {
		for (int i = 0; i < numOfShipments; i++) {
			if (shipments[i].getId() == id) {
				shipments[i].toString();
				return;
			}
		}
		System.out.println("Shipment does not exist");
	}
}

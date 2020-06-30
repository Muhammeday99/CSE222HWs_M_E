
public class BranchEmployee extends Employee {
	private Shipment[] shipments;
	private int numOfShipments;
	public BranchEmployee(String name) {
		super(name);
		shipments = new Shipment[100];
		numOfShipments = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void addShipment(Shipment shipment) {
		shipments[numOfShipments] = shipment;
	}
	
	public void sendShipment(Shipment shipment) {
		for (int i = 0; i < numOfShipments; i++) {
			if(shipments[i].getId() == shipment.getId()) {
				shipments[i].setStatus("Sent");
				shipment.setStatus("Sent");
			}
		}
	}
}

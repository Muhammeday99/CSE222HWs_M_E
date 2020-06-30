import java.util.ArrayList;

public class BranchEmployee extends Employee {
	private ArrayList<Shipment> shipments;
	private int numOfShipments;
	public BranchEmployee(String name) {
		super(name);
		shipments = new ArrayList<Shipment>();
		numOfShipments = 0;
	}
	
	@Override
	public void addShipment(Shipment shipment) {
		shipments.add(shipment);
		numOfShipments++;
	}
	
	@Override
	public void ChangeShipmentStatus(Shipment shipment) {
		for (int i = 0; i < numOfShipments; i++) {
			if(shipments.get(i).getId() == shipment.getId()) {
				shipments.get(i).setStatus("Sent");
				shipment.setStatus("Sent");
			}
		}
	}
}

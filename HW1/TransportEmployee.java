
public class TransportEmployee extends Employee {
	public TransportEmployee(String Name) {
		super(Name);
	}
	
	public void DeliverShipment(Shipment shipment) {
		shipment.setStatus("Delivered");
	}
	
	public String getName() {
		return name;
	}
}

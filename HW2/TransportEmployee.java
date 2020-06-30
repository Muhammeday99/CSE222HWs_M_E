
public class TransportEmployee extends Employee {
	public TransportEmployee(String Name) {
		super(Name);
	}
	
	@Override
	public void DeliverShipment(Shipment shipment) {
		shipment.setStatus("Delivered");
	}
	
}

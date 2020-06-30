
public class Shipment {
	private Customer sender;
	private Customer receiver;
	private int id;
	private String status;
	
	public Shipment(String senderName, String receiverName, int id, String status) {
		sender = new Customer(senderName);
		receiver = new Customer(receiverName);
		this.id = id;
		this.status = status;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setReceiver(Customer receiver) {
		this.receiver = receiver;
	}
	
	public String getReceiver() {
		return receiver.getName();
	}
	
	public void setSender(Customer sender) {
		this.sender = sender;
	}
	
	public String getSender() {
		return sender.getName();
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	@Override
	public String toString() {
		System.out.println("Shipment info:");
		System.out.println("Senders name: "+getSender());
		System.out.println("Recievers name: " + getReceiver());
		System.out.println("Shipment Id: " + getId());
		System.out.println("Shipment Status: " + getStatus());
		
		return "a";
	}
}

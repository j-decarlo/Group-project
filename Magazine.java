package experiments;

public class Magazine extends Item {
	
	// Constructor //////////////////////////////////////////////////
	public Magazine(String _title) {
		this.setTitle(_title);
		this.setCanCheckout(false);
		this.setIsCheckedOut(false);
	}
}

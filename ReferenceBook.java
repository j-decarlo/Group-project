package experiments;

public class ReferenceBook extends Item {
	
	// Constructor //////////////////////////////////////////////////
	public ReferenceBook(String _title) {
		this.setTitle(_title);
		this.setCanCheckout(false);
		this.setIsCheckedOut(false);
	}
}

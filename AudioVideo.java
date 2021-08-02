package experiments;

public class AudioVideo extends Item {
	
	// Properties
	private int checkoutLength;	// 14 days
	
	
	// Constructor
	public AudioVideo(String _title, Boolean _canCheckout, Boolean _isCheckedOut) {
		this.setTitle(_title);
		this.setCanCheckout(_canCheckout);
		this.setIsCheckedOut(_isCheckedOut);
		checkoutLength = 14;
	}

	
	// Getters
	public int getCheckoutLength() {
		return checkoutLength;
	}
	
	
	// Functions
	public void printCheckoutLength() {
		System.out.println(checkoutLength);
	}
}

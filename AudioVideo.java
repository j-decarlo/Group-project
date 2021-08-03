package experiments;

public class AudioVideo extends Item {
	
	// Properties //////////////////////////////////////////////////
	private int checkoutLength;	// 14 days
	private double itemValue;
	
	
	// Constructor //////////////////////////////////////////////////
	public AudioVideo(String _title, Boolean _canCheckout, Boolean _isCheckedOut, double _itemValue) {
		this.setTitle(_title);
		this.setCanCheckout(_canCheckout);
		this.setIsCheckedOut(_isCheckedOut);
		checkoutLength = 14;
	}

	
	// Getters //////////////////////////////////////////////////
	public int getCheckoutLength() {
		return checkoutLength;
	}

	public double getItemValue() {
		return itemValue;
	}
	
	
	// Setters //////////////////////////////////////////////////
	public void setItemValue(double _itemValue) {
		this.itemValue = _itemValue;
	}
	
	
	// Functions //////////////////////////////////////////////////
	public void printCheckoutLength() {
		System.out.println(checkoutLength);
	}

	public void printItemValue() {
		System.out.println("$" + String.format("%.2f", itemValue));
	}
}

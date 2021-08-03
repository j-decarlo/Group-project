package library_system;

public class Book extends Item {
	
	// Properties //////////////////////////////////////////////////
	private int checkoutLength;	// 21 days standard, or 14 days if best seller
	private Boolean isBestSeller;
	private double itemValue;
	
	
	// Constructor //////////////////////////////////////////////////
	public Book(String _title, Boolean _isBestSeller, double _itemValue) {
		this.setTitle(_title);
		this.setCanCheckout(true);
		this.setIsCheckedOut(false);
		this.setIsBestSeller(_isBestSeller);	// Sets checkoutLength
	}

	
	// Getters //////////////////////////////////////////////////
	public int getCheckoutLength() {
		return checkoutLength;
	}

	public Boolean isBestSeller() {
		return isBestSeller;
	}

	public double getItemValue() {
		return itemValue;
	}

	
	// Setters //////////////////////////////////////////////////
	public void setCheckoutLength(int _checkoutLength) {
		this.checkoutLength = _checkoutLength;
	}

	public void setIsBestSeller(Boolean _isBestSeller) {
		this.isBestSeller = _isBestSeller;
		
		// Set checkout length accordingly
		if (_isBestSeller)
		{
			this.checkoutLength = 14;
		}
		else
		{
			this.checkoutLength = 21;
		}
	}

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

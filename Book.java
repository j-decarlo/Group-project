package experiments;

public class Book extends Item {
	
	// Properties
	private int checkoutLength;	// 21 days standard, or 14 days if best seller
	private Boolean isBestSeller;
	
	
	// Constructor
	public Book(String _title, Boolean _canCheckout, Boolean _isCheckedOut, Boolean _isBestSeller) {
		this.setTitle(_title);
		this.setCanCheckout(_canCheckout);
		this.setIsCheckedOut(_isCheckedOut);
		this.setIsBestSeller(_isBestSeller);
	}

	
	// Getters
	public int getCheckoutLength() {
		return checkoutLength;
	}

	public Boolean isBestSeller() {
		return isBestSeller;
	}

	
	// Setters
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
	
	
	// Functions
	public void printCheckoutLength() {
		System.out.println(checkoutLength);
	}
}

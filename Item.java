package experiments;

public class Item {
	
	// Properties
	private String title;
	private Boolean canCheckout;
	private Boolean isCheckedOut;

	
	// Getters
	public String getTitle() {
		return title;
	}

	public Boolean canCheckout() {
		return canCheckout;
	}

	public Boolean isCheckedOut() {
		return isCheckedOut;
	}

	
	// Setters
	public void setTitle(String _title) {
		this.title = _title;
	}

	public void setCanCheckout(Boolean _canCheckout) {
		this.canCheckout = _canCheckout;
	}

	public void setIsCheckedOut(Boolean _isCheckedOut) {
		this.isCheckedOut = _isCheckedOut;
	}
	
	
	// Functions
	public void printTitle() {
		System.out.println(title);
	}

	public void printCanCheckout() {
		System.out.println(canCheckout);
	}

	public void printIsCheckedOut() {
		System.out.println(isCheckedOut);
	}
}

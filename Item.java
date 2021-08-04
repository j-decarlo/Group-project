package library_system;

public class Item {
	
	// Properties //////////////////////////////////////////////////
	private int id;
	private String title;
	private Boolean canCheckout;
	private Boolean isCheckedOut;

	
	// Getters //////////////////////////////////////////////////
	public int getID() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}

	public Boolean canCheckout() {
		return canCheckout;
	}

	public Boolean isCheckedOut() {
		return isCheckedOut;
	}

	
	// Setters //////////////////////////////////////////////////
	public void setID(int _id) {
		this.id = _id;
	}
	
	public void setTitle(String _title) {
		this.title = _title;
	}

	public void setCanCheckout(Boolean _canCheckout) {
		this.canCheckout = _canCheckout;
	}

	public void setIsCheckedOut(Boolean _isCheckedOut) {
		this.isCheckedOut = _isCheckedOut;
	}
	
	
	// Functions //////////////////////////////////////////////////
	public void printID() {
		System.out.println(id);
	}
	
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

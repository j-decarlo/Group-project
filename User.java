package experiments;

public class User {
	private String name;
	private String address;
	private String phoneNumber;
	private String libraryNumber;

	
	// Getters
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getLibraryNumber() {
		return libraryNumber;
	}

	
	// Setters
	public void setName(String _name) {
		this.name = _name;
	}

	public void setAddress(String _address) {
		this.address = _address;
	}

	public void setPhoneNumber(String _number) {
		this.phoneNumber = _number;
	}

	public void setLibraryNumber(String _libraryNumber) {
		this.libraryNumber = _libraryNumber;
	}
	
	
	// Functions
	public void printName() {
		System.out.println(name);
	}

	public void printAddress() {
		System.out.println(address);
	}

	public void printPhoneNumber() {
		System.out.println(phoneNumber);
	}

	public void printLibraryNumber() {
		System.out.println(libraryNumber);
	}
}

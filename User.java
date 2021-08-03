package library_system;

public class User {
	
	// Properties //////////////////////////////////////////////////
	private String name;
	private String address;
	private String phoneNumber;
	private String libraryNumber;
	private int age;

	
	// Getters //////////////////////////////////////////////////
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
	
	public int getAge() {
		return age;
	}

	
	// Setters //////////////////////////////////////////////////
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

	public void setAge(int _age) {
		this.age = _age;
	}
	
	
	// Functions //////////////////////////////////////////////////
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

	public void printAge() {
		System.out.println(age);
	}
}

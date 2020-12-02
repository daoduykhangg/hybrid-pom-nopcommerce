package oop;

public class Honda {
	//Dream
	//Wave 110
	//Air Blade
	//SH
	public Honda() {
		System.out.println("View Dream");
	}
	
	public Honda(String bikeName) {
		System.out.println("View " + bikeName);
	}
	
	public Honda(int bikeNumber) {
		System.out.println("Buy " + bikeNumber);
	}
	
	public Honda(String bikeName, int bikeNumber) {
		System.out.println("View " + bikeName);
		System.out.println("Buy " + bikeNumber);
	}
}

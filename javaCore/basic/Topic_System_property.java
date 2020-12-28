package basic;

public class Topic_System_property {

	public static void main(String[] args) {
		String osName = System.getProperty("os.name");
		String projectFolder = System.getProperty("user.dir");
		
		System.out.println(osName);
		System.out.println(projectFolder);
		System.out.println(java.time.LocalDate.now());  
		
	}

}

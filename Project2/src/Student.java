//student class to store information about students 
public class Student extends User {
    // variables to store information unique to the student class
	private int maxDocOut = 6;
	private int maxTime = 180;
	private String typeUser = "Student";
	
	
    public Student(String name, int userID, int numOut, int balance, 
    		String typeUser, String type) {
        super(name, userID, numOut, balance, type);
        this.typeUser = typeUser;
    }
}
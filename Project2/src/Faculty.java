//faculty class to store information about the faculty
public class Faculty extends User {
	//variables to store information unique to the faculty class
	private int maxDocOut = 12;
	private int maxTime = 365;
	private String typeUser = "Faculty";
	
	//constructor
    public Faculty(String name, int userID, int numOut, int balance, 
    		String typeUser, String type) {
        super(name, userID, numOut, balance, type);
        this.typeUser = typeUser;
    }
    
}
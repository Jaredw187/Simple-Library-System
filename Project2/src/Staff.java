//staff class to store information about the staff
class Staff extends User {
    //variables to store information unique to the staff class
	private int maxDocOut = 12;
	private int maxTime = 365;
	private String typeUser = "Staff";
	
	
    public Staff(String name, int userID, int numOut, int balance, 
    		String typeUser, String type) {
        super(name, userID, numOut, balance, type);
        this.typeUser = typeUser;
    }
}
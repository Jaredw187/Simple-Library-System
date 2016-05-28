import java.util.*;
import java.io.*;
//user class to house all information about each type of user
public class User implements Serializable {
 
	//variable to store info about the users
	private String name;
	private int userID;
	private int numOut;// number of documents the user currently has in his possesion
	private float balance; 
	private String type;
	
    private ArrayList<Staff> staffUsers = new ArrayList<Staff>();
    private ArrayList<Faculty> facultyUsers = new ArrayList<Faculty>();
    private ArrayList<Student> studentUsers = new ArrayList<Student>();

	//constructor
    public User(String name, int userID, int numOut, 
    		int balance, String type) {
        this.name = name;
        this.userID = userID;
        this.numOut = numOut;
        this.balance = balance;
        this.type = type;
    }
    //add a user of type staff
    public void addStaffUser(int index, User user){
    	staffUsers.add((Staff) user);
    }
    //add a user of type faculty
    public void addFacultyUser(int index, User user){
    	facultyUsers.add((Faculty) user);
    }
    //add a user of type student
    public void addStudentUser(int index, User user){
    	studentUsers.add((Student) user);
    }
    //remove a user by name
    public String removeName(String name){
		String _success = "Successfully Removed " + name;
		String _failure = "Failed to remove " + name;
    	for(User title: studentUsers){
    		if (name.equals(title.getName())){
				studentUsers.remove(title);
				return _success;
			}		
    	}
		for(User title: staffUsers){
			if (name.equals(title.getName())){
				staffUsers.remove(title);
				return _success;
			}
		}
		for(User title: facultyUsers){
			if (name.equals(title.getName())){
				facultyUsers.remove(title);
				return _success;
			}
		}
		return _failure;
    }
    //out put all names and the information tied to them
    public void printAll(){
		System.out.println("\n Printing List of Users \n");
		System.out.println("Type     Name   ID  NumOut  Out Limit");
		for(User title: studentUsers){
			System.out.println(title);
		}
		for(User title: staffUsers){
			System.out.println(title);
		}
		for(User title: facultyUsers){
			System.out.println(title);
		}
		
		System.out.println("\n End of Users \n");

	}
    // see if the user can check out and more documents based on their balance and their limit
    public boolean checkUserLimit(int id){
    	
    	for(User title: studentUsers){
    		if (id == title.getID()){
    			if (getBalance() >= getNumOut()){
    				return true;
    			}
    		}
		}
		for(User title: staffUsers){
			if (id == title.getID()){
    			if (getBalance() >= getNumOut()){
    				return true;
    			}
    		}
		}
		for(User title: facultyUsers){
			if (id == title.getID()){
    			if (getBalance() >= getNumOut()){
    				return true;
    			}
    		}
		}
		return false;
    }
    // overwriting the tostring method for printing purposes
    public String toString(){
		String myString = type + "  " + name + "   " +  userID + "     " + numOut + "    " + balance;
		return myString;	
	}
    //get the name of the object
    public String getName(){
    	return name;
    }
    // get the number of documents checked out from a object
    public int getNumOut(){
    	return numOut;
    }
    //get the number of docs that a user can check out
    public float getBalance(){
    	return balance;
    }
    //get the id of a object
    public int getID(){
    	return userID;
    }
    //search for a user by name and increment or decrement their number of docs checked out
    public boolean searchUserAndAlter(String name, int choice){
    	for(User title: studentUsers){
    		if(name.equals(title.getName())){
    			if (choice == 1){
    				title.numOut ++;
    			}
    			if (choice == 2){
    				title.numOut --;
    			}
    			return true;
    		}
    	}
		for(User title: staffUsers){
    		if(name.equals(title.getName())){
    			if (choice == 1){
    				title.numOut ++;
    			}
    			if (choice == 2){
    				title.numOut --;
    			}
    			return true;
    		}		
    	}
		for(User title: facultyUsers){
    		if(name.equals(title.getName())){
    			if (choice == 1){
    				title.numOut ++;
    			}
    			if (choice == 2){
    				title.numOut --;
    			}
    			return true;
    		}
    	}
    	return false;
    }
    //get the number of months the document can be checked out based upon user type
    public int getLendingPeriod(String name){
    	for(User title: studentUsers){
    		if(name.equals(title.getName())){
    			return 6;
    		}
    	}
		for(User title: staffUsers){
    		if(name.equals(title.getName())){
    			return 12;
    		}		
    	}
		for(User title: facultyUsers){
    		if(name.equals(title.getName())){
    			return 12;
    		}
    	}
		return 0;
    }
    //checks to see if the name passed is a user in the system
    public boolean isUser(String name){
    	for(User title: studentUsers){
    		if(name.equals(title.getName())){
    			return true;
    		}
    	}
		for(User title: staffUsers){
    		if(name.equals(title.getName())){
    			return true;
    		}		
    	}
		for(User title: facultyUsers){
    		if(name.equals(title.getName())){
    			return true;
    		}
    	}
    	return false;
    }  
}
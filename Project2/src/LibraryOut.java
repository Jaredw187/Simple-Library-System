import java.io.*;
import java.util.*;

//class used to store the documents checked out in the library
public class LibraryOut implements Serializable{
	//store the id of the user, the id of the document, and when it is due
	private String userID;
	private String docID;
	private Date dueDate;
	//constructor
	public LibraryOut(String userID, String docID, Date dueDate){
		this.userID = userID;
		this.docID = docID;
		this.dueDate = dueDate;
	}
	//get the id of the document
	public String getDocID(){
		return docID;
	}
	//get the id of the user
	public String getUserID(){
		return userID;
	}
	//overwriting the tostring method for printing purposes
	public String toString(){
		String myString = userID + " " + docID + " due: " + dueDate;
		return myString;	
	}
	

	
	
}

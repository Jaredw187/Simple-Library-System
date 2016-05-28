import java.util.*;
import java.io.*; //for serialization
//document class to house all the documents in the library and manipulate their data
public class Document implements  Serializable {
 
	//variables to store data for manipulation by methods
	private String title;
    private String publisher;
    private String date;
    private String author;
    private int copies;
    private String type;
    
    //array lists to store the library documents and information
    private ArrayList<Audio> audioDocuments = new ArrayList<Audio>();
    private ArrayList<Book> bookDocuments = new ArrayList<Book>();
    private ArrayList<Conference> conferenceDocuments = new ArrayList<Conference>();
    private ArrayList<Journal> journalDocuments = new ArrayList<Journal>();
    private ArrayList<Video> videoDocuments = new ArrayList<Video>();
    private ArrayList<LibraryOut> documentOut = new ArrayList<LibraryOut>();
    
    //constructor
    public Document(String type, String title, String publisher, String author, int copies, String date) {
    	this.title = title;
    	this.publisher = publisher;
    	this.date = date;
    	this.author = author;
    	this.copies = copies;
    	this.type = type;
    }
	//add an item of type audio to the audio array list
    public void addAudio(int index, Document doc ){
		audioDocuments.add((Audio) doc);
	}
	//add an item of type book to the book array list
    public void addBook(int index, Document doc) {
		bookDocuments.add((Book) doc);	
	} 
	//add a item of type conference to the conference array list
    public void addConference(int index, Document doc) {
		conferenceDocuments.add((Conference) doc);	
	}
	//add a item of type journal to the journal array list
    public void addJournal(int index, Document doc) {
		journalDocuments.add((Journal) doc);	
	}
	// add a item of type video to the video array list
    public void addVideo(int index, Document doc) {
		videoDocuments.add((Video) doc);	
	}
	//print all documents in the library
    public void printAll(){
		System.out.println("\n Printing Library Documents \n");
		
		for(Document title: audioDocuments){
			System.out.println(title);
		}
		for(Document title: bookDocuments){
			System.out.println(title);
		}
		for(Document title: conferenceDocuments){
			System.out.println(title);
		}
		for(Document title: journalDocuments){
			System.out.println(title);
		}
		for(Document title: videoDocuments){
			System.out.println(title);
		}
		System.out.println("   Documents out");
		for (LibraryOut title: documentOut){
			System.out.println(title);
		}
		System.out.println("\n End of Documents \n");

	}
	//over writing the toString method for printing purposes
	public String toString(){
		String myString = "Type: "+type + " Title: " + title + " Author: " +  author + " Publisher: " + publisher + " Date: " + date + " numberCopies: " + copies;
		return myString;	
	}
	//removes an item of type audio from the audio array list
	//returns success message if successful, and vice versa
	public String removeAudio(String title){
		String _success = "Successfully Removed Audio Document " + title;
		String _failure = "Failed to remove Audio Document" + title;
		for(Document _title: audioDocuments){
			if (title.equals(_title.getTitle())){
				audioDocuments.remove(_title);
				return _success;
			}
		}
		return _failure;

	}
	//removes an item of type book from the book array list
	//returns success message if successful, and vice versa
	public String removeBook(String title){
		String _success = "Successfully Removed Book Document " + title;
		String _failure = "Failed to remove Book Document" + title;
		for(Document _title: bookDocuments){
			if (title.equals(_title.getTitle())){
				bookDocuments.remove(_title);
				return _success;
			}
		}
		return _failure;
	}
	// removes an item of type conference from the conference array list
	//returns success message if successful, and vice versa
	public String removeConference(String title){
		String _success = "Successfully Removed Conference Document " + title;
		String _failure = "Failed to remove Conference Document" + title;
		for(Document _title: conferenceDocuments){
			if (title.equals(_title.getTitle())){
				conferenceDocuments.remove(_title);
				return _success;
			}
		}
		return _failure;
	}
	//remove an item of type journal from the journal array list
	//returns success message if successful, and vice versa
	public String removeJournal(String title){
		String _success = "Successfully Removed Journal Document " + title;
		String _failure = "Failed to remove Journal Document" + title;
		for(Document _title: journalDocuments){
			if (title.equals(_title.getTitle())){
				journalDocuments.remove(_title);
				return _success;
			}
		}
		return _failure;
	}
	// removes a item of type video from the video array list
	//returns success message if successful, and vice versa
	public String removeVideo(String title){
		String _success = "Successfully Removed Audio Document " + title;
		String _failure = "Failed to remove Audio Document" + title;
		for(Document _title: videoDocuments){
			if (title.equals(_title.getTitle())){
				videoDocuments.remove(_title);
				return _success;
			}
		}
		return _failure;
	}
	//searches the array lists for a document based on type of document, as well as by title, publisher, or author.
	//if found, return true. if not found returns false;
	public boolean search(int choice, String type, String title){
		//title publisher author
		
		if (choice == 1){ //search by title
			if (type == "Audio"){
				for(Document _title: audioDocuments){
					if(title.equals(_title.getTitle()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Book"){
				for(Document _title: bookDocuments){
					if(title.equals(_title.getTitle()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Conference"){
				for(Document _title: conferenceDocuments){
					if(title.equals(_title.getTitle()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Journal"){
				for(Document _title: journalDocuments){
					if(title.equals(_title.getTitle()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Video"){
				for(Document _title: videoDocuments){
					if(title.equals(_title.getTitle()));
					System.out.println(_title);
					return true;
				}
			}
		}
		if (choice == 2){ //search by publisher
			if (type == "Audio"){
				for(Document _title: audioDocuments){
					if(title.equals(_title.getPublisher()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Book"){
				for(Document _title: bookDocuments){
					if(title.equals(_title.getPublisher()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Conference"){
				for(Document _title: conferenceDocuments){
					if(title.equals(_title.getPublisher()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Journal"){
				for(Document _title: journalDocuments){
					if(title.equals(_title.getPublisher()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Video"){
				for(Document _title: videoDocuments){
					if(title.equals(_title.getPublisher()));
					System.out.println(_title);
					return true;
				}
			}
		}
		if (choice == 3){ //search by author
			if (type == "Audio"){
				for(Document _title: audioDocuments){
					if(title.equals(_title.getAuthor()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Book"){
				for(Document _title: bookDocuments){
					if(title.equals(_title.getAuthor()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Conference"){
				for(Document _title: conferenceDocuments){
					if(title.equals(_title.getAuthor()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Journal"){
				for(Document _title: journalDocuments){
					if(title.equals(_title.getAuthor()));
					System.out.println(_title);
					return true;
				}
			}
			if (type == "Video"){
				for(Document _title: videoDocuments){
					if(title.equals(_title.getAuthor()));
					System.out.println(_title);
					return true;
				}
			}
		}
		
		return false;
	}
	// allows for the borrowing of a document from the library 
	//returns success after successful borrow
	public String borrowDoc(LibraryOut newDoc){
		documentOut.add((LibraryOut) newDoc);
		String _success = "Successfully borrrowed " + title;
		return _success;
	}
	// allows for the returning of a document. returns success after successful message return
	public String returnDoc(String id){
		String _success = "Successfully Returned Document " + id;
		String _failure = "Failed to return Document" + id;
		for(LibraryOut _id: documentOut){
			if (id.equals(_id.getDocID())){
				documentOut.remove(_id);
				return _success;
			}
		}
		return _failure;
	}	
	//used to return the title of an object
	public String getTitle(){
		return title;
	}
	//used to return the publisher of an object
	public String getPublisher(){
		return publisher;
	}
	//used to return the author of a object
	public String getAuthor(){
		return author;
	}
	//increments or decrements the number of copies based on type of document and title.
	public void xcrementCopies(String type, String title, int choice){
			if(type == "Audio"){
				for (Document _title: audioDocuments){
					if(title.equals(_title.getTitle())){
						if (choice == 1){
							_title.copies ++;
						}
						if (choice == 2){
							_title.copies --;
						}
					}
				}
			}
			if(type == "Book"){
				for (Document _title: bookDocuments){
					if(title.equals(_title.getTitle())){
						if (choice == 1){
							_title.copies ++;
						}
						if (choice == 2){
							_title.copies --;
						}
					}
				}
			}
			if(type == "Conference"){
				for (Document _title: conferenceDocuments){
					if(title.equals(_title.getTitle())){
						if (choice == 1){
							_title.copies ++;
						}
						if (choice == 2){
							_title.copies --;
						}
					}
				}
			}
			if(type == "Journal"){
				for (Document _title: journalDocuments){
					if(title.equals(_title.getTitle())){
						if (choice == 1){
							_title.copies ++;
						}
						if (choice == 2){
							_title.copies --;
						}
					}
				}
			}
			if(type == "Video"){
				for (Document _title: videoDocuments){
					if(title.equals(_title.getTitle())){
						if (choice == 1){
							_title.copies ++;
						}
						if (choice == 2){
							_title.copies --;
						}
					}
				}
			}
		}
	//removes an object from the document out array based on title. 
	//returns a success message if successful and vice versa
	public String removeFromOut(String title){
		String _success = "Successfully Removed Audio Document " + title;
		String _failure = "Failed to remove Audio Document" + title;
		for(LibraryOut _title: documentOut){
			if (title.equals(_title.getDocID())){
				documentOut.remove(_title);
				return _success;
			}
		}
		return _failure;
	}
    //checks to see if the user has a document checked out based on name
	public boolean hasDocOut(String name){

		for(LibraryOut title: documentOut){
    		if(name.equals(title.getUserID())){
    			return true;
    		}
    	}
		return false;
    }
    //checks to see if a document is checked out based on the name of the document
    public boolean isBorrowedDoc(String name){
    	for(LibraryOut title: documentOut){
    		if(name.equals(title.getDocID())){
    			return true;
    		}
    	}
		return false;
    }
}
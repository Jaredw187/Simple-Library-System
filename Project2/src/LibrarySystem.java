
import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
//library system class.. basically what drives the program.
public class LibrarySystem {
	//creating initial objects 
	static Scanner _scanner = new Scanner(System.in);
	private Document Docs = new Document(null, null, null, null, 0, null);
	private User Users = new User(null, 0, 0, 0, null);
	private LibraryOut DocsOut = new LibraryOut(null, null, null);
	int myIndex = 1;
	int numUsers = 1;
	//main driver for the program
	public static void main(String[] args){
		
		LibrarySystem library = new LibrarySystem();
		//bring in the data from previous sessions
		try {
			FileInputStream fileIn = new FileInputStream("Documents");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			library.Docs = (Document)objectIn.readObject();
			library.Users = (User)objectIn.readObject();
			library.DocsOut = (LibraryOut)objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e){
			System.out.println("File Not Found. Cause: " + e);
		} catch (IOException e) {
			System.out.println("input file has issues. Cause: " + e);
		} catch (ClassNotFoundException e) {
			System.out.println("problem with class. Cause: " + e);
		} 
		
		System.out.println("Welcome to the Library");
		library.begin();
		//write the data to a output file
		try{
			FileOutputStream fileOut = new FileOutputStream("Documents");
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(library.Docs);
			objOut.writeObject(library.Users);
			objOut.writeObject(library.DocsOut);
			fileOut.close();
			System.out.println("Success!");
		}catch (IOException e){
			System.out.println("output file has issues. Cause:" + e);
		}
	}
	//display initial menu and guide user to next step depending on input
	private void begin(){
		System.out.println("What would you like to do?");
		System.out.println("Add a Document/User        - 1");
		System.out.println("Remove a Document/User     - 2");
		System.out.println("Check out/return/search    - 3");
		System.out.println("Display library documents  - 4");
		System.out.println("Display list of users      - 5");
		System.out.println("Quit                       - 6");
		System.out.println("Please enter a number corresponding to your choice:");
		int initialChoice = 0;
		initialChoice = _scanner.nextInt();
		
		switch(initialChoice){
			case 1: Add(); break;
			case 2: Remove(); break;
			case 3: userQuery(selectDocType()); break;
			case 4: Docs.printAll(); begin(); break;
			case 5: Users.printAll(); begin(); break;
			case 6: System.out.println("Quitting"); break;
			default: System.out.println("invalid input!"); begin(); break;
		}
	}
	//allows user to select the type of document to interact with in the library. returns document type
	private String selectDocType(){	
		
		System.out.println("What type of Document would you like?");
		System.out.println("  Audio      - 1");
		System.out.println("  Book       - 2");
		System.out.println("  Conference - 3");
		System.out.println("  Video   - 4");
		System.out.println("  Journal    - 5");
		System.out.println("Please enter a number corresponding to your choice:");
		
		int userChoiceDoc = 0;
		userChoiceDoc = _scanner.nextInt();
		String docType = "";
		
		switch (userChoiceDoc){
			case 1: docType = "Audio"; break;
			case 2: docType = "Book"; break;
			case 3: docType = "Conference"; break;
			case 4: docType = "Video"; break;
			case 5: docType = "Journal"; break;
			default: System.out.println("Invalid Input!"); selectDocType(); break;
		}
		return docType;
	}
	//displays another menu to get input for user action and guide them to next step
	private void userQuery(String docType){
		System.out.println("What would you like to do?");
		System.out.println("Please enter a number Corresponding to your choice");
		System.out.println("  Search - 1");
		System.out.println("  Borrow - 2");
		System.out.println("  Return - 3");
		System.out.println("Please enter your choice:");
		int userChoice = 0;
		int secondaryChoice = 0;
		String userSearch = "hi:)";
		userChoice = _scanner.nextInt();
		
		
		if (userChoice == 1){
			System.out.println("You chose to search for \"" + docType + "\"");			
			System.out.println("Please enter a number Corresponding to your choice");
			System.out.println("  Search by Title     - 1");
			System.out.println("  Search by Publisher - 2");
			System.out.println("  Search by Author    - 3");
			System.out.println("Please enter your choice:");
			secondaryChoice = _scanner.nextInt();
			switch (secondaryChoice){
				case 1:
				case 2:
				case 3: System.out.println("Please enter a string to search for:");
					_scanner.nextLine();
					userSearch = _scanner.nextLine();
					System.out.println(Docs.search(secondaryChoice, docType, userSearch));
					begin();
					break;
				default: System.out.println("Invalid Input!"); userQuery(docType); break; 
			}
		}
			
			
		
		if (userChoice == 2){
			System.out.println("You chose to borrow from the libary!");
			//user id
			//document-id
			//due-date
			//item borrowed by user
			//number copies of the book updated
			borrow();
			begin();
		}
		if (userChoice == 3){
			System.out.println("You chose to return a book to the libary!");
			//user number books updated
			//number copies of book updated
			//related transaction record removed
			returnDoc();
			begin();
		}
		
		
	}
	//add a document to the library
	private void Add(){
		String type = "";
		String author = "";
		String title = "";
		String isbn = "";
		String publisher = "";
		String publishDate = "";
		int copies = 0;
		int volume = 0;
		int issue = 0;
		String userName = "";
		Document doc;
		Date timeOut = new Date();
		String location = "";
		String date = "";
		float length = 0;
		
		System.out.println("You Chose to add a User/Document:");
		System.out.println("Would you like to add a user or a document?");
		System.out.println("  User     - 1");
		System.out.println("  Document - 2");
		System.out.println("Please enter a number corresponding to your choice:");
		int addChoice = 0;
		addChoice = _scanner.nextInt();
		switch (addChoice){
			case 1: 
				System.out.println("You chose to add a User to the Library");
				System.out.println("Please enter a number for the type of user");
				System.out.println("Faculty - 1");
				System.out.println("Student - 2");
				System.out.println("Staff   - 3");
				int userTypeChoice = 0;
				userTypeChoice = _scanner.nextInt();
				String _userType = "";
				
				switch (userTypeChoice){
					case 1: _userType = "Faculty"; break;
					case 2: _userType = "Student"; break;
					case 3:_userType = "Staff"; break;
					default: System.out.println("Invalid Input"); Add(); break;
				}
				System.out.println("Please enter your Name");
				_scanner.nextLine();
				userName = _scanner.nextLine();
				
				User newUser;
				if (_userType == "Staff"){
					newUser = new Staff(userName, numUsers, 0, 12, _userType, _userType);
					Users.addStaffUser(numUsers, newUser);
				}
				if (_userType == "Student"){
					newUser = new Student(userName, numUsers, 0, 6, _userType, _userType);
					Users.addStudentUser(numUsers, newUser);
				}
				if (_userType == "Faculty"){
					newUser = new Faculty(userName, numUsers, 0, 12, _userType, _userType);
					Users.addFacultyUser(numUsers, newUser);
				}
				numUsers++;
				begin();
				break;
			case 2: 
				String typeOfDoc = selectDocType();
				if(typeOfDoc == "Audio"){
					System.out.println("You chose to add Audio to the Library");
					
					System.out.println("Please enter a Title"); 
				 	_scanner.nextLine();
					title = _scanner.nextLine();
				 	
					System.out.println("Please enter a publisher"); 
					publisher = _scanner.nextLine();
					
					System.out.println("Please enter a Publish date");
					publishDate = _scanner.nextLine();
					
					System.out.println("Please enter a Author");
					author = _scanner.nextLine();
					
					System.out.println("Please enter the Number of Copies");
					copies = _scanner.nextInt();
					
					type = "Audio";
					
					doc = new Audio(type, title, publisher, author, copies, publishDate, timeOut);
					Docs.addAudio(myIndex, doc);
				}
				if(typeOfDoc == "Book"){
					System.out.println("You chose to add a Book to the Library");
					System.out.println("Please enter a Title"); 
					_scanner.nextLine();
				 	title = _scanner.nextLine();
				 	
					System.out.println("Please enter a publisher"); 
					publisher = _scanner.nextLine();
					
					System.out.println("Please enter a Publish date");
					publishDate = _scanner.nextLine();
					
					System.out.println("Please enter a Author");
					author = _scanner.nextLine();
					
					System.out.println("Please enter the Number of Copies");
					copies = _scanner.nextInt();
					
					System.out.println("Please enter the Number of Copies");
					isbn = _scanner.nextLine();
					
					type = "Book";
					
					doc = new Book(type, title, publisher, author, copies, publishDate, isbn);
					Docs.addBook(myIndex, doc);
				}
				if(typeOfDoc == "Conference"){
					System.out.println("You chose to add a Conference to the Library");
					System.out.println("Please enter a Title"); 
					_scanner.nextLine();
				 	title = _scanner.nextLine();
				 	
					System.out.println("Please enter a publisher"); 
					publisher = _scanner.nextLine();
					
					System.out.println("Please enter a Publish date");
					publishDate = _scanner.nextLine();
					
					System.out.println("Please enter a Author");
					author = _scanner.nextLine();
					
					System.out.println("Please enter the Number of Copies");
					copies = _scanner.nextInt();
					
					System.out.println("Please enter the Number of Copies");
					isbn = _scanner.nextLine();
					
					type = "Conference";
					
					doc = new Conference(type, title, publisher, author, copies, publishDate, isbn, date, location);
					Docs.addConference(myIndex, doc);
				}
				if(typeOfDoc == "Journal"){
					System.out.println("You chose to add a Journal to the Library");
					System.out.println("Please enter a Title"); 
					_scanner.nextLine();
				 	title = _scanner.nextLine();
				 	
					System.out.println("Please enter a publisher"); 
					publisher = _scanner.nextLine();
					
					System.out.println("Please enter a Publish date");
					publishDate = _scanner.nextLine();
					
					System.out.println("Please enter a Author");
					author = _scanner.nextLine();
					
					System.out.println("Please enter the Number of Copies");
					copies = _scanner.nextInt();
					
					type = "Journal";
					
					doc = new Journal(type, title, publisher, author, copies, publishDate, volume, issue);
					Docs.addJournal(myIndex, doc);
				}
				if(typeOfDoc == "Video"){
					System.out.println("You chose to add a Video to the Library");
					System.out.println("Please enter a Title");
					_scanner.nextLine();
				 	title = _scanner.nextLine();
				 	
					System.out.println("Please enter a publisher"); 
					publisher = _scanner.nextLine();
					
					System.out.println("Please enter a Publish date");
					publishDate = _scanner.nextLine();
					
					System.out.println("Please enter a Author");
					author = _scanner.nextLine();
					
					System.out.println("Please enter the Number of Copies");
					copies = _scanner.nextInt();
					
					type = "Video";
					
					doc = new Video(type, title, publisher, author, copies, publishDate, length);
					Docs.addVideo(myIndex, doc);
				}
				myIndex++;
				begin();
				break;
			default: System.out.println("Invalid Input!"); Add(); break;
					
		}

	}
	//remove a document from the library
	private void Remove(){
		System.out.println("Would you like to remove a user or a Document?");
		System.out.println("User - 1");
		System.out.println("Document  - 2");
		int userRemoveChoice = 0;
		userRemoveChoice = _scanner.nextInt();
		if(userRemoveChoice == 1){
			System.out.println("Please Enter the name of the User you wish to remove");
			_scanner.nextLine();
			String nameToRemove = _scanner.nextLine();
			System.out.println(Users.removeName(nameToRemove) + "\n");
			begin();
		}
		if (userRemoveChoice == 2){
			String whatDocTypeToRemove = selectDocType();
			System.out.println("You chose to remove \"" + whatDocTypeToRemove + "\"");
			System.out.println("Please enter the title of the document you wish to remove");
			_scanner.nextLine();
			String docToRemoveTitle = "";
			docToRemoveTitle = _scanner.nextLine();
			if(whatDocTypeToRemove == "Audio"){
				Docs.removeAudio(docToRemoveTitle);
			}
			if(whatDocTypeToRemove == "Book"){
				Docs.removeBook(docToRemoveTitle);
			}
			if(whatDocTypeToRemove == "Conference"){
				Docs.removeConference(docToRemoveTitle);
			}
			if(whatDocTypeToRemove == "Journal"){
				Docs.removeJournal(docToRemoveTitle);
			}
			if(whatDocTypeToRemove == "Video"){
				Docs.removeVideo(docToRemoveTitle);
			}
			begin();
		}
		
		
		
	}
	//borrow an item from the library
	private void borrow(){
		String userID, docID;
		int dueDateLength;
		Date dueDate;
		System.out.println("Please enter your Name");
		_scanner.nextLine();
		userID = _scanner.nextLine();
		if (!Users.isUser(userID)){
			System.out.println("This userID is not linked to a user");
			begin();
		}
		
		dueDateLength = Users.getLendingPeriod(userID);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, dueDateLength);
		dueDate = cal.getTime();
		DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
		format.format(dueDate);
		
		String docType = selectDocType(); 
		
		System.out.println("Please enter the document title");
		_scanner.nextLine();
		docID = _scanner.nextLine();
		
		
		
		if (Docs.search(1, docType, docID)){
			LibraryOut newDoc;
			newDoc = new LibraryOut(userID, docID, dueDate);
			System.out.println(Docs.borrowDoc(newDoc));
			//decrement copies of that document
			Docs.xcrementCopies(docType, docID, 2);
			//increment user copies held count
			Users.searchUserAndAlter(userID, 1);
		}
		
		
		else{ System.out.println("Document does not exist!");}
		begin();
	}
	//return an item to the library
	private void returnDoc(){
		String userID, docID, dueDate = "";
		
		System.out.println("Please enter your Name");
		_scanner.nextLine();
		userID = _scanner.nextLine();
		
		if (!Users.isUser(userID)){
			System.out.println("This userID is not linked to a user");
			begin();
		}
		
		if(!Docs.hasDocOut(userID)){
			System.out.println("User does not have document borrowed");
			begin();
		}
		
		String docType = selectDocType(); 
		
		System.out.println("Please enter the document title");
		_scanner.nextLine();
		docID = _scanner.nextLine();
		
		if(!Docs.isBorrowedDoc(docID)){
			System.out.println("This is not a borrowed document");
			begin();
		}
		
		System.out.println(Docs.returnDoc(docID));
		//update copies of that document
		Docs.xcrementCopies(docType, docID, 1);
		//update user doc balance
		Users.searchUserAndAlter(userID, 2);
		//delete transaction record
		Docs.removeFromOut(docID);
		
		
		begin();
	}
}
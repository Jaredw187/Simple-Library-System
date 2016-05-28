import java.util.*;
//audio class to store information about audio in the library
public class Audio extends Document {
	//variables to store information unique to audio
    private Date timeOut;
    private String type;
    //constructor
	public Audio(String type, String title, String publisher, String author, int copies, 
			String publishDate, Date timeOut) {
    	super(type, title, publisher, author, copies, publishDate);
		this.timeOut = timeOut;    	
		this.type = type; 
	}
}
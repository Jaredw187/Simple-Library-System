//journal class to store information about journals
public class Journal extends Document {
	//variables to store information unique to the journal class
	private int volume = 0;
	private int issue = 0;
	private String type;
	private int loanDuration = 3;
	//constructor
	public Journal(String type, String title, String publisher, String author, int copies, 
			String publishDate, int volume, int issue) {
    	super(type, title, publisher, author, copies, publishDate);
    	this.volume = volume;
    	this.issue = issue;
    	this.type = type;
	}

}
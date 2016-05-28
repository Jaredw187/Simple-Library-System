//conference class to store information about conferences
public class Conference extends Book{
	//variables to store data unique to conferences
	private String location = "";
	private String date = "";
	private String type;
	//constructor
	public Conference( String type, String title, String publisher, String author, int copies, 
			String publishDate, String isbn, String date, String location) {
		super(type,title, publisher, author, copies, publishDate, isbn);
		this.date = date;
		this.location = location;
		this.type = type;
	}

    	

}
//book class to store information about books
public class Book extends Document {
	//variables to store information unique to books
	private String isbn;
	//constructor
	public Book(String type, String title, String publisher, String author, int copies, 
			String publishDate, String isbn) {
    	super(type, title, publisher, author, copies, publishDate);
    	this.isbn = isbn;
    }


}
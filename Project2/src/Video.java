//video class for objects of type video
public class Video extends Document {
    //store the length and type of the video
	private float length;
	private String type;
	//constructor
	public Video(String type, String title, String publisher, String author, int copies, 
			String publishDate, float length) {
    	super(type, title, publisher, author, copies, publishDate);
    	this.length = length;
    	this.type = type;
    }
}
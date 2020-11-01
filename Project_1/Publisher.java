package Project_1;


public class Publisher {

    private String publisherID;
    private String publisherName;
    private String publisherLocation;
    private Book[] bookList;


    public Publisher(){

    }

    public Publisher(String publisherID, String publisherName, String publisherLocation) {
        //super(); //not sure what this does...
        this.publisherID = publisherID;
        this.publisherName = publisherName;
        this.publisherLocation = publisherLocation;
    }




    public void display() {
        System.out.println("Publisher Information \n\tPublisher ID: "+getPublisherID()+" \n\tPublisher Name: "+getPublisherName()+" \n\tPublisher Location: "+getPublisherLocation());
    }




    public String getPublisherID() {
        return publisherID;
    }



    public void setPublisherID(String publisherID) {
        this.publisherID = publisherID;
    }



    public String getPublisherName() {
        return publisherName;
    }



    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }



    public String getPublisherLocation() {
        return publisherLocation;
    }



    public void setPublisherLocation(String publisherLocation) {
        this.publisherLocation = publisherLocation;
    }


    public Book[] getBookList() {
        return bookList;
    }


    public void setBookList(Book[] bookList) {
        this.bookList = bookList;
    }

}

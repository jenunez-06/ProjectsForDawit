package Project_1;


public class Book extends Publisher{


    private String bookID;
    private String bookTitle;
    private String pubYear;
    private int[] authorIDList;


    public Book() {

    }

    //ONLY BOOK INFORMATION
    public Book(String bookID, String bookTitle, String pubYear) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.pubYear = pubYear;
    }


    @Override
    public void display() {
        //super.display(); //this line is to display the publisher info too.
        System.out.println("\tBookID: "+getBookID()+" \n\tBook Title: "+getBookTitle()+" \n\tPublication Year: "+getPubYear());
    }



    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getPubYear() {
        return pubYear;
    }

    public void setPubYear(String pubYear) {
        this.pubYear = pubYear;
    }

    public int[] getAuthorIDList() {
        return authorIDList;
    }

    public void setAuthorIDList(int[] authorIDList) {
        this.authorIDList = authorIDList;
    }



}

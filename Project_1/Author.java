package Project_1;


public class Author extends Publisher{

    private String authorID;
    private String authorName;
    private String authorDOB;

    public Author() {

    }

    public Author(String authorID, String authorName, String authorDOB) {
        this.authorID = authorID;
        this.authorName = authorName;
        this.authorDOB = authorDOB;
    }


    @Override
    public void display() {
        System.out.println("\tAuthorID: "+getAuthorID()+" \n\tAuthor Name: "+getAuthorName()+" \n\tDOB: "+getAuthorDOB());
    }



    public String getAuthorID() {
        return authorID;
    }
    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    public String getAuthorDOB() {
        return authorDOB;
    }
    public void setAuthorDOB(String authorDOB) {
        this.authorDOB = authorDOB;
    }

}





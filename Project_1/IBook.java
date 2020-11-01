package Project_1;

import java.io.IOException;

public interface IBook {
    //IN AN INTERFACE CLASS, public AND abstract ARE NOT REQUIRED SINCE IT IS ASSUMED.
    public abstract void loadData() throws IOException;
    public void searchByAuthor(String authorName);
    void searchByTitle(String bookTitle);
    void searchByPublisher(String publisherName);



}

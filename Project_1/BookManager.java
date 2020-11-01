package Project_1;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookManager implements IBook {

    List<Publisher> pubListArray = new ArrayList<Publisher>();
    List<Book> bookListArray = new ArrayList<Book>();
    List<Author> authorListArray = new ArrayList<Author>();

    List<String[]> bookToPublisher = new ArrayList<String[]>();
    List<String[]> bookToAuthor = new ArrayList<String[]>();

    //		HashMap<String, List<Book>> pubToBookMap = new HashMap<String, List<Book>>();
//		HashMap<String, List<Author>> authorToBookMap = new HashMap<String, List<Author>>();
    @Override
    public void loadData() throws IOException {
        //Scenario 1: Search by publisher to get all the book titles that belong to that publisher
        //Scenario 2: Search by author and return all the books that author has.
        //Scenario 3: Search by book title. Return the book info.


        //READS IN THE PubList.txt FILE.
        FileReader pubListFile = new FileReader("src/Project_1/PubList.txt");
        Scanner pubListDataScan = new Scanner(pubListFile);
        pubListDataScan.nextLine();
        while (pubListDataScan.hasNext()) {
            //Takes the whole single line and puts it in the line var
            String line = pubListDataScan.nextLine();
            //Now, we split the line based on the delimiter chosen and put it into an array.
            String[] array = line.split(",");
            //Now that we have the line split, we create the publisher object using the info in the array.
            Publisher pub = new Publisher(array[0], array[1], array[2]);

            //This adds the book to the publisher list array
            pubListArray.add(pub);

            //pub.display();
        }	pubListDataScan.close();

        //READS IN THE BookList.txt FILE.
        FileReader bookListData = new FileReader("src/Project_1/BookList.txt");
        Scanner bookListDataScan = new Scanner(bookListData);
        bookListDataScan.nextLine();
        while (bookListDataScan.hasNext()) {
            //Takes the whole single line and puts it in the line var
            String line = bookListDataScan.nextLine();
            //Now, we split the line based on the delimiter chosen and put it into an array.
            String[] array = line.split(",");
            //Now that we have the line split, we create the publisher object using the info in the array.
            Book book = new Book(array[0], array[1], array[2]);
            //Adds the book to the book list array
            bookListArray.add(book);

            //book.display();
        }	bookListDataScan.close();

        //READS IN THE AuthorList.txt FILE AND PUTS IT IN A STRING ARRAY.
        //FileReader authorListData = new FileReader("AuthorList.txt");
        FileReader authorListData = new FileReader("src/Project_1/AuthorList.txt");
        Scanner authorListDataScan = new Scanner(authorListData);
        authorListDataScan.nextLine();
        while (authorListDataScan.hasNext()) {
            //Takes the whole single line and puts it in the line var
            String line = authorListDataScan.nextLine();
            //Now, we split the line based on the delimiter chosen and put it into an array.
            String[] array = line.split(",");
            //Now that we have the line split, we create the publisher object using the info in the array.
            Author author = new Author(array[0], array[1], array[2]);
            //Adds the author to the author list array
            authorListArray.add(author);

            //author.display();
        }		authorListDataScan.close();

        //READS IN THE Book_Author.txt FILE AND PUTS IT IN AN ARRAY.
        FileReader book_author = new FileReader("src/Project_1/Book_Author.txt");
        Scanner book_authorDataScan = new Scanner(book_author);
        book_authorDataScan.nextLine();
        while (book_authorDataScan.hasNext()) {
            String line = book_authorDataScan.nextLine();
            //Now, we split the line based on the delimiter chosen and put it into an array.
            String[] array = line.split(",");

            bookToAuthor.add(array);

            //System.out.println(array[0] +"\t"+ array[1] +"\t"+ array[2]);
        }		book_authorDataScan.close();

        //READS IN THE Book_Publisher.txt FILE AND PUTS IT IN AN ARRAY.
        FileReader book_pub = new FileReader("src/Project_1/Book_Publisher.txt");
        Scanner book_pubDataScan = new Scanner(book_pub);
        book_pubDataScan.nextLine();
        while (book_pubDataScan.hasNext()) {
            String line = book_pubDataScan.nextLine();
            //Now, we split the line based on the delimiter chosen and put it into an array.
            String[] array = line.split(",");

            bookToPublisher.add(array);
        } 		book_pubDataScan.close();
    }


    @Override
    public void searchByPublisher(String publisherName) {
		/*
		The logic here is to go through all the publisher objects (which contain arrays).
		If it finds the publisher name in the array, get that ID.
		With ID in hand, we can return the "list of books" that is attached to that publisher ID.
		 */
        System.out.println("=======You're looking for books published by "+publisherName);

		/*This loop goes through the publisher object list and looks for the ID of the passed publisherName argument.
		Once it gets the ID, it can go to the Book_Publisher.txt List and find the book IDs that
		matches the publisher list.
		 */
        for (Publisher pub : pubListArray) {
            if (publisherName.equals(pub.getPublisherName())) {
                String pubID = pub.getPublisherID();    //this line gets the publisher's ID
                List<String> books = new ArrayList<>(); //this array is for storing the books the pub may have

                //This loop is taking the pubID and going over to the bookToPublisher file (which is an ArrayList object)
                //and returning the matching bookID
                for (String[] i : bookToPublisher){
                    if (pubID.equals(i[2])){
                        String obtainedBookID = i[1];
                        books.add(obtainedBookID);
                    }
                }
                //With the bookID obtained, we go to the list of book objects and print that book's info
                System.out.println("This publisher's books are: ");
                for (String i : books){
                    bookListArray.get(Integer.parseInt(i)-1).display(); //has to be -1 since the IDs need to match its index within the array.
                    System.out.println("");
                }
            }
        }
    }

    @Override
    public void searchByTitle(String bookTitle) {
        System.out.println("=======You're looking for the book: "+bookTitle);

        for (Book book : bookListArray) {
            if (bookTitle.equals(book.getBookTitle())) {
                book.display();
                String bookID = book.getBookID();    //this line gets the book's ID
                List<String> authors = new ArrayList<>(); //this array is for storing the authors the book may have

                //This loop is taking the bookID and going over to the bookToAuthor file (which is an ArrayList object)
                //and returning the matching authorID
                for (String[] i : bookToAuthor){
                    if (bookID.equals(i[1])){
                        String obtainedAuthorID = i[2];
                        authors.add(obtainedAuthorID);
                    }
                }
                //With the authorIDs obtained, we go to the list of author objects and print that author's name
                System.out.println("\nThis book's authors is/are: ");
                for (String i : authors){
                    for (Author j : authorListArray){
                        if (i.equals(j.getAuthorID())){
                            j.display();
                            System.out.println("");
                        }
                    }
                }
            }
        }
    }

    @Override
    public void searchByAuthor(String authorName) {
        System.out.println("\n=======You're looking for books authored by: "+authorName);
        for (Author author : authorListArray) {
            if (authorName.equals(author.getAuthorName())) {
                String authorID = author.getAuthorID();    //this line gets the ID
                List<String> books = new ArrayList<>(); //this array is for storing the books

                //This loop is taking the authorID and going over to the bookToAuthor file (which is an ArrayList object)
                //and returning the matching bookID
                for (String[] i : bookToAuthor){
                    if (authorID.equals(i[2])){
                        String obtainedBookID = i[1];
                        books.add(obtainedBookID);
                    }
                }
                //With the bookID obtained, we go to the list of book objects and print that book's info
                System.out.println("This author's books are: ");
                for (String i : books){
                    bookListArray.get(Integer.parseInt(i)-1).display();
                    System.out.println("");
                }
            }
        }
    }





    public static void main(String[] args) throws IOException {

        BookManager manager = new BookManager();
        manager.loadData();

        //List of book titles available: Clean Code		Java For Starters		Data Science	Advanced Java	Data Science II
        manager.searchByTitle("Clean Code");

        //List of publishers available: Data Publ		Carole Inst		Pearson
        manager.searchByPublisher("Carole Inst");

        //List of authors available: Mark	Judy	David	Marry	Caleb	Dawit
        manager.searchByAuthor("Judy");


    }
}

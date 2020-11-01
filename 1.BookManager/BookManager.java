package Assignment_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BookManager {

    /*
     * THIS METHOD READS THE DATA FROM THE GIVEN FILE AND LOADS IT INTO A COLLECTION OF STUDENT OBJECTS
     *
     * -In the Book Manager class, create a method that loads the book information from the text file called book.txt.
     * -Then provide methods that allow a user to search by title or author and display the content of the object
     */



    //DECLARED HERE FOR GLOBAL SCOPE
    //** NOT ENTIRELY SURE WHY THE PROGRAM REQUIRED ME TO ADD STATIC IN FRONT OF THE OBJECTS...**
    static Book book;
    static Author author;

    static HashMap<String, String> hashBookAndAuthor = new HashMap<String, String>();
    static HashMap<String, String> hashAuthorAndBook = new HashMap<String, String>();

    static List<Book> bookList = new ArrayList<Book>();          	//List is an interface while ArrayList is a concrete class.
    static List<Author> authorList = new ArrayList<Author>();       //use List by default. Arraylist is bad form.
    //List<String> bookAndAuthor = new ArrayList<String>();


    /*
     * 1. THIS METHOD ASKS THE USER TO PROVIDE THE fileName AS AN ARGUMENT
     * 2. IT THEN READS THE FILE AND SPLITS THE DATA INTO AN ARRAY THAT IS ORGANIZED BY
     *
     * 		COLUMN 1: BOOK TITLE
     * 		COLUMN 2: GENRE
     * 		COLUMN 3: NUMBER OF PAGES
     * 		COLUMN 4: AUTHOR
     * 	 **NOTE** THE PROVIDED TEXT FILE MUST BE A CSV. THE COLUMNS MUST ALSO MATCH.**
     *
     * 3. PRINTS ALL THE BOOKS THAT ARE IN TEXT FILE.
     */

    private void readAndPrintLibrary(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);			//locates the file
        BufferedReader br = new BufferedReader(fr);			//loads the data into temp memory
        String line = br.readLine();

        System.out.print("These are the books in this library: \n");

        while (line != null) {
            //The text file is split based on the regex chosen. 0 says that there is no limit to how long the created array can be.
            String[] data = line.split(",", 0);

            //The objects are then initialized with the parsed information.
            book = new Book(data[0], data[1], Integer.parseInt(data[2]));
            author = new Author(data[3]);
            //The objects are then stored in an ArrayList.
            bookList.add(book);
            authorList.add(author);
            hashBookAndAuthor.put(book.getTitle().toLowerCase(), author.getName());

            //need to iterate through the author list to find duplicates. If it has it, add it to the authors book list.

            String[] bk = {"hi","he"};
            author.setList(bk);

            hashAuthorAndBook.put(author.getName(), book.getTitle());
            //This checks for duplicate authors in the list and removes it.
            //if()


            //This pushes the cursor to the next line in preparation for the next line read.
            line = br.readLine();
        }

        System.out.println(hashBookAndAuthor);
        System.out.println(hashAuthorAndBook);

        System.out.println("");
        br.close();
    }



    /*
     *  THIS METHOD REQUIRES THE USER TO PASS A BOOK NAME. IF IT IS FOUND IN THE LIST OF BOOKS, IT PRINTS ALL THE DETAILS.
     */
    public static void searchByBook(String name) {

        boolean found = false;
        for (Book b: bookList) {
            if (b.getTitle().equalsIgnoreCase(name)) {
                System.out.print("\tBook details: \n\t"+ b.getTitle()+" \n\tWritten by: "+hashBookAndAuthor.get(name.toLowerCase())+" \n\tThe genre is: "+b.getGenre()+" \n\tNumber of Pages: "+b.getNumberOfPages());
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Book was not found..."
                    + "\nHere is a list of the books available: "
                    + "\n"+hashBookAndAuthor);
        }
    }


    //WASN'T ABLE TO FIGURE OUT HOW TO searchByAuthor

    public static void searchByAuthor(String name) {
        boolean found = false;
        for (Author b: authorList) {
            if (b.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\n\tAuthor details: \n\t"+ b.getName()+" \n\tBook Title: "+bookList+" \n\tThe genre is: "+b.getName()+" \n\tNumber of Pages: "+b.getName());
                System.out.println();
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Author was not found..."
                    + "\nHere is a list of the authors available: "
                    + "\n"+hashAuthorAndBook.keySet());
        }
    }





    public static void main(String[] args) throws IOException {

        BookManager myLibrary = new BookManager();

        //Pass the title of the text file to read.
        myLibrary.readAndPrintLibrary("book.txt");

        //Search for a book in text file. Upper or lower case does not matter.
        searchByBook("robot");

        //Search by author. Does not account for author's with multiple books. Furthermore, the hashmap
        //this methods references was not completed.
        searchByAuthor("Robert C. Martin");


    }
}

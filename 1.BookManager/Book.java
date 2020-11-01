package Assignment_1;

public class Book {

    private String title;
    private String genre;
    private int numberOfPages;



    //DEFAULT CONSTRUCTOR THAT THE COMPILER CREATS FOR US IF YOU DON'T SPECIFY ONE.
//	public Book() {
//
//	}


    //THIS WOULD REPLACE THE DAFAULT CONSTRUCTOR.
    public Book(String title, String genre, int i) {
        this.title = title;
        this.genre = genre;
        this.numberOfPages = i;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }




}

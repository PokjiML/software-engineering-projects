package gift;

public class Book extends Gift {
    private String genre;
    private String author;
    private String title;

    public Book(String name, String type, String genre, String author, String title) {
        super(genre + " Book", "Book");
        this.genre = genre;
        this.author = author;
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }

}

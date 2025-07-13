package gift;

public class BookFactory {

    public Gift createGift(String name, String type, String genre, String author, String title) {
        return new Book(name, type, genre, author, title);
    }

}

package librarymanagementsystem;

import java.util.List;

public class Book {
    public int   bookId;
    public String bookName;
    public String bookTitle;
    public Genre genre;
    List<Author> authors;
    public Book(int bookId, String bookName, List<Author> authors, Genre genre) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authors = authors;
        this.genre = genre;
    }
}

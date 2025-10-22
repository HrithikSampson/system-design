package librarymanagementsystem;
import java.util.List;
public class Author extends Person {
    List<Book> books;
    public Author(String name,List<Book> books){
        super(name);
        this.books = books;
    }
}

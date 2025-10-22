package librarymanagementsystem;

import java.util.Date;
import java.util.List;

public interface ISearchFunctionality {
    List<BookItem> getBooksByAuthor(String author);
    List<BookItem> getBooksByTitle(String title);
    List<BookItem> getBooksByName(String name);
    List<BookItem> getBooksByPublicationDate(Date publicationDate);
}

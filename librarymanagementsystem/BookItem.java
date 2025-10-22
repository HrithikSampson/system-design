package librarymanagementsystem;

import java.util.Date;
import java.util.List;

public class BookItem extends Book {
    Location location;
    String barcode;
    Date publicationDate;
    public BookItem(int bookId, String bookName, List<Author> authors, Genre genre,Location location, String barcode, Date publicationDate) {
        super(bookId,bookName, authors, genre);
        this.location = location;
        this.barcode = barcode;
        this.publicationDate = publicationDate;
    }
}

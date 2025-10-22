package librarymanagementsystem;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class SearchFunctionality implements ISearchFunctionality {
    private final Library library;
    public SearchFunctionality(Library library){
        this.library=library;
    }
    public List<BookItem> getBooksByAuthor(String author) {
        Predicate<BookItem> p = bookItem ->
                bookItem.authors.stream().anyMatch(
                        author1 ->
                                author1.name.equals(author)
                );
        return filter(p);
    }
    public List<BookItem> getBooksByTitle(String title) {
        Predicate<BookItem> p = bookItem ->
            bookItem.bookTitle.equals(title);
        
        return filter(p);
    }

    public List<BookItem> getBooksByName(String name) {
        Predicate<BookItem> p = bookItem ->
                bookItem.bookName.equals(name);
        return filter(p);
    }

    private List<BookItem> filter(Predicate<BookItem> p) {
        return library.getBooks().stream().filter(p).collect(Collectors.toList());
    }
    public List<BookItem> getBooksByPublicationDate(Date publicationDate) {
        Predicate<BookItem> p =  bookItem -> {
            return bookItem.publicationDate.equals(publicationDate);
        };
        return filter(p);
    }
}

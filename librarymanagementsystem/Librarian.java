package librarymanagementsystem;

public abstract class Librarian extends Person {
    ISearchFunctionality searchFunctionality;
    IBookIssueService bookIssueService;
    Library library;
    public Librarian(String name,IBookIssueService bookIssueService, ISearchFunctionality searchFunctionality, Library library) {
        super(name);
        this.bookIssueService = bookIssueService;
        this.searchFunctionality = searchFunctionality;
        this.library = library;
    }
    public void addBook(BookItem bookItem) {
        library.addBook(this, bookItem);
    }
}

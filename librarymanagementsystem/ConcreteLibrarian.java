package librarymanagementsystem;

public class ConcreteLibrarian extends Librarian {
    public ConcreteLibrarian(String name,IBookIssueService bookIssueService, ISearchFunctionality searchFunctionality, Library library) {
        super(name, bookIssueService, searchFunctionality, library);
    }
}

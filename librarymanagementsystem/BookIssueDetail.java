package librarymanagementsystem;

import java.util.Date;

public class BookIssueDetail {
    private BookItem book;
    private Person issuedTo;
    private Date issueDate;
    private Date dueDate;

    public BookIssueDetail(BookItem book, Person issuedTo, Date issueDate, Date dueDate) {
        this.book = book;
        this.issuedTo = issuedTo;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
    }

    public BookItem getBook() {
        return book;
    }

    public Person getIssuedTo() {
        return issuedTo;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }
}
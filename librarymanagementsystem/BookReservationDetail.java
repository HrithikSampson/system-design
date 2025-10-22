package librarymanagementsystem;

import java.util.Date;

public class BookReservationDetail {
    private BookItem book;
    private Person reservedBy;
    private Date reservedDate;

    public BookReservationDetail(BookItem book, Person reservedBy, Date reservedDate) {
        this.book = book;
        this.reservedBy = reservedBy;
        this.reservedDate = reservedDate;
    }

    public BookItem getBook() {
        return book;
    }

    public Person getReservedBy() {
        return reservedBy;
    }

    public Date getReservedDate() {
        return reservedDate;
    }
}
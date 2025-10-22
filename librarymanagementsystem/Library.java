package librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

import librarymanagementsystem.BookItem;

public class Library {
    String name;
    private List<BookItem> books;
    Address address;
    private List<Librarian> librarians;
    public Library(String name, Address address) {
        this.name = name;
        this.address = address;
        this.books = new ArrayList<>();
    }
    public Library(String name, Address address, List<BookItem> books) {
        this.name = name;
        this.address = address;
        this.books = books;
    }
    public void addBook(Librarian librarian, BookItem book) {
        if(!librarians.contains(librarian)) {
            throw new Error("Librarian doesn't belong to this library");
        }
        books.add(book);
    }
    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }
    public List<BookItem> getBooks() {
        return books;
    }
}
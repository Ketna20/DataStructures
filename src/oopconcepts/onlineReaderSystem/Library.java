package oopconcepts.onlineReaderSystem;
/*
 * ketnakhalasi created on 7/20/21
 * */

import java.util.HashMap;
import java.util.Map;

public class Library {

    private Map<String, Book> books = new HashMap<>();

    protected void addBook(Book book) {
        books.putIfAbsent(book.getIsbn(), book);
    }
    protected boolean removeBook(Book book) {
        return books.remove(book.getIsbn(), book);
    }

    protected Book findBook(String isbn) {
        return books.get(isbn);
    }
}

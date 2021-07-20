package oopconcepts.onlineReaderSystem;
/*
 * ketnakhalasi created on 7/20/21
 * */

public class Displayer {
    private Book book;
    private Reader reader;
    private String page;
    private int pageNumber;

    protected void displayReader(Reader reader) {
        this.reader = reader;
        refreshReader();
    }

    protected void displayBook(Book book) {
        this.book = book;
        refreshBook();
    }

    protected void nextPage() {
        page = book.fetchPage(++pageNumber);
        refreshPage();
    }

    private void refreshPage() {
        System.out.println("Reading page number : " + pageNumber + " content " + page);
    }

    private void refreshReader() {
        System.out.println("Reader : " + reader.getName());
    }
    private void refreshBook() {
        pageNumber = 0;
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
    }

}

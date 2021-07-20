package oopconcepts.onlineReaderSystem;
/*
 * ketnakhalasi created on 7/20/21
 * */

public class OnlineReaderSystem {
    private Displayer displayer;
    private Library library;
    private ReaderManager readerManager;

    private Reader reader;
    private Book book;

    public OnlineReaderSystem() {
        displayer = new Displayer();
        library = new Library();
        readerManager = new ReaderManager();
    }

    public void displayReader(Reader reader) {
        this.reader = reader;
        displayer.displayReader(reader);
    }

    public void displayReader(String email) {
        this.reader = readerManager.findReader(email);
        if(reader != null) {
            displayer.displayReader(reader);
        }
    }

    public void displayBook(Book book) {
        this.reader = reader;
        displayer.displayReader(reader);
    }

    public void displayBook(String email) {
        this.reader = readerManager.findReader(email);
        if(reader != null) {
            displayer.displayReader(reader);
        }
    }

    public void nextPage() {
        displayer.nextPage();
    }

    public void previousPage() {
        displayer.previousPage();
    }

    public void addReader(Reader reader) {
        readerManager.addReader(reader);
    }

    public boolean deleteReader(Reader reader) {
        if(!reader.equals(this.reader)){
            return readerManager.removeReader(reader);
        }
        return false;
    }

    public void addBook(Book book) {
        library.addBook(book);
    }

    public boolean deleteBook(Book book) {
        if(!book.equals(this.book)){
            return library.removeBook(book);
        }
        return false;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

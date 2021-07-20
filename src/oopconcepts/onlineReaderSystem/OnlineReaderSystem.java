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

}

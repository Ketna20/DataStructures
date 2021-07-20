package oopconcepts.onlineReaderSystem;
/*
 * ketnakhalasi created on 7/20/21
 * */

public class OnlineReaderSystemMain {

    public static void main(String[] args) {
        Reader mark = new Reader("Mark M.", "mark@gmail.com");
        Book masterOfGames = new Book("Master of Games", "Sidney Sheldon", "MG123");

        OnlineReaderSystem onlineReaderSystem = new OnlineReaderSystem();
        onlineReaderSystem.addReader(mark);
        onlineReaderSystem.addBook(masterOfGames);
        onlineReaderSystem.displayReader(mark);
        onlineReaderSystem.displayBook(masterOfGames);

        onlineReaderSystem.nextPage();
        onlineReaderSystem.nextPage();
        onlineReaderSystem.nextPage();
        onlineReaderSystem.previousPage();
    }
}

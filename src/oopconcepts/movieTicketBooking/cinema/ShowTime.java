package oopconcepts.movieTicketBooking.cinema;

public enum ShowTime {
    NINE_AM(1), ELEVEN_AM(2),
    ONE_PM(3), THREE_PM(4),
    FIVE_PM(5), SEVEN_PM(6),
    NINE_PM(7), TEN_PM(8);

    private int showNumber;

    ShowTime(int showNumber) {
        this.showNumber = showNumber;
    }

    public int getShowNumber() {
        return showNumber;
    }

    public void setShowNumber(int showNumber) {
        this.showNumber = showNumber;
    }
}

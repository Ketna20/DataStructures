package oopconcepts.movieTicketBooking.cinema;

public enum SeatType {
    SIMPLE(1), SILVER(5), GOLD(10);

    private final int price;

    SeatType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

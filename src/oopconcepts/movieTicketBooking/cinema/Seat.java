package oopconcepts.movieTicketBooking.cinema;
/*
 * ketnakhalasi created on 7/21/21
 * */

public class Seat {

    private final CinemaRoom cinemaRoom;
    private final String number;
    private final SeatType seatType;
    private boolean available = true;

    public Seat(CinemaRoom cinemaRoom, String number, SeatType seatType) {
        this.cinemaRoom = cinemaRoom;
        this.number = number;
        this.seatType = seatType;
    }

    protected void assignSeat() {
        available = false;
    }
    protected void releaseSeat() {
        available = true;
    }

    protected int seatPrice() {
        return this.seatType.getPrice();
    }

    public CinemaRoom getCinemaRoom() {
        return cinemaRoom;
    }

    public String getNumber() {
        return number;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public boolean isFree() {
        return available;
    }

    public void setFree(boolean available) {
        this.available = available;
    }
}

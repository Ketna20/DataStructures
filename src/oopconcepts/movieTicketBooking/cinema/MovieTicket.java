package oopconcepts.movieTicketBooking.cinema;
/*
 * ketnakhalasi created on 7/21/21
 * */

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class MovieTicket {
    private Movie movie;
    private LocalTime startTime;
    private LocalTime endTime;
    private String roomName;
    private List<String> seatNumbers;
    private int price;

    public MovieTicket(Movie movie, LocalTime startTime,
                       String roomName, List<String> seatNumbers,
                       int price) {
        this.movie = movie;
        this.startTime = startTime;
        this.price = price;
        this.roomName = roomName;
        this.seatNumbers = seatNumbers;
        this.endTime = this.startTime.plusMinutes(movie.getMinutes());
    }

    public boolean isValid() {
        return LocalTime.now().isAfter(startTime)
                && LocalTime.now().isBefore(endTime);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

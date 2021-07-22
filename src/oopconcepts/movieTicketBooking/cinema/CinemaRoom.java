package oopconcepts.movieTicketBooking.cinema;
/*
 * ketnakhalasi created on 7/21/21
 * */

import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CinemaRoom {
    private String roomName;
    private boolean open = true;
    private ShowTime showTime;
    private List<Seat> seats;
    private Map<Movie, Integer> schedule = new HashMap<>();

    public CinemaRoom(String roomName) {
        this.roomName = roomName;
    }

    public CinemaRoom(String roomName, List<Seat> seats) {
        this.roomName = roomName;
        this.seats = seats;
    }

    public void displaySchedule() {
        System.out.println("schedule: " + getSchedule().toString());
    }

    public boolean createSchedule(List<Movie> movies) {

        if(movies.size() <= 8) {
            int show = 1;
            for(Movie movie : movies) {
                schedule.put(movie, show);
                show++;
            }
        } else {
            return false;
        }
        return true;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public ShowTime getShowTime() {
        return showTime;
    }

    public void setShowTime(ShowTime showTime) {
        this.showTime = showTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Map<Movie, Integer> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<Movie, Integer> schedule) {
        this.schedule = schedule;
    }
}

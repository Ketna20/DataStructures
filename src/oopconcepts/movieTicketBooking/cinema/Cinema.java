package oopconcepts.movieTicketBooking.cinema;
/*
 * ketnakhalasi created on 7/21/21
 * */

import java.util.HashMap;
import java.util.Map;

public class Cinema {
    private String cinemaName;
    private Map<String, CinemaRoom> rooms = new HashMap<>();

    public Cinema(String cinemaName, Map<String, CinemaRoom> rooms) {
        this.cinemaName = cinemaName;
        this.rooms = rooms;
    }


    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public Map<String, CinemaRoom> getRooms() {
        return rooms;
    }

    public void setRooms(Map<String, CinemaRoom> rooms) {
        this.rooms = rooms;
    }
}

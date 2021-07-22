package oopconcepts.movieTicketBooking.cinema;
/*
 * ketnakhalasi created on 7/21/21
 * */

import java.util.Objects;

public class Movie {
    private int id;
    private String title;
    private String category;
    private int minutes;

    public Movie(int id, String title, String category, int minutes) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.minutes = minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id &&
                minutes == movie.minutes &&
                Objects.equals(title, movie.title) &&
                Objects.equals(category, movie.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, category, minutes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
}

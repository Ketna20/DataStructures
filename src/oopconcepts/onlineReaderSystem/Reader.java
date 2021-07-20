package oopconcepts.onlineReaderSystem;
/*
 * ketnakhalasi created on 7/20/21
 * */

import java.util.Objects;

public class Reader {
    private String name;
    private String email;

    public Reader(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(name, reader.name) &&
                Objects.equals(email, reader.email);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * Objects.hashCode(this.name);
        hash = 71 * Objects.hashCode(this.email);
        return hash;
    }
}

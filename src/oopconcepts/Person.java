package oopconcepts;
/*
 * ketnakhalasi created on 7/13/21
 * */

public class Person {
    private String name;
    private Address address;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        String city = this.address.getCity();
        String zip = this.address.getZip();

        return city + " " + zip;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

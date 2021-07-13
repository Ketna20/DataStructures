package oopconcepts;
/*
 * ketnakhalasi created on 7/13/21
 * */

public class AssociationExample {

    public static void main(String[] args) {
        Person kate = new Person("Kate");
        Person amy = new Person("Amy");
        Address a1 = new Address("Torrance","90503");
        Address a2 = new Address("Torrance","90502");
        kate.setAddress(a1);
        amy.setAddress(a2);
        System.out.println(kate.getName() + " lives at " + kate.getAddress());
        System.out.println(amy.getName() + " lives at " + amy.getAddress()
        );
    }
}

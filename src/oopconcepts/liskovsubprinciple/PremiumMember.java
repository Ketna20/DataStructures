package oopconcepts.liskovsubprinciple;
/*
 * ketnakhalasi created on 7/13/21
 * */

public class PremiumMember extends Member {

    public PremiumMember(String name) {
        super(name);
    }

    @Override
    public void joinTournament() {
        System.out.println("Premium member joins tournament.");
    }

    @Override
    public void organizeTournament() {
        System.out.println("Premium member organizes tournament.");
    }
}

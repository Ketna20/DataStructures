package oopconcepts.liskovsubprinciple;
/*
 * ketnakhalasi created on 7/13/21
 * */

public class VipMember extends Member {

    public VipMember(String name) {
        super(name);
    }

    @Override
    public void joinTournament() {
        System.out.println("VIP member joins tournament.");
    }

    @Override
    public void organizeTournament() {
        System.out.println("VIP member organizes tournament.");
    }
}

package oopconcepts.liskovsubprinciple;
/*
 * ketnakhalasi created on 7/13/21
 * */

public class FreeMember implements TournamentJoiner {
    private String name;
    public FreeMember(String name) {
        this.name = name;
    }

    @Override
    public void joinTournament() {
        System.out.println("Classic member joins tournament.");
    }

}

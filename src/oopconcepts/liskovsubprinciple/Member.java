package oopconcepts.liskovsubprinciple;
/*
 * ketnakhalasi created on 7/13/21
 * */

public abstract class Member implements TournamentJoiner, TournamentOrganizer {
    private final String name;

    public Member(String name) {
        this.name = name;
    }



}

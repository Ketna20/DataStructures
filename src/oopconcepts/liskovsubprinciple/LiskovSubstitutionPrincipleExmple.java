package oopconcepts.liskovsubprinciple;
/*
 * ketnakhalasi created on 7/13/21
 * */

import com.sun.tools.javac.util.List;

public class LiskovSubstitutionPrincipleExmple {

    public static void main(String[] args) {
        List<TournamentJoiner> members = List.of(
                new PremiumMember("Jack Smith"),
                new PremiumMember("Abby Goel"),
                new FreeMember("Ketu Kumar")
        );

        /** looping the list and substituting each member with
            TournamentJoiner interface works as expected and observes
            Liskov's Substitution Principle
        **/
        for (TournamentJoiner memeber : members) {
            memeber.joinTournament();
        }

        List<TournamentOrganizer> organizers = List.of(
                new PremiumMember("Jack Smith"),
                new VipMember("Abby Goel")
        );

        for(TournamentOrganizer organizer : organizers) {
            organizer.organizeTournament();
        }
    }
}

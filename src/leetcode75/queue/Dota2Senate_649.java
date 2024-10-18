package leetcode75.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In the world of Dota2, there are two parties: the Radiant and the Dire.
 *
 * The Dota2 senate consists of senators coming from two parties. Now the Senate wants to decide on a change in the Dota2 game. The voting for this change is a round-based procedure. In each round, each senator can exercise one of the two rights:
 *
 * Ban one senator's right: A senator can make another senator lose all his rights in this and all the following rounds.
 * Announce the victory: If this senator found the senators who still have rights to vote are all from the same party, he can announce the victory and decide on the change in the game.
 * Given a string senate representing each senator's party belonging. The character 'R' and 'D' represent the Radiant party and the Dire party. Then if there are n senators, the size of the given string will be n.
 *
 * The round-based procedure starts from the first senator to the last senator in the given order. This procedure will last until the end of voting. All the senators who have lost their rights will be skipped during the procedure.
 *
 * Suppose every senator is smart enough and will play the best strategy for his own party. Predict which party will finally announce the victory and change the Dota2 game. The output should be "Radiant" or "Dire".
 * Example 1:
 * Input: senate = "RD"
 * Output: "Radiant"
 * Explanation:
 * The first senator comes from Radiant and he can just ban the next senator's right in round 1.
 * And the second senator can't exercise any rights anymore since his right has been banned.
 * And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
 * Example 2:
 * Input: senate = "RDD"
 * Output: "Dire"
 * Explanation:
 * The first senator comes from Radiant and he can just ban the next senator's right in round 1.
 * And the second senator can't exercise any rights anymore since his right has been banned.
 * And the third senator comes from Dire and he can ban the first senator's right in round 1.
 * And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
 *
 * Solution Idea
 * We will use a two queue approach.
 * Recall, each senator has a position to exercise their right.
 * The ones to the left have an earlier turn than the ones to the right.
 * rad is queue that holds all positions of active senators in "Radiant"
 * dir is queue that holds all positions of active senators in "Dire".
 * Active being that they still have the right to vote.
 * Our queue will be ordered so that the senators with earlier voting power come first (to the left of the queue).
 * To goal is to have the earliest senator of each queue fight each other to see who gets to eliminate the other depending on their position.
 * Obviously, the one with the earlier position will win.
 * The loser is removed from the queue since they are no longer active.
 * The winner will go to the end of the queue for the next round.
 * We keep doing this until one queue is empty which means there are no more senators on the team.
 * Example : senate = "RDDDRDRRDR"
 * insert each senator in their respective queue, each uniquely identifies by their indexes
 * Queue rad = 0 4 6 7 9
 * Queue dir = 1 2 3 5 8
 * here the size senate size n = 10.
 * we will use the size to increment as the senates are going in next round
 *  n=10
 *      Queue rad = 0 4 6 7 9
 *      Queue dir = 1 2 3 5 8
 *   we look at the front of the both queues and they both fight with each other,
 *   whoever has lower index, he wins.
 *   since rad's index(0) is lower than dir's index(1), rad wins.
 *   so we increment n and push it in rad queue
 *   n=11
 *      Queue rad = 4 6 7 9 10
 *      Queue dir = 2 3 5 8
 *    now rad(4) and dir(2) fights and dir wins
 *    n=12
 *     Queue rad = 6 7 9 10
 *     Queue dir = 3 5 8 11
 *    they keep fighting until we enventually obtain
 *    n=16
 *    Queue rad = 15
 *    Queue dir = 12 13 14
 *    After this fight Dir wins and rad queue becomes empty.
 *    So Dire wins.
 */

public class Dota2Senate_649 {
    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> rad = new LinkedList<>();
        Queue<Integer> dir = new LinkedList<>();

        for(int i=0; i<n; i++) {
            if(senate.charAt(i) == 'R') {
                rad.offer(i);
            } else {
                dir.offer(i);
            }
        }

        while(!rad.isEmpty() && !dir.isEmpty()) {
            if(rad.peek() < dir.peek()) {
                rad.offer(n++);
            } else {
                dir.offer(n++);
            }
            rad.poll();
            dir.poll();
        }
        return (rad.isEmpty()) ? ("Dire") : ("Radiant");
    }
}

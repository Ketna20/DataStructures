package ik.learn.adhoc;

public class RobotBoundInCircle {
    public static void main(String[] args) {
        boolean ans = isRobotBounded("GG");
        System.out.println(ans);
    }

    public static boolean isRobotBounded(String instructions) {
        //facing directions: North=0, East=1, South=2, West=3
        int currX = 0, currY = 0, currD = 0;
        char[] directions = instructions.toCharArray();
        for(int i=0; i<directions.length; i++) {
            if(directions[i] == 'R') {
                currD = (currD+1) % 4;
            } else if(directions[i] == 'L') {
                currD = (currD-1) % 4;
            } else if(directions[i] == 'G') {
                if(currD == 0){
                    currY++;
                }else if(currD == 1) {
                    currX++;
                } else if(currD == 2) {
                    currY--;
                }else {
                    currX--;
                }
            }
        }

        if((currX+currY) != 0 && currD == 0) {
            return false;
        }

        return true;
    }
}

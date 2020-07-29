package intervwPrep;
/*
 * ketnakhalasi created on 7/15/20
 * */

public class CountingValleys {

    public static void main(String[] args) {
        int stepsCount = 8;
       // String steps = "UDDDUDUU";
        String steps = "DDUUDDUU";
        int vallyes = countingValleys(stepsCount, steps);
        System.out.println(vallyes);

    }

    static int countingValleys(int n, String s) {
        char [] steps = s.toCharArray();
        int seaLevel = 0;
        int valleys = 0;
        for(char c: steps) {
            if (c == 'U') {
                ++seaLevel;
            } else {
                --seaLevel;
            }
            if(seaLevel == 0 && c == 'U') {
                ++valleys;
            }
        }

        return valleys;
    }
}

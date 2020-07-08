package ProblemSolving;

public class KangarooJumps {

    public static void main(String[] args) {
       // System.out.println(kangarooMeet(0, 3, 4, 2));
        System.out.println(kangarooMeet(43, 2, 70, 2));
    }

    /**
     * Example X1=0,V1=3 , X2=4, V2=2
     * 0,3,6,9,12
     * 4,6,8,10,12
     * @param x1
     * @param v1
     * @param x2
     * @param v2
     * @return
     */
    public static String kangarooMeet(int x1, int v1, int x2, int v2) {
        int positionDiff = Math.abs(x1 - x2);
        int step = 0;
        int minStartPos = Math.min(x1,x2);
        int minStartPosV = x1 == minStartPos ? v1 : v2;
        int maxStartPos = x1 == minStartPos ? x2 : x1;
        int maxStartPosV = minStartPosV == v1 ? v2 : v2;

        while ( minStartPos != maxStartPos ){
            minStartPos = minStartPos + minStartPosV;
            maxStartPos = maxStartPos + maxStartPosV;
            if (minStartPos == maxStartPos) {
                return "YES";
            }
            if (positionDiff <= maxStartPos - minStartPos) {
                return "NO";
            }
            positionDiff = maxStartPos - minStartPos;
            step++;
        }
        System.out.println(step);
        return "NO";
    }




}

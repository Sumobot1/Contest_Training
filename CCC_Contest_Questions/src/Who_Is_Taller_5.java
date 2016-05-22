/*
 http://cemc.math.uwaterloo.ca/contests/computing/2013/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Who_Is_Taller_5 {

    public static void main(String[] args) throws IOException {
        ArrayList<ArrayList<Integer>> al2D = new ArrayList<ArrayList<Integer>>();
        int nPep, nDone, nP1, nP2, arn2D[][], arn2DBig[][], nNum;
        String sYN;
        boolean bCheck1, bCheck2;
        Scanner fin = new Scanner(new FileReader("taller.txt"));
        nPep = fin.nextInt();
        nDone = fin.nextInt();
        arn2D = new int[nDone][2];
        for (int i = 0; i < nDone; i++) {
            for (int j = 0; j < 2; j++) {
                arn2D[i][j] = fin.nextInt();
            }
        }
        nP1 = fin.nextInt();
        nP2 = fin.nextInt();
        for (int k = 0;k<nPep;k++){
            al2D.add(new ArrayList<Integer>());
        }
        for (int j = 0; j < arn2D.length; j++) {
            al2D.get((arn2D[j][1]) - 1).add(arn2D[j][0]);
        }
        bCheck1 = findtaller(al2D, nP1, nP2);
        if (bCheck1) {
            System.out.println("yes");
        } else {
            
            bCheck2 = findtaller(al2D, nP2, nP1);
            if (bCheck2) {
                System.out.println("no");
            }
            else{
                System.out.println("unknown");
            }
        }
    }

    public static boolean findtaller(ArrayList<ArrayList<Integer>> arn2D, int nBig, int nSmall) {
        int nNum;
        ArrayList<Integer> arlQueue = new ArrayList<Integer>();
        ArrayList<Integer> arlSeen = new ArrayList<Integer>();
        arlQueue.add(nSmall);
        while (!arlQueue.isEmpty()) {
            nNum = arlQueue.get(0);
            arlQueue.remove(0);
            for (int i = 0; i < arn2D.get(nNum-1).size(); i++) {
                if (arn2D.get(nNum-1).get(i) == nBig) {
                    return true;
                } else if (arn2D.get(nNum-1).get(i) != nBig && arn2D.get(nNum-1).get(i) != 0){
                    if (!arlSeen.contains(arn2D.get(nNum-1).get(i))) {
                        arlSeen.add(arn2D.get(nNum-1).get(i));
                        arlQueue.add(arn2D.get(nNum-1).get(i));
                    }
                }
            }
        }
        return false;
    }
}
/*
 http://cemc.math.uwaterloo.ca/contests/computing/2013/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Who_Is_Taller_4 {

    public static void main(String[] args) throws IOException {
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
        arn2DBig = new int[nPep][nPep];
        for (int j = 0; j < arn2D.length; j++) {
            nNum = 0;
            while (arn2DBig[(arn2D[j][1]) - 1][nNum] != 0 && nNum < arn2DBig[(arn2D[j][1]) - 1].length) {
                nNum++;
                //System.out.print(nNum +" ");
            }
            //System.out.println("here" +j);
            arn2DBig[(arn2D[j][1]) - 1][nNum] = arn2D[j][0];      //Take bigger number, add it onto the smaller line
        }
        // System.out.println("here");
//        for (int k = 0; k < arn2DBig.length; k++) {
  //          System.out.print(k + "    ");
    //        for (int l = 0; l < arn2DBig[k].length; l++) {
      //          System.out.print(arn2DBig[k][l] + " ");
        //    }
          //  System.out.println();
       // }
        bCheck1 = findtaller(arn2DBig, nP1, nP2);
        if (bCheck1) {
            System.out.println("yes");
        } else {
            
            bCheck2 = findtaller(arn2DBig, nP2, nP1);
            if (bCheck2) {
                System.out.println("no");
            }
            else{
                System.out.println("unknown");
            }
        }

//        System.out.println(sYN);
        //       if (nYN == 0) {
        //         System.out.println("unknown");
        //   } else if (nYN == 1) {
        //     System.out.println("no");
        //     } else if (nYN == 2) {
        //       System.out.println("equal");
        // } else if (nYN == 3) {
        //   System.out.println("yes");
        // }
    }

    public static boolean findtaller(int arn2D[][], int nBig, int nSmall) {
        int nNum;
        ArrayList<Integer> arlQueue = new ArrayList<Integer>();
        boolean arb2D[][] = new boolean[arn2D.length][arn2D.length];
        arlQueue.add(nSmall);
        //System.out.println(nSmall);
        while (!arlQueue.isEmpty()) {
            nNum = arlQueue.get(0);
            arlQueue.remove(0);
            //System.out.println(nNum);
            for (int i = 0; i < arn2D[nNum-1].length; i++) {
               // System.out.println("here");
                if (arn2D[nNum - 1][i] == nBig) {
                    return true;
                } else if (arn2D[nNum-1][i] != nBig && arn2D[nNum-1][i] != 0){
                    if (arb2D[nNum - 1][i] == false) {
                        arb2D[nNum - 1][i] = true;
                        arlQueue.add(arn2D[nNum - 1][i]);
                    }
                }
            }
        }
        return false;
    }
}
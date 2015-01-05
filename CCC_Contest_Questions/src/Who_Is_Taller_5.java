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
       // arn2DBig = new int[nPep][nPep];
        for (int k = 0;k<nPep;k++){
            al2D.add(new ArrayList<Integer>());
        }
        for (int j = 0; j < arn2D.length; j++) {
          //  nNum = 0;
   //         while (arn2DBig[(arn2D[j][1]) - 1][nNum] != 0 && nNum < arn2DBig[(arn2D[j][1]) - 1].length) {
     //           nNum++;
       //         //System.out.print(nNum +" ");
         //   }
            //System.out.println("here" +j);
            al2D.get((arn2D[j][1]) - 1).add(arn2D[j][0]);
           // arn2DBig[(arn2D[j][1]) - 1][nNum] = arn2D[j][0];      //Take bigger number, add it onto the smaller line
        }
        // System.out.println("here");
//        for (int k = 0; k < arn2DBig.length; k++) {
  //          System.out.print(k + "    ");
    //        for (int l = 0; l < arn2DBig[k].length; l++) {
      //          System.out.print(arn2DBig[k][l] + " ");
        //    }
          //  System.out.println();
       // }
        //System.out.println("poop");
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

    public static boolean findtaller(ArrayList<ArrayList<Integer>> arn2D, int nBig, int nSmall) {
        int nNum;
        ArrayList<Integer> arlQueue = new ArrayList<Integer>();
        ArrayList<Integer> arlSeen = new ArrayList<Integer>();
        //boolean arb2D[][] = new boolean[arn2D.size()][arn2D.size()];
        arlQueue.add(nSmall);
        //System.out.println(nSmall);
        while (!arlQueue.isEmpty()) {
            nNum = arlQueue.get(0);
            arlQueue.remove(0);
            //System.out.println(nNum);
            for (int i = 0; i < arn2D.get(nNum-1).size(); i++) {
               // System.out.println("here");
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
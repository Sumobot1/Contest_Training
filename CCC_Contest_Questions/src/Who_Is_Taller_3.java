/*
 http://cemc.math.uwaterloo.ca/contests/computing/2013/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Who_Is_Taller_3 {

    public static void main(String[] args) throws IOException {
        int nPep, nDone, nYN, nP1, nP2, arn2D[][];
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
        nYN = findtaller(arn2D, nP1, nP2);
        if (nYN == 0) {
            System.out.println("unknown");
        } else if (nYN == 1) {
            System.out.println("no");
        } else if (nYN == 2) {
            System.out.println("equal");
        } else if (nYN == 3) {
            System.out.println("yes");
        }
    }

    public static int findtaller(int arn2D[][], int nTall, int nShort) {
        System.out.println(nTall +" " +nShort);
        int nCount;
        ArrayList<Integer> alHeights = new ArrayList<Integer>();
    //    alHeights.add(arn2D[0][0]);
        //  alHeights.add(arn2D[0][1]);
        //arn2D[0][0] = 0;
        //arn2D[0][1] = 0;
        //print(alHeights);
        for (int i = 0; i < arn2D.length; i++) {
            alHeights.clear();
            nCount = 0;
            while (nCount<arn2D.length) {
                if (arn2D[nCount][0] != 0 && arn2D[nCount][1] != 0) {
                  //  System.out.println("derp");        
                    alHeights.add(arn2D[nCount][0]);
                    alHeights.add(arn2D[nCount][1]);
                    arn2D[nCount][0] = 0;
                    arn2D[nCount][1] = 0;
                   // System.out.println("here");
                    break;
                }
                //print(alHeights);
                nCount++;
            }
           // System.out.println(nCount);
            for (int j = nCount; j < arn2D.length; j++) {
                if (arn2D[i][0] == nTall && arn2D[j][1] == nShort) {
                    return 3;
                }
                if (arn2D[i][0] == nShort && arn2D[j][1] == nTall) {
                    return 1;
                }
                if (arn2D[j][1] == alHeights.get(0)) {
                    alHeights.add(0, arn2D[j][1]);
                    alHeights.add(0, arn2D[j][0]);
                    arn2D[j][0] = 0;
                    arn2D[j][1] = 0;
                }
                if (arn2D[j][0] == alHeights.get(0)) {
                    alHeights.add(0, arn2D[j][0]);
                    alHeights.add(0, arn2D[j][1]);
                    arn2D[j][0] = 0;
                    arn2D[j][1] = 0;
                }
                if (arn2D[j][0] == alHeights.get(alHeights.size() - 1)) {
                    alHeights.add(arn2D[j][0]);
                    alHeights.add(arn2D[j][1]);
                    arn2D[j][0] = 0;
                    arn2D[j][1] = 0;
                }
                if (arn2D[j][1] == alHeights.get(alHeights.size() - 1)) {
                    alHeights.add(arn2D[j][1]);
                    alHeights.add(arn2D[j][0]);
                    arn2D[j][0] = 0;
                    arn2D[j][1] = 0;
                }
            }
            print(alHeights);
            for (int k = 0; k < alHeights.size(); k++) {
                if (alHeights.get(k) == nTall) {
                    for (int l = 0; l < alHeights.size(); l++) {
                        if (alHeights.get(l) == nShort && l > k) {
                            return 3;       //nTall>nShort
                        }
                        if (alHeights.get(l) == nShort && l == k) {
                            return 2;       //nTall == nShort
                        }
                        if (alHeights.get(l) == nShort && l < k) {
                            return 1;       //nTall<nShort
                        }
                    }
                }
            }
        }
      //  print(alHeights);

        return 0;   //Could not find in array
    }

    public static void print(ArrayList<Integer> alHeights) {
        for (int i = 0; i < alHeights.size(); i++) {
            System.out.print(alHeights.get(i) + " ");
        }
        System.out.println();
    }
}

/*
 https://cemc.math.uwaterloo.ca/contests/computing/2007/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Boxes {
    //Read in data, organize
    public static void main(String[] args) throws IOException {
        int nBoxes, arnSize[][], nStuff, arnBoxes[] = new int[3];
        Scanner fin = new Scanner(new FileReader("boxes.txt"));
        nBoxes = fin.nextInt();
        arnSize = new int[nBoxes][3];
        for (int i = 0; i < nBoxes; i++) {
            arnSize[i][0] = fin.nextInt();
            arnSize[i][1] = fin.nextInt();
            arnSize[i][2] = fin.nextInt();
        }
        //Sort boxes by size
        arnSize = sort(arnSize);
        nStuff = fin.nextInt();
        for (int i = 0; i < nStuff; i++) {
            for (int j = 0; j < 3; j++) {
                arnBoxes[j] = fin.nextInt();
            }
            check(arnBoxes, arnSize);
        }
    }
    public static int[][] sort(int arnSize[][]) {
        int arnSums[] = new int[arnSize.length], nSum, arn2[] = new int[arnSize.length], arnFin[][] = new int[arnSize.length][arnSize[0].length];
        for (int i = 0; i < arnSize.length; i++) {
            nSum = 1;
            for (int j = 0; j < arnSize[i].length; j++) {
                nSum *= arnSize[i][j];
            }
            arnSums[i] = nSum;
        }
        for (int i = 0; i < arnSums.length; i++) {
            arn2[i] = arnSums[i];
        }
        Arrays.sort(arnSums);
        for (int i = 0; i < arnSums.length; i++) {
            for (int j = 0; j < arnSums.length; j++) {
                if (arnSums[i] == arn2[j]) {
                    for (int k = 0; k < arnSize[j].length; k++) {
                        arnFin[i][k] = arnSize[j][k];
                    }
                }
            }
        }
        return arnFin;
    }

    public static void check(int arnStuff[], int arnBoxes[][]) {
        int nSize, nTemp, n1, n2, n3, nVol = 1;
        for (int i = 0; i < arnStuff.length; i++) {
            nVol *= arnStuff[i];
        }
        for (int i = 0; i < arnBoxes.length; i++) {
            nSize = 1;
            for (int j = 0; j < arnBoxes[i].length; j++) {
                nSize *= arnBoxes[i][j];
            }
            if (nSize >= nVol) {
                n1 = arnBoxes[i][0];
                n2 = arnBoxes[i][1];
                n3 = arnBoxes[i][2];
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            if (k != l && k != m && l != m) {
                                if (arnStuff[k] <= n1 && arnStuff[l] <= n2 && arnStuff[m] <= n3) {
                                    System.out.println(nSize);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Item Does Not Fit");
    }

    //Debugging function - print 2D array
    public static void print2D(int arnValues[][]) {
        for (int i = 0; i < arnValues.length; i++) {
            for (int k = 0; k < arnValues[0].length; k++) {
                System.out.print(arnValues[i][k] + " ");
            }
            System.out.println();
        }
    }
}

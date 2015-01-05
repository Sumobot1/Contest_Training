/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-200612-p1.pdf
 */

import java.util.*;
import java.io.*;

public class Jimmy_Lost_His_Marbles_Dynamic {

    public static int nMax, nBags;//, nBest;
    public static int[] arnBags;
    public static int[][] arnValues, arnKeep;
    
    public static void main(String[] args) throws IOException {
        int nBest;
        Scanner fin = new Scanner(new FileReader("marbles.txt"));
        for (int j = 0; j < 5; j++) {
            nBest = 0;
            nMax = fin.nextInt();
            nBags = fin.nextInt();
            //System.out.println(nMax +" " +nBags);
            arnBags = new int[nBags + 1];
            for (int i = 0; i < nBags; i++) {
                arnBags[i] = fin.nextInt();
            //    System.out.print(arnBags[i] +" ");
            }
            //System.out.println();
            //rec(0, 0);
            arnValues = new int[nBags+1][nMax];
            //print2D(arnValues);
            //arnKeep = new int[nBags+1][nMax];
            populate();
            //find();
            nBest = arnValues[nBags][nMax-1];
            System.out.println(nBest);
           // System.out.println(nBest);
        }
    }
    public static void populate(){
        int nCurr, nLeave, nRem, nTake;
        for (int i = 1;i<nBags+1;i++){
            nCurr = arnBags[i-1];
            for (int j = 0;j<nMax;j++){
                if (nCurr<=(j+1)){
                    nLeave = arnValues[i - 1][j];
                    //System.out.println("Leave: " +nLeave +" at " +i +" " +j);
                    nRem = (j+1)-nCurr;
                    nTake = nCurr;
                    if (nRem>0){
                        nTake = nCurr + arnValues[i - 1][nRem - 1];
                    }
                    if (nLeave < nTake) {
                        arnValues[i][j] = nTake;
                        //arnKeep[i][j] = 1;
                    }
                    else{
                        arnValues[i][j] = nLeave;
                    }
                }
                else{
                    nLeave = arnValues[i - 1][j];           //Needed to add the case where if number could not fit, take number from column above
                    arnValues[i][j] = nLeave;
                }
            }
        }
       // print2D(arnValues);
    }
    public static void print2D(int arn2D[][]){
        for (int i = 0;i<arnValues.length;i++){
                for (int k = 0;k<arnValues[0].length;k++){
                    System.out.print(arnValues[i][k] +" ");
                }
                System.out.println();
            }
    }

}

/*
 http://cemc.uwaterloo.ca/contests/computing/2000/stage1/2000CCCStage1Contest.pdf
 */
import java.io.*;
import java.util.*;
public class Golf {
public static int nBest = 0, nDist, nClubs, arnClubs[];
    public static void main(String[] args) throws IOException{
        Scanner fin = new Scanner (new FileReader("golf.txt"));
        nDist = fin.nextInt();
        nClubs = fin.nextInt();
        arnClubs = new int[nClubs];
        for (int i = 0;i<nClubs;i++){
            arnClubs[i] = fin.nextInt();
        }
        int nAns = rec(0,0,0);
        if (nBest == nDist){
            System.out.println("Roberta wins in " +nAns +" strokes.");
        }
        else if (nBest < nDist){
            System.out.println("Roberta acknowledges defeat.");
        }
    }
    public static int rec(int i, int nTotal, int nNum){      
        if (nBest==nDist){
            return nNum-1;
        }
        if (nTotal>nBest && nTotal<=nDist){
            nBest = nTotal;
        }
        if (i >= nClubs){
            return nNum;
        }
        rec(i+1, nTotal, nNum);
        return rec(i+1, nTotal+arnClubs[i], nNum+1);
    }
}

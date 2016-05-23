/*
 http://www.nayuki.io/res/dwite-programming-contest-solutions/dwite-200602-p2.pdf
 */
import java.util.*;
import java.io.*;
public class Floppy_Disk {
public static int nCap, nSets, arnData[], arn2D[][];
    public static void main(String[] args) throws IOException{
        Scanner fin = new Scanner (new FileReader("floppy.txt"));
        for (int i = 0;i<5;i++){
            nCap = 1440;
            nSets = fin.nextInt();
            arnData = new int[nSets];
            for (int j = 0;j<nSets;j++){
                arnData[j] = fin.nextInt();     
            }
            arn2D = new int[nSets+1][nCap];
            solve();
            System.out.println(nCap - arn2D[arn2D.length-1][arn2D[0].length-1]);
        }
    }
    public static void solve(){
        int nLeave, nTake, nRem;
        for (int i =1;i<arn2D.length;i++){
            for (int j = 0;j<arn2D[0].length;j++){
                nLeave = arn2D[i-1][j];
                if (arnData[i-1]<=(j+1)){
                    nTake = arnData[i-1];
                    nRem = (j)-arnData[i-1];    
                    if (nRem>=0){
                        nTake = arnData[i-1] + arn2D[i-1][nRem];
                    }
                    if (nLeave<nTake){
                        arn2D[i][j] = nTake;
                    } 
                    else{
                        arn2D[i][j] = nLeave;
                    }
                }
                else{
                    arn2D[i][j] = nLeave;
                }
            }
        }
    }
    //Debug Code
    public static void print2D(int arn2D[][]) {
        for (int i = 0; i < arn2D.length; i++) {
            for (int j = 0; j < arn2D[i].length; j++) {
                System.out.print(arn2D[i][j] + " ");
            }
            System.out.println();
        }
    }
    //Debug Code
    public static void print(int arnthing[]) {
        for (int i = 0; i < arnthing.length; i++) {
            System.out.print(arnthing[i] + " ");
        }
        System.out.println();
    }
}

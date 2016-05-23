/*
http://dwite.ca/questions/shortest_path_around_v2.html
 */
import java.util.*;
import java.io.*;
public class Shortest_Path_Around_V2_Dynamic {
public static String ars2D[][] = new String[8][8];
public static int nRow2, nCol2;
    public static void main(String[] args) throws IOException{
        int arnDist[][], nRow = 0, nCol = 0;
        String sLine;
        Scanner fin = new Scanner (new FileReader("pathdynamic.txt"));
        long stime = System.nanoTime();
        for (int i = 0;i<5;i++){
            arnDist = new int[8][8];
            for (int l = 0;l<8;l++){
                for (int m = 0;m<8;m++){                   
                    arnDist[l][m] = -1;
                }
            }
            for (int j = 0;j<8;j++){
                sLine = fin.nextLine();
                for (int k = 0;k<8;k++){
                    ars2D[j][k] = Character.toString(sLine.charAt(k));
                    if (ars2D[j][k].equals("A")){
                        nRow = j;
                        nCol = k;
                        arnDist[j][k] = 0;
                    }else if (ars2D[j][k].equals("B")){
                        nRow2 = j;
                        nCol2 = k;
                    }                    
                }
            }
            solve(arnDist, nRow, nCol);
            System.out.println(arnDist[nRow2][nCol2]);
        }
        long etime = System.nanoTime();
        System.out.println(etime - stime);
    }
    public static void solve (int arnDist[][], int nRow, int nCol){
        int[] arnX = {0, 0, -1, -1, -1, 1, 1, 1}, arnY = {-1, 1, -1, 0, 1, -1, 0, 1};
        for (int i = 0;i<8;i++){
            if (nRow+arnY[i]>=0 && nCol+arnX[i]>=0 && nRow+arnY[i]<8 && nCol+arnX[i]<8 && !ars2D[nRow+arnY[i]][nCol+arnX[i]].equals("#")){
                if (arnDist[nRow+arnY[i]][nCol+arnX[i]] == -1 || arnDist[nRow+arnY[i]][nCol+arnX[i]]>arnDist[nRow][nCol]+1){
                    arnDist[nRow+arnY[i]][nCol+arnX[i]] = arnDist[nRow][nCol]+1;
                    //print2D(arnDist);
                    //System.out.println();
                    solve(arnDist, nRow+arnY[i], nCol+arnX[i]);        
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
}

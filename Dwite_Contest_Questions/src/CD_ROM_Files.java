/*
http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-200410-p4.pdf
 */
import java.util.*;
import java.io.*;
public class CD_ROM_Files {
public static int nSpace, nFiles, arnFiles[], arn2D[][];
    public static void main(String[] args) throws IOException{
        Scanner fin = new Scanner (new FileReader("CDROM.txt"));
        int nFin;
        for (int i = 0;i<5;i++){
            nSpace = fin.nextInt();
            nFiles = fin.nextInt();
            //System.out.println(nSpace +" " +nFiles);
            arnFiles = new int[nFiles];
            for (int j = 0;j<nFiles;j++){
                arnFiles[j] = fin.nextInt();
                //System.out.println(arnFiles[j]);
            }
            arn2D = new int[nFiles+1][nSpace];
            best();
            nFin = arn2D[nFiles][nSpace-1];
            //print2D(arn2D);
            System.out.println(nFin);
        }
    }
    public static void best(){
        int nLeave, nRem, nTake;
        for (int i = 1;i<nFiles+1;i++){
            for (int j = 0;j<nSpace;j++){
                nLeave = arn2D[i-1][j];
                nTake = arnFiles[i-1];
                if (arnFiles[i-1]<=(j+1)){
                    nRem = (j+1)-arnFiles[i-1];
                    if (nRem>0){
                        nTake = arnFiles[i-1]+arn2D[i - 1][nRem];           //nRem-1 worked for last program doesnt work now...
                        if (nLeave<nTake){
                            arn2D[i][j] = nTake;
                        }
                        else{
                            arn2D[i][j] = nLeave;
                        }
                    }
                }
                else{
                    arn2D[i][j] = nLeave;
                }
            }
        }
    }
        public static void print2D(int arnValues[][]){
        for (int i = 0;i<arnValues.length;i++){
                for (int k = 0;k<arnValues[0].length;k++){
                    System.out.print(arnValues[i][k] +" ");
                }
                System.out.println();
            }
    }
}

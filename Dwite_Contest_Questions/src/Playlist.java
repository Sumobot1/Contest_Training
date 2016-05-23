/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-200712-p3.html
 */
import java.util.*;
import java.io.*;
public class Playlist {
public static int arnRat[], arnSize[], arnVals[][];
    public static void main(String[] args) throws IOException{
        int nSpace, nSongs;
        String arsLine[];
        Scanner fin = new Scanner (new FileReader("playlist.txt"));
        
        for (int i = 0;i<5;i++){
            nSpace = Integer.parseInt(fin.nextLine().trim());
            System.out.println("Space: "+nSpace);
            nSongs = Integer.parseInt(fin.nextLine().trim());
            System.out.println("Songs: " +nSongs);
            arnRat = new int[nSongs];
            arnSize = new int[nSongs];
            for (int j = 0;j<nSongs;j++){
                arsLine = fin.nextLine().split(" ");
               // print(arsLine);
                arnRat[j] = Integer.parseInt(arsLine[1]);
                arnSize[j] = Integer.parseInt(arsLine[2]);
            }
            arnVals = new int[nSongs+1][nSpace];
            solve();
            System.out.println(arnVals[arnVals.length-1][arnVals[0].length-1]);
        }
    }
    public static void solve(){
        int nTake, nLeave, nRem;
        for (int i = 1;i<arnVals.length;i++){
            for (int j = 0;j<arnVals[0].length;j++){
                nLeave = arnVals[i-1][j];
                if (arnSize[i-1]<=(j+1)){                   
                    nTake = arnRat[i-1];
                    nRem = (j)-arnSize[i-1];           
                    if (nRem>0){
                        nTake = arnRat[i-1]+arnVals[i-1][nRem];
                    }
                    if (nTake>nLeave){
                        arnVals[i][j] = nTake;
                    }
                    else{
                        arnVals[i][j] = nLeave;
                    }
                }
                else{
                    arnVals[i][j] = nLeave;
                }
            }
        }
      //  print2D(arnVals);
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
    public static void print(String arnthing[]) {
        for (int i = 0; i < arnthing.length; i++) {
            System.out.print(arnthing[i] + " ");
        }
        System.out.println();
    }
}

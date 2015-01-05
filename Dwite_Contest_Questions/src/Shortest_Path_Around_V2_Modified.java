/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-200801-p4.html
 */

import java.util.*;
import java.io.*;

public class Shortest_Path_Around_V2_Modified {
public static String arsRoom[][] = new String[10][10];
public static int nRowEnd, nColEnd;
    public static void main(String[] args) throws IOException {
        String sLine;
        int nRow = 0, nCol = 0;
        Scanner fin = new Scanner(new FileReader("pathdynamic.txt"));       
        int nX = 0, nY = 0, nDist;
        String sDashes;
        long stime = System.nanoTime();
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 8; i++) {
                sLine = fin.nextLine();
                for (int k = 0;k<8;k++){
                    arsRoom[i][k] = Character.toString(sLine.charAt(k));
                    if (arsRoom[i][k].equals("A")){
                        nRow = i;
                        nCol = k;
                    }
//                    if (arsRoom[i][k].equals("B")){
  //                      nRowEnd = i;
    //                    nColEnd = k;
      //              }
                }
                //arsRoom[i] = fin.nextLine().toCharArray();
            }
            nDist = dist(nRow, nCol);
            System.out.println(nDist);
            //sDashes = fin.nextLine();
        }
        long etime = System.nanoTime();
        System.out.println(etime - stime);
    }
    public static int dist(int nX, int nY){
        ArrayList<Integer> arlQueue = new ArrayList<Integer>(), arlQueue2 = new ArrayList<Integer>();
        //ArrayList<Integer> arlQueue2 = new ArrayList<Integer>();
        //ArrayList<String> arlSeen = new ArrayList<String>();
        int arnSeen[][] = new int[8][8];
        int arnX[] = {0,0,-1,-1,-1,1,1,1}, arnY[] = {-1,1,-1,0,1,-1,0,1}, nCurX, nCurY, nNewX, nNewY, nNum = 0;
        arlQueue.add(nX);
        arlQueue.add(nY);
        arnSeen[nX][nY] = 1;
        //arlSeen.add(nX +" " +nY);
        while(!arlQueue.isEmpty()){
            nCurX = arlQueue.get(0);
            arlQueue.remove(0);
            nCurY = arlQueue.get(0);
            arlQueue.remove(0);
            for (int i = 0;i<8;i++){
                nNewX = nCurX +arnX[i];
                nNewY = nCurY + arnY[i];
                if (nNewX>=0 && nNewX<8 && nNewY>=0 && nNewY<8){
                    if (arnSeen[nNewX][nNewY] == 0 && !arsRoom[nNewX][nNewY].equals("#")){
                        if (arsRoom[nNewX][nNewY].equals("B")){
                            return (nNum+1);
                        }
                        arlQueue2.add(nNewX);
                        arlQueue2.add(nNewY);
                        arnSeen[nNewX][nNewY] = 1;
                        //arlSeen.add(nNewX +" " +nNewY);
                    }
                }
            }
            if (arlQueue.isEmpty()){
                for(int i = 0;i<arlQueue2.size();i++){
                arlQueue.add(arlQueue2.get(i));
            }
            arlQueue2.clear();
            nNum ++;  
            }
        }
        return -1;
    }
}
//4601690       Grondin
//6337981       Mine                    MINE IS SLOWER WTF
//3705989       Grondin
//3349072       New BFS
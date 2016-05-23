/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-200801-p4.html
 */

import java.util.*;
import java.io.*;

public class Shortest_Path_Around {

    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner(new FileReader("path.txt"));
        char arcRoom[][] = new char[10][10];
        int nX = 0, nY = 0, nDist;
        String sDashes;
        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 10; i++) {
                arcRoom[i] = fin.nextLine().toCharArray();
            }
            for (int k = 0;k<10;k++){
                for (int l = 0;l<10;l++){
                    if (arcRoom[k][l] == 'X'){
                        nX = k;
                        nY = l;
                        break;
                    }
                }
            }
            nDist = dist(arcRoom, nX, nY);
            System.out.println(nDist);
            sDashes = fin.nextLine();
        }
    }
    public static int dist(char arcRoom[][], int nX, int nY){
        ArrayList<Integer> arlQueue = new ArrayList<Integer>();
        ArrayList<Integer> arlQueue2 = new ArrayList<Integer>();
        ArrayList<String> arlSeen = new ArrayList<String>();
        int arnX[] = {0,0,-1,-1,-1,1,1,1}, arnY[] = {-1,1,-1,0,1,-1,0,1}, nCurX, nCurY, nNewX, nNewY, nNum = 0;
        arlQueue.add(nX);
        arlQueue.add(nY);
        arlSeen.add(nX +" " +nY);
        while(!arlQueue.isEmpty()){
            nCurX = arlQueue.get(0);
            arlQueue.remove(0);
            nCurY = arlQueue.get(0);
            arlQueue.remove(0);
            for (int i = 0;i<8;i++){
                nNewX = nCurX +arnX[i];
                nNewY = nCurY + arnY[i];
                if (nNewX>=0 && nNewX<10 && nNewY>=0 && nNewY<10){
                    if (arlSeen.indexOf(nNewX+" "+nNewY)<0 && arcRoom[nNewX][nNewY]!='#'){
                        if (arcRoom[nNewX][nNewY]=='X'){
                            return (nNum+1);
                        }
                        arlQueue2.add(nNewX);
                        arlQueue2.add(nNewY);
                        arlSeen.add(nNewX +" " +nNewY);
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

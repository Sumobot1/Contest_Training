/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-200512-p2.pdf
 */

import java.util.*;
import java.io.*;

public class The_Maze {

    public static void main(String[] args) throws IOException {
        int nLen, nWid, nX = 0, nY = 0, nDist;
        char arcMaze[][];
        String arsLine[], sLine;
        Scanner fin = new Scanner(new FileReader("maze.txt"));
        for (int i = 0; i < 5; i++) {
            sLine = fin.nextLine();
            System.out.println(sLine);
            arsLine = sLine.split(" ");
            nLen = Integer.parseInt(arsLine[0]);
            nWid = Integer.parseInt(arsLine[1]);
            arcMaze = new char[nLen][nWid];
            for (int j = 0; j < nLen; j++) {
                arcMaze[j] = fin.nextLine().toCharArray();       //WOULD NOT READ IN CORRECTLY.  HAD TO REPASTE INPUT FILE FOR NO APPARENT REASON A MILLION FUCKING TIMES
            }
            for (int l = 0; l < arcMaze.length; l++) {
                for (int m = 0; m < arcMaze[l].length; m++) {
                    if (arcMaze[l][m] == 'E') {
                        nX = l;
                        nY = m;
                    }
                }
              //  System.out.println();
            }
            nDist = solvemaze(arcMaze, nX, nY);
            System.out.println(nDist);
        }
    }

    public static int solvemaze(char arcMaze[][], int nX, int nY) {
        ArrayList<Integer> arlQueue = new ArrayList<Integer>();
        ArrayList<Integer> arlQueue2 = new ArrayList<Integer>();
        ArrayList<String> arlSeen = new ArrayList<String>();
        int[] arnX = {0, 0, -1, 1}, arnY = {-1, 1, 0, 0};
        int nCurx, nCury, nNewx, nNewy, nNum = 0;
        arlQueue.add(nX);
        arlQueue.add(nY);
        arlSeen.add(nX + " " + nY);
        while (!arlQueue.isEmpty()) {
            nCurx = arlQueue.get(0);
            arlQueue.remove(0);
            nCury = arlQueue.get(0);
            arlQueue.remove(0);
            for (int i = 0; i < 4; i++) {
                nNewx = nCurx + arnX[i];
                nNewy = nCury + arnY[i];
                if (nNewx >= 0 && nNewy >= 0 && nNewx < arcMaze.length && nNewy < arcMaze[0].length) {
                    if (arlSeen.indexOf(nNewx + " " + nNewy) < 0 && arcMaze[nNewx][nNewy] == '.' ||  arcMaze[nNewx][nNewy] == 'X') {
                        if (arcMaze[nNewx][nNewy] == 'X') {
                            return (nNum);
                        }
                        arlQueue2.add(nNewx);
                        arlQueue2.add(nNewy);
                        arlSeen.add(nNewx + " " + nNewy);
                    }
                }
            }
            if (arlQueue.isEmpty()) {
                for (int i = 0; i < arlQueue2.size(); i++) {
                    arlQueue.add(arlQueue2.get(i));
                }
                arlQueue2.clear();
                nNum++;
            }
        }
        return -1;
    }
}

/*
 http://www.nayuki.io/res/dwite-programming-contest-solutions/dwite-200810-p3.html
 */

import java.util.*;
import java.io.*;

public class Schools_A_Maze {

    public static char arcSchool[][] = new char[10][19];
    public static int nRow, nCol;

    public static void main(String[] args) throws IOException {
        int arnDists[][] = new int[10][19], nDist = 0, nCurr, nCurc;
        char arcLine[];
        Scanner fin = new Scanner(new FileReader("school.txt"));
        for (int j = 0; j < 10; j++) {
            arcSchool[j] = fin.nextLine().toCharArray();

        }
        print2D(arcSchool);
        long stime = System.nanoTime();
        for (int i = 0; i < 5; i++) {
            nDist = 0;
            arcLine = fin.nextLine().toCharArray();        
            fill(arnDists);                                 
            for (int j = 0; j < arcLine.length - 1; j++) {
                find(arcLine[j]);
                nCurr = nRow;
                nCurc = nCol;
                find(arcLine[j + 1]);
                arnDists[nCurr][nCurc] = 0;
                solve(arnDists, nCurr, nCurc);
                nDist += arnDists[nRow][nCol];
                fill(arnDists);
            }
            System.out.println(nDist);
        }
        long etime = System.nanoTime();
        System.out.println(etime - stime);
    }

    public static void find(char cLet) {
        for (int j = 0; j < arcSchool.length; j++) {
            for (int k = 0; k < arcSchool[j].length; k++) {
                if (arcSchool[j][k] == cLet) {        
                    nRow = j;
                    nCol = k;
                }
            }
        }
        return;
    }

    public static void solve(int arnDist[][], int nCurRow, int nCurCol) {
        int[] arnX = {0, 0, -1, 1}, arnY = {-1, 1, 0, 0};
        
        for (int i = 0; i < 4; i++) {
            if (nCurRow + arnY[i] >= 0 && nCurCol + arnX[i] >= 0 && nCurRow + arnY[i] < arnDist.length && nCurCol + arnX[i] < arnDist[0].length && arcSchool[nCurRow + arnY[i]][nCurCol + arnX[i]] != '#') {
                if (arnDist[nCurRow + arnY[i]][nCurCol + arnX[i]] == -1 || arnDist[nCurRow + arnY[i]][nCurCol + arnX[i]] > arnDist[nCurRow][nCurCol] + 1) {
                    arnDist[nCurRow + arnY[i]][nCurCol + arnX[i]] = arnDist[nCurRow][nCurCol] + 1;
                    solve(arnDist, nCurRow + arnY[i], nCurCol + arnX[i]);

                }
            }
        }

    }

    public static void fill(int arn2D[][]) {
        for (int l = 0; l < arn2D.length; l++) {
            for (int m = 0; m < arn2D[0].length; m++) {
                arn2D[l][m] = -1;
            }
        }
    }

    public static void print2D(char arn2D[][]) {
        for (int i = 0; i < arn2D.length; i++) {
            for (int j = 0; j < arn2D[i].length; j++) {
                System.out.print(arn2D[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void print2Dint(int arn2D[][]) {
        for (int i = 0; i < arn2D.length; i++) {
            for (int j = 0; j < arn2D[i].length; j++) {
                System.out.print(arn2D[i][j] + " ");
            }
            System.out.println();
        }
    }
}
//  BFS:      6169734
//  DYNAMIC:  1639039
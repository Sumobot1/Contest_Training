/*
 http://www.nayuki.io/res/dwite-programming-contest-solutions/dwite-200810-p3.html
 */

import java.util.*;
import java.io.*;

public class Schools_A_Maze_BFS {

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
            fill(arnDists);                                 //Forgot to flood array with 0s before the first test case
            for (int j = 0; j < arcLine.length - 1; j++) {
                if (arcLine[j] != arcLine[j + 1]) {
                    find(arcLine[j]);
                    nCurr = nRow;
                    nCurc = nCol;
                    find(arcLine[j + 1]);
                    nDist += solve(nCurr, nCurc);
                }
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

    public static int solve(int nCurRow, int nCurCol) {
        int arnX[] = {0, 0, -1, 1}, arnY[] = {-1, 1, 0, 0}, nCurr, nCurc, nNum = 0;
        ArrayList<Integer> arlQueue = new ArrayList<Integer>(), arlQueue2 = new ArrayList<Integer>();
        ArrayList<String> arlSeen = new ArrayList<String>();
        arlQueue.add(nCurRow);
        arlQueue.add(nCurCol);
        arlSeen.add(nCurRow + " " + nCurCol);
        while (!arlQueue.isEmpty()) {
            nCurr = arlQueue.get(0);
            arlQueue.remove(0);
            nCurc = arlQueue.get(0);
            arlQueue.remove(0);
            for (int i = 0; i < 4; i++) {
                if (!arlSeen.contains(nCurr + arnY[i] + " " + nCurc + arnX[i]) && nCurr + arnY[i] >= 0 && nCurc + arnX[i] >= 0 && nCurr + arnY[i] < arcSchool.length && nCurc + arnX[i] < arcSchool[0].length && arcSchool[nCurr + arnY[i]][nCurc + arnX[i]] != '#') {
                    if (nCurr + arnY[i] == nRow && nCurc + arnX[i] == nCol) {
                        return (nNum + 1);
                    }
                    arlQueue2.add(nCurr + arnY[i]);
                    arlQueue2.add(nCurc + arnX[i]);
                    arlSeen.add(nCurr + arnY[i] + " " + nCurc + arnX[i]);
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

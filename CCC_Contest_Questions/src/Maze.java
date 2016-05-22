/*
 http://www.cemc.uwaterloo.ca/contests/computing/2008/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Maze {

    public static int nCases, nRows, nCols, arnSeen[][];
    public static char arcCity[][];

    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner(new FileReader("maze.txt"));
        nCases = fin.nextInt();
        for (int i = 0; i < nCases; i++) {
            nRows = fin.nextInt();
            nCols = fin.nextInt();
            fin.nextLine();                           
            arcCity = new char[nRows][nCols];
            arnSeen = new int[nRows][nCols];
            for (int j = 0; j < nRows; j++) {
                arcCity[j] = fin.nextLine().toCharArray();
            }
            if (nRows == 1 && nCols == 1) {
                System.out.println(1);
            } else {
                travel();
            }
        }
    }

    public static void travel() {
        ArrayList<Integer> arlQueue = new ArrayList<Integer>();
        ArrayList<Integer> arlQueue2 = new ArrayList<Integer>();
        int nNewRow, nNewCol, nCurRow, nCurCol, nNum = 0;
        int[] arnRow = {0, 0, -1, 1}, arnCol = {-1, 1, 0, 0};
        arlQueue.add(0);
        arlQueue.add(0);
        arnSeen[0][0] = 1;
        while (!arlQueue.isEmpty()) {
            nCurRow = arlQueue.get(0);
            arlQueue.remove(0);
            nCurCol = arlQueue.get(0);
            arlQueue.remove(0);
            if (arcCity[nCurRow][nCurCol] == '+') {
                for (int i = 0; i < 4; i++) {
                    if (nCurRow + arnRow[i] >= 0 && nCurRow + arnRow[i] < nRows && nCurCol + arnCol[i] >= 0 && nCurCol + arnCol[i] < nCols && arnSeen[nCurRow + arnRow[i]][nCurCol + arnCol[i]] == 0 && arcCity[nCurRow + arnRow[i]][nCurCol + arnCol[i]] != '*') {
                        if (nCurRow + arnRow[i] + 1 == nRows && nCurCol + arnCol[i] + 1 == nCols) {
                            System.out.println(nNum + 2);
                            return;
                        }
                        arlQueue2.add(nCurRow + arnRow[i]);
                        arlQueue2.add(nCurCol + arnCol[i]);
                        arnSeen[nCurRow + arnRow[i]][nCurCol + arnCol[i]] = 1;
                    }
                }
            } else if (arcCity[nCurRow][nCurCol] == '-') {
                for (int i = 0; i < 2; i++) {
                    if (nCurRow + arnRow[i] >= 0 && nCurRow + arnRow[i] < nRows && nCurCol + arnCol[i] >= 0 && nCurCol + arnCol[i] < nCols && arnSeen[nCurRow + arnRow[i]][nCurCol + arnCol[i]] == 0 && arcCity[nCurRow + arnRow[i]][nCurCol + arnCol[i]] != '*') {
                        if (nCurRow + arnRow[i] + 1 == nRows && nCurCol + arnCol[i] + 1 == nCols) {
                            System.out.println(nNum + 2);
                            return;
                        }
                        arlQueue2.add(nCurRow + arnRow[i]);
                        arlQueue2.add(nCurCol + arnCol[i]);
                        arnSeen[nCurRow + arnRow[i]][nCurCol + arnCol[i]] = 1;
                    }
                }
            } else if (arcCity[nCurRow][nCurCol] == '|') {
                for (int i = 2; i < 4; i++) {
                    if (nCurRow + arnRow[i] >= 0 && nCurRow + arnRow[i] < nRows && nCurCol + arnCol[i] >= 0 && nCurCol + arnCol[i] < nCols && arnSeen[nCurRow + arnRow[i]][nCurCol + arnCol[i]] == 0 && arcCity[nCurRow + arnRow[i]][nCurCol + arnCol[i]] != '*') {
                        if (nCurRow + arnRow[i] + 1 == nRows && nCurCol + arnCol[i] + 1 == nCols) {
                            System.out.println(nNum + 2);
                            return;
                        }
                        arlQueue2.add(nCurRow + arnRow[i]);
                        arlQueue2.add(nCurCol + arnCol[i]);
                        arnSeen[nCurRow + arnRow[i]][nCurCol + arnCol[i]] = 1;
                    }
                }
            } else {
                System.out.println("Im retarded");
            }
            if (arlQueue.isEmpty()) {
                for (int i = 0; i < arlQueue2.size(); i++) {
                    arlQueue.add(arlQueue2.get(i));
                }
                arlQueue2.clear();
                nNum++;
            }
        }
        System.out.println(-1);
        return;
    }

    public static void print2D(char arn2D[][]) {
        for (int i = 0; i < arn2D.length; i++) {
            for (int j = 0; j < arn2D[i].length; j++) {
                System.out.print(arn2D[i][j] + " ");
            }
            System.out.println();
        }
    }
}

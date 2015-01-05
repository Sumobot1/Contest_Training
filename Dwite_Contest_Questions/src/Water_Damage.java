/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-200811-p5.html
 */

import java.util.*;
import java.io.*;

public class Water_Damage {

    public static void main(String[] args) throws IOException {
        int nWater, nCol, nRow, nStart, nFin, nDiff;
        String sFuck;
        char arc2D[][], arc2DCopy[][];
        Scanner fin = new Scanner(new FileReader("water.txt"));
        while (fin.hasNext()) {
            nWater = Integer.parseInt(fin.nextLine());
            nCol = Integer.parseInt(fin.nextLine());
            nRow = Integer.parseInt(fin.nextLine());
            arc2D = new char[nRow + 1][nCol + 1];
            arc2DCopy = new char[nRow + 1][nCol + 1];
            for (int i = 0; i < nRow; i++) {
                arc2D[i] = (fin.nextLine() + "#").toCharArray();
            }
            for (int i = 0; i < nCol + 1; i++) {
                arc2D[nRow][i] = '#';
            }
            for (int i = 0; i < arc2D.length; i++) {
                for (int j = 0; j < arc2D[i].length; j++) {
                    arc2DCopy[i][j] = arc2D[i][j];
                }
            }
            while (nWater > 0) {
                arc2DCopy = waterpath(arc2DCopy);
                nWater -= 1;
            }
            nStart = countA(arc2D);
            nFin = countA(arc2DCopy);
            nDiff = nStart - nFin;
            System.out.println(nDiff);
            if (fin.hasNextLine()) {
                sFuck = fin.nextLine();
            }
        }
    }

    public static char[][] waterpath(char arc2DCopy[][]) {
        int i = 0, j = 0;
        while (i < arc2DCopy.length - 1 && j < arc2DCopy[i].length - 1) {
            if (arc2DCopy[i + 1][j] != '#' && arc2DCopy[i + 1][j] != '*') {
                i += 1;
            } else {
                if (arc2DCopy[i][j + 1] != '#' && arc2DCopy[i][j + 1] != '*') {
                    j += 1;
                } else {
                    arc2DCopy[i][j] = '*';
                    break;
                }
            }
        }
        return arc2DCopy;
    }

    public static int countA(char arc2D[][]) {
        int nNum = 0;
        for (int i = 0; i < arc2D.length; i++) {
            for (int j = 0; j < arc2D[i].length; j++) {
                if (arc2D[i][j] == 'A') {
                    nNum += 1;
                }
            }
        }
        return nNum;
    }
}

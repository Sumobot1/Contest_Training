/*
 https://cemc.math.uwaterloo.ca/contests/computing/2012/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Mouse_Journey {

    public static int arn2D[][];
    public static int nPaths = 0;

    public static void main(String[] args) throws IOException {
        int nRows, nCols, nCats, nCRow, nCCol;
        Scanner fin = new Scanner(new FileReader("Mouse.txt"));
        nRows = fin.nextInt();
        nCols = fin.nextInt();
        arn2D = new int[nRows][nCols];
        nCats = fin.nextInt();
        for (int i = 0; i < nCats; i++) {
            nCRow = fin.nextInt();
            nCCol = fin.nextInt();
            arn2D[nCRow - 1][nCCol - 1] = 2;
        }
        arn2D[0][0] = 1;
        arn2D[arn2D.length - 1][arn2D[0].length - 1] = 3;
//        for (int i = 0;i<arn2D.length;i++){
//            for (int j = 0;j<arn2D[0].length;j++){                //DEBUG TO CHECK IF ARRAY IS POPULATING CORRECTLY
//                System.out.print(arn2D[i][j] +" ");
//            }
//            System.out.println();
//        }
        rec(0, 0);
        System.out.println(nPaths);
    }

    public static void rec(int nCurRow, int nCurCol) {
        //System.out.println(nCurRow +" " +nCurCol);
        if (nCurRow >= arn2D.length || nCurCol >= arn2D[0].length) {        //DONT NEED TO CHECK IF LESS THAN 0 - CANNOT MOVE IN THAT DIRECTION
            //System.out.println("noep");
            return;
        }
        if (arn2D[nCurRow][nCurCol] == 2) {
            //System.out.println("djakaj");
            return;
        }
        if (arn2D[nCurRow][nCurCol] == 3) {
            //System.out.println("dopne");
            nPaths++;
            return;
        }
        rec(nCurRow+1, nCurCol);
        rec(nCurRow, nCurCol+1);
    }
}

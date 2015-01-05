/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-200612-p1.pdf
 */

import java.util.*;
import java.io.*;

public class Jimmy_Lost_His_Marbles {

    public static int nMax, nBags, nBest;
    public static int[] arnBags;

    public static void main(String[] args) throws IOException {
        //int nCount;
        Scanner fin = new Scanner(new FileReader("marbles.txt"));
        for (int j = 0; j < 5; j++) {
            nBest = 0;
            nMax = fin.nextInt();
            nBags = fin.nextInt();
            //System.out.println(nMax +" " +nBags);
            arnBags = new int[nBags + 1];
            for (int i = 0; i < nBags; i++) {
                arnBags[i] = fin.nextInt();
                //System.out.print(arnBags[i] +" ");
            }
            //System.out.println();
            rec(0, 0);
            System.out.println(nBest);
        }
    }

    public static void rec(int i, int nCount) {
        if (nCount > nMax || i == nBags+1) {
            return;
        }
        if (nCount > nBest && nCount <= nMax) {
            nBest = nCount;
        }
        rec(i + 1, nCount);
        rec(i + 1, nCount + arnBags[i]);

    }
}

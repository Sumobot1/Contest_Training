/*
 http://dwite.ca/old/Problem4Dec2004.pdf
 */

import java.util.*;
import java.io.*;

public class Prime_Number_Conjecture_5 {
    public static boolean arbNums[];
    public static void main(String[] args) throws IOException {
        int nNum, k, nCombos;
        ArrayList<Integer> alNums = new ArrayList<Integer>();
        Scanner fin = new Scanner(new FileReader("Waring.txt"));
        for (int j = 0; j < 5; j++) {
            alNums.clear();
            nNum = fin.nextInt();
            arbNums = new boolean[nNum + 6];
            arbNums[0] = true;
            arbNums[1] = true;
            for (int i = 0; i <= nNum; i++) {
                if (arbNums[i] == false) {
                    alNums.add(i);
                    for (int l = i; Math.abs(i * l) <= nNum; l++) {
                        arbNums[i * l] = true;
                    }
                }
            }
            if (alNums.contains(nNum)) {
                System.out.println("PRIME");
            } else {
                nCombos = combo(alNums, nNum);
                System.out.println("Combos: " +nCombos);
            }
        }
    }

    public static int combo(ArrayList<Integer> alNums, int nNum) {
        int nCombos = 0, nRem;
        for (int i = 0; i < alNums.size(); i++) {
            for (int m = 0; m < alNums.size(); m++) {       
                if (alNums.get(i) >= alNums.get(m)) {
                    nRem = alNums.get(i) + alNums.get(m);
                    if ((nNum - nRem) <= alNums.get(m) && nNum >= nRem && arbNums[nNum - nRem] == false) {
                        nCombos += 1;
                    }
                }
            }
        }
        return nCombos;
    }
}

/*
 http://dwite.ca/old/Problem4Dec2004.pdf
//Slow Version...
 */

import java.util.*;
import java.io.*;

public class Prime_Number_Conjecture {

    public static void main(String[] args) throws IOException {
        int nNum, k, nCombos;
        boolean arbNums[];
        ArrayList<Integer> alNums = new ArrayList<Integer>();
        Scanner fin = new Scanner(new FileReader("Waring.txt"));
        for (int j = 0; j < 5; j++) {
            alNums.clear();
            nNum = fin.nextInt();
            arbNums = new boolean[nNum+6];
            arbNums[0] = true;
            arbNums[1] = true;
            for (int i = 0; i <= nNum; i++) {
                if (arbNums[i] == false) {
                    alNums.add(i);
                    k = i;
                    while ((k + i) <= arbNums.length) {
                        arbNums[k] = true;
                        k += i;
                    }
                }
            }
            if (alNums.contains(nNum)){
                System.out.println("PRIME");
            }
            else{
                nCombos = combo(alNums, nNum);
            }
        }
    }

    public static int combo(ArrayList<Integer> alNums, int nNum) {
        int nCombos = 0;
        for (int i = 0; i < alNums.size(); i++) {
            for (int m = 0; m < alNums.size(); m++) {
                for (int l = 0; l < alNums.size(); l++) {
                    if (alNums.get(i) + alNums.get(l) + alNums.get(m) == nNum && alNums.get(i) >= alNums.get(m) && alNums.get(m) >= alNums.get(l)) {
                        nCombos += 1;
                    }
                }
            }
        }
        System.out.println("Combos " + nCombos);
        return nCombos;
    }
}

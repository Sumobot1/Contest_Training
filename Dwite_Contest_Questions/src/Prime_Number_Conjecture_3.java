/*
 http://dwite.ca/old/Problem4Dec2004.pdf
 */

import java.util.*;
import java.io.*;

public class Prime_Number_Conjecture_3 {

    public static ArrayList<Integer> alNums = new ArrayList<Integer>(); //TURNED GLOBAL
    public static boolean arbNums[];
    public static int nCombos = 0;

    public static void main(String[] args) throws IOException {
        int nNum, k;    
        Scanner fin = new Scanner(new FileReader("Waring.txt"));
        for (int j = 0; j < 5; j++) {
            nCombos = 0;
            alNums.clear();
            nNum = fin.nextInt();
            arbNums = new boolean[nNum + 6];
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
            if (alNums.contains(nNum)) {
                System.out.println("PRIME");
            } else {
                System.out.println(alNums.get(alNums.size() - 1));
                combo(nNum, 0, alNums.get(alNums.size() - 1));
                System.out.println("Combos: " + nCombos);
            }
        }
    }

    public static void combo(int nNum, int nCount, int nHighPrime) {
        int nPrime;
        if (nHighPrime <= 1) {
            return;
        }
        if (nCount == 2) {
            if (arbNums[nHighPrime] == false) {     //IF YOU ARE ON LAST NUMBER - IF THE REMAINDER IS PRIME LEAVE
                nCombos++;
            }
            return;
        }

        nPrime = nHighPrime - 1;
        while (nPrime > 0 && arbNums[nPrime] == true) {     
            nPrime--;
        }
        combo(nNum - nHighPrime, nCount + 1, nPrime);       // CALL NUM-HIGHEST PRIME LESS THAN THAT NUMBER, INCREASE COUNT, AND PASS IN NEXT LOWEST PRIME
        combo(nNum, nCount, nPrime);                      
        combo(nNum - nHighPrime, nCount + 1, nHighPrime);
    }
}

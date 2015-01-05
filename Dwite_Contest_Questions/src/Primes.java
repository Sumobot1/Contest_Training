/*
 http://dwite.ca/old/Problem4Dec2004.pdf
 */

import java.util.*;
import java.io.*;

public class Primes {

    public static void main(String[] args) throws IOException {
        int nNum, k, nCombos;
        boolean arbNums[];
        ArrayList<Integer> alNums = new ArrayList<Integer>();
        Scanner fin = new Scanner(new FileReader("Waring.txt"));
        for (int j = 0; j < 5; j++) {
            alNums.clear();
            nNum = fin.nextInt();
            System.out.println(nNum);
           // arbNums = new boolean[nNum + 6];
          //  arbNums[0] = true;
          //  arbNums[1] = true;
          //  int i = 0;
         //   while (arnPrimes[i])
            for (int i = 2; i < nNum; i++) {
                if (prime(i)){
                    alNums.add(i);
                    System.out.print(i +" ");
                }
                
//                if (arbNums[i] == false) {
//                    alNums.add(i);
//                    k = i;
//                    while ((k + i) <= arbNums.length) {
//                        arbNums[k] = true;
//                        k += i;
//                    }
//                }
            }
            System.out.println();
                        System.out.println("Done");
            if (alNums.contains(nNum)){
                System.out.println("PRIME");
            }
            else{
                nCombos = combo(alNums, nNum);
            }
        }
    }

    public static boolean prime(long lNum) {
        if (lNum % 2 == 0 && lNum != 2) {
            return false;
        }
        for (long i = 3; i * i <= lNum; i += 2) {
            if (lNum % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int combo(ArrayList<Integer> alNums, int nNum) {
        int nCombos = 0;
        for (int i = 0; i < alNums.size(); i++) {
            for (int m = 0; m < alNums.size(); m++) {
                for (int l = 0; l < alNums.size(); l++) {
                    if (alNums.get(i) + alNums.get(l) + alNums.get(m) == nNum && alNums.get(i) >= alNums.get(m) && alNums.get(m) >= alNums.get(l)) {
                        //System.out.println(alNums.get(i) +" " +alNums.get(l) +" " +alNums.get(m));
                        nCombos += 1;
                    }
                }
            }
        }
//        for (int i = 0; i < alNums.size(); i++) {
//            System.out.print(alNums.get(i) + " ");
//        }
        System.out.println("Combos " + nCombos);
        return nCombos;
    }
}

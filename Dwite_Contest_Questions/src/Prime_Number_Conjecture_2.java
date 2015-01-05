/*
 http://dwite.ca/old/Problem4Dec2004.pdf
 */

import java.util.*;
import java.io.*;

public class Prime_Number_Conjecture_2 {
public static ArrayList<Integer> alNums = new ArrayList<Integer>(); //TURNED GLOBAL
public static boolean arbNums[];
public static int nCombos = 0;
    public static void main(String[] args) throws IOException {
        int nNum, k;
       // boolean arbNums[];       
        Scanner fin = new Scanner(new FileReader("Waring.txt"));
        for (int j = 0; j < 5; j++) {
            nCombos = 0;
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
                combo(nNum, 0, alNums.get(alNums.size()-1));
                System.out.println("Combos: " +nCombos);
            }
        }
    }

    public static void combo(int nNum, int nCount, int nHighPrime) {
        int nPrime;
        if (nCount == 2){
            if (arbNums[nHighPrime] == false){
                nCombos++;
                //nCount = 0;
                //return;
            }
            return;
        }
        nPrime = nHighPrime-1;
        while (arbNums[nPrime] == true && nPrime> 0){
            nPrime--;
        }
        combo(nNum-nHighPrime, nCount+1, nPrime);
        combo(nNum, nCount+1, nPrime);
        combo(nNum-nHighPrime, nCount+1, nHighPrime);
//        for (int i = 0; i < alNums.size(); i++) {
//            for (int m = 0; m < alNums.size(); m++) {
//                for (int l = 0; l < alNums.size(); l++) {
//                    if (alNums.get(i) + alNums.get(l) + alNums.get(m) == nNum && alNums.get(i) >= alNums.get(m) && alNums.get(m) >= alNums.get(l)) {
//                        //System.out.println(alNums.get(i) +" " +alNums.get(l) +" " +alNums.get(m));
//                        nCombos += 1;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < alNums.size(); i++) {
//            System.out.print(alNums.get(i) + " ");
//        }
        //System.out.println("Combos " + nCombos);
        //return;// nCombos;
    }
}
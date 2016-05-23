/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-200412-p1.pdf
 The difficulty with this problem is that the largest number that will need to be prime factorized will be 2000000000.  This causes out of memory error for the seive.
 */

import java.util.*;
import java.io.*;

public class Prime_Factorization {

    public static ArrayList<Integer> alNums = new ArrayList<Integer>();
    public static String sFin = "";

    public static void main(String[] args) throws IOException {
        int nNum;
        boolean bCheck;
        int nDiv;
        Scanner fin = new Scanner(new FileReader("PrimeFactorization.txt"));
        for (int i = 0; i < 5; i++) {
            sFin = "";
            nNum = fin.nextInt();
            bCheck = isPrime(nNum);
            if (bCheck) {
                System.out.println(nNum);
            } else {
                nDiv = 2;
                while (true) {
                    if (isPrime(nDiv)) {
                        if (nNum % nDiv == 0) {
                            nNum /= nDiv;
                            sFin += nDiv + "*";
                        } else {
                            nDiv++;
                        }
                    } else {
                        nDiv++;
                    }
                    if (nDiv == nNum) {
                        sFin += nNum;
                        break;
                    }
                }
                System.out.println(sFin);
            }
        }
    }

    public static boolean isPrime(int n) {
        int p = (int)Math.sqrt(n);
        if (n % 2 == 0 && n!= 2) {
            return false;
        }
        //if not, then just check the odds
        for (int i = 3; i<= p+1; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
//    public static void rec(int nNum, int i) {
//        //String sFin = "";
//        System.out.println(i);
//        if (isPrime(nNum)) {
//            sFin += nNum;
//            return;
//        }
////        if ()
//        else {
//            if (isPrime(i)) {
//                System.out.println("i = " +i);
//                if (nNum % i == 0) {
//                    sFin += (i + "*");
//                    rec(nNum / i, i);
//                } else {
//                    rec(nNum, i + 1);
//                }
//            } else {
//                rec(nNum, i + 1);
//            }
//
//        }
//        System.out.println(sFin);
//    }
}

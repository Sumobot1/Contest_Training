/*
 http://dwite.ca/questions/round_to_second_prime.html
 */

import java.util.*;
import java.io.*;

public class Second_Prime {

    public static void main(String[] args) throws IOException {
        int nNum, nCheck, nCheck2;
        boolean bCheckhi, bChecklo, bCheck;
        Scanner fin = new Scanner(new FileReader("second.txt"));
        for (int i = 0; i < 5; i++) {
            nNum = fin.nextInt();
            nCheck = nNum + 1;
            nCheck = second(nCheck, +1);
            nCheck2 = nNum - 1;
            nCheck2 = second(nCheck2, -1);
            if (nNum-nCheck2<nCheck-nNum){
                System.out.println("Round to: " +nCheck2);
            }
            else{
                System.out.println("Round to: " +nCheck);
            }
            System.out.println(nCheck + " " + nCheck2);
        }
    }

    public static boolean isprime(int nNum) {
        if (nNum % 2 == 0 && nNum != 2) {
            return false;
        }
        for (int i = 3; i * i <= nNum; i += 2) {
            if (nNum % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int second(int nCheck, int nNum) {
        boolean bCheck = false;
        while (true) {
            if (isprime(nCheck)) {
                if (bCheck == true) {
                    return nCheck;
                }
                if (bCheck == false) {
                    bCheck = true;
                }
            }
            nCheck += nNum;
        }
    }
}

/*
 http://dwite.ca/old/Problem1Dec2005.pdf
 */

import java.util.*;
import java.io.*;

public class Semiprimes {

    public static void main(String[] args) throws IOException {
        int nLow, nHigh, k;
        boolean arbNums[];
        ArrayList<Integer> alNums = new ArrayList<Integer>();
        Scanner fin = new Scanner(new FileReader("semiprimes.txt"));
        for (int j = 0; j < 5; j++) {
            alNums.clear();
            nLow = fin.nextInt();
            nHigh = fin.nextInt();
            arbNums = new boolean[nHigh / 2 + 6];
            arbNums[0] = true;
            arbNums[1] = true;
            for (int i = 0; i < arbNums.length; i++) {
                if (arbNums[i] == false) {
                    alNums.add(i);
                    k = i;
                    while ((k + i) <= arbNums.length) {
                        arbNums[k] = true;
                        k += i;
                    }
                }
            }
            System.out.println(find(alNums, nLow, nHigh));
        }
    }
    public static int find(ArrayList<Integer> alNums, int nLow, int nHigh){
        int nCount = 0;
        for (int i = 0;i<alNums.size();i++){
            for (int j = 0;j<alNums.size();j++){
                if (alNums.get(i)>=alNums.get(j) && alNums.get(i)*alNums.get(j)>=nLow && alNums.get(i)*alNums.get(j)<=nHigh)
                    nCount +=1;
            }
        }
        return nCount;
    }
}

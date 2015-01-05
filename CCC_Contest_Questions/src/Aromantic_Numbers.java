/*
 http://cemc.uwaterloo.ca/contests/computing/2012/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Aromantic_Numbers {

    public static void main(String[] args) throws IOException {
        String sNum;
        int nAns;
        Scanner fin = new Scanner(new FileReader("aroma.txt"));
        sNum = fin.nextLine();
        System.out.println(sNum);
        nAns = calculate(sNum);
        System.out.println(nAns);
    }

    public static int calculate(String sNum) {
        int nNum, nRom, nRom2, nSum = 0;
        for (int i = 0; i < sNum.length() - 1; i += 2) {
            nNum = Integer.parseInt(Character.toString(sNum.charAt(i)));
            nRom = convert(sNum.charAt(i+1));
            if(i+3<sNum.length()){
                nRom2 = convert(sNum.charAt(i+3));
               // System.out.println(nRom2);
                if (nRom<nRom2){
                    nSum-=(nRom*nNum);
                    System.out.println(nSum);
                }
                else{
                    nSum+=(nRom*nNum);
                    System.out.println(nSum);
                }
            }
            else{
                
                nSum += (nNum*nRom);
                System.out.println(nSum);
            }
        }
        return nSum;
    }
    public static int convert(char c){
        if (c == 'I') {
                   return 1;
            } else if (c == 'V') {
                    return 5;
            } else if (c == 'X') {
                    return 10;
            } else if (c == 'L') {
                    return 50;
            } else if (c == 'C') {
                    return 100;
            } else if (c == 'D') {
                    return 500;
            } else if (c == 'M') {
                    return 1000;
            }
        return 0;
    }

}

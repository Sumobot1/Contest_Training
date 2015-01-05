/*
http://dwite.ca/questions/word_arithmetic.html
 */
import java.util.*;
import java.io.*;
public class Word_Arithmetic {

    public static void main(String[] args) throws IOException{
        String s1, s2, sAns;
        String arsLine[];
        int arn1[], arn2[];
        char arcLetters[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        Scanner fin = new Scanner (new FileReader("words.txt"));
        for (int i = 0;i<5;i++){
            arsLine = fin.nextLine().split(" ");
            s1 = arsLine[0];
            s2 = arsLine[1];
            while (s1.length()<s2.length()){
                s1 = "A" +s1;
            }
            while (s2.length()<s1.length()){
                s2 = "A" +s2;
            }
            arn1 = toint(s1, arcLetters);
            arn2 = toint(s2, arcLetters);
            sAns = solve(arn1, arn2, arcLetters);
            System.out.println(sAns);
        }
        
    }
    public static int[] toint(String sWord, char arcLetters[]){
        int arnNums[] = new int[sWord.length()];
        for (int i = 0;i<sWord.length();i++){
            for (int j = 0;j<arcLetters.length;j++){
                if (sWord.charAt(i) == arcLetters[j]){
                    arnNums[i] = j;
                }
            }
        }
        return arnNums;
    }
    public static String solve(int arn1[], int arn2[], char arcLetters[]){
        StringBuilder sbFin;
        int nCarry = 0, nSum, nFin, nLet, nDerp = 0;
        String sFin = "", sDone = "";
        for (int i = arn1.length-1;i>=0;i--){
            nSum = arn1[i]+arn2[i]+nCarry;
            if (nSum>25){
                nLet = nSum%26;
                nCarry = nSum/26;
                sFin += arcLetters[nLet];
            }
            else{
                nLet = nSum;
                sFin += arcLetters[nLet];
                nCarry = 0;
            }
        }
        sbFin = new StringBuilder(sFin);
        sbFin = sbFin.reverse();
        sFin = sbFin.toString();
        for (int k = 0;k<sFin.length();k++){
            if (sFin.charAt(k)!='A'){
                nDerp = k;
                break;
            }
        }
        for (int l = nDerp;l<sFin.length();l++){
            sDone += sFin.charAt(l);
        }
        return sDone;
    }
    
}

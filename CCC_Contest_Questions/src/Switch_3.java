/*
 https://cemc.math.uwaterloo.ca/contests/computing/2011/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Switch_3 {

    public static int[] arnTurns = new int[3];

    public static void main(String[] args) throws IOException {
        int nNum, arnLights[], nTaken = 0;
        String sLights = "", sPass = "";
        Scanner fin = new Scanner(new FileReader("switch.txt"));
        nNum = fin.nextInt();
        for (int i = 0; i < nNum; i++) {
            sLights += fin.nextInt();
        }
        sLights = clear(sLights);
        start(0, sLights, 0);
        end(0, sLights, 0);
        middle(0, sLights, 0);
        for (int i = 0;i<arnTurns.length;i++){
            System.out.println(arnTurns[i]);
        }
    }

    public static void start(int nCurrent, String sLights, int nTurn) {
        sLights = clear(sLights);
        StringBuilder sbLights = fix(sLights);
        boolean bCheck = true;
        String sOther;
        for (int i = 0; i < sbLights.length(); i++) {
            if (sbLights.charAt(i) == '1') {
                bCheck = false;
            }
        }
        if (bCheck) {
            System.out.println("here " + nTurn);
            arnTurns[0] = nTurn;
            return;
        }
        if (nCurrent >= sLights.length()) {
            nCurrent = 0;
        }
        for (int i = nCurrent; i < sLights.length(); i++) {
            System.out.println(i);
            if (sLights.charAt(i) == '0') {
                sbLights.deleteCharAt(i);
                sbLights.insert(i, '1');
                sOther = sbLights.toString();
                System.out.println("sother: " +sOther);
                start(i, sOther, nTurn+1);                
                break;                     
            }
        }
    }

    public static void end(int nCurrent, String sLights, int nTurn) {
        sLights = clear(sLights);
        StringBuilder sbLights = fix(sLights);
        boolean bCheck = true;
        String sOther;
        for (int i = 0; i < sbLights.length(); i++) {
            if (sbLights.charAt(i) == '1') {
                bCheck = false;
            }
        }
        if (bCheck) {
            System.out.println("here " + nTurn);
            arnTurns[1] = nTurn;
            return;
        }
        if (nCurrent >= sLights.length()) {
            nCurrent = 0;
        }
        for (int i = nCurrent; i < sLights.length(); i++) {
            System.out.println(i);
            if (sLights.charAt(sLights.length()-1-i) == '0'){
                sbLights.deleteCharAt(sLights.length()-1-i);        
                sbLights.insert(sLights.length()-1-i, '1');
                sOther = sbLights.toString();
                end(i, sOther, nTurn+1);
                break;                                  
            }
        }
        
        
    }

    public static void middle(int nCurrent, String sLights, int nTurn) {
        sLights = clear(sLights);
        StringBuilder sbLights = fix(sLights);
        boolean bCheck = true;
        String sOther;
        for (int i = 0; i < sbLights.length(); i++) {
            if (sbLights.charAt(i) == '1') {
                bCheck = false;
            }
        }
        if (bCheck) {
            System.out.println("here " + nTurn);
            arnTurns[2] = nTurn;
            return;
        }
        if (nCurrent >= sLights.length()) {
            nCurrent = 0;
        }
                for (int i = nCurrent; i < sLights.length(); i++) {
            System.out.println(i);
            if (sLights.charAt(i) == '0') {
                sbLights.deleteCharAt(i);
                sbLights.insert(i, '1');
                sOther = sbLights.toString();
                System.out.println("sother: " +sOther);
                middle(i, sOther, nTurn+1);                
                break;                    
            }
            else if (sLights.charAt(sLights.length()-1-i) == '0'){
                sbLights.deleteCharAt(sLights.length()-1-i);        
                sbLights.insert(sLights.length()-1-i, '1');
                sOther = sbLights.toString();
                middle(i, sOther, nTurn+1);
                break;                                  
            }
        }
    }

    public static StringBuilder fix(String sLights) {
        int nNum, nEnd;
        StringBuilder sbLights = new StringBuilder(sLights);
        for (int j = 0; j < sLights.length(); j++) {
            if (sLights.charAt(j) == '1') {
                nNum = j;
                nEnd = j;
                int nStar = j;
                while (nEnd < sLights.length() && sLights.charAt(nEnd) != '0') {
                    nEnd++;
                }                                                                  
                if (nEnd - nNum >= 4) {
                    while (nNum < nEnd) {
                        sbLights.deleteCharAt(nNum);
                        sbLights.insert(nNum, '0');
                        nNum++;
                    }
                }
            }

        }
        return sbLights;
    }
    public static String clear(String sLights){
        String sFin;
        int j = 0;
        while(sLights.length()-j-1>=4 && sLights.charAt(j) == '0'){
            j++;
        }
        sFin = sLights.substring(j, sLights.length());
        System.out.println(sFin);
        j = 0;
        while (sFin.length()-j>4 && sFin.charAt(sFin.length()-1-j) == '0'){
            System.out.println(j);
            j++;
        }
        sFin = sFin.substring(0,sFin.length()-j);
        System.out.println(sFin);
        return sFin;
    }
}

    //DOES NOT WORK FOR SECOND TEST CASE.  I HAVE NO CLUE HOW IT CAN BE DONE

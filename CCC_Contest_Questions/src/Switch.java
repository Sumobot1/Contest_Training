/*
 https://cemc.math.uwaterloo.ca/contests/computing/2011/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Switch {

    public static int nTurns = 0;

    public static void main(String[] args) throws IOException {
        int nNum, arnLights[];
        String sLights = "";
        Scanner fin = new Scanner(new FileReader("switch.txt"));
        nNum = fin.nextInt();
        for (int i = 0; i < nNum; i++) {
            sLights += fin.nextInt();
        }
        rec(0, sLights, 0);
        System.out.println("nNum: " +nTurns);
    }

    public static void rec(int nCurrent, String sLights, int nTurn) {
        int nNum, nEnd;
        boolean bCheck = true;
        String sThing, sOther;
        StringBuilder sbLights = new StringBuilder(sLights);
        if (nCurrent >= sLights.length()) {
            nCurrent = 0;
        }
        System.out.println("Turn: " +nTurn);
        for (int j = 0;j<sLights.length();j++){            
            if (sLights.charAt(j) == '1'){   
                nNum = j;
                nEnd = j;
                int nStar = j;
                while (nEnd<sLights.length() && sLights.charAt(nEnd)!='0'){
                    nEnd++;
                }                                    
                if (nEnd-nNum>=4){
                    while(nNum<nEnd){
                        sbLights.deleteCharAt(nNum);
                        sbLights.insert(nNum, '0');
                        nNum++;
                    }
                }
            }
            
        }
        System.out.println(sLights +" changed to " +sbLights);
        for (int i = 0;i<sbLights.length();i++){
            if (sbLights.charAt(i) == '1')
                bCheck = false;
        }
        if (bCheck){
            System.out.println("here " +nTurn);
            nTurns = nTurn;
            return;
        }
        for (int i = nCurrent; i < sLights.length(); i++) {
            System.out.println(i);
            if (sLights.charAt(i) == '0') {
                sbLights.deleteCharAt(i);
                sbLights.insert(i, '1');
                sOther = sbLights.toString();
                System.out.println("sother: " +sOther);
                rec(i+1, sOther, nTurn+1);
                break;               
            }
            if (sLights.charAt(sLights.length()-1-i) == '0'){
                sbLights.deleteCharAt(sLights.length()-1-i);        
                sbLights.insert(sLights.length()-1-i, '1');
                sOther = sbLights.toString();
                rec(i+1, sOther, nTurn+1);
                break;                                  
            }
        }
    }
}


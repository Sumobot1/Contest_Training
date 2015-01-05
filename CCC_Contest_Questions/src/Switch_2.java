/*
 https://cemc.math.uwaterloo.ca/contests/computing/2011/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Switch_2 {

    public static int nTurns = 0;

    public static void main(String[] args) throws IOException {
        int nNum, arnLights[], nTaken = 0;
        String sLights = "", sPass = "";
        Scanner fin = new Scanner(new FileReader("switch.txt"));
        nNum = fin.nextInt();
        for (int i = 0; i < nNum; i++) {
            sLights += fin.nextInt();
        }
//        for (int j = 0;j<sLights.length();j++){
//            if (sLights.length()-nTaken-1>=4){
//                if (sLights.charAt(j) == '0')
//                    nTaken+=1;
//                else{
//                    sPass+=sLights.charAt(j);
//                }
//                
//            }
//            else{
//                sPass+=sLights.charAt(j);
//            }
//        }
//        nTaken = 0;
//        for (int j = sLights.length()-1;j>=0;j--){
//            if (sLights.length()-nTaken-1>=4){
//                if (sLights.charAt(j) == '0')
//                    nTaken+=1;
//                else{
//                    sPass+=sLights.charAt(j);
//                }
//            }
//            else{
//                sPass+=sLights.charAt(j);
//            }
//        }
        rec(0, sPass, 0);
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
                //bCheck = false;
                nNum = j;
                nEnd = j;
                int nStar = j;
                while (nEnd<sLights.length() && sLights.charAt(nEnd)!='0'){
                    nEnd++;
                }                                                                   //METHOD TO TURN ANY GROUPS OF 4 OR MORE 1S INTO 0S
                //System.out.println("here" +nEnd);
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
        //sLights = sbLights.toString();
        
        //return;
        //nTurns +=1;
        for (int i = nCurrent; i < sLights.length(); i++) {
            System.out.println(i);
            if (sLights.charAt(i) == '0') {
               // sThing = sbLights.toString();             //TRIED DOING TWO RECURSIVE CALLS ON TOP OF EACH OTHER... DIDNT WORK IDK WHY
                sbLights.deleteCharAt(i);
                sbLights.insert(i, '1');
                sOther = sbLights.toString();
                System.out.println("sother: " +sOther);
               // System.out.println("sThing: "+sThing);
                
               // rec(i+1, sThing, nTurn);              //NOT INCREMENTING I GIVES STACK OVERFLOW
                rec(i, sOther, nTurn+1);                //GOING FROM OUTSIDE IN, CANNOT INCREMENT I
                break;
               // sLights[nCurrent] = 1;            //DONT FORGET THIS HAS TO BE A COPY - ARRAYS PASSED BY REFERENCE
             //   System.out.println(nTurns);
                
               // System.out.println(sThing +" lol " +sOther +" " +nTurn);                        
            }
            else if (sLights.charAt(sLights.length()-1-i) == '0'){
                sbLights.deleteCharAt(sLights.length()-1-i);        //RANDOMLY WONDERED IF THIS WOULD WORK... IT DID
                sbLights.insert(sLights.length()-1-i, '1');
                sOther = sbLights.toString();
                rec(i, sOther, nTurn+1);
                break;                                  //NEEDED BREAKS OR IT WOULD NOT RETURN RIGHT NUMBER... WHY?
            }
        }
     //   System.out.println("here" +nTurn);
     //   return 9999;
    }
}

    //DOES NOT WORK FOR SECOND TEST CASE.  I HAVE NO CLUE HOW IT CAN BE DONE
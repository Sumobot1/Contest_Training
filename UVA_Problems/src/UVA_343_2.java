/*
 *What Base is This?
http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=5&page=show_problem&problem=279
 */
import java.util.*;
import java.io.*;
public class UVA_343_2 {
    public static void main(String[] args) throws IOException{
        String sNum1, sNum2, sNew1, sNew2;
        int nNum1, nNum2, nSum, nFin1 = 0, nFin2 = 0;
        int arnBases[] = new int [34], arnBases2[] = new int[34];
        boolean bCheck;
        Scanner fin = new Scanner (new FileReader("343.txt"));
        while (fin.hasNextLine()){
            bCheck = false;
            sNum1 = fin.next();
            sNum2 = fin.next();
            sNew1 = tonum(sNum1);
            sNew2 = tonum(sNum2);
            arnBases = findbases(sNew1);
            arnBases2 = findbases(sNew2);
            nSum = 100;
            for (int i = 0;i<arnBases.length;i++){
                for (int j = 0;j<arnBases2.length;j++){
                    if (arnBases[i] == arnBases2[j]){
                        bCheck = true;
                        if (nSum>arnBases[i]+arnBases2[j]){
                            nSum = arnBases[i]+arnBases2[j];
                            nFin1 = i+2;
                            nFin2 = j+2;
                        }
                    }
                }
            }
            if (bCheck){
                System.out.println(sNum1 +" base " +nFin1 +" " +sNum2 +" base " +nFin2);
            }
            else{
                System.out.println(sNum1+" is not equal to " +sNum2 +" from bases 2-36");
            }
        }
    }
    public static int[] findbases(String sNum){
        int arnBases[] = new int[34];
        for (int i = 0;i<34;i++){
            arnBases[i] = tobase(sNum, i+2);        //CONVERT EACH STRING TO NUMBER AT THAT BASE
        }
        return arnBases;
    }
    public static String tonum(String sNum){
        String arsAlpha[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","T","U","V","W","X","Y","Z"};
        for (int i = 0;i<arsAlpha.length;i++){
            if (sNum.equals(arsAlpha[i])){      //CONVERT STRING TO NUMBERS...
                return Integer.toString(i+10);
            }     
        }
        return sNum;
    }
    public static int tobase(String sNum, int nBase){           //CONVERT NUMBER AT BASE 10 TO NUMBER AT BASE B
        int nTot = 0, j = 0;
        for (int i = sNum.length()-1;i>=0;i--){
            nTot += (double)Character.getNumericValue(sNum.charAt(i))*(Math.pow(nBase,j));
            j+=1;
        }
        return nTot;
    }
    
}

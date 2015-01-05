/*
 *What Base is This?
http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=5&page=show_problem&problem=279
 */
import java.util.*;
import java.io.*;
public class UVA_343 {

//    public static int nBase1 = 1, nBase2 = 1;
    public static void main(String[] args) throws IOException{
        String sNum1, sNum2, sNew1, sNew2;
        int nNum1, nNum2, arnBases[];
      //  boolean bCheck;
        Scanner fin = new Scanner (new FileReader("343.txt"));
        while (fin.hasNextLine()){
      //      nBase1 = 1;
    //        nBase2 = 1;
            sNum1 = fin.next();
            sNum2 = fin.next();
            sNew1 = tonum(sNum1);
            sNew2 = tonum(sNum2);
            arnBases = findbases(sNew1, sNew2);
            if (arnBases[0] == 1){
                System.out.println("Works " +sNum1 +" base " +arnBases[1] +" " +sNum2 +" base " +arnBases[2]);
            }
            else{
                System.out.println("nope");
            }
   //         if (bCheck){
     //           System.out.println(nBase1 +" " +nBase2);
       //     }
         //   else{
           //     System.out.println("nope");
            //}
        }
    }
    public static String tonum(String sNum){
        String arsAlpha[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","T","U","V","W","X","Y","Z"};
        for (int i = 0;i<arsAlpha.length;i++){
            if (sNum.equals(arsAlpha[i])){
                return Integer.toString(i+10);
            }     
        }
        return sNum;
    }
    public static int[] findbases(String sNum1, String sNum2){
        int nBase1 =  2, nBase2 = 2, nNum1, nNum2, arnNums[] = new int[3];
        nNum1 = tobase(sNum1, nBase1);
        nNum2 = tobase(sNum2, nBase2);
        while (nNum1 != nNum2 && nBase1<37 && nBase2<37){
            nNum1 = tobase(sNum1, nBase1);
            nNum2 = tobase(sNum2, nBase2);
            if (nNum1 == nNum2){
                arnNums[0] = 1;
                arnNums[1] = nBase1;
                arnNums[2] = nBase2;
                return arnNums;
            }
            if (nNum1>nNum2){
                nBase2+=1;
            }
            else if (nNum2>nNum1){
                nBase1+=1;
            }
        }
        return arnNums;
        
    }
    public static int tobase(String sNum, int nBase){
        //System.out.println("newcall");
        int nTot = 0, j = 0;
        for (int i = sNum.length()-1;i>=0;i--){
            //System.out.println((double)Character.getNumericValue(sNum.charAt(i)) +" " +Math.pow(nBase,j) +" " +(double)(Character.valueOf(sNum.charAt(i)))*(Math.pow(nBase,j)));
            nTot += (double)Character.getNumericValue(sNum.charAt(i))*(Math.pow(nBase,j));
            j+=1;
        }
        return nTot;
    }
    
}

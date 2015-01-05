/*
 http://cemc.uwaterloo.ca/contests/computing/2010/stage1/juniorEn.pdf
 */
import java.util.*;
import java.io.*;
public class Global_Warming {

    public static void main(String[] args) throws IOException{
        int nNum, nLen, arnTemps[];
        boolean bCheck;
        Scanner fin = new Scanner (new FileReader("global.txt"));
        while (fin.hasNext()){
            nNum = fin.nextInt();
            if (nNum == 0){
                break;
            }
            arnTemps = new int[nNum];
            for (int i = 0;i<nNum;i++){
                arnTemps[i] = fin.nextInt();
            }
            //print(arnTemps);
            nLen = length(arnTemps);
            System.out.println(nLen);
        }
    }
    public static int length(int arnTemps[]){
        int nDiff, nLen;
        boolean bCheck;
        ArrayList<Integer> alDifs = new ArrayList<Integer>();
        for (int i = 0;i<arnTemps.length-1;i++){
            nDiff = arnTemps[i+1] - arnTemps[i];
            alDifs.add(nDiff);
           // System.out.print(nDiff +" ");
        }
     //   System.out.println();
        
        for (int i = 1;i<alDifs.size();i++){
            bCheck = checkit(alDifs, i);
            if (bCheck){
                return i;
            }
        }
        return alDifs.size();
        
    }
    public static boolean checkit(ArrayList<Integer> alDifs, int nLen){
        int arnDifs[] = new int[nLen];
        int nNum = 0;
        int nNum2 = 0;
        for (int i = 0;i<nLen;i++){
            arnDifs[i] = alDifs.get(i);
        }      
        //print(arnDifs);
        while (nNum<alDifs.size()){
          //  System.out.println("poop");
            //System.out.println(nNum2);// + " " +alDifs.get(nNum) +" " +arnDifs[nNum2] +" " +nLen);
            if (nNum2 > nLen-1){
                nNum2 = 0;
            }
            if (alDifs.get(nNum) != arnDifs[nNum2]){
          //      System.out.println("Here");
            //    if (nNum2 == nLen-1){
              //      nNum2 = -1;
                //}
                return false;
                
                
            }
            
            nNum+=1;
            nNum2+=1;
        }
        return true;
    }
    public static void print(int arnTemps[]){
        for (int i = 0;i<arnTemps.length;i++){
            System.out.print(arnTemps[i] +" ");
        }
        System.out.println();
    }
}

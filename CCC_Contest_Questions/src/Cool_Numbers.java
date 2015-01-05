/*
 https://cemc.math.uwaterloo.ca/contests/computing/2009/stage1/seniorEn.pdf
 */
import java.util.*;
import java.io.*;
public class Cool_Numbers {

    public static void main(String[] args) throws IOException{
        int nCount = 0;
        Scanner fin = new Scanner (new FileReader("CoolNums.txt"));
        long nSmall = fin.nextInt();
        long nBig = fin.nextInt();
        for (long i = nSmall;i<=nBig; i++){
            //System.out.println(i);
            if (square(i)){
                //System.out.println("ok");
                if(cubed(i)){
                    //System.out.println(i);
                    nCount ++;
                }
            }
        }
        System.out.println(nCount);
    }
    public static boolean square(double lNum){
        if (Math.sqrt(lNum) == (int)Math.sqrt(lNum)){
            return true;
        }
        return false;
    }
    public static boolean cubed(double lNum){
        //System.out.println("dlakfjadkjf" +lNum);
        if (Math.cbrt(lNum) == (int)Math.cbrt(lNum)){
            //System.out.println(Math.pow(lNum, (1/3)) +" " +(int)Math.pow(lNum, (1/3)));
            return true;
        }
        return false;
    }
}

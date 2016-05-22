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
            if (square(i)){
                if(cubed(i)){
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
        if (Math.cbrt(lNum) == (int)Math.cbrt(lNum)){
            return true;
        }
        return false;
    }
}

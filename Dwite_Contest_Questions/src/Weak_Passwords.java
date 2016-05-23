/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-201003-p5.html
 */
import java.util.*;
import java.io.*;
public class Weak_Passwords {

    public static void main(String[] args) throws IOException{
        int nNum;
        String sFin;
        Scanner fin = new Scanner (new FileReader("Hash.txt"));
        for (int i = 0;i<5;i++){
            nNum = fin.nextInt();            
            sFin = crack(nNum);
            System.out.println(sFin);
        }
    }
    public static String crack(int nNum){
        long lK, lM, lP;
        String sFin;
        for (int i = 65;i<=90;i++){
            for (int j = 65;j<=90;j++){
                for (int k = 65;k<=90;k++){
                    for (int l = 65;l<=90;l++){
                        lK = (long) (i* Math.pow(10, 6)+ j*Math.pow(10, 4) + k*Math.pow(10,2)+ l);
                        lM = i*11 + j*101 + k*1009 + l*10007;
                        lP = lK%lM;
                        if (lP == nNum){
                            sFin = Character.toString((char)i) + Character.toString((char)j) + Character.toString((char)k) + Character.toString((char)l);
                            return sFin;
                        }
                        
                    }
                }
            }
        }
        return "No Password Found";
    }
    
}

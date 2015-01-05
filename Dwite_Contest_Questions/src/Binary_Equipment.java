/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-201006-p1.html
 */
import java.util.*;
import java.io.*;
public class Binary_Equipment {

    public static void main(String[] args) throws IOException{
        int nNum, nPos;
        String j, sFin = "";
        Scanner fin = new Scanner (new FileReader("Binary.txt"));
        for (int i = 0;i<5;i++){
            sFin = "";
            nNum = fin.nextInt();
            nPos = fin.nextInt();
            j = "00000" +Integer.toBinaryString(nNum);
            for (int k = j.length()-1;k>=0;k--){
                sFin+= j.charAt(k);
            }
            if (sFin.charAt(nPos) == '1'){
                System.out.println("1");
            }
            else {
                System.out.println("0");
            }
        }
    }   
}

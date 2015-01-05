/*
 http://www.cemc.uwaterloo.ca/contests/computing/2006/stage1/seniorEn.pdf
 */
import java.util.*;
import java.io.*;
public class Cipher_Texts {

    public static void main(String[] args) throws IOException{
        String sLine, sHash, sCode;
        char cChar1, cChar2, arcAns[];
        Scanner fin = new Scanner (new FileReader("cipher.txt"));
        sLine = fin.nextLine();
        sHash = fin.nextLine();
        sCode = fin.nextLine();
        arcAns = sCode.toCharArray();
        for (int k = 0;k<sCode.length();k++){
            if (!sHash.contains(Character.toString(sCode.charAt(k)))){
                arcAns[k] = '.';
            }
        }
        for (int i = 0;i<sLine.length();i++){
            for (int j = 0;j<sCode.length();j++){
                if (sCode.charAt(j) == sHash.charAt(i)){
                    arcAns[j] =  sLine.charAt(i);
                }
            }
        }
        for (int i = 0;i<arcAns.length;i++){
            System.out.print(arcAns[i]);
        }
    }
    
}

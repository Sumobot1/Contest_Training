/*
 http://www.cemc.uwaterloo.ca/contests/computing/2006/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Cipher_Texts_2 {

    public static void main(String[] args) throws IOException {
        String sLine, sHash, sCode, sAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        char cChar1 = '.', arcAns[];
        int nBad = 0;
        Scanner fin = new Scanner(new FileReader("cipher.txt"));
        sLine = fin.nextLine();
        sHash = fin.nextLine();
        sCode = fin.nextLine();
        arcAns = new char[sCode.length()];
        for (int i = 0; i < sCode.length(); i++) {
            arcAns[i] = '.';
        }
        for (int i = 0; i < sLine.length(); i++) {
            for (int j = 0; j < sCode.length(); j++) {
                if (sCode.charAt(j) == sHash.charAt(i)) {
                    arcAns[j] = sLine.charAt(i);
                }
            }
        }
        for (int i = 0; i < arcAns.length; i++) {
            if (arcAns[i] == '.') {
                nBad += 1;
            }
        }
        if (nBad == 1) {
            for (int i = 0; i < sAlpha.length(); i++) {
                for (int j = 0; j < sLine.length(); j++) {
                    if (!sLine.contains(Character.toString(sAlpha.charAt(i)))) {
                        cChar1 = sAlpha.charAt(i);
                        break;
                    }
                }
            }
            for (int k = 0; k < arcAns.length; k++) {
                if (arcAns[k] == '.') {
                    arcAns[k] = cChar1;
                    break;
                }
            }
        }
        for (int i = 0; i < arcAns.length; i++) {
            System.out.print(arcAns[i]);
        }
    }
}

/*
 http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=947
 */

import java.util.*;
import java.io.*;

public class UVA_10006 {
public static boolean arbNums[];
public static ArrayList<Integer> alNums = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner(new FileReader("10006.txt"));
        int nNum = 1;
        boolean bCheck;
        arbNums = new boolean[65000+1];
        arbNums[0] = true;
        arbNums[1] = true;
        for (int i = 0; i <= 65000; i++) {
            if (arbNums[i] == false) {
                alNums.add(i);
                for (int l = i; Math.abs(i * l) <= 65000; l++) {
                    arbNums[i * l] = true;
                }
            }
        }
        while (true) {
            nNum = fin.nextInt();
            bCheck = iscarmichael(nNum);
            if (nNum == 0){
                break;
            }
            if (bCheck){
                System.out.println(nNum +" is a Carmichael Number.");
            }
            else{
                System.out.println(nNum +" is normal.");
            }
        }
    }
    public static boolean iscarmichael(int nNum){
        int nCombo = 0;
        for (int i = 0;alNums.get(i)<nNum;i++){
            if (nNum%alNums.get(i) == 0){
                nCombo++;
            }
            if (nCombo>=3){
                return true;
            }
        }
        return false;            
    }
}

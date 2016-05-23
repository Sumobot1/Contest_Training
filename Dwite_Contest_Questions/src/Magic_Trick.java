/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-201211-p4.html
 */

import java.util.*;
import java.io.*;

public class Magic_Trick {

    public static void main(String[] args) throws IOException {
        int nNum, arnOrder[];
        String sFin;
        ArrayList<Integer> arlNums = new ArrayList();
        Scanner fin = new Scanner(new FileReader("magic.txt"));
        for (int i = 0; i < 5; i++) {
            nNum = fin.nextInt();
            System.out.println(nNum);
            for (int k = 1; k <= nNum; k++) {
                arlNums.add(k);

            }
            arnOrder = new int[nNum];
            for (int j = 0; j < nNum; j++) {
                arnOrder[j] = fin.nextInt();
            }
            sFin = order(arnOrder, arlNums);
            System.out.println(sFin);
        }
    }

    public static String order(int arnOrder[], ArrayList<Integer> arlNums) {
        String sFin = "";
        boolean bCheck;
        int arnFin[] = new int[arnOrder.length];
        for (int i = 0; i < arnOrder.length; i++) {
            if ((arlNums.size() - 1 - arnOrder[i]) >= 0) {
                arnFin[i] = arlNums.get(arlNums.size() - 1 - arnOrder[i]);
                arlNums.remove(arlNums.get(arlNums.size() - 1 - arnOrder[i]));
            } else {
                return "IMPOSSIBLE";
            }
        }
        bCheck = checkit(arnFin, arnOrder);
        if (bCheck){
        for (int j = 0; j < arnFin.length; j++) {
            sFin += (arnFin[j] + " ");
        }
        return sFin;
        }
        else{
            return "IMPOSSIBLE";
        }
    }
    public static boolean checkit(int arnFin[], int arnOrder[]){
        int nBig = 0;
        for (int i = 0;i<arnFin.length;i++){
            nBig = 0;
            for (int j = i+1;j<arnFin.length;j++){
                if (arnFin[j]>arnFin[i]){
                    nBig++;
                }
            }
            if (nBig!= arnOrder[i]){
                return false;
            }
        }
        return true;
    }

}

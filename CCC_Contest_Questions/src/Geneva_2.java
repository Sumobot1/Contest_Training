/*
http://cemc.uwaterloo.ca/contests/computing/2014/stage%201/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Geneva_2 {

    public static void main(String[] args) throws IOException {
        int nNum, nNum2;
        ArrayList<Integer> arlNums = new ArrayList();
        boolean bCheck;
        Scanner fin = new Scanner(new FileReader("Geneva Confection.txt"));
        nNum = Integer.parseInt(fin.nextLine());
        for (int i = 0; i < nNum; i++) {
            nNum2 = Integer.parseInt(fin.nextLine());
            for (int j = 0; j < nNum2; j++) {
                arlNums.add(Integer.parseInt(fin.nextLine()));
            }
            bCheck = calculate(arlNums);
            System.out.println(bCheck);
        }
    }

    public static boolean calculate(ArrayList<Integer> arnNums) {
        ArrayList<Integer> arlBranch = new ArrayList();
        boolean bDone;
        int i = 0, nNum = 1;
        while (i < arnNums.size() || i < arlBranch.size()) {
            bDone = false;
            if (arlBranch.size() > 0) {
                if (arlBranch.get(arlBranch.size() - 1) == nNum) {
                    arlBranch.remove(arlBranch.size() - 1);
                    nNum += 1;
                    bDone = true;
                } else {
                    if (arnNums.isEmpty()) {
                        return false;
                    }
                }
            }
            if (arnNums.size() > 0 && bDone == false) {
                if (arnNums.get(arnNums.size() - 1) == nNum) {
                    arnNums.remove(arnNums.size() - 1);
                    nNum += 1;
                } else {
                    arlBranch.add(arnNums.get(arnNums.size() - 1));
                    arnNums.remove(arnNums.size() - 1);
                }
            }
        }
        return (true);
    }
}
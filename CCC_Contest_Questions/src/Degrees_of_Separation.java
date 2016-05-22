/*
 https://cemc.math.uwaterloo.ca/contests/computing/2009/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Degrees_of_Separation {

    public static ArrayList<ArrayList<Integer>> arl2D = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) throws IOException {
        String sLine;
        int nFirst, nLast, nSecond;
        Scanner fin = new Scanner(new FileReader("Degrees.txt"));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(5)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(5)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(5, 3, 4, 14)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(2, 5, 4)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(3, 5, 2)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 6)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(5, 7)));              //THIS SUCKS THERE HAS TO BE A BETTER WAY
        arl2D.add(new ArrayList<Integer>(Arrays.asList(6, 8)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(7, 9, 11)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(8, 10)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(9, 11)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(8, 10, 12)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(11, 13, 14)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(12)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(2, 12)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(16, 17)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(15, 17)));
        arl2D.add(new ArrayList<Integer>(Arrays.asList(15, 16)));
        for (int i = 0; i < 6; i++) {
            sLine = fin.nextLine();
            if (sLine.equals("q")) {
                break;
            } else if (sLine.equals("i")) {
                nFirst = Integer.parseInt(fin.nextLine()) - 1;
                nSecond = Integer.parseInt(fin.nextLine()) - 1;
                insert(nFirst, nSecond);
            } else if (sLine.equals("d")) {
                nFirst = Integer.parseInt(fin.nextLine()) - 1;
                nSecond = Integer.parseInt(fin.nextLine()) - 1;
                delete(nFirst, nSecond);
            } else if (sLine.equals("n")) {
                nFirst = Integer.parseInt(fin.nextLine()) - 1;
                friends(nFirst);
            } else if (sLine.equals("f")) {
                for (int k = 0; k < arl2D.size(); k++) {
                    for (int j = 0; j < arl2D.get(k).size(); j++) {
                        System.out.print(arl2D.get(k).get(j) + " ");           //DEBUG CODE
                    }
                    System.out.println();
                }
                nFirst = Integer.parseInt(fin.nextLine()) - 1;
                foff(nFirst);
            } else if (sLine.equals("s")) {
                nFirst = Integer.parseInt(fin.nextLine()) - 1;
                nSecond = Integer.parseInt(fin.nextLine()) - 1;
                separation(nFirst, nSecond);
            }
        }
    }

    public static void insert(int nFirst, int nSecond) {
        if (nFirst>arl2D.size()){
            for(int i = 0;i<nFirst-arl2D.size()+100;i++){
                arl2D.add(new ArrayList<Integer>());
            }            
        }
        arl2D.get(nFirst).add(nSecond);
        arl2D.get(nSecond).add(nFirst);
    }

    public static void delete(int nFirst, int nSecond) {
        for (int i = 0; i < arl2D.get(nFirst).size(); i++) {
            if (arl2D.get(nFirst).get(i) == nSecond) {
                arl2D.get(nFirst).remove(i);
            }
        }
        for (int i = 0; i < arl2D.get(nSecond).size(); i++) {
            if (arl2D.get(nSecond).get(i) == nFirst) {
                arl2D.get(nSecond).remove(i);
            }
        }
    }

    public static void friends(int nPerson) {
        System.out.println(arl2D.get(nPerson).size());
    }

    public static void foff(int nPerson) {
        ArrayList<Integer> arlDone = new ArrayList<Integer>();       //DON'T NEED A QUEUE, ALREADY HAVE WITH ARRAYLIST
        int nSize = 0;
        System.out.println(nPerson);
        for (int i = 0; i < arl2D.get(nPerson).size(); i++) {
            for (int j = 0;j<arl2D.get(arl2D.get(nPerson).get(i)).size(); j++){
                if (!arlDone.contains(arl2D.get(arl2D.get(nPerson).get(i)).get(j))){
                    arlDone.add(arl2D.get(arl2D.get(nPerson).get(i)).get(j));
                    System.out.print(arl2D.get(arl2D.get(nPerson).get(i)).get(j) +" ");
                    nSize++;
                }
                System.out.println();
            }
        }
        System.out.println(nSize);
    }

    public static void separation(int nFirst, int nSecond) {
        int nNum = 1;
        ArrayList<Integer> arlQueue = new ArrayList<Integer>();
        ArrayList<Integer> arlQueue2 = new ArrayList<Integer>();
        ArrayList<String> arlSeen = new ArrayList<String>();
        for (int i = 0; i < arl2D.get(nFirst).size(); i++) {
            arlQueue.add(arl2D.get(nFirst).get(i));
        }
        while (!arlQueue.isEmpty()) {
            nNum = arlQueue.get(0);
            arlQueue.remove(0);
            if (arl2D.get(nNum).contains(nSecond)) {
                System.out.println("dkajfldkj" + nNum);
                break;
            } else {
                for (int i = 0; i < arl2D.get(nNum).size(); i++) {
                    arlQueue2.add(arl2D.get(nNum).get(i));
                }
            }
            if (arlQueue.isEmpty()){
                                for (int i = 0; i < arlQueue2.size(); i++) {
                    arlQueue.add(arlQueue2.get(i));
                }
                arlQueue2.clear();
                nNum++;
            }
        }
    }
}

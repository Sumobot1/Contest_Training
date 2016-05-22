/*
 https://cemc.math.uwaterloo.ca/contests/computing/2009/stage1/seniorEn.pdf
 */

import java.util.*;
import java.io.*;

public class Degrees_of_Separation_2 {

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
                nFirst = Integer.parseInt(fin.nextLine()) - 1;
                foff(nFirst);
            } else if (sLine.equals("s")) {
                nFirst = Integer.parseInt(fin.nextLine()) - 1;
                nSecond = Integer.parseInt(fin.nextLine()) - 1;
                if (arl2D.get(nFirst).contains(nSecond)){
                    System.out.println("Degree of Separation: " +1);
                }
                else{
                    separation(nFirst, nSecond);
                }
                
            }
        }
    }

    public static void insert(int nFirst, int nSecond) {
        if (nFirst > arl2D.size()) {
            for (int i = 0; i < nFirst - arl2D.size() + 100; i++) {
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
        System.out.println("Friends of " +nPerson +": " +arl2D.get(nPerson).size());
    }
    //Friends of friends of Person
    public static void foff(int nPerson) {
        ArrayList<Integer> arlDone = new ArrayList<Integer>();
        int nSize = 0, nFriend;
        for (int i = 0; i < arl2D.get(nPerson).size(); i++) {
            nFriend = arl2D.get(nPerson).get(i);
            for (int j = 0; j < arl2D.get(nFriend).size(); j++) {
                if (!arlDone.contains(arl2D.get(nFriend).get(j)) && arl2D.get(nFriend).get(j) != nPerson && !arl2D.get(nPerson).contains(arl2D.get(nFriend).get(j))) {
                    arlDone.add(arl2D.get(arl2D.get(nPerson).get(i)).get(j));
                    nSize++;
                }
            }
        }
        System.out.println("Friends of Friends of " +nPerson +": " + nSize);
    }
    //Degrees of separation
    public static void separation(int nFirst, int nSecond) {
        System.out.println(nFirst +" " +nSecond);
        int nDeg = 1, nNum;
        ArrayList<Integer> arlQueue = new ArrayList<Integer>();
        ArrayList<Integer> arlQueue2 = new ArrayList<Integer>();
        ArrayList<Integer> arlSeen = new ArrayList<Integer>();
        for (int i = 0; i < arl2D.get(nFirst).size(); i++) {
            arlQueue.add(arl2D.get(nFirst).get(i));
        }
        arlSeen.add(nFirst);
        while (!arlQueue.isEmpty()) {
            System.out.println("Queue: " +arlQueue);
            System.out.println("Seen: " +arlSeen);
            nNum = arlQueue.get(0);
            arlQueue.remove(0);
            System.out.println(nNum);
            if (arl2D.get(nNum).contains(nSecond)) {
                System.out.println("Degree of Separation: " + (nDeg+1));
                return;
            } else {
                System.out.println("At person " +nNum +": " +arl2D.get(nNum));
                if (!arlSeen.contains(nNum)){
                    for (int i = 0; i < arl2D.get(nNum).size(); i++){
                        arlQueue2.add(arl2D.get(nNum).get(i));
                    }
                    arlSeen.add(nNum);
                }
            }
            if (arlQueue.isEmpty()) {
                for (int i = 0; i < arlQueue2.size(); i++) {
                    arlQueue.add(arlQueue2.get(i));
                }
                arlQueue2.clear();
                nDeg++;
            }
        }
        System.out.println("No Connection.");
    }
}

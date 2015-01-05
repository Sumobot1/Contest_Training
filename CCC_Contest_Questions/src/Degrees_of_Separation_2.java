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
//        for (int i = 0;i<23;i++){
        //          arl2D.add(new ArrayList<Integer>());
        //    }
        //arl2D.get(0) = Arrays.asList({6});
//        int arn2[] = {6,4,5,15};
//        int arn3[] = {3,6,5};
//        int arn4[] = {4,6,3};
//        int arn5[] = {1,2,3,4,5,7};
//        int arn6[] = {6,8};
//        int arn7[] = {7,9};
//        int arn8[] = {8,10,12};                           //TRIED ADDING ARRAYS TO ARRAYLIST, DIDNT WORK
//        int arn9[] = {9,11};                              //TRIED ADDING JUST VALUES TO ARRAYLIST, DIDNT WORK
//        int arn10[] = {10,12};
//        int arn11[] = {9,11,13};
//        int arn12[] = {12,14,15};
//        //int arn13[] = {13};
//        int arn14[] = {3,13};
//        int arn15[] = {17,18};
//        int arn16[] = {16,18};
//        int arn17[] = {16,17};
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
//        for (int i = 0;i<arl2D.size();i++){
//            for (int j = 0;j<arl2D.get(i).size();j++){
//                System.out.print(arl2D.get(i).get(j) +" ");           //DEBUG CODE
//            }
//            System.out.println();
//        }

        for (int i = 0; i < 6; i++) {
            //break;
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
//                System.out.println("Debug Code:");
//                for (int k = 0; k < arl2D.size(); k++) {
//                    for (int j = 0; j < arl2D.get(k).size(); j++) {
//                        System.out.print(arl2D.get(k).get(j) + " ");           //DEBUG CODE
//                    }
//                    System.out.println();
//                }
                nFirst = Integer.parseInt(fin.nextLine()) - 1;
                //System.out.println("Finding friends of friends of " + nFirst);          //UPDATE - READ THE QUESTION... LOL PERSON AND FRIENDS OF THAT PERSON DO NOT COUNT
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
        //arl2D.get(nSecond).remove(nFirst);        //NEED TO REMOVE ITEM AT INDEX, NOT SPECIFIC VALUE
    }

    public static void friends(int nPerson) {
        System.out.println("Friends of " +nPerson +": " +arl2D.get(nPerson).size());
    }

    public static void foff(int nPerson) {
        ArrayList<Integer> arlDone = new ArrayList<Integer>();       //DON'T NEED A QUEUE, ALREADY HAVE WITH ARRAYLIST
        int nSize = 0, nFriend;
        //System.out.println(nPerson);
        for (int i = 0; i < arl2D.get(nPerson).size(); i++) {
            nFriend = arl2D.get(nPerson).get(i);
            //System.out.println("Person: " + nFriend);
            for (int j = 0; j < arl2D.get(nFriend).size(); j++) {
                if (!arlDone.contains(arl2D.get(nFriend).get(j)) && arl2D.get(nFriend).get(j) != nPerson && !arl2D.get(nPerson).contains(arl2D.get(nFriend).get(j))) {
                    arlDone.add(arl2D.get(arl2D.get(nPerson).get(i)).get(j));
                    //System.out.print(arl2D.get(arl2D.get(nPerson).get(i)).get(j) +" ");
                    nSize++;
                }
                //System.out.println();
            }
        }
        System.out.println("Friends of Friends of " +nPerson +": " + nSize);
    }

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
        //arlSeen.add(arl2D.get(nFirst).get(arl2D.get(nFirst).size()-1));
        //System.out.println("Queue: " +arlQueue);
        while (!arlQueue.isEmpty()) {
            System.out.println("Queue: " +arlQueue);
            System.out.println("Seen: " +arlSeen);
            nNum = arlQueue.get(0);
            arlQueue.remove(0);
            //arlSeen.add(nNum);
            System.out.println(nNum);
            if (arl2D.get(nNum).contains(nSecond)) {
                //System.out.println(arl2D.get(nNum));
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
//                for (int i = 0; i < arl2D.get(nNum).size(); i++) {
//                    if (!arlSeen.contains(nNum)){
//                        System.out.println(nNum +" is not contained in " +arlSeen);
//                        arlQueue2.add(arl2D.get(nNum).get(i));
//                        //arlSeen.add(nNum);
//                    }                    
//                }
                //arlSeen.add(nNum);
                //arlSeen.add(nNum);
                //System.out.println(arlQueue2);
            }
            if (arlQueue.isEmpty()) {
                for (int i = 0; i < arlQueue2.size(); i++) {
                    arlQueue.add(arlQueue2.get(i));
                }
                arlQueue2.clear();
                nDeg++;                         //Variable named nNum... same name as variable being looked for...
                //System.out.println("Lol");
            }
        }
        System.out.println("No Connection.");
    }
}

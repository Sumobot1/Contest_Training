/*
 http://www.cemc.uwaterloo.ca/contests/computing/2007/stage1/seniorEn.pdf
 */
import java.util.*;
import java.io.*;
public class Waterpark {
public static ArrayList<ArrayList<Integer>> arnMap = new ArrayList<ArrayList<Integer>>();
public static int nDest, nPaths;
    public static void main(String[] args) throws IOException{
        int nStart, nEnd;
        Scanner fin = new Scanner (new FileReader ("waterpark.txt"));
        nDest = fin.nextInt();
        for (int i = 0;i<nDest+1;i++){
            arnMap.add(new ArrayList<Integer>());
        }
        while (fin.hasNext()){
            nStart = fin.nextInt();
            nEnd = fin.nextInt();
            arnMap.get(nStart).add(nEnd);
        }
        //System.out.println(arnMap);
        rec(1);
        System.out.println(nPaths);
    }
    public static void rec(int nStart){
        if (nStart == nDest){
            nPaths+= 1;
            return;
        }
        if (arnMap.get(nStart).isEmpty()){
            return;
        }
        else{
            for (int i = 0;i<arnMap.get(nStart).size();i++){
                rec(arnMap.get(nStart).get(i));
            }
        }
    }
}

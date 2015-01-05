/*
 http://www.cemc.uwaterloo.ca/contests/computing/2007/stage1/juniorEn.pdf
 */
import java.util.*;
import java.io.*;
public class Keep_on_Truckin {
public static int nPaths = 0, nMin, nMax;
public static ArrayList<Integer> alStops = new ArrayList<> (Arrays.asList(990, 1010, 1970, 2030, 2940, 3060, 3930, 4060, 4970, 5030, 5990, 6010, 7000));
    public static void main(String[] args) throws IOException{       
        int nNew;
        Scanner fin = new Scanner (new FileReader("truckin.txt"));
        nMin = fin.nextInt();
        nMax = fin.nextInt();
        nNew = fin.nextInt();
        for (int i = 0;i<nNew;i++){
            alStops.add(fin.nextInt());
        }
        rec(0);
        System.out.println(nPaths);
    }
    public static void rec(int nDist){
        int nMinDist = nDist+nMin;
        int nMaxDist = nDist+nMax;        
        for (int i = 0;i<alStops.size();i++){
            if (alStops.get(i)>= nMinDist && alStops.get(i)<=nMaxDist){
                rec(alStops.get(i));
            }
        }
        if (nMinDist<=7000 && nMaxDist>=7000){
            nPaths += 1;
            return;
        }
            
    }
}

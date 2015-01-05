/*
 http://cemc.math.uwaterloo.ca/contests/computing/2013/stage1/juniorEn.pdf
 */
import java.util.*;
import java.io.*;
public class Time_On_Task {

    public static void main(String[] args) throws IOException{
        int nTot, nChores, arnChores[], nNum;
        Scanner fin = new Scanner (new FileReader("Time On Task.txt"));
        nTot = fin.nextInt();
        nChores = fin.nextInt();
        arnChores = new int[nChores];
        for (int i = 0;i<nChores;i++){
            arnChores[i] = fin.nextInt();
        }
        Arrays.sort(arnChores);
        nNum = calc(arnChores, nTot);
        System.out.println(nNum);
    }
    public static int calc(int arnChores[], int nTot){
        int nSum = 0, i = 0;
        while (nSum<=nTot){
            nSum += arnChores[i];
            i++;
        }
        return i-1;
    }
    
}

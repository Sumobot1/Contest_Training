/*
 http://dwite.ca/questions/primal_numbers.html
 */
import java.util.*;
import java.io.*;
public class Primal_Numbers {

    public static void main(String[] args) throws IOException{
        int nNum, nStep, nPrimal;
        Scanner fin = new Scanner (new FileReader("primal.txt"));
        ArrayList<Integer> alPrimes = sieve(8000);        
        for (int i = 0;i<5;i++){
            nNum = fin.nextInt();           
            nStep = alPrimes.get(nNum-1);          
            nPrimal = alPrimes.get(nStep-1);
            System.out.println(nPrimal);
        }
    }
    public static ArrayList<Integer> sieve(int nNum) {
        ArrayList<Integer> alPrimes = new ArrayList<Integer>();
        boolean[] arbNums = new boolean[nNum + 1];
        for (int m = 2; m <= nNum; m++) {
            if (!arbNums[m]) {
                alPrimes.add(m);
                for (int k = m * m; k <= nNum; k += m) {
                    arbNums[k] = true;
                }
            }
        }
        return alPrimes;
    }
}
    

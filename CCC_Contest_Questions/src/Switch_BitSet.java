/*
 https://cemc.math.uwaterloo.ca/contests/computing/2011/stage1/seniorEn.pdf
 */
import java.util.*;
import java.io.*;
public class Switch_BitSet {

    public static void main(String[] args) throws IOException{
        int nNum;
        BitSet bits = new BitSet(); 
        Scanner fin = new Scanner (new FileReader("switch.txt"));
        nNum = fin.nextInt();
        //arnLights = new int[nNum];
        for (int i = 0; i < nNum; i++) {
            if (fin.nextInt() == 1){            //GOING TO USE AN ARRAY, HOWEVER BITSET IS MORE EFFICIENT TO MY UNDERSTANDING...
                bits.set(i, true);
            }           
        }
        rec(bits, 0);
    }
    public static void rec(BitSet bits, int i){
        if (i >= bits.length()){
            return;
        }
        for (int j = 0;j<=bits.length()-1;j++){
            System.out.print(bits.get(j) +" ");
        }
        System.out.println(i);
        
        //rec(bits, i+1);
        bits.set(i, false);
        rec(bits, i+1);
        
    }
}

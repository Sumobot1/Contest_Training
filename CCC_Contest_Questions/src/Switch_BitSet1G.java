/*
 https://cemc.math.uwaterloo.ca/contests/computing/2011/stage1/seniorEn.pdf
 */
import java.util.*;
import java.io.*;
public class Switch_BitSet1G {

    public static void main(String[] args) throws IOException{
        int nNum;
        String sNums = "1001001";
        boolean isTrue;
        //BitSet bits = new BitSet(001100101); 
        BitSet bits = new BitSet(); 
        System.out.println(bits);
        for(int j=0;j<sNums.length();j++){
            //System.out.println(bits.get(j));
            //isTrue = bits.get(j);
            if(sNums.charAt(j)=='0'){
                bits.set(j,false);
            }
            else{
                bits.set(j,true);               
            }
            //System.out.println(isTrue);           
        }
        for(int j=0;j<bits.length();j++){
            if(bits.get(j)){
                System.out.println("true");
            }
            else{
                System.out.println("false");                
            }           
        }
        /*Scanner fin = new Scanner (new FileReader("switch.txt"));
        nNum = fin.nextInt();
        //arnLights = new int[nNum];
        for (int i = 0; i < nNum; i++) {
            if (fin.nextInt() == 1){            //GOING TO USE AN ARRAY, HOWEVER BITSET IS MORE EFFICIENT TO MY UNDERSTANDING...
                bits.set(i, true);
            }           
        }
        rec(bits, 0);*/
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

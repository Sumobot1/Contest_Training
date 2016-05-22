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
        BitSet bits = new BitSet(); 
        System.out.println(bits);
        for(int j=0;j<sNums.length();j++){
            if(sNums.charAt(j)=='0'){
                bits.set(j,false);
            }
            else{
                bits.set(j,true);               
            }         
        }
        for(int j=0;j<bits.length();j++){
            if(bits.get(j)){
                System.out.println("true");
            }
            else{
                System.out.println("false");                
            }           
        }
    }
    public static void rec(BitSet bits, int i){
        if (i >= bits.length()){
            return;
        }
        for (int j = 0;j<=bits.length()-1;j++){
            System.out.print(bits.get(j) +" ");
        }
        System.out.println(i);
        bits.set(i, false);
        rec(bits, i+1);
        
    }
}

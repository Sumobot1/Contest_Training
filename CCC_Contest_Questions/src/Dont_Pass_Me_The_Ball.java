/*
 http://cemc.uwaterloo.ca/contests/computing/2012/stage1/seniorEn.pdf
 */
import java.util.*;
import java.io.*;
public class Dont_Pass_Me_The_Ball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        int nNum, nCom;
        Scanner fin = new Scanner (new FileReader("noball.txt"));
        nNum = fin.nextInt();
        nCom = combine(nNum);
        System.out.println(nCom);
    }
    public static int combine(int nNum){
        int nFin = 0;
        for (int i = 0;i<nNum-3;i++){
            for (int j = 0;j<nNum-2;j++){
                for (int k = 0;k<nNum-1;k++){
                        if (i!=j && i!=k && j!=k && k>j && k>i && j>i){
                            nFin ++;
                    }
                }
            }
        }
        return nFin;
    }
    
}

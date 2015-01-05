/*
 http://nayuki.eigenstate.org/res/dwite-programming-contest-solutions/dwite-201003-p1.html
 */
import java.util.*;
import java.io.*;
public class ASCII_Bar_Graphs {

    public static void main(String[] args) throws IOException{
        int nNum;
        //char arcGraph[] = {'-','-','-','-','-','|','-','-','-','-','-'};
        Scanner fin = new Scanner (new FileReader("Bargraph.txt"));
        for (int i = 0;i<5;i++){
            char arcGraph[] = {'-','-','-','-','-','|','-','-','-','-','-'};        //TF IS WRONG WITH THIS
            //arcGraph = {'-','-','-','-','-','|','-','-','-','-','-'};
            nNum = fin.nextInt();
            arcGraph = show(arcGraph, nNum);
            for (int j = 0;j<arcGraph.length;j++){
                System.out.print(arcGraph[j]);
            }
            System.out.println();
        }
    }
    public static char[] show (char arcGraph[], int nNum){
        if (nNum>0){
            for (int i = 6;i<=nNum+5;i++){
                arcGraph[i] = '*';
            }
        }
        if (nNum<0){
            for (int i = 4;i>=nNum+5;i--){
                arcGraph[i] = '*';
            }
        }
        return arcGraph;
    }
    
}

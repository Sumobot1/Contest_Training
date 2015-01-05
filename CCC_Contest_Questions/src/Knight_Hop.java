/*
 http://cemc.uwaterloo.ca/contests/computing/2010/stage1/juniorEn.pdf
 */
import java.io.*;
import java.util.*;
public class Knight_Hop {

    public static void main(String[] args) throws IOException{
        int nDist;
        Scanner fin = new Scanner (new FileReader("knight.txt"));
        int arnBoard[][] = new int[8][8];
        int nYS = fin.nextInt()-1;
        int nXS = fin.nextInt()-1;
        int nYE = fin.nextInt()-1;
        int nXE = fin.nextInt()-1;        
        arnBoard[nXS][nYS] = 1;
        arnBoard[nXE][nYE] = 2;
        nDist = finddist(arnBoard, nXS, nYS);
        if (nXS == nXE && nYS == nYE){
            nDist = 0;
        }
        System.out.println(nDist);
    }
    public static int finddist(int arnBoard[][], int nX, int nY){
        ArrayList<Integer> arlQueue = new ArrayList<Integer>();
        ArrayList<Integer> arlQueue2 = new ArrayList<Integer>();
        ArrayList<String> arlSeen = new ArrayList<String>();
        int[] arnX = {2, 1, -1, -2, -2, -1, 1, 2}, arnY = {1, 2, 2, 1, -1, -2, -2, -1};
        int nCurx, nCury, nNewx, nNewy, nNum = 0;
        arlQueue.add(nX);
        arlQueue.add(nY);
        arlSeen.add(nX +" " +nY);
        while (!arlQueue.isEmpty()){
            nCurx = arlQueue.get(0);
            arlQueue.remove(0);
            nCury = arlQueue.get(0);
            arlQueue.remove(0);
            for (int i = 0;i<8;i++){
                nNewx = nCurx+arnX[i];
                nNewy = nCury+arnY[i];
                if (nNewx >= 0 && nNewy >= 0 && nNewx < arnBoard.length && nNewy < arnBoard[0].length) {
                    if (arlSeen.indexOf(nNewx +" " +nNewy)<0 && arnBoard[nNewx][nNewy] == 0 || arnBoard[nNewx][nNewy] == 2){
                        if (arnBoard[nNewx][nNewy] == 2){
                            return nNum+1;
                        }
                        arlQueue2.add(nNewx);
                        arlQueue2.add(nNewy);
                        arlSeen.add(nNewx +" " +nNewy);
                    }
                }
            }
            if (arlQueue.isEmpty()){
                for (int i = 0; i < arlQueue2.size(); i++) {
                    arlQueue.add(arlQueue2.get(i));
                }
                arlQueue2.clear();
                nNum++;
            }
            }
        return -1;
        }
        
    }


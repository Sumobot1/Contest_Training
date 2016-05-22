/*
 https://cemc.math.uwaterloo.ca/contests/computing/2009/stage1/seniorEn.pdf
 */
import java.util.*;
import java.io.*;
public class Shop_and_Ship {

    public static void main(String[] args) throws IOException{
        int nCities, nRoutes, nDist, nStart, nEnd, nPencils, arnPencils[][], nDest, nTot, nMin = Integer.MAX_VALUE;
        Vertex arVertex[];
        Scanner fin = new Scanner (new FileReader("shop.txt"));
        nCities = fin.nextInt();
        nRoutes = fin.nextInt();
        arVertex = new Vertex[nCities+1];
        for (int i = 0; i < nCities+1; i++) {
            arVertex[i] = new Vertex();
        }
        for (int i = 0;i<nRoutes;i++){
            nStart = fin.nextInt();
            nEnd = fin.nextInt();
            nDist = fin.nextInt();
            arVertex[nStart].adjacencies.add(new Edge(arVertex[nEnd], nDist));
            arVertex[nEnd].adjacencies.add(new Edge(arVertex[nStart], nDist));
        }
        nPencils = fin.nextInt();
        arnPencils = new int[nPencils][2];
        for (int i = 0;i<nPencils;i++){
            arnPencils[i][0] = fin.nextInt();
            arnPencils[i][1] = fin.nextInt();            
        }
        nDest = fin.nextInt();
        for (int i = 0;i<arnPencils.length;i++){
            nTot = 0;
            nTot+= arnPencils[i][1];
            for (int j = 0;j<arVertex.length;j++){
                arVertex[j].minDistance = Double.POSITIVE_INFINITY;
            }
            computePaths(arVertex[arnPencils[i][0]]);
            nTot+= arVertex[nDest].minDistance;
            if (nTot<nMin){
                nMin = nTot;
            }
        }
        System.out.println(nMin);
    }
    public static void computePaths(Vertex vSource) {
        Vertex v;
        double dWeight, dDistanceThrough;
        vSource.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(vSource);
        while (!vertexQueue.isEmpty()){
            Vertex vCur = vertexQueue.poll();
            for (Edge eCurr : vCur.adjacencies){
                v = eCurr.target;
                dWeight = eCurr.weight;
                dDistanceThrough = vCur.minDistance+dWeight;
                if (dDistanceThrough<v.minDistance){
                    vertexQueue.remove(v);
                    v.minDistance = dDistanceThrough;
                    v.previous = vCur;
                    vertexQueue.add(v);
                }
                
            }
        }
    }
    
}
class Vertex implements Comparable<Vertex> {

    //public final String sName;
    public ArrayList<Edge> adjacencies = new ArrayList<Edge>();
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    //Constructor - gives name of city

    public void Vertex() {
//        sName = sWord;
    }
//    //Turns to String... without this names are full of random chars
//
//    public String toString() {
//        return sName;
//    }
    //Compares distances between current minimum distance (originally infinity) and the current distance between 2 points
    //Tries to find shortest distance

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}
// Defines edges as connections between 2 points.  Gives each connection a distance.
class Edge {

    public final Vertex target;
    public final double weight;

    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}


/*
 http://www.nayuki.io/res/dwite-programming-contest-solutions/dwite-200601-p5.pdf
 */

import java.util.*;
import java.io.*;

public class Distance_Between_Towns {

    public static void main(String[] args) throws IOException {
        Vertex arVertex[];
        int nNum, nDist, nIndex, nDestIndex;
        char arcPlaces[];
        String sAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Scanner fin = new Scanner(new FileReader("distance.txt"));
        nNum = fin.nextInt();
        //System.out.println(nNum);
        arVertex = new Vertex[nNum];
        for (int i = 0; i < nNum; i++) {
            arVertex[i] = new Vertex(Character.toString(sAlpha.charAt(i)));
            //System.out.println(arVertex[i]);
        }
        for (int i = 0; i < nNum; i++) {
            arcPlaces = fin.next().toCharArray();           //Check first digit as origin, second as destination.  Find correct array index, add edge
            System.out.println(arcPlaces[0] + " " + arcPlaces[1]);
            nDist = fin.nextInt();
            System.out.println(nDist);
            nIndex = find(sAlpha, arcPlaces[0]);
            System.out.println(arVertex[nIndex]);
            nDestIndex = find(sAlpha, arcPlaces[1]);
            System.out.println(arVertex[nDestIndex]);
            arVertex[nIndex].adjacencies.add(new Edge(arVertex[nDestIndex], nDist));
            arVertex[nDestIndex].adjacencies.add(new Edge(arVertex[nIndex], nDist));
            //arVertex[i].adjacencies.add();
        }
        //for (int i = 0;i<arVertex.length;i++)
        while (fin.hasNext()) {
            arcPlaces = fin.next().toCharArray();
            nIndex = find(sAlpha, arcPlaces[0]);
            nDestIndex = find(sAlpha, arcPlaces[1]);
            System.out.println(arcPlaces[0] + " " + arcPlaces[1]);
            for (Vertex v : arVertex) {
                v.minDistance = Double.POSITIVE_INFINITY;
            }
            computePaths(arVertex[nIndex]);
            System.out.println(arVertex[nDestIndex].minDistance);
        }

    }

    public static int find(String sAlpha, char cCurr) {
        for (int i = 0; i < sAlpha.length(); i++) {
            if (sAlpha.charAt(i) == cCurr) {
                return i;
            }
        }
        return -1;
    }

    public static void computePaths(Vertex vSource) {
        Vertex v;
        double dWeight, dDistanceThrough;
        vSource.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(vSource);
        while (!vertexQueue.isEmpty()) {
            Vertex vCur = vertexQueue.poll();
            for (Edge eCurr : vCur.adjacencies) {
                v = eCurr.target;
                dWeight = eCurr.weight;
                dDistanceThrough = vCur.minDistance + dWeight;
                if (dDistanceThrough < v.minDistance) {
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

    public final String sName;
    public ArrayList<Edge> adjacencies = new ArrayList<Edge>();
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    //Constructor - gives name of city

    public Vertex(String sWord) {
        sName = sWord;
    }
    //Turns to String... without this names are full of random chars

    public String toString() {
        return sName;
    }
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

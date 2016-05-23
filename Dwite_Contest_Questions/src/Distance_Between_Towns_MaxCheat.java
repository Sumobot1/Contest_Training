/*
Looks like problem is that something is not resetting properly...
* http://www.nayuki.io/res/dwite-programming-contest-solutions/dwite-200601-p5.pdf
 */

import java.util.*;
import java.io.*;

public class Distance_Between_Towns_MaxCheat {
//public static Vertex2 vertices;
    public static void main(String[] args) throws IOException {
        Scanner fin = new Scanner(new FileReader("distance.txt"));
        String sAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //Declare vertex, give it a name
        Vertex2 v0 = new Vertex2("A");
        Vertex2 v1 = new Vertex2("B");
        Vertex2 v2 = new Vertex2("C");
        Vertex2 v3 = new Vertex2("D");
        Vertex2 v4 = new Vertex2("E");
        Vertex2 v5 = new Vertex2("F");
        //Declare the adjacencies for each vertex.  Each adjacency is an edge with a destination and a weight
        v0.adjacencies = new Edge2[]{new Edge2(v1, 5), new Edge2(v3, 5), new Edge2(v4, 6)};
        v1.adjacencies = new Edge2[]{new Edge2(v0, 5), new Edge2(v2, 4)};
        v2.adjacencies = new Edge2[]{new Edge2(v1, 4), new Edge2(v3, 2), new Edge2(v4, 2), new Edge2(v5, 4)};
        v3.adjacencies = new Edge2[]{new Edge2(v0, 5), new Edge2(v2, 2), new Edge2(v5, 6)};
        v4.adjacencies = new Edge2[]{new Edge2(v0, 6), new Edge2(v2, 2), new Edge2(v5, 1)};
        v5.adjacencies = new Edge2[]{new Edge2(v2, 4), new Edge2(v3, 6), new Edge2(v4, 1)};
        Vertex2[] vertices = {v0, v1, v2, v3, v4, v5};      //Creates an array of verticies - Each vertex is a class

        for (int i = 0; i < 10; i++) {
            fin.nextLine();
        }
        computePaths(v4);       //Calls method computepaths 
        for (Vertex2 v : vertices) {    //For each vertex in the array...
            System.out.println("Distance to " + v + ": " + v.minDistance);
            List<Vertex2> path = getShortestPathTo(v);
            System.out.println("Path: " + path);
        }
        for (Vertex2 v : vertices){
            v.minDistance = Double.POSITIVE_INFINITY;                               
        }
        computePaths(v5);
        for (Vertex2 v : vertices) {    //For each vertex in the array...
            System.out.println("Distance to " + v + ": " + v.minDistance);
            List<Vertex2> path = getShortestPathTo(v);
            System.out.println("Path: " + path);
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

    public static void computePaths(Vertex2 source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex2> vertexQueue = new PriorityQueue<Vertex2>();      //Each object has a priority associated with it - not just a chronological list
        vertexQueue.add(source);        //Add the source
        double weight, distanceThroughU;
        Vertex2 v;
        while (!vertexQueue.isEmpty()) {        //This is somewhat similar to the bfs - checks adjacent points and finds distance...
            Vertex2 u = vertexQueue.poll();

            // Visit each edge exiting u
            for (Edge2 e : u.adjacencies) {     //Check each adjacent edge
                v = e.target;           //Find the Destination Point
                weight = e.weight;       //Find Distanc
                distanceThroughU = u.minDistance + weight;       //Find Distance to Destination point through current one by taking the minimum distance to the current point and adding the distance
                if (distanceThroughU < v.minDistance) {     //If current distance is less than current min distance, 
                    vertexQueue.remove(v);              //Remove vertex from queue

                    v.minDistance = distanceThroughU;   //Update minimum distance
                    v.previous = u;                     //Change previous point before that vertex to be the current one
                    vertexQueue.add(v);                 //Add new vertex to queue
                }
            }
        }
    }

    public static List<Vertex2> getShortestPathTo(Vertex2 target) {     //Minimum distances have already been calculated from point to point using the "previous" method in the vertex class (previous point is the one closest to the current one with respect to the starting vertex)
        List<Vertex2> path = new ArrayList<Vertex2>();
        for (Vertex2 vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex);
        }

        Collections.reverse(path);          //Because path starts at destination and goes to start, it needs to be reversed
        return path;
    }
}
//  This is the explanation for implements... http://stackoverflow.com/questions/3718383/java-class-implements-comparable
class Vertex2 implements Comparable<Vertex2> {

    public final String sName;
    public Edge2[] adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex2 previous;
    //Constructor - gives name of city

    public Vertex2(String sWord) {
        sName = sWord;
    }
    //Turns to String... without this names are full of random chars

    public String toString() {
        return sName;
    }
    //Compares distances between current minimum distance (originally infinity) and the current distance between 2 points
    //Tries to find shortest distance

    public int compareTo(Vertex2 other) {
        return Double.compare(minDistance, other.minDistance);
    }
}
// Defines edges as connections between 2 points.  Gives each connection a distance.
class Edge2 {

    public final Vertex2 target;
    public final double weight;

    public Edge2(Vertex2 argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}
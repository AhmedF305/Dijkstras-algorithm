// GROUP MEMBERS :-
//============================
// MEMBER 1 : 
// NAME : Mohammed ALzahrani
// ID : 1740166
//============================
// MEMBER 2 : 
// NAME : Ahmed Hedaya
// ID : 1743728
//============================
// MEMBER 3 : 
// NAME : Ahmed ALmutairi
// ID : 1740898
//============================
package CheckPoint3.pkg1;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private static Vertex vertexList[]; // Array of vertices as objects of class Vertex
    private static int adjMat[][]; // adjacency matrix
    private static int adjList[]; // list the Adjacent vertexs for each vertexs
    private static boolean connect_graph = true; // the check if the graph is connacted or not
    private StackX theStack = new StackX();
    private Queue<Integer> queue = new LinkedList<>();
    private Dijkstras path = new  Dijkstras();

// -----------------------------------------------------------
    public Graph(int num_of_vertex) // constructor
    {
//initialize the above data members
        this.vertexList = new Vertex[num_of_vertex];
        this.adjMat = new int[num_of_vertex][num_of_vertex];

    } // end constructor
// -----------------------------------------------------------

    public static String isConnect_graph() {
        System.out.println("");
        // Check the graph states and print if it's connected or not 
        if (connect_graph) {
            return "Graph is connected.";
        } else {
            return "Graph is not connected.";
        }

    }

    public static void setConnect_graph(boolean connect_graph) {
        Graph.connect_graph = connect_graph;
    }

// -----------------------------------------------------------
    public void addVertex(char lab, int i) {
        //add new vertex
        vertexList[i] = new Vertex(lab);
    }

// -----------------------------------------------------------

    public void addEdge(int start, int end, int Weigted) {
//add new edge for undirected graph
        adjMat[start][end] = Weigted;
        //adjMat[end][start] = Weigted;
    }
// ------------------------------------------------------------

    public void displayVertex(PrintWriter output) {
        output.print("\r\nAdjacent Vertices of every vertex: \r\n\r\n");
        for (int i = 0; i < vertexList.length; i++) {
            int countadj = 0;
            output.print("VERTEX: " + i + " {" + vertexList[i].label + "} - VISIT: " + vertexList[i].wasVisited + " - ADJACENCY: ");

            for (int j = 0; j < vertexList.length; j++) {
                if (adjMat[i][j] > 0) {
                    countadj++;
                }
            }
            adjList = new int[countadj];
            for (int j = 0, k = 0; j < vertexList.length; j++) {
                if (adjMat[i][j] > 0) {
                    adjList[k] = j;
                    k++;
                }
            }
            for (int j = 0; j < adjList.length; j++) {
                output.print(adjList[j]);
                if (j < adjList.length - 1) {
                    output.print(",");
                }
            }
            output.print("\r\n");
        }
    }
// -------------------------------------------------------------

    public StringBuilder dfs() // depth-first search
    {
        StringBuilder stringB = new StringBuilder();
        //Depth-first-search 
        //vertex 0(a) as visited
        vertexList[0].setWasVisited(true);
        //Push it onto the stack
        theStack.push(0);
        //print this vertex 0(a)
        stringB.append(0);
        //while stack is not empty, do the following
        while (!theStack.isEmpty()) {
            // next codes will go row by row add the vertexs to the stack and print it and make it visted
            for (int i = 0; i < adjMat[theStack.peek()].length; i++) {
                if (adjMat[theStack.peek()][i] > 0 && !vertexList[i].isWasVisited()) {
                    vertexList[i].setWasVisited(true);
                    stringB.append("," + i);
                    theStack.push(i);
                    i = 0;
                }
            }
            // after the for-loop remove the first element from the stack     
            theStack.pop();
            // check if the graph is connected or not.
            if (theStack.isEmpty()) {
                // getAdjUnvisitedVertex() will return the index of unvisited vertex or -1
                int IndexForUnvisited = getAdjUnvisitedVertex();
                if (IndexForUnvisited != -1) {
                    // if there is unvisited vertex puch it to the stack and make it visited and print it 
                    theStack.push(IndexForUnvisited);
                    vertexList[IndexForUnvisited].setWasVisited(true);
                    stringB.append("," + IndexForUnvisited);
                }
            }
        }
        return stringB;
    } // end dfs
// -------------------------------------------------------------

    public StringBuilder bfs() // breadth-first search
    {
        StringBuilder s = new StringBuilder();
        // the next code to make all vertex unvisited becase i used dfs before
        for (int i = 0; i < vertexList.length; i++) {
            vertexList[i].setWasVisited(false);
        }
        //vertex 0(a) as visited
        vertexList[0].setWasVisited(true);
        //Insert this vertex into the queue
        queue.add(0);
        //while queue is not empty, do the following
        while (!queue.isEmpty()) {
            //Inside this  for loop, write the statements to change the status 
            //'wasVisited" of these adjacent vertices to 'true', display these 
            //vertices and insert them into the queue
            for (int i = 0; i < adjMat[queue.peek()].length; i++) {
                if (adjMat[queue.peek()][i] > 0 && !vertexList[i].isWasVisited()) {
                    vertexList[i].setWasVisited(true);
                    queue.add(i);
                }
            }
            // print and remove from the queue
            s.append(queue.remove());
            if (!queue.isEmpty()) {
                s.append(",");
            }

            // check if the graph is connected or not.
            if (queue.isEmpty()) {
                // getAdjUnvisitedVertex() will return the index of unvisited vertex or -1
                int IndexForUnvisited = getAdjUnvisitedVertex();
                if (IndexForUnvisited != -1) {
                    // if there is unvisited vertex puch it to the stack and make it visited and print it 
                    vertexList[IndexForUnvisited].setWasVisited(true);
                    s.append(",");
                    queue.add(IndexForUnvisited);
                }
            }
        }
        return s;
    } // end bfs()

// -------------------------------------------------------------
    public int getAdjUnvisitedVertex() {
        for (int i = 0; i < vertexList.length; i++) {
            // to check is it Connect graph or not
            if (!vertexList[i].isWasVisited()) {
                setConnect_graph(false);
                return i;
            }
        }
        return -1;
    } // end getAdjUnvisitedVertex()

// ------------------------------------------------------------
    public void displayGraph(PrintWriter output) {
        displayGraph(adjMat, output);
    }

    private void displayGraph(int[][] adjMat, PrintWriter output) {
// display the adjacency matrix of the given graph like 
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < vertexList.length; i++) {
            output.print("     " + (i));
            output.print("     ");
            for (int j = 0; j < vertexList.length; j++) {
                output.printf("%3d", adjMat[i][j]);
                output.print("     ");
            }
            output.print("\r\n");
        }
        displayVertex(output);

    }
// ------------------------------------------------------------    
    
    public void dij(){
        long start = System.currentTimeMillis();
        for (int i = 0; i < vertexList.length; i++) {
            Dijkstras.dijkstra(adjMat, i);
            System.out.println("\n");
        }
        long end = System.currentTimeMillis();
        double total = (double)(end - start);
        System.out.println("total is "+ total);
        
        
    }
    
    
    
}

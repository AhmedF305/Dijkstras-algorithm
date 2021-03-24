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

public class Dijkstras {

    private static final int noParent = -1;
    
    public static void dijkstra(int[][] adjMat, int startV) {
        int nVertices = adjMat[0].length;
        
        // shortestDist[i] will hold the shortest distance from src to i 
        int[] shortestDist = new int[nVertices];

        // added[i] will true if vertex i is included in shortest path tree or shortest distance from src to i is finalized 
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as infinite and added[] as false 
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
            shortestDist[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        // Distance of source vertex from itself is always 0 
        shortestDist[startV] = 0;

        // Parent array to store shortest path tree 
        int[] parentArr = new int[nVertices];

        // The starting vertex does not have a parent 
        parentArr[startV] = noParent;
        
        // Find shortest path for all vertices 
        for (int i = 1; i < nVertices; i++) {
            // Pick the minimum distance vertex from the set of vertices not yet processed
            // nearestV is  always equal to startNode in first iteration. 
            int nearestV = -1;
            int shortestDist2 = Integer.MAX_VALUE;
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                if (!added[vertexIndex] && shortestDist[vertexIndex] < shortestDist2) {
                    nearestV = vertexIndex;
                    shortestDist2 = shortestDist[vertexIndex];
                }
            }
            // Mark the picked vertex as processed 
            added[nearestV] = true;

            // Update dist value of the adjacent vertices of the picked vertex
            for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                int edgeDist = adjMat[nearestV][vertexIndex];

                if (edgeDist > 0 && ((shortestDist2 + edgeDist) < shortestDist[vertexIndex])) {
                    parentArr[vertexIndex] = nearestV;
                    shortestDist[vertexIndex] = shortestDist2 + edgeDist;
                }
            }
        }
        printSolution(startV, shortestDist, parentArr);
    }

    
    // array and shortest paths 
    private static void printSolution(int startV, int[] distances, int[] parent) {
        int nVertices = distances.length;
        System.out.print("Dijkstra using priority queue:\n" + "Shortest paths from vertex "+startV+" are:");
        for (int vertexIndex = 0; vertexIndex < nVertices; vertexIndex++) {
                System.out.print("\nA path from " + startV + " to ");
                System.out.print(vertexIndex + ": ");
                printPath(vertexIndex, parent);
                System.out.print("(Length:"+ (double)distances[vertexIndex] + ")\t\t");
        }
    }

    // Function to print shortest path Function to print shortest path 
    private static void printPath(int currentV, int[] parent) {
        // the base case Source node has been processed 
        if (currentV == noParent) {
            return;
        }
        printPath(parent[currentV], parent);
        System.out.print(currentV + " ");
    }
}

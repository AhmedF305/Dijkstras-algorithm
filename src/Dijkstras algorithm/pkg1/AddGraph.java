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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AddGraph {

    public static void main(String[] args) throws FileNotFoundException {
        File IFile = new File("input.txt");//we made object 
        if (!IFile.exists()) {
            System.out.println("The file dosen't exists");
        }
        //ReadForIF = Read For input file
        Scanner input = new Scanner(IFile);
        String withWeigted = input.next();
        // print the output in file output.txt
        File OFile = new File("output.txt");
        PrintWriter Output = new PrintWriter(OFile);
        //Read number of vertex from file
        int num_of_vertex = input.nextInt();
        //Read number of edges from file 
        int number_of_edges = input.nextInt();
        // Create new graph object 
        Graph g = new Graph(num_of_vertex);
        // start the lable name from 'a'
        char lab = 'a';
        for (int i = 0; i < num_of_vertex; i++) {
            g.addVertex(lab, i);
            lab = ++lab;
        }
        String x[][] = new String[num_of_vertex][number_of_edges];
        for (int i = 0; i < number_of_edges; i++) {
            int source = input.nextInt();
            int target = input.nextInt();

            // check if the graph is weighted or not
            int copWeigted = 0;
            if (withWeigted.equals("WEIGHTED")) {
                // if it is weighted read the weight from the file 
                int Weigted = input.nextInt();
                g.addEdge(source, target, Weigted);
                copWeigted = Weigted;
            } else {
                // if not, Weight = 1
                g.addEdge(source, target, 1);
            }
            
            
            //-----------------------------------------------------------------------
            for (int k = 0; k < number_of_edges; k++) {
                if (x[source][k] == null) {
                    x[source][k] = source + "-" + target + " " + copWeigted + "  ";
                    break;
                }
                //-------------------------------------------------------------------
            }

        }

        Output.print("\r\nAdjacency Matrix: \r\n");
        Output.print("      ");
        // Display the matrex hedar
        for (int i = 0; i < num_of_vertex; i++) {
            Output.print("       " + (i));
        }
        Output.print("\r\n");
        // Display the adjacecy matrex 
        g.displayGraph(Output);

        Output.print("\r\nDFS traversal: ");
        Output.print(g.dfs());  // depth-first search

        Output.print("\r\n\r\nBFS traversal: ");
        Output.print(g.bfs()); // breadth-first search
        Output.print("\r\n\r\n");
        Output.print(g.isConnect_graph());//print if the graph is connacted or not

        
        //-----------------------------------------------------------------------------------------------------------
        System.out.println("# of vertices is: " + num_of_vertex + ", # of edges is: " + number_of_edges);
        for (int i = 0; i < num_of_vertex; i++) {
            System.out.print(i+":  ");
            for (int j = 0; j < number_of_edges; j++) {
                if (x[i][j] != null) {
                    switch (x[i][j].charAt(0)) {
                        case '0':
                            System.out.print(x[i][j]);
                            break;
                        case '1':
                            System.out.print(x[i][j]);
                            break;
                        case '2':
                            System.out.print(x[i][j]);
                            break;
                        case '3':
                            System.out.print(x[i][j]);
                            break;
                        default:
                            System.out.print(x[i][j]);
                            break;
                    }
                    
                }
            }
            System.out.println();
        }
        Scanner in = new Scanner(System.in);
        //System.out.print("Enter Source vertex: ");
        //int num = in.nextInt();
        System.out.println();
       // g.dij();
        System.out.println();

// close the output file         
        Output.close();
    }

}

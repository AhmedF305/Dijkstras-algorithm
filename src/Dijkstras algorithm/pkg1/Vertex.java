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

public class Vertex {

    public char label; // label (e.g. ‘A’) or "Jeddah" if defined as String
    public boolean wasVisited;
// -----------------------------------------------------------

    public Vertex(char lab) // constructor
    {
        label = lab;
        wasVisited = false;
    }
// -----------------------------------------------------------

    public boolean isWasVisited() {
        return wasVisited;
    }
// -----------------------------------------------------------

    public void setWasVisited(boolean wasVisited) {
        this.wasVisited = wasVisited;
    }
// -----------------------------------------------------------
}

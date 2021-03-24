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

class StackX //Class for definining Stack Operations
{

    private final int SIZE = 20;
    private int[] st;
    private int top;
// -----------------------------------------------------------

    public StackX() // constructor
    {
//Initialize size of array ‘st’ for stack elements and the top variable here
        st = new int[SIZE];
        top = -1;
    }
// -----------------------------------------------------------

    public void push(int j) // put item on stack
    {
//Write command(s) for pushing item here
        if (top < SIZE) {
            st[++top] = j;
        } else {
            System.out.println("The stack is full");
        }

    }
// -----------------------------------------------------------

    public int pop() // take item off stack
    {
//Write command(s) for poping item here
        if (!isEmpty()) {
            int temp = st[top--];
            return temp;
        } else {
            System.out.println("The stack is empty");
        }
        return -1;
    }
// ------------------------------------------------------------

    public int peek() // peek at top of stack
    {
        //Write command(s) for returning peek/top item here
        return st[top];
    }
// ------------------------------------------------------------

    public Boolean isEmpty() // true if nothing on stack-
    {
        //Write command(s) for returing true/false to see the status of stack
        if (top == -1) {
            return true;
        }
        return false;
    }
// ------------------------------------------------------------
} // end class StackX


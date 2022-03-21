/* Java program to merge two
   sorted linked lists */
import java.util.*;

/* Link list node */
class Node1
{
    int data;
    Node1 next;
    Node1(int d) {data = d;
        next = null;}
}

class MergeLists
{
    Node1 head;

    /* Method to insert a node at
       the end of the linked list */
    public void addToTheLast(Node1 node)
    {
        if (head == null)
        {
            head = node;
        }
        else
        {
            Node1 temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    /* Method to print linked list */
    void printList()
    {
        Node1 temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    // Driver Code
    public static void main(String args[])
    {
    /* Let us create two sorted linked
       lists to test the methods 
       Created lists:
           llist1: 5->10->15,
           llist2: 2->3->20
    */
        MergeLists llist1 = new MergeLists();
        MergeLists llist2 = new MergeLists();

        // Node head1 = new Node(5);
        llist1.addToTheLast(new Node1(1));
        llist1.addToTheLast(new Node1(4));
        llist1.addToTheLast(new Node1(5));
        llist1.addToTheLast(new Node1(8));

        // Node head2 = new Node(2);
        llist2.addToTheLast(new Node1(2));
        llist2.addToTheLast(new Node1(3));
        llist2.addToTheLast(new Node1(6));
        llist2.addToTheLast(new Node1(7));

        llist1.printList();
        llist2.printList();


        llist1.head = new Gfg().sortedMerge(llist1.head,
                llist2.head);
        llist1.printList();

    }
}

class Gfg
{
    /* Takes two lists sorted in
    increasing order, and splices
    their nodes together to make
    one big sorted list which is
    returned. */
    Node1 sortedMerge(Node1 headA, Node1 headB)
    {
      
    /* a dummy first node to 
       hang the result on */
        Node1 dummyNode = new Node1(0);
      
    /* tail points to the 
    last result node */
        Node1 tail = dummyNode;
        while(true)
        {
          
        /* if either list runs out, 
        use the other list */
            if(headA == null)
            {
                tail.next = headB;
                break;
            }
            if(headB == null)
            {
                tail.next = headA;
                break;
            }
          
        /* Compare the data of the two
        lists whichever lists' data is 
        smaller, append it into tail and
        advance the head to the next Node
        */
            if(headA.data <= headB.data)
            {
                tail.next = headA;
                headA = headA.next;
            }
            else
            {
                tail.next = headB;
                headB = headB.next;
            }

            /* Advance the tail */
            tail = tail.next;
        }
        return dummyNode.next;
    }
}

// This code is contributed
// by Shubhaw Kumar
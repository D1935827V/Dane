// Java program to reverse linked list
// using stack
import java.util.*;
class Linked_reverse
{

    /* Link list node */
    static class Node2
    {
        int data;
        Node2 next;
    }
    static Node2 head = null;

    /* Given a reference (pointer to pointer) to
    the head of a list and an int, push a new
    node on the front of the list. */
    static void push( int new_data)
    {
        Node2 new_node = new Node2();

        new_node.data = new_data;
        new_node.next = (head);
        (head) = new_node;
    }


    // Function to reverse linked list
    static Node2 reverseList(Node2 head)
    {
        // Stack to store elements of list
        Stack<Node2 > stk = new Stack<Node2> ();

        // Push the elements of list to stack
        Node2 ptr = head;
        while (ptr.next != null)
        {
            stk.push(ptr);
            ptr = ptr.next;
        }

        // Pop from stack and replace
        // current nodes value'
        head = ptr;
        while (!stk.isEmpty())
        {
            ptr.next = stk.peek();
            ptr = ptr.next;
            stk.pop();
        }
        ptr.next = null;

        return head;
    }

    // Function to print the Linked list
    static void printList(Node2 head)
    {
        while (head != null)
        {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    // Driver Code
    public static void main()
    {
        /* Start with the empty list */
        //Node head = null;
 
    /* Use push() to construct below list
    1->2->3->4->5 */
        push( 5);
        push( 4);
        push( 3);
        push( 2);
        push( 1);

        printList(head);

        head = reverseList(head);

        System.out.println();
        printList(head);
        System.out.println();

    }
}
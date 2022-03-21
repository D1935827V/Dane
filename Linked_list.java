import java.util.Iterator;

// Custom Linked List class using Generics
class List<T> implements Iterable<T> {
    Node<T> head, tail;

    // add new Element at tail of the linked list in O(1)
    public void add(T data)
    {
        Node<T> node = new Node<>(data, null);
        if (head == null)
            tail = head = node;
        else {
            tail.setNext(node);
            tail = node;
        }
        System.out.println("Enqueued data: " + data);
        Iterator<T> MyIterator = iterator();
        int count = 0;
        while (MyIterator.hasNext()){
            count +=1;
            MyIterator.next();
        }
        Iterator<T> MyIterator2 = iterator();
        System.out.print("Words count: " + count + ", data: ");
        while (MyIterator2.hasNext()){
            System.out.print(MyIterator2.next() + " ");
        }
        System.out.println();

    }
    public void deletefirst()
    {
        System.out.println("Dequeued data: " + head.getData());
        if (head == null)
            System.out.println();
        else {
            head = head.getNext();
        }
        Iterator<T> MyIterator = iterator();
        int count = 0;
        while (MyIterator.hasNext()){
            count +=1;
            MyIterator.next();
        }
        Iterator<T> MyIterator2 = iterator();
        System.out.print("Words count: " + count + ", data: ");
        while (MyIterator2.hasNext()){
            System.out.print(MyIterator2.next() + " ");
        }
        System.out.println();

    }

    // return Head
    public Node<T> getHead()
    {
        return head;
    }

    // return Tail
    public Node<T> getTail()
    {
        return tail;
    }

    // return Iterator instance
    public Iterator<T> iterator()
    {
        return new ListIterator<T>(this);
    }
}

class ListIterator<T> implements Iterator<T> {
    Node<T> current;

    // initialize pointer to head of the list for iteration
    public ListIterator(List<T> list)
    {
        current = list.getHead();
    }

    // returns false if next element does not exist
    public boolean hasNext()
    {
        return current != null;
    }

    // return current data and update pointer
    public T next()
    {
        T data = current.getData();
        current = current.getNext();
        return data;
    }

    // implement if needed
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}

// Constituent Node of Linked List
class Node<T> {
    T data;
    Node<T> next;
    public Node(T data, Node<T> next)
    {
        this.data = data;
        this.next = next;
    }

    // Setter getter methods for Data and Next Pointer
    public void setData(T data)
    {
        this.data = data;
    }

    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    public T getData()
    {
        return data;
    }

    public Node<T> getNext()
    {
        return next;
    }
}

// Driver class
class Linked_list {
    public static void main() {
        // Create Linked List
        List<String> myList = new List<>();

        // Add Elements
        myList.add("abc");
        myList.add("mno");
        myList.add("pqr");
        myList.add("xyz");
        myList.deletefirst();
        myList.deletefirst();
        myList.deletefirst();
        myList.deletefirst();
    }
}
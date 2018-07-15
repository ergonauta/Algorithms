package Chapter1.Section3.DoublyLinkedList;

import edu.princeton.cs.introcs.StdOut;

import java.util.Iterator;

public class DoublyLinkedList<Item> implements Iterable<Item> {

    private Node    first;  //  Link to least recently added node
    private Node    last;   //  Link to most recently added node
    private int     N = 0;  //  Number of items in the queue

    private class Node
    {
        Item item;
        Node next;
        Node previous;
    }

    private boolean  isEmpty()   {   return first == null;   }   //  Or: N == 0
    private int      size()      {   return N;               }

    private void enqueue(Item item)
    {   //  Add item to the end of the list
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.previous = null;
        if (isEmpty())
            first = last;
        else {
            oldLast.next = last;
            last.previous = oldLast;
        }
        N++;
    }

    private Item dequeue()
    {   //  Remove item from the beginning of the list
        Item item = first.item;
        first = first.next;
        first.previous = null;
        if (isEmpty())  last = null;
        N--;
        return item;
    }

    private void removeLastNode() {
        last = last.previous;
        last.next = null;
    }

    public Iterator<Item> iterator()
    {   return new ListIterator();  }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean  hasNext()   {   return current != null;     }
        public void     remove()    {                               }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private static void fillList(DoublyLinkedList list) {
        for (int i = 0; i < 10; i++)
            list.enqueue(i);
    }

    private static void printList(DoublyLinkedList list) {
        for (Object item:list)
            StdOut.print(item);
        StdOut.println();
    }

    public static void main(String args[]) {

        DoublyLinkedList<Integer> testLinkedList = new DoublyLinkedList<>();

        // Exercise 1.3.19
        fillList(testLinkedList);
        printList(testLinkedList);

        testLinkedList.removeLastNode();
        printList(testLinkedList);

        testLinkedList.enqueue(9);
        printList(testLinkedList);



    }

}
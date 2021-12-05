/*
 *  File: Steque.java
 *  Author: 
 *  Date: 18th Nov, 2021
 *  ---------------------------------------
 *  Steque is stack-ended queue data structure which supports
 *  stack operations: pop and push, along with queue enqueue 
 *  operation.
 *  
 *  Salient features:
 *  1. Operations like push, pop, enqueue are supported.
 *  2. NullPointerException is thrown when null element is inserted.
 *  3. UnsupportedOperationException is thrown when using remove() method.
 *  4. The data structure is iterable and is implemented for generic type.
 *  
 */

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * 
 * Steque is a stack-ended data structure which 
 * supports stack operations as well as queue's 
 * enqueue operation.
 * 
 * @author 
 * @version 1.0
 *
 */
public class Steque<Item> implements Iterable<Item> {
    private Node First,Last;
    private int number;
    private class Node {
        Item item;
        Node next;
    }


    /**
     * constructs a steque object.
     */
    public Steque() {
        number=0;
        First=Last=null;
    }
    
    
    /**
     * inserts an item in the steque in queue fashion.
     * @param item Item to be inserted.
     */
    //Time Complexity:O(1), Space Complexity:O(N)
    public void enqueue(Item item) {
        if(item==null)
            throw new IllegalArgumentException();
        Node oldlast=Last;
        Last=new Node();
        Last.item=item;
        Last.next=null;
        if(First==null)
            First=Last;
        else
            oldlast.next=Last;
        number++;
    }

    /**
     * inserts an item in the steque in stack fashion.
     * @param item Item to be inserted.
     */ 
    //Time Complexity:O(1), Space Complexity:O(N)
    public void push(Item item) {
        if(item==null)
            throw new IllegalArgumentException();
        Node oldfirst=First;
        First=new Node();
        First.item=item;
        First.next=oldfirst;
        if(Last==null)
            Last=First;
        number++;
    }

    //Time Complexity:O(1), Space Complexity:O(N)
    public Item pop() {
        if(isEmpty())
            throw new NoSuchElementException();
        Item item=First.item;
        First=First.next;
        number--;
        return item;
    }

    /**
     * checks to see if steque is empty.
     * @return true if steque is empty, false otherwise.
     */
      //Time Complexity:O(1), Space Complexity:0
      public boolean isEmpty() {
        return First==null||Last==null;
    }
    
    /**
     * return the number of elements currently in the steque.
     * @return size as integer.
     */
    //Time Complexity: O(1), Space Complexity:0
    public int size() {
        return number;
    }
    
    /**
     * returns an iterator over the elements 
     * stored in steque.
     * 
     */
    //Time Complexity: O(1) , Space Complexity:0
    public Iterator<Item> iterator() {
        return new StequeIterator();
    }
    //Time Complexity:O(1), Space Complexity:O(1)
    public Iterator<Item> iterator() {
        return new StequeIterator();
    }
    public class StequeIterator implements Iterator<Item>{
        Node current=first;
        public boolean hasNext(){
            return current!=null;
        }
        public Item next(){
            if(!hasNext()) throw new NoSuchElementException();
            else{
                Item item=current.item;
                current=current.next;
                return item;
            }
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
public static void main(String[] args)
{
    Steque<Integer> s = new Steque<Integer>();
    s.enqueue(14);
    s.enqueue(17);
    s.enqueue(20);
    s.push(5);
    s.push(10);
    s.push(15);
    Iterator <Integer> t = s.iterator();
    System.out.println("Steque elems are: ");
    while(t.hasNext())
    {
        System.out.println(t.next());
    }
    System.out.println("Popped elems are: ");
    while(!s.isEmpty())
    {
        System.out.println(s.pop());
    }
}
}
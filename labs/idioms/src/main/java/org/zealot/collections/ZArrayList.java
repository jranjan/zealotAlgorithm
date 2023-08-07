package org.zealot.collections;

import java.util.*;

// ArrayList is of collection type and is implemented as flexible array
// Did you notice the iterator type differences: Iterator and ListIterator? The later provides backward traversal.
public class ZArrayList {
    public int count;
    public ArrayList<Integer> storage = new ArrayList<>();
    public ZArrayList(int num) {
        count = num;
        initialise();
    }

    private void initialise() {
        for(int i = 0; i < count; i++) {
            storage.add(i*i);
        }
    }

    public List<Integer> getStorage(){
        return storage;
    }

    public void printUsingIterator() {
        ListIterator iterator = storage.listIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public void printUsingListIteratorForward() {
        Iterator iterator = storage.listIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public void printUsingListIteratorReverse() {
        ListIterator iterator = storage.listIterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        while (iterator.hasPrevious())
            System.out.print(iterator.previous() + " ");

        System.out.println();
    }


    public static void main(String[] args){
        ZArrayList zal = new ZArrayList(10);

        System.out.println("Printing the array:");
        System.out.println(zal.getStorage().toString());

        System.out.println("Collection initilization:");
        ArrayList al1 = new ArrayList(zal.getStorage());
        System.out.println(al1);

        System.out.println("Adding all elements of one list into another:");
        ArrayList al2 = new ArrayList();
        al1.addAll(zal.getStorage());
        al2.addAll(al1);
        System.out.println(al2);

        System.out.println("Using LIST iterator to print forward:");
        zal.printUsingListIteratorForward();

        System.out.println("Using LIST iterator to print backward:");
        zal.printUsingListIteratorReverse();

        System.out.println("Using PLAIN iterator to print forward:");
        zal.printUsingIterator();
    }
}

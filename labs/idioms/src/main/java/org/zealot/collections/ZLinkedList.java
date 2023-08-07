package org.zealot.collections;

import java.util.LinkedList;

// LinkedList is a collection type but implemented using LinkedList. It has some extra methods to do things like
//      - Peek inside the list
//      - Traversal is little different
//      - perform like a stack
// See methods for more detail.
public class ZLinkedList {
    public int count;
    public LinkedList<Integer> storage = new LinkedList<>();
    public ZLinkedList(int num, boolean duplicates) {
        count = num;
        initialise(duplicates);
    }

    private void initialise(boolean duplicates) {
        for(int i = 0; i < count; i++) {
            storage.add(i*i);
        }

        if (duplicates) {
            for(int i = 0; i < count; i = i+2) {
                storage.add(i*i);
            }
        }
    }

    public LinkedList<Integer> getStorage(){
        return storage;
    }

    public void printEndElements() {
        System.out.println(String.format("First=%d, End=%d", storage.getFirst(), storage.getLast()));
    }

    public static void main(String[] args) {
        ZLinkedList zll1 = new ZLinkedList(10, false);
        zll1.printEndElements();

        LinkedList zll2Storage = new ZLinkedList(10, true).getStorage();
        System.out.println(String.format("FirstPosition of 4 = %d, Last Position of 4 = %d",
                zll2Storage.indexOf(4), zll2Storage.lastIndexOf(4)));
        System.out.println(String.format("FirstPosition of 99 = %d, Last Position of 99 = %d",
                zll2Storage.indexOf(99), zll2Storage.lastIndexOf(99)));
        zll2Storage.set(zll2Storage.indexOf(4), 99);
        System.out.println(String.format("FirstPosition of 4 = %d, Last Position of 4 = %d",
                zll2Storage.indexOf(4), zll2Storage.lastIndexOf(4)));
        System.out.println(zll2Storage);
    }
}

package org.zealot.collections;

import java.util.Set;
import java.util.TreeSet;

// Set is also a collection but no duplicates. Treeset does not maintain order.
public class ZTreeSet {
    public static void initialiseSquare(Set<String> s) {
        for(int i = 0; i < 10; i++) {
            s.add(Integer.toString(i*i));
        }
    }

    public static void initialiseZigzawSquare(Set<String> s) {
        for(int i = 0; i < 10; i++) {
            s.add(Integer.toString((i / 2) * (i /2)));
        }
    }

    public static void main(String[] args) {
        Set<String> ts1 = new TreeSet<>();
        initialiseSquare(ts1);
        System.out.println("Treeset after creation, pay attention to text:");
        System.out.println(ts1);

        // Duplicates not allowed
        System.out.println("Adding duplicates:");
        for(int i = 0; i < 10; i++) {
            ts1.add(Integer.toString(i*i));
        }
        System.out.println(ts1);

        Set<String> ts2 = new TreeSet<>();
        initialiseZigzawSquare(ts2);

        // Union
        System.out.println(String.format("Union of hs1=%s, ts2=%s is...", ts1, ts2));
        ts1.addAll(ts2);
        System.out.println(ts1);

        // Intersection
        ts1.clear();
        initialiseSquare(ts1);
        System.out.println(String.format("Intersection of hs1=%s, ts2=%s is...", ts1, ts2));
        ts1.retainAll(ts2);
        System.out.println(ts1);

        // Disjoint
        ts1.clear();
        initialiseSquare(ts1);
        System.out.println(String.format("Asymmetric difference of hs1=%s, ts2=%s is...", ts1, ts2));
        ts1.removeAll(ts2);
        System.out.println(ts1);
    }
}

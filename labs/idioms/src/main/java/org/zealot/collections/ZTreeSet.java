package org.zealot.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

// Set is also a collection but no duplicates. Hashset does not maintain order.
public class ZLinkedHashSet {
    public static void initialiseSquare(Set<String> hs) {
        for(int i = 0; i < 10; i++) {
            hs.add(Integer.toString(i*i));
        }
    }

    public static void initialiseZigzawSquare(Set<String> hs) {
        for(int i = 0; i < 10; i++) {
            hs.add(Integer.toString((i / 2) * (i /2)));
        }
    }

    public static void main(String[] args) {
        Set<String> hs1 = new LinkedHashSet<>();
        initialiseSquare(hs1);
        System.out.println("Hashset after creation:");
        System.out.println(hs1);

        // Duplicates not allowed
        System.out.println("Adding duplicates:");
        for(int i = 0; i < 10; i++) {
            hs1.add(Integer.toString(i*i));
        }
        System.out.println(hs1);

        Set<String> hs2 = new LinkedHashSet<>();
        initialiseZigzawSquare(hs2);

        // Union
        System.out.println(String.format("Union of hs1=%s, hs2=%s is...", hs1, hs2));
        hs1.addAll(hs2);
        System.out.println(hs1);

        // Intersection
        hs1.clear();
        initialiseSquare(hs1);
        System.out.println(String.format("Intersection of hs1=%s, hs2=%s is...", hs1, hs2));
        hs1.retainAll(hs2);
        System.out.println(hs1);

        // Disjoint
        hs1.clear();
        initialiseSquare(hs1);
        System.out.println(String.format("Asymmetric difference of hs1=%s, hs2=%s is...", hs1, hs2));
        hs1.removeAll(hs2);
        System.out.println(hs1);
    }
}

package org.zealot.collections;

import java.util.LinkedHashSet;
import java.util.Set;

// Set is also a collection but no duplicates. LinkedHashset does maintain insertion order
// unlike HashSet.
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
        Set<String> lhs1 = new LinkedHashSet<>();
        initialiseSquare(lhs1);
        System.out.println("LinkedHashset after creation:");
        System.out.println(lhs1);

        // Duplicates not allowed
        System.out.println("Adding duplicates:");
        for(int i = 0; i < 10; i++) {
            lhs1.add(Integer.toString(i*i));
        }
        System.out.println(lhs1);

        Set<String> lhs2 = new LinkedHashSet<>();
        initialiseZigzawSquare(lhs2);

        // Union
        System.out.println(String.format("Union of hs1=%s, hs2=%s is...", lhs1, lhs2));
        lhs1.addAll(lhs2);
        System.out.println(lhs1);

        // Intersection
        lhs1.clear();
        initialiseSquare(lhs1);
        System.out.println(String.format("Intersection of hs1=%s, hs2=%s is...", lhs1, lhs2));
        lhs1.retainAll(lhs2);
        System.out.println(lhs1);

        // Disjoint
        lhs1.clear();
        initialiseSquare(lhs1);
        System.out.println(String.format("Asymmetric difference of hs1=%s, hs2=%s is...", lhs1, lhs2));
        lhs1.removeAll(lhs2);
        System.out.println(lhs1);
    }
}

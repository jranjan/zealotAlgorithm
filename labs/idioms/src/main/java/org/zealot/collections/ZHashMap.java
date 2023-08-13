package org.zealot.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ZHashMap {
    public static void initialiseSquare(Map<Integer, String> m) {
        for(int i = 0; i < 10; i++) {
            m.put(i, "0x" + Integer.toHexString(i*i));
        }
    }

    public static void initialiseZigzawSquare(Map<Integer, String> m) {
        for(int i = 0; i < 10; i++) {
            m.put(i, "0x" + Integer.toHexString((i / 2) * (i /2)));
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> hmap1 = new HashMap<>();
        initialiseSquare(hmap1);
        System.out.println(String.format("Map hmap1=%s", hmap1));
        System.out.println("Keys are:");
        for(Integer k : hmap1.keySet()) {
            System.out.print(String.format("%d ", k));
        }
        System.out.println();

        Map<Integer, String> hmap2 = new HashMap<>();
        initialiseZigzawSquare(hmap2);
        System.out.println(String.format("Map hmap2=%s", hmap2));
    }
}

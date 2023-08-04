package org.zealot.algorithm.mergeintervals;

import org.junit.jupiter.api.Test;
import org.zealot.ds.interval.Interval;

import java.util.LinkedList;
import java.util.List;

public class OverlappingIntervalsTest {
    @Test
    void findOverlap(){
        System.out.println("1: ------------------------------------");
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(5,9));
        System.out.println(String.format("Overlap={%s}", OverlappingIntervals.findOverlap(intervals)).toString());

        System.out.println("2: ------------------------------------");
        intervals.clear();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(2,5));
        intervals.add(new Interval(7,9));
        System.out.println(String.format("Overlap={%s}", OverlappingIntervals.findOverlap(intervals)).toString());

        System.out.println("3: ------------------------------------");
        intervals.clear();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(3,5));
        System.out.println(String.format("Overlap={%s}", OverlappingIntervals.findOverlap(intervals)).toString());

        System.out.println("4: ------------------------------------");
        intervals.clear();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(4,7));
        intervals.add(new Interval(8,10));
        System.out.println(String.format("Overlap={%s}", OverlappingIntervals.findOverlap(intervals)).toString());
    }
}

package org.zealot.algorithm.pattern.mergeintervals;

import org.junit.jupiter.api.Test;
import org.zealot.algorithm.pattern.mergeintervals.MergeInterval;
import org.zealot.algorithm.ds.interval.Interval;

import java.util.LinkedList;
import java.util.List;

public class MergeIntervalTest {

    @Test
    void overlappingIntervals(){
        System.out.println("T1: ------------------------------------");
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(5,9));
        List<Interval> mergedIntervals = MergeInterval.merge(intervals);
        System.out.println("Size = " + mergedIntervals.size());
        for (Interval interval : mergedIntervals) {
            System.out.println(interval.start + ":" + interval.end);
        }

        System.out.println("T2: ------------------------------------");
        intervals.clear();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(2,5));
        intervals.add(new Interval(7,9));
        mergedIntervals = MergeInterval.merge(intervals);
        System.out.println("Size = " + mergedIntervals.size());
        for (Interval interval : mergedIntervals) {
            System.out.println(interval.start + ":" + interval.end);
        }

        System.out.println("T3: ------------------------------------");
        intervals.clear();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(3,5));
        mergedIntervals = MergeInterval.merge(intervals);
        System.out.println("Size = " + mergedIntervals.size());
        for (Interval interval : mergedIntervals) {
            System.out.println(interval.start + ":" + interval.end);
        }

        System.out.println("T4: ------------------------------------");
        intervals.clear();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(4,7));
        intervals.add(new Interval(8,10));
        mergedIntervals = MergeInterval.merge(intervals);
        System.out.println("Size = " + mergedIntervals.size());
        for (Interval interval : mergedIntervals) {
            System.out.println(interval.start + ":" + interval.end);
        }
    }

    @Test
    void overlappingIntervalsOptimal(){
        System.out.println("O1: ------------------------------------");
        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(5,9));
        List<Interval> mergedIntervals = MergeInterval.mergeLeveragingSort(intervals);
        System.out.println("Size = " + mergedIntervals.size());
        for (Interval interval : mergedIntervals) {
            System.out.println(interval.start + ":" + interval.end);
        }

        System.out.println("O2: ------------------------------------");
        intervals.clear();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(2,5));
        intervals.add(new Interval(7,9));
        mergedIntervals = MergeInterval.mergeLeveragingSort(intervals);
        System.out.println("Size = " + mergedIntervals.size());
        for (Interval interval : mergedIntervals) {
            System.out.println(interval.start + ":" + interval.end);
        }

        System.out.println("O3: ------------------------------------");
        intervals.clear();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(3,5));
        mergedIntervals = MergeInterval.mergeLeveragingSort(intervals);
        System.out.println("Size = " + mergedIntervals.size());
        for (Interval interval : mergedIntervals) {
            System.out.println(interval.start + ":" + interval.end);
        }

        System.out.println("O4: ------------------------------------");
        intervals.clear();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(4,7));
        intervals.add(new Interval(8,10));
        mergedIntervals = MergeInterval.mergeLeveragingSort(intervals);
        System.out.println("Size = " + mergedIntervals.size());
        for (Interval interval : mergedIntervals) {
            System.out.println(interval.start + ":" + interval.end);
        }
    }
}
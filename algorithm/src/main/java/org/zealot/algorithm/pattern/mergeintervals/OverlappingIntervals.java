package org.zealot.algorithm.pattern.mergeintervals;

import org.zealot.algorithm.ds.interval.Interval;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class OverlappingIntervals {
    public static boolean findOverlap(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return false;
        }

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalIterator = intervals.iterator();
        Interval prev = intervalIterator.next();
        while(intervalIterator.hasNext()) {
            Interval curr = intervalIterator.next();
            if (curr.start < prev.end) {
                // its overlapping
                return true;
            } else {
                prev = curr;
            }
        }

        return false;
    }
}

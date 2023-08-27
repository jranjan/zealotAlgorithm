package org.zealot.algorithm.pattern.mergeintervals;

import org.zealot.algorithm.ds.interval.Interval;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {
    public static List<Interval> merge(List<Interval> intervals){
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        mergedIntervals.add(intervals.get(0));
        for(int i=1; i<intervals.size(); i++) {
            Interval curr = intervals.get(i); // 4,7 : 8,10
            int currSize = mergedIntervals.size();
            boolean bCurrAdded = false;
            for(int j=0; j<currSize; j++) {
                Interval mergedInterval = mergedIntervals.get(j);
                Interval postMergeInterval = getNewInterval(curr, mergedInterval);

                if (postMergeInterval != null) {
                    mergedIntervals.remove(j);
                    mergedIntervals.add(postMergeInterval);
                } else {
                    if (bCurrAdded == false) {
                        mergedIntervals.add(curr);
                        bCurrAdded = true;
                    }
                }
            }
        }
        return mergedIntervals;
    }

    private static Interval getNewInterval(Interval first, Interval second) {
        // Do not overlap at all
        if (((first.start < second.start) && (first.end < second.start)) ||
                ((first.start > second.end) && (first.end > second.end))) {
            return null;
        }
        // first is completely inside second
        if ((first.start >= second.start) && (first.end <= second.end)) {
            return new Interval(second.start, second.end);
        }

        // first contains second completely
        if ((first.start <= second.start) && (first.end >= second.end)) {
            return new Interval(first.start, first.end);
        }

        // first starts early but finish somewhere in between second
        if ((first.start <= second.start) && (first.end >= second.start)) {
            return new Interval(first.start, second.end);
        }

        // first starts in between of second but finish after second
        if ((first.start >= second.start) && (first.end >= second.end)) {
            return new Interval(second.start, first.end);
        }

        return null;
    }


    public static List<Interval> mergeLeveragingSort(List<Interval> intervals){
        if (intervals.size() < 2)
            return intervals;

        // sort the intervals by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Iterator<Interval> intervalItr = intervals.iterator();
        Interval interval = intervalItr.next();
        int start = interval.start;
        int end = interval.end;
        while (intervalItr.hasNext()) {
            interval = intervalItr.next();
            if (interval.start < end) {
               // its overlapping interval, isn't it?
               end = end = Math.max(interval.end, end);
            } else {
                // Find the disjoint one
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // add the last interval
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }
}

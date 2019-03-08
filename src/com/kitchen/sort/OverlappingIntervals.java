package com.kitchen.sort;

import com.Utils.PrintUtil;

import java.util.*;

public class OverlappingIntervals {

    public static void main(String[] args) {
        List<Interval> intervalsList = new ArrayList<>();
        intervalsList.add(new Interval(0,10));
        intervalsList.add(new Interval(2,12));
        intervalsList.add(new Interval(-4,-2));
        intervalsList.add(new Interval(-5,-3));
        PrintUtil<Interval> printer = new PrintUtil<>();
        printer.print(intervalsList);
        mergeIntervals(intervalsList);
        System.out.println("\n");
        printer.print(intervalsList);
    }

    public static List<Interval> mergeIntervals(List<Interval> intervalsList) {
        if (intervalsList == null || intervalsList.isEmpty()){
            return new ArrayList<>();
        }

        Collections.sort(intervalsList, new IntervalComparator());
        Interval previous = null;
        Interval current = null;

        ListIterator<Interval> iter = intervalsList.listIterator();
        while(iter.hasNext()){
            if (previous == null){
                previous = iter.next();
            } else {
                current = iter.next();
                if (previous.end < current.start){
                    previous = current;
                } else if (previous.end >= current.start){
                    previous.end = current.end;
                    iter.remove();
                } else if (previous.start == current.start){
                    previous.end = previous.end < current.end ? current.end : previous.end;
                    iter.remove();
                }
            }
        }
        return intervalsList;
    }

    public static class IntervalComparator implements Comparator<Interval>{

        public int compare(Interval interval1, Interval interval2){
            if (interval1.start != interval2.start) return interval1.start - interval2.start;
            return interval1.end - interval2.end;
        }
    }
}

    class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "["+start+","+end+"]";
        }
    }

package com.kitchen.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LargestNumber {
    public static void main(String[] args) {
        Integer[] A = { 931, 94, 209, 448, 716, 903, 124, 372, 462, 196, 715, 802, 103, 740, 389, 872, 615, 638, 771, 829, 899, 999, 29, 163, 342, 902, 922, 312, 326, 817, 288, 75, 37, 286, 708, 589, 975, 747, 743, 699, 743, 954, 523, 989, 114, 402, 236, 855, 323, 79, 949, 176, 663, 587, 322 };

        System.out.println(largestNumber(Arrays.asList(A)));
    }

    public static String largestNumber(final List<Integer> A) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new NumberComparator());
        boolean differentFromZero = false;
        for (Integer item : A){
            if (!differentFromZero && item != 0){
                differentFromZero = true;
            }
            heap.add(item);
        }
        if (!differentFromZero){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()){
            sb.append(heap.poll());
        }
        return sb.toString();
    }

    public static class NumberComparator implements Comparator<Integer> {

        public int compare(Integer o1, Integer o2){
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            int i1=0;
            int i2=0;
            char c1;
            char c2;
            while (i1 < s1.length() || i2 < s2.length()){
                if (i1 < s1.length()){
                    c1 = s1.charAt(i1++);
                } else {
                    c1 = s1.charAt(0);
                }

                if (i2 < s2.length()){
                    c2 = s2.charAt(i2++);
                } else {
                    c2 = s2.charAt(0);
                }

                if (Integer.valueOf(c1) < Integer.valueOf(c2)){
                    return 1;
                } else if (Integer.valueOf(c1) > Integer.valueOf(c2)){
                    return -1;
                }
            }

            return 0;
        }
    }
}

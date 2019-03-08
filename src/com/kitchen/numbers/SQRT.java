package com.kitchen.numbers;

public class SQRT {
    public static void main(String[] args) {
        System.out.println(sqrt(2147483647));
    }

    public static int sqrt(int a) {
        Long low = Long.valueOf(1);
        Long high = Long.valueOf(2);
        while (high * high < a){
            high = high * 2;
        }
        Long mid = (high+low)/2;
        long product = mid * mid;

        while (high - low > 1){
            if (product == a){
                return mid.intValue();
            } else if (product > a){
                high = mid;
            } else if (product < a){
                low = mid;
            }
            mid = (high+low)/2;
            product = mid * mid;
        }
        return ((high.intValue()+low.intValue()))/2;
    }
}

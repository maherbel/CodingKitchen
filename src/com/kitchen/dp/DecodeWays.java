package com.kitchen.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a number
 * return the number of possible ways to decode it into string
 * supposing each number can be considered an asci code
 * exemple for 10 it can be 1 and 0 so AB and also 10 so J
 * so result for 10 is 2
 */

public class DecodeWays {

    public static void main(String[] args) {
        System.out.println(numDecodings("10"));
    }

    public static int numDecodings(String A) {
        if (A == null || A.length() == 0) return 0;
        else if (A.charAt(0) == 0) return 0;
        else if (A.length() == 1) return 1;

        boolean[] zeroDetected = new boolean[1];
        Map<String,Integer> memoMap = new HashMap<String,Integer>();

        int result = waysDecodingsDP(A, 0, zeroDetected);
        return zeroDetected[0] ? 0 : result;
    }
    public static int waysDecodingsDP(String input, int index, boolean[] zeroDetected){
        if (zeroDetected[0] || index == input.length()){
            return 0;
        }

        int answer = 0;
        if (isValid(input, index, String.valueOf(input.charAt(index)), zeroDetected)){
            answer += waysDecodingsDP(input, index + 1, zeroDetected) + 1;
        }
        if (index < input.length()-1 && isValid(input, index, String.valueOf(input.charAt(index)) + String.valueOf(input.charAt(index+1)), zeroDetected)){
            answer += waysDecodingsDP(input, index + 2, zeroDetected) + (input.charAt(index+1) == '0' ? 1 : 2);
        }

        return answer;
    }

    public static boolean isValid(String input, int index, String inputToCheck, boolean[] zeroDetected){
        if (inputToCheck.charAt(0) == '0') {
            if (Integer.parseInt(String.valueOf(input.charAt(index-1))) > 2) zeroDetected[0] = true;
            return false;
        }

        return Integer.valueOf(inputToCheck) <= 26;
    }
}

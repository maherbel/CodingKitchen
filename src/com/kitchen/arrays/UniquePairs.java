package com.kitchen.arrays;

import java.util.HashMap;
import java.util.Map;

public class UniquePairs {

    public static void main(String[] args) {
        int[] input = { 1, 1, 2, 3, 5 };
        System.out.println(countUniquePairwiseDiffs(input, 0));
    }

    public static int countUniquePairwiseDiffs(int[] input, int diff) {
        if (input == null || input.length == 0) return 0;
        // Map of input elements
        Map<Long,Integer> inputMap = new HashMap<Long,Integer>();

        // Input the data into the Map
        Integer cnt;
        for(int i=0; i < input.length; i++){
            cnt = inputMap.get(Long.valueOf(input[i]));
            inputMap.put(Long.valueOf(input[i]), cnt != null ? ++cnt : 1);
        }

        int uniqueCountResult = 0;

        Long key;
        Integer value;
        for(Map.Entry<Long,Integer> entry : inputMap.entrySet()){
            key = entry.getKey();
            value = entry.getValue();
            if (diff == 0){
                if (value > 1){
                    uniqueCountResult++;
                }
            } else if (inputMap.containsKey(key+diff)){
                uniqueCountResult++;
            }
        }

        return uniqueCountResult;
    }
}

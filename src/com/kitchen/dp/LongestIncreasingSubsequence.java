package com.kitchen.dp;

import com.Utils.PrintUtil;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        Integer[] nums = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        PrintUtil<Integer> printUtil = new PrintUtil<>();
        printUtil.print(nums);
        System.out.println("LIS : "+nums(nums));
    }

    public static int nums(Integer[] nums) {
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int len = 1;
        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            int p = bs(dp, 0, len-1, num);
            if(dp[p]==0){
                dp[p] = num;
                len++;
            }else{
                dp[p] = Math.min(dp[p],num);
            }
        }
        return len;
    }


    // 这种写法是 寻找比target 大且最接近target 的数 (如果target不存在)
    private static int bs(int[] arr, int s, int e, int tar){
        if(s>e) return s;
        int mid = s+(e-s)/2;
        if(arr[mid]>=tar){
            return bs(arr, s, mid-1,tar);
        }else{
            return bs(arr,mid+1,e,tar);
        }
    }
}

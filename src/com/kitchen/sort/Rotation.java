package com.kitchen.sort;

public class Rotation {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Result : "+ search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int start=0, end = nums.length -1;
        int mid = (start+end)/2;

        if (nums[start] < nums[end]){ // This is the classic case no rotation
            while (end-start > 1 && nums[mid]!=target){
                if  (nums[mid]==target)     {return mid;}
                else if (nums[mid] > target){end = mid;}
                else                        {start = mid;}
                mid = (start+end)/2;
            }
        } else
        if(nums[start] > nums[end]){ // This is where we have a rotation (we don't know yet where it is)
            while (end-start > 1 && nums[mid]!=target){
                if ((nums[mid] < nums[end] && nums[mid]<=target && target<=nums[end]) ||
                        (nums[mid] > nums[end] && (nums[mid]<=target || target<=nums[end]))){
                    start = mid;
                } else if((nums[mid] > nums[start] && nums[start]<=target && target<=nums[mid]) ||
                        (nums[mid] < nums[start] && (nums[start]<=target || target<=nums[mid]))){
                    end = mid;
                }
                mid = (start+end)/2;
            }
        }
        if (nums[mid] == target){
            return mid;
        } else if (nums[start] == target){
            return start;
        } else if (nums[end] == target){
            return end;
        }

        return -1;
    }
}

package com.kitchen.arrays;

public class ReverseWord {

    // The idea here would be to iterate using two pointers
// One from the start (index 0) and one from the end (index size of array minus 1)
// We will switch the elements at theses two indexes and the increment/decrement them
// we repeat the operation until the two pointers have crossed
// Important note : this algorithm should be applied on each word meaning each subarray that does not contain empty space

    public static char[] reverseWords(char[] input){
        if (input == null || input.length <= 1) return input;

        // The two pointers used to traverse the words to be reversed
        int left=0;
        int right=0;

        int nextWordIndex=0;
        // Temp char to be used to inplace swap
        char tempChar;

        // Traverse all array until the flag inputProcessed is true (meaning we processed the last word)
        boolean inputProcessed = false;
        while (!inputProcessed && left < input.length){
            // Find the next word by incrementing the right pointer
            while (right < input.length && input[right] != ' '){
                right++;
            }
            // Keep track of the last 'right' index to restart the word search
            nextWordIndex = right;
            right--;
            // Check if this is the last word to stop the global while
            if (right == input.length){
                inputProcessed = true;
            }
            // Until we're not at the middle of the word continue to swap
            while (left < right){
                tempChar = input[left];
                input[left] = input[right];
                input[right] = tempChar;
                left++;
                right--;
            }
            left = nextWordIndex+1;
            right = nextWordIndex+1;
        }

        // We're finished an return the same input parameter reversed
        return input;
    }

    // Some tests here
    public static void main(String[] args){
        char[] input1 = {'I', ' ', 'l','o','v','e',' ','T','a','x','i','f','y'};
        char[] reversedInput1 = reverseWords(input1);

        /*char[] input2 = ['I','l','o','v','e','T','a','x','i','f','y'];
        char[] reversedInput2 = reverseWords(input2);

        char[] input3 = [''];
        char[] reversedInput3 = reverseWords(input3);

        char[] input4 = null;
        char[] reversedInput4 = reverseWords(input4)*/;
    }
}

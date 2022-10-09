package com.paypal.platform.scm.config.impl;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        String input = "abcdcba";

        int longestSubStringWithNoRepeatChars = longestSubStringWithNoRepeatChars(input);

        System.out.println("Result = " + longestSubStringWithNoRepeatChars);
    }
    
    public  static int longestSubStringWithNoRepeatChars(String str){

        if(null==str || str.trim().length()==0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int sliding_window_length = Integer.MIN_VALUE;
        int max_so_far = Integer.MIN_VALUE;
        int left = 0;
        int right=0;
        while(right<str.length()){
            if(map.containsKey(str.charAt(right))){
                //char repeat in sliding window
                int last_seen = map.get(str.charAt(right));
                if(last_seen >= left){ //  if repeat char is between sliding window range
                    left = last_seen + 1; // move left pointer to right after  repeat char last seen index
                }
            }

            sliding_window_length = right-left+1; // current sligding window length
            max_so_far = Math.max(max_so_far,sliding_window_length); // update max length if applicable
            map.put(str.charAt(right),right); // add or update map with char with correspoding index
            right++;
        }
        return max_so_far;
    }
}

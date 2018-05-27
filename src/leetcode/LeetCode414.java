package leetcode;

import java.util.Scanner;

public class LeetCode414 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++){
            nums[i] = in.nextInt();
        }
        System.out.println(thirdMax(nums));
    }

    public static int thirdMax(int[] nums) {
        int res = 0;
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        boolean flag = false;

        for(int i=0; i<nums.length; i++){
            if(nums[i]==max1 || nums[i]==max2 || nums[i]==max3){
                continue;
            }
            if(nums[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] > max3){
                flag = true;
                max3 = nums[i];
            }
        }
        if(max3 != Long.MIN_VALUE){
            flag = true;
        }
        return (int)(true==flag?max3:max1);
    }
}

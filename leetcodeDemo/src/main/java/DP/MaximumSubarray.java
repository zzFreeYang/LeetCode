package DP;

/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //--------------- start --------------------------
        //因为是连续数组，所以最后一位是否add 可以作为DP数组
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int result = dp[0];
        for(int i = 1 ; i < len ; i++){
            //该值加上是否是最大的
            dp[i] = Math.max(dp[i-1]+nums[i] , nums[i]);
            //更新最大值
            result = Math.max(dp[i],result);
        }
        System.out.println(result);







    }
}

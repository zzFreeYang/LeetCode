package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 3;
        //------------ start ------------------------
        int[] dp = new int[n];
        int[] dp_two= new int[2];
        //dp[i]的意义: 爬第n阶有几种方案
        if( n == 1){
            System.out.println(1);
        }
        if( n == 2){
            System.out.println(2);
        }
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < n;i++ ){
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n-1]);


        //进阶:节约空间

        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        System.out.println(r);

    }


}

package GreedyAlgorithm;

/**
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 */

import java.util.Arrays;

/**
 *  思路: 为了满足尽可能多的小孩，应该先满足胃口最小的小孩，然后就可以类推。
 *        需要对两个数据排序,使用Arrays.sort();
 *        类似双指针
 */
public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        Arrays.sort(g);
        Arrays.sort(s);
        int cookie = 0 ; // 指向s
        int child = 0;   // 指向g
        while(cookie < s.length && child < g.length){
            if(s[cookie] >= g[child]){
                child++;
            }
                cookie++;
        }
        System.out.println(child);
//      return child;
    }
}

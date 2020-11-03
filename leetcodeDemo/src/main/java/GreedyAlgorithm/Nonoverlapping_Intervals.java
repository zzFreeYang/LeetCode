package GreedyAlgorithm;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
 * 可以认为区间的终点总是大于它的起点。
 * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠
 *
 * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
 *
 * 输出: 1
 *
 * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * 思路: 区间结尾越小，留给其他区间的空间就越大。因此，优先保留结尾小且不相交的区间。
 * 做法: 1. 根据结尾排序 2.每次选择结尾最小且和前一个选择的区间不重叠的区间。
 * 举例: 12,24,13 排序为  12，13，24. 首先选择12，然后24
 */

public class Nonoverlapping_Intervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,4},{1,3}};
        if(intervals.length == 0){
//            return 0;
        }
        // 按 end 升序排序
        // sort(T[] a, Comparator<? supre T> c): 根据指定比较器产生的顺序对指定对象数组进行排序。（按一维元素比较二维数组）
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];   // 1:冲小到大  0 原位置不动 -1 从大到小
            }
        });
        // 至少有一个区间不相交
        int count = 1;
        // 排序后，第一个区间就是 x
        int x_end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
//        return (intervals.length-count);
        System.out.println(intervals.length-count);
    }
}

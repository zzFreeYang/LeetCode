package GreedyAlgorithm;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 思路：1 。 统计每一个字符最后出现的位置
 *       2 。   从头遍历字符，如果找到之前字符最大出现位置下标和当前下标相等，则找到了分割点
 */
public class PartitionLabels {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
//        return partition;
    }
    }


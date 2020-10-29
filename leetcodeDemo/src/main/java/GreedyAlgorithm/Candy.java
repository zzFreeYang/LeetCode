package GreedyAlgorithm;

/**
 *135. 分发糖果
 *老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 *
 *输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 */

/**
 *  思路: 每个孩子最少1颗，先初始化为 1的数组[1,1,1] 然后根据大小，先从前到后遍历，如果更使右边=左边+1
 *  [1,0,2]:    [1,1,1] --> [1,1,2]
 *  然后从后到前遍历  （这一次遍历要注意，如果左边孩子评分高，但是糖果已经比右边多了，就不需要再给了）
 *                         特殊情况举例:   [1,3,2] 初始化为 [1,1,1],第一轮 [1,2,1] 第二轮如果只看大小，是[1,3,1] 实际上不需要
 *  [1,1,2]-->[2,1,2]
 *  这样遍历两次，就可以将 左边大于右边 和 右边大于左边 两种情况都处理完成
 *  核心是 2次遍历，多的=少的+1
 */


public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,2,87,87,87,2,1};
        int length = ratings.length;
        int count = 0;
        int[] retArray = new int[length];
        for(int i = 0 ; i < length-1 ; i++){
            if(ratings[i+1]>ratings[i]){
                retArray[i+1] = retArray[i]+1;
            }
        }
        for(int i = length-1 ; i > 0 ; i--){
            if(ratings[i-1]>ratings[i] && retArray[i-1] <= retArray[i]){
                retArray[i-1] = retArray[i]+1;
            }
        }
        for(int a :retArray){
            count += a;
        }
        System.out.println(count+length);
    }
}

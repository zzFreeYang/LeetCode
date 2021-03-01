package OneHundredTop;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 思路：
 * 遍历每个元素，对索引进行标记
 * 将对应索引位置的值变为负数；
 * 遍历下索引，看看哪些索引位置上的数不是负数的。
 * 位置上不是负数的索引，对应的元素就是不存在的。
 */
public class FindAllNumbers {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        //------------ start ---------------------
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ;i < nums.length ; i++){
            int a = Math.abs(nums[i]); //可能为负的
            if( nums[a-1] > 0){   //两次不要重复乘以负数
                nums[a-1] *= -1;
            }
        }
        for(int i = 0 ; i < nums.length;i++){
            if(nums[i] > 0){
                //将索引转化为对应的元素
                int num1 = i + 1;
                res.add(num1);
            }
        }
        System.out.println(res);
    }



}

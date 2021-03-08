package OneHundredTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/** 1
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *   [ target-nums[i] , i   ]
 *
 *
 *  思路:简单的HashMap
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        // - ------------------- start -----------------------------
        int[] ret1 = new int[2];
        ArrayList ret = new ArrayList(2);
        HashMap a = new HashMap();
        a.put(target - nums[0] , 0);
        for(int i = 1 ; i < nums.length ; i++){
            if( a.containsKey(nums[i])){
                ret.add(i);
                ret.add(a.get(nums[i]));
                System.out.println(ret.toString());
            }else{
                a.put(target - nums[i],i);
            }
        }
    }
}

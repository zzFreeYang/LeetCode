package recall;

//       回溯

import java.util.ArrayList;
import java.util.List;

/**
 *  78                         给你一个整数数组 nums ，返回该数组所有可能的子集（幂集）。解集不能包含重复的子集。
 *
 *输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
public class Subsets {
    public static void main(String[] args) {
        int []nums = {1,2,3};
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
//        return list;
        System.out.println(list.toString());
    }

    static void backtrack(List<List<Integer>> list , List<Integer> tempList, int []nums ,int start ){
        list.add(new ArrayList<>(tempList));
        for(int i = start ; i < nums.length ; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }

    }


}

package recall;

/**     46
 *  给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 思路: 回溯
 *  使用 used数组 ，做深度遍历。
 *  比如 nums={1,2,3} used =  {0,0,0} 第一层: {1,0,0}  {0,1,0},{0,0,1}
 *  排列问题需要注意:
 *  每层都是从0开始搜索而不是startIndex
 *  需要used数组记录path里都放了哪些元素了
 *  */
public class Permutations {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        //------------ start ----------------------
        int len = nums.length;
        int[] used = new int[len];
        List<List<Integer>> list = new ArrayList<>();
        backtrack(used,nums,list, new ArrayList<>());
//        return list;
        System.out.println(list.toString());

    }

    static void backtrack(int[] used, int []nums,List<List<Integer>> list,List<Integer> path ){
        //1.结束条件:当收集元素的数组path的大小达到和nums数组一样大的时候，说明找到了一个全排列
        if( path.size() == nums.length){
            list.add(new ArrayList<>(path));
            //用 list.add(path)会都是空；因为path是一个引用类型
        }
        //2.逐层递归,每次从0开始
        for(int i = 0 ; i < nums.length ; i++){
            if(used[i] == 1){ // path里已经收录的元素，直接跳过
                continue;
            }
            used[i] = 1; //选择
            path.add(nums[i]);//选择
            backtrack(used,nums,list,path);
            path.remove(path.size()-1);//回溯
            used[i] =0 ;//回溯
        }
    }
}

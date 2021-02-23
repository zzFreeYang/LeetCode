package recall;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *   39 组合总和
 *   给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
 *   candidates 中的数字可以无限制重复被选取。
 *

 */
public class Combination_Sum {
    public static void main(String[] args) {
        int []candidates = {2,3,6,7};
        int target = 7;
        //-------------------  start ---------------------------------
        int len =candidates.length;
        List<List<Integer>> list = new ArrayList<>();
        if(len == 0){
//            return list;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,len,target,path,list);
        System.out.println(list.toString());
    }

    /**
     *
     * @param candidates 候选数组
     * @param begin      搜索起点
     * @param len
     * @param target     每减去一个元素，目标值变小
     * @param path       从根节点到叶子结点的路径，是一个栈
     * @param list       结果集列表
     */
        private static void dfs(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> list){
            if( target < 0){
                return;
            }
            //满足条件，将路径写入list
            if( target == 0 ){
                list.add(new ArrayList<>(path));
                return;
            }
            for( int i = begin ; i < len ; i++){
                path.addLast(candidates[i]);
                dfs(candidates,i,len,target - candidates[i],path,list);
                path.removeLast();

            }

        }



}

package OneHundredTop;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 *
 * 摩尔投票算法:
 *  每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个
 *  具体实现:计数器，相同++，为负则替换
 *
 *  如果用Hash的话，需要考虑内存大小，如果数据太大会超出内存
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {10,9,9,9,10};
        //---------------- start -----------------
        int res = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length ; i++){
            if(res == nums[i]){
                count++;
            }else{
                count--;
                if(count < 0){
                    count = 1;
                    res = nums[i];
                }
            }
        }
        System.out.println(res);


    }

}

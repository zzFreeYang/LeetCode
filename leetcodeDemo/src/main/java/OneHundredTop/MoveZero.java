package OneHundredTop;

/**
 *    283. 移动零
 *    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *    输入: [0,1,0,3,12]
 *    输出: [1,3,12,0,0]
 *    必须在原数组上操作，不能拷贝额外的数组。
 */

//双指针
public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        //-------------- start --------------------
        int i = 0 ,j = 0;  // j代表非0下标
        while(i < nums.length ){
            if(nums[i] != 0){
                if(i != j ){
                    nums[j] = nums[i];
                }
                j++;
            }
            i++;
        }
        while( j < nums.length){
            nums[j] = 0 ;
            j++;
        }
//        System.out.println();
            for(int a : nums){
                System.out.println(a);
            }

    }
}

package OneHundredTop;

/**
 * 338. 比特位计数
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 输入: 2
 * 输出: [0,1,1]
 */

/**
 * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
 * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
 *

 */
public class CountingBits {
    public static void main(String[] args) {

        int num = 5;
        //============ ============================================
        int ret[]= new int[num+1];
        int cur = 0;
        for(int i = 0 ; i <= num ; i++){
            if( i % 2 == 0){
                cur = ret[i/2];
            }else{
                cur = ret[i-1]+1;
            }
            ret[i] = cur;
        }

    }



}

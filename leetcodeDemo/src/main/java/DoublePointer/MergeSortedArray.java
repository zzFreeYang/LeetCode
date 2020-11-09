package DoublePointer;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 输入：
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3
 输出：[1,2,2,3,5,6]

 */
//思路1: 把Nums2替换为nums1的0，然后排序

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n =3;
        //************  start 1 *******************
        int j = 0 ;
        for(int i = 0 ; i < nums1.length ; i++){
            if(nums1[i] == 0 && j <nums2.length){
                nums1[i] = nums2[j];
                j++;
            }
        }
        Arrays.sort(nums1);
        //************** end 1 *******************
        for (int a :nums1) {
            System.out.println(a);
        }
    }






}

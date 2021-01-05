package ArrayAndLinkedList;

/**反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */

/**
 * 思路：
 *  1->2->3
 *  此时有 null = prev
 *          head = 1 = curr
 *          循环三步:因为把 cur 指向 pre 会断开原本的 cur.next 所以需要保存下来
 *          temp = cur.next;
 *          cur.next = prev; //这里是逆着指向，移动的是next的指向，其余是动指针
 *          prev = curr;  //双指针后移
 *          curr = temp ; //后移到暂存的temp
 *
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = null;
 //-----------------------start----------------------------

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
//return prev;
}


  public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
            val = x; }
  }




}




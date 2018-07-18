package leetcode;

import java.util.*;


import java.util.*;
/*
 * Created by a111 on 23/5/18.
 *  Input: (2 -> 4 -> 3) + (5 -> 6 ->4)
 *  Output: 7 -> 0 -> 8
 *  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 *      l1 [2, 4, 3]   l1.next[4, 3]
 *      l2 [5, 6, 4]   l2.next[6, 4]
 *      dummy [0, 7, 0, 8]    dummy.next[7, 0, 8]


 *       2    ->     4    ->    3   ->  null
         ^                               ^
         |                               |
         l1                              p1

          5    ->     6    ->    4   ->  null
          ^                               ^
          |                               |
          l2                              p2

 0   ->   7    ->    10   ->    8   ->  null
 ^        ^                     ^        ^
 |        |                     |        |
dummy   dummy.next()           cur      cur.next()
 *
 *
 *
 * }
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);// used to link the head of the result linkedlist
        int sum = 0;
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        while (p1 != null || p2 !=null){
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        if (sum == 1){
            cur.next = new ListNode(1);
        }
        return dummy.next;//?
    }
}

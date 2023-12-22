import java.util.*;
 class mergeKsorted
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        ListNode[] lis = new ListNode[k];
        for (int i = 0; i < k; i++) {
            ListNode head = null;
            ListNode tail = null;
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                ListNode node = new ListNode(num);
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    tail = node;
                }
            }
            lis[i] = head;
        }
        ListNode mergedList = mergeKLists(lis);
        while (mergedList != null) {
 System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lis) {
        if (lis == null || lis.length == 0) {
            return null;
        }
        return mergeKLists(lis, 0, lis.length - 1);
    }

    public static ListNode mergeKLists(ListNode[] lis, int start, int end) {
        if (start == end) {
            return lis[start];
        }
        int mid = (start + end) / 2;
        ListNode left = mergeKLists(lis, start, mid);
        ListNode right = mergeKLists(lis, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temporary = new ListNode(0);
 ListNode tail = temporary;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next = l2;
        }
        return temporary.next;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;}}
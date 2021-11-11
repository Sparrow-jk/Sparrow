package suanfa;

public class ReserveLink {


    static class ListNode {

        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }


    public static ListNode reserve(ListNode head) {

        ListNode perv = null;
        ListNode curt = head;

        while (curt != null) {
            ListNode next = curt.next;
            curt.next = perv;
            perv = curt;
            curt = next;
        }
        return perv;

    }


    public static void print(ListNode node) {
        ListNode next = node;
        while (next != null) {
            System.out.println(next.value);
            next = next.next;

        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = null;

        print(listNode1);
        System.out.println("==================");

        ListNode result = reserve(listNode1);
        print(result);

    }


}

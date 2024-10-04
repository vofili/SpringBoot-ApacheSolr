package StreamOperations;

import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
public class LinkedListCycleDetect {



    static ListNode generateCycledLinkedList(){
        ListNode head=new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);

        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = three;

        return head;
    }
    public static void main(String[] args) {

        String name1 = new String("valentine");
        String name2 =  new String("valentine");

       // System.out.println(name1.equals(name2));
       // System.out.println(name1 == name2);
        ListNode start = generateCycledLinkedList();
       // printLinkedList(head);
        System.out.println(getNodeCycleStarts(start));

        //given 2 arrays arrange the items into a linked list
        int nums1[]= {1,3,2,4,1,5,6};
        int nums2[]= {1,2,3,4,5,6,2};
ListNode startNumList=new ListNode(1);
startNumList.next = new ListNode(1);
        for(int i=0;i < nums1.length;i++){

        }

    }


    //detect Node that Cycle starts from
    static ListNode getNodeCycleStarts(ListNode head){

        ListNode slow=head;
        ListNode fast=head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if(slow.equals(fast)){
                //detect node cycle exists
                fast=head;

                while(!fast.equals(slow)){
                    fast = fast.next;
                    slow= slow.next;
                }
                return fast;
            }
        }
        return null;
    }

        static boolean detectCycleWithHashSet(ListNode listnode){
        Set<ListNode> nodeSet = new HashSet<ListNode>();

        while(listnode != null ){
            if(nodeSet.add(listnode)){
                listnode = listnode.next;
            }else{
                return true;
            }

        }
        return false;
    }

    static void printLinkedList(ListNode listhead){

        while(listhead != null){
            System.out.print(" "+listhead.value);
            listhead = listhead.next;
        }
    }
}

class ListNode{
    int value;
    ListNode next;

    public ListNode(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "value=" + value +
                '}';
    }
}
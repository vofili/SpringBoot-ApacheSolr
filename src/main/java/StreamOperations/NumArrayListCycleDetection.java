package StreamOperations;

import java.util.HashSet;
import java.util.Set;

public class NumArrayListCycleDetection {

    // Method to detect a cycle in the two arrays nums1 and nums2
    public static  ListNode addIntArrayToList(int[] num1, int[] num2){


        if(num1.length != num2.length || num1.length ==0 || num2.length==0)
            throw new IllegalArgumentException("Arrays haave to be an equal length");


        ListNode[] nodeArray = new ListNode[num1.length];
        //populate the array of nodes with the value from the num1 array
        for(int i = 0; i < num1.length;i++){
            nodeArray[i] = new ListNode(num1[i]);
        }

        //populate the next elements of each item in the list
        for(int i=0; i < num1.length; i++){
            nodeArray[i].next = nodeArray[num2[i]];
        }

        return nodeArray[0];


    }


    public static void printLinkList(ListNode nodelist){

        while(nodelist != null){
            System.out.print(" "+nodelist);
            nodelist = nodelist.next;
        }
    }

    public static boolean hasCycle(ListNode node){
        Set<ListNode> mySet =  new HashSet<ListNode>();

        while(node != null){
            if(mySet.add(node)){
                node = node.next;
            }else{

                return true;
            }

        }

        return false;
    }

    public static int removeDuplicates(int[] nums) {
        // If the array is empty, return 0
        if (nums.length == 0) {
            return 0;
        }

        // Initialize the pointer j to track unique elements
        int j = 0;

        // Iterate through the array with i
        for (int i = 1; i < nums.length; i++) {
            // If current element is different from the previous unique element
            if (nums[i] != nums[j]) {
                j++; // Move j to the next unique position
                nums[j] = nums[i]; // Copy the current element to the next position
            }
        }

        // Return the number of unique elements (which is j + 1)
        return j + 1;
    }
    public static void main(String[] args) {
        int nums1[] = {1, 3, 2, 4, 1, 5, 6};
        int nums2[] = {1, 2, 3, 4, 5, 6, 6};
        ListNode ans = addIntArrayToList(nums1,nums2);
        System.out.println(hasCycle(ans));
        //  printLinkList(ans);
        boolean result = hasCycle(ans);
        if (result) {
            System.out.println("Cycle detected in the arrays.");
        } else {
            System.out.println("No cycle found in the arrays.");
        }

        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5, 6};
        int uniqueCount = removeDuplicates(nums);

        System.out.println("Number of unique elements: " + uniqueCount);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}



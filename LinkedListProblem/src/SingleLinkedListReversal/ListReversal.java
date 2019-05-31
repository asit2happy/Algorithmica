package SingleLinkedListReversal;

// Given an single linked list. Find and efficient algorithm to reverse the link.

public class ListReversal {
	
	// TC: O(n), SC: O(1)
	public static void reverseList1(ListNode head) {
		ListNode prev=null; ListNode current= head.next;
		
		while(current!=null){
			ListNode temp=current.next;
			current.next=prev;
			prev=current;
			current=temp;
		}
		head.next=prev;
	}
	
	public static void swap1(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
	}
	private static void swap(ListNode first, ListNode second) {
		//first = first ^ second;
		//second = first ^ second;
		//first = first ^ second;
	}
	public static void reverseList2(ListNode head) {
		ListNode prev = null, current = head.next;
		while (current != null) {
			swap(current.next, prev);
			swap(current, prev);
		}
		head.next = prev;
	}

	
	public static void main(String[] args) {
		
	}

}

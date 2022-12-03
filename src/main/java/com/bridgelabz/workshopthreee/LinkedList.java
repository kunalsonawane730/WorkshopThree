package com.bridgelabz.workshopthreee;

public class LinkedList {
	    node head = null;
	    static class node {
	        int value;
            node next;
	 
	        public node(int value)
	        {
	            this.value = value;
	        }
	    }
	 
	    node sortedMerge(node one, node two)
	    {
	        node result = null;
	        if (one == null)
	            return two;
	        if (two == null)
	            return one;
	
	        if (one.value <= two.value) {
	            result = one;
	            result.next = sortedMerge(one.next, two);
	        }
	        else {
	            result = two;
	            result.next = sortedMerge(one, two.next);
	        }
	        return result;
	    }
	 
	    node mergeSort(node h)
	    {
	        // Base case : if head is null
	        if (h == null || h.next == null) {
	            return h;
	        }
	        node middle = getMiddle(h);
	        node nextofmiddle = middle.next;
	        middle.next = null;

	        node left = mergeSort(h);
	        node right = mergeSort(nextofmiddle);
	        node sortedlist = sortedMerge(left, right);
	        return sortedlist;
	    }
	 
	    // Utility function to get the middle of the linked list
	    public static node getMiddle(node head)
	    {
	        if (head == null)
	            return head;
	 
	        node slow = head, fast = head;
	 
	        while (fast.next != null && fast.next.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        return slow;
	    }
	 
	    void push(int new_data)
	    {
	        node new_node = new node(new_data);
	        new_node.next = head;
	        head = new_node;
	    }

	    void printList(node headref)
	    {
	        while (headref != null) {
	            System.out.print(headref.value + " ");
	            headref = headref.next;
	        }
	    }
	 
	    public static void main(String[] args)
	    {
	 
	        LinkedList list = new LinkedList();
	        list.push(14);
	        list.push(9);
	        list.push(5);
	        list.push(18);
	        list.push(6);
	        list.push(3);
	 
	        // Apply merge Sort
	        list.head = list.mergeSort(list.head);
	        System.out.print("\n Sorted Linked List is: \n");
	        list.printList(list.head);
	    }
	}



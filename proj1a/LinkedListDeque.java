/**
 * Deque Implementation using circular doubly linked list
 */
public class LinkedListDeque<T> {
    private int size;
    private ListNode sentinel;

    private class ListNode {
        public T item;
        public ListNode next;
        public ListNode prev;

        public ListNode(T item, ListNode next, ListNode prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public LinkedListDeque() {
        sentinel = new ListNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }


    public void addFirst(T item) {
        if (isEmpty()) {
            ListNode newNode = new ListNode(item, sentinel, sentinel);
            sentinel.next = newNode;
            sentinel.prev = newNode;
        } else {
            ListNode head = sentinel.next;
            ListNode newNode = new ListNode(item, head, sentinel);
            sentinel.next = newNode;
            head.prev = newNode;
        }
        size += 1;
    }

    public void addLast(T item) {
        if (isEmpty()) {
            ListNode newNode = new ListNode(item, sentinel, sentinel);
            sentinel.next = newNode;
            sentinel.prev = newNode;
        } else {
            ListNode tail = sentinel.prev;
            ListNode newNode = new ListNode(item, sentinel, tail);
            sentinel.prev = newNode;
            tail.next = newNode;
        }
        size += 1;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        ListNode head = sentinel.next;
        while (head != sentinel) {
            System.out.print(head.item.toString() + " ");
            head = head.next;
        }
    }


    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        ListNode head = sentinel.next;
        sentinel.next = head.next;
        // 释放内存
        head.next.prev = sentinel;
        head.prev = null;
        head.next = null;
        size -= 1;
        return head.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        ListNode tail = sentinel.prev;

        tail.prev.next = sentinel;
        sentinel.prev = tail.prev;

        tail.next = null;
        tail.prev = null;
        size -= 1;

        return tail.item;

    }


    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        int tmp = 0;
        ListNode start = sentinel.next;
        while (tmp < index) {
            if (start == sentinel) {
                return null;
            }
            start = start.next;
            tmp += 1;
        }
        return start.item;
    }

    public T getRecursive(int index) {
        if (index == 0) {
            return this.sentinel.prev.item;
        }
        return this.getRecursive(index - 1);
    }
    
}

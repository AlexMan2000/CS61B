public class ArrayDeque<T> {
    private int capacity;
    private int size;
    private T[] array;
    private int front;
    private double usageRatio;

    public ArrayDeque() {
        size = 0;
        capacity = 8;
        front = 4;
        usageRatio = 0;
        this.array = (T[]) new Object[8];
    }

    public void addFirst(T item) {
        if (isEmpty()) {
            this.array[front] = item;
        } else {
            if (isFull()) {
                resize(capacity * 2);
            }

            this.front = (this.front - 1 + capacity) % capacity;
            this.array[front] = item;
        }
        size += 1;
        usageRatio = (float) size / (float) capacity;

    }

    public void addLast(T item) {
        if (isEmpty()) {
            this.array[front % capacity] = item;
        } else {
            if (isFull()) {
                resize(capacity * 2);
            }
            int last = (front + size) % capacity;
            this.array[last] = item;
        }
        size += 1;
        usageRatio = (float) size / (float) capacity;

    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return this.size;
    }


    public void printDeque() {
        if(isEmpty()){
            return;
        }
        int start = front;
        int last = (front + size - 1) % capacity;
        while (start != last) {
            System.out.print(this.array[start].toString() + " ");
            start = (start + 1) % capacity;
        }
        System.out.print(this.array[start].toString() + " ");
        System.out.println();
    }


    public T removeFirst() {
        T result = this.array[this.front];
        this.array[this.front] = null;
        this.front = (this.front + 1) % capacity;
        size -= 1;
        usageRatio = (float) size / (float) capacity;
        if (usageRatio < 0.25) {
            resize(capacity/2);
        }
        return result;
    }


    public T removeLast() {
        int last = (front + size - 1) % capacity;
        T result = array[last];
        array[last] = null;
        size -= 1;
        usageRatio = (float) size / (float) capacity;
        if (usageRatio < 0.25) {
            resize(capacity /2);
        }
        return result;
    }


    public T get(int index) {
        int tmp = 0;
        int start = front;
        while (tmp < index) {
            tmp += 1;
            start = (start + 1) % capacity;
        }
        return array[start];
    }


    private boolean isFull() {
        return this.size == capacity;
    }


    // Resize the array to the size of length.
    private void resize(int len) {
        if(len==1){
            return;
        }
        int last = (front - 1 + size) % capacity;
        T[] newList = (T[]) new Object[len];
        int start = front;
        int newfront = front % len;
        this.front = newfront;
        while (start % capacity != last) {
            newList[newfront] = this.array[start];
            newfront = (newfront + 1) % len;
            start = (start + 1) % capacity;
        }
        newList[newfront] = this.array[start];
        this.array = newList;
        this.capacity = len;
        usageRatio = (float) size / (float) capacity;
    }

    private T[] getArray() {
        T[] resultArray = (T[]) new Object[size];
        int start = front;
        int last = (start + size - 1) % capacity;
        int tmp = 0;
        while (start != last) {
            resultArray[tmp] = this.array[start];
            start = (start + 1) % capacity;
            tmp += 1;
        }
        resultArray[tmp] = this.array[start];
        return resultArray;
    }

//    public static void main(String[] args) {
//        ArrayDeque<Integer> A= new ArrayDeque<Integer>();
//        A.addFirst(0);
//        A.addLast(1);
//        A.removeFirst();
//        A.removeLast();
//        A.addFirst(6);
//        A.removeLast();
//        A.addLast(9);
//        A.printDeque();
//        System.out.println(A.size());
//        System.out.println(A.capacity);
//        A.removeLast();
//        System.out.println(A.size());
//        System.out.println(A.capacity);
//        A.printDeque();
//
//    }

}
